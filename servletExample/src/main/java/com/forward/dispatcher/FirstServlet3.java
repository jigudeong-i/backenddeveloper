package com.forward.dispatcher;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstDispatcher")
public class FirstServlet3 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	// 데이터를 서블릿에서 서블릿으로 넘길 땐 Get, Post 상관 없음. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException { 
	  response.setContentType("text/html;charset=utf-8");
	  
	  // 바인딩. 원래는 데이터를 ?name=... 형식으로 넘겼었는데 그거 안 하고 '정보공유'로 하겠다. 
	  request.setAttribute("language", "java");
	  request.setAttribute("name", "홍길동");
	  request.setAttribute("address", "서울특별시 강남구 강남구 테헤란로14길 6");
	  request.setAttribute("age", 20);
	  request.setAttribute("now", new Date());
	  
	  // get 방식으로 할 수도 있다. RequestDispatcher dispatch = request.getRequestDispatcher("secondDispatcher?language=java...........");  
	  // dispatch.forward(request, response);
	  // 근데 이러면 많은 자료를 넘길때 불편하지 않겠냐고..  
	  
	  RequestDispatcher dispatch = request.getRequestDispatcher("secondDispatcher");  
	  dispatch.forward(request, response);
   }
}


/*
요청

맨 처음 init 실행됨. 

어딘가에서 객체 생성

호출

서비스 실행 

doget, dopost 골라골라 
----------------------여기까진 컨테이너가 알아서. 

그 다음은 우리가 짠 로직. 

두번째 서블릿은 요청을 안 해서 객체를 안 만든 상태.  

그래서 정보를 전송하겠다.  
*/
