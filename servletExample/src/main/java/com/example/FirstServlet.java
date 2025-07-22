package com.example;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet { // 서블릿 사용시 반드시 상속해야한다.  
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		System.out.println("FirstServlet 객체 생성");
	}
	
	//init() 메서드는 클라이언트로부터 서블릿 요청이 있을 때, 즉 서블릿 객체가 처음 생성될 때 딱 한번 호출되어 초기 설정을 수행.  
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드 호출");
	}
	
	// service() 메서드는 클라이언트의 요청이 있을 때마다 서블릿 컨테이너가 자동 실행. 실제 서블릿이 처리해야하는 작업.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==========> doGet() 메서드 호출");
		response.setContentType("text/html; charset=UTF-8"); // 응답할건데 형식은 html.
		
		PrintWriter ka = response.getWriter();  
		// PrintWriter : 클라이언트에게 응답할 수 있는 출력 스트림. 
		// response : HttpServletResponse의 객체  
		// getWriter : 문자기반 출력 스트림
		
		ka.println("<!DOCTYPE hmtl><html><head><meta charset='UTF-8' />");
		ka.println("<title>JSP 예제</title><link rel='icon' href='data:,'></head>");
		ka.println("<body><h1>Hello Servlet ~~!</h1></body></html>");
	
		ka.close();      // 자원 사용했으면 꼭 닫아주기! 
		// HttpServletRequest request는 service 메서드의 기본설정이기 때문에 안 써도 적어야한다. (갖다쓰는거니까) 
	}
}

// 콘솔창 출력 확인





