package com.forward.refresh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstRefresh")   // 10초 뒤에 출력
public class FirstServlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException{
      response.setContentType("text/html;charset=utf-8");
      response.addHeader("Refresh","10;url=secondRefresh"); //("Refresh", "경과시간(초);url=요청할 서블릿/JSP")
	}
}