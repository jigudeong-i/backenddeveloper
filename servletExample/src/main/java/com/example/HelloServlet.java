package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello") //이 클래스는 서블릿임을 선언. 브라우저 주소로 /hello를 요청하고 서블릿을 실행하겠다. 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		System.out.println("========> HelloServlet 객체 생성");
	}
	
	@Override      
	public void init(ServletConfig config) throws ServletException {
		System.out.println("========> init() 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========> doGet() 메서드 호출");
		response.setContentType("text/html; charset=UTF-8"); // 응답을 할 문서의 타입은 html 
		
		PrintWriter ka = response.getWriter();
		ka.println("<!DOCTYPE hmtl><html>");
		ka.println("<head><meta charset='UTF-8' />");
		ka.println("<title>JSP 예제</title>");
		ka.println("<link rel='icon' href='data:,'></head>");
		ka.println("<body><h1>안녕 서블렛 ~~!</h1></body>");
		ka.println("</html>");
		
		ka.close();
	}
}
