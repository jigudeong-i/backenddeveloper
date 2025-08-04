package com.mvc.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping; // HandlerMapping 클래스 만들었었다.  
	private ViewResolver viewResolver;
	
	public void init() throws SecurityException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();

		viewResolver.setPrefix("/WEB-INF");
		viewResolver.setSuffix(".jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1.클라이언트의 요청 path 정보를 추출한다.
		// 요청 URL: http://localhost:8080/board/getBoardList.do
		String path = request.getRequestURI();	// 버튼 클릭후 주소가 http://localhost:8080/board/getBoardList.do 즉, /board/getBoardList.do를 path에 담는다. 이게 식별자가 되는 것. 
		
		// 2.HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path); 
		//Controller ctrl = new GetBoardListController의 주솟값 
		
		// 3.검색된 Controller를 실행한다.
		// GetBoardListController 클래스의 execute() 호출 
		String viewName = ctrl.execute(request, response);
		// 	   viewName = "/board/getBoardList" 
		
		// 4.ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			// viewResolver.getview("/board/getBoardList") => /WEB-INF/board/getBoardList.jsp 
			// 5.검색된 화면으로 이동한다.(포워드)
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			} catch (Exception ex) {
				System.out.println("forward 오류 : " + ex);
			}
		} else {
			// 5.검색된 화면으로 이동한다.(웹브라우저에 재요청)
			view = viewName;
			response.sendRedirect(view);
		}	
	}
}
