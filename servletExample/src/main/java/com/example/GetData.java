package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getData")        
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");     				// 클라이언트로부터 전송받은 파라미터의 인코딩 설정. 
		response.setContentType("text/html; charset=UTF-8"); 	// 서버가 클라이언트 브라우저에 전송할 문서 타입 설정할 문서 타입은 ~ 
		
		String paramName = request.getParameter("name");   		// 요청받은 파라미터값 중 이름이 name인 값 반환(홍길동)
		String paramAddress = request.getParameter("address");	// 요청받은 파라미터값 중에서 이름이 address인 값 반환 (서울시)
		
		PrintWriter out = response.getWriter();			// 출력스트림 생성(서버에서 클라이언트로 데이터를 전송)
		// 작성: out.println("태그");
		out.println("<!DOCTYPE html><html>");  
		out.println("<head><meta charset='UTF-8' /><title>POST DATA</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center'>POST 방식 테스트입니다.</h2>");
		out.println("<ul>");
		
		if (!paramName.equals("") && !paramAddress.equals("")) {
			out.println("<li>입력한 이름 : " + paramName + "</li>");
			out.println("<li>입력한 주소 : " + paramAddress + "</li>");
		}
		
		out.println("</ul>");
		out.println("<a href='#' onclick='history.back()'>이전 페이지</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close(); // 출력 스트림 해제
	}
}














