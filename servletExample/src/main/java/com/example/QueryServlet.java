package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/queryget","/querypost"})
public class QueryServlet extends HttpServlet { 	// 서블릿 구현시 반드시 특정 추상클래스를 상속해야함
	private static final long serialVersionUID = 1L;

	// 매서드 방식이 get 이면 doGet 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);  // 요청객체, 응답객체. 
	}

	// 매서드 방식이 post 이면 doPost 호출 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  // 문자의 인코딩을 utf-8 해야 한글 데이터 제대로 처리.
		process(request, response);
	}
	
	protected void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");  // 응답 문서의 타입: html 
		
		PrintWriter out = response.getWriter();	// 서버가 클라이언트에 내보내야함. 그래서 출력 스트림(PrintWriter)
		
		String userName = request.getParameter("guestName");       // 파라미터값 접근하겠다. guestName. (홍길동)
		int number = Integer.parseInt(request.getParameter("num"));   // 10 
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>GET 방식과 POST 방식</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		
		out.print("<h2>요청 방식 : " + request.getMethod() + "</h2>");     // 요청 받아온 메서드 방식 : get 방식 
		out.print("<h2>요청 URI : " + request.getRequestURI() + "</h2>");  
		
		out.print("<h2>당신의 이름은 " + userName + "이군요!</h2>");
		out.print("<h2>당신이 좋아하는 숫자는 " + number + "이군요!</h2>");

		out.print("<a href='#' onclick='history.back();'>입력화면으로 가기</a>"); // history.back (자바스크립트 객체) 이전페이지 가기 : query.html       
		
		out.println("</body></html>");
		out.close();
	}
}













