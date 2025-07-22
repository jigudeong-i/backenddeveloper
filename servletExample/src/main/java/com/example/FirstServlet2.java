package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "firstServlet2", 
		urlPatterns = { "/first2", "/first3" })
public class FirstServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========> doGet() 메서드 호출");
		
		response.setContentType("text/html; charset=UTF-8");    // html 형식으로 보내겠다.
		
		PrintWriter out = response.getWriter();					// 문자 출력 스트림
		out.println("<!DOCTYPE hmtl><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>JSP 예제</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body><h1>Long Time No See</h1></body>");
		out.println("</html>");
		
		out.close();
	}

}
