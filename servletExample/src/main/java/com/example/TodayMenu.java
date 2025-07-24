package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/todayMenu")   // 맵핑. 
public class TodayMenu extends HttpServlet {  // 서블릿 구현시 반드시 특정 추상클래스를 상속해야함
	private static final long serialVersionUID = 1L;

	//get인지 post인지는 js에서 결정했다! 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();      // response객체에서 getWriter() 메서드의 인스턴스를 얻어야 한다. 
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>SELECT & POST</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		out.println("<div style='text-align:center'>오늘점심메뉴 : <strong>");
		
		String[] values = request.getParameterValues("lunch");    // getParameter:문자반환,  getParameterValues:문자열 배열반환
		for(int i=0; i<values.length; i++) {
			out.print(values[i]);           
			if(i<values.length-1) out.print(","); // 점심메뉴 사이에 구분자는 쉼표. 근데 마지막 항목 뒤엔 안 붙여야 하니까 -1 
		}
		//Arrays.toString(values); 값이 제대로 담겼는지 확인하는 용도
		out.println("</strong></div>");
		out.println("</body></html>");
		out.close();
	}
}
