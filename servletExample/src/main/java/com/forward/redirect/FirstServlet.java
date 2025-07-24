package com.forward.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstRedirect")
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		// 단순 이동은 인자값으로 서블릿명 또는 jsp파일명 명시. response.sendRedirect("secondRedirect"); 

		response.sendRedirect("secondRedirect?name=Younghee&id=wlrnejddl&pw=admin1234");
		// 이때 /servletExample 는 같은 context명을 사용하기에 생략 가능.   
		// 서블릿명 또는 jsp 파일명 다음에 ?이후 즉 query string이라고 하며 서블릿에 전달할 값을 명시. 
		// 그때 name=value로 여러개이면 name=value&name1=value1로 작성.
		//response.sendRedirect("/servletExample/secondRedirect?name=Younghee");
   }
}