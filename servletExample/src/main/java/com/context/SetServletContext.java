package com.context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ServletContext 자원 바인딩 기능 예제 */

@WebServlet("/setContext")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ServletContext의 인스턴스를 얻는다.
		ServletContext context = getServletContext();

		List<String> member = new ArrayList<String>();
		member.add("홍길동");
		member.add("한늘봄");
		member.add("김영희");
		context.setAttribute("member", member);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
		dispatcher.forward(request, response);
	}
}