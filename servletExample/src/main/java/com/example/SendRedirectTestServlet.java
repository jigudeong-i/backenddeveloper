package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/portalSite")  // 어노테이션 기반 url 패턴 매핑. web.xml 똑같은 작업 
public class SendRedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1653501095386225075L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("site"); 
		
		if (param.equals("naver")) {      // getParameter로 가져온 값이 naver 와 같다면! 
			response.sendRedirect("https://www.naver.com/");
		} else if (param.equals("daum")) {
			response.sendRedirect("https://www.daum.net/");
		} else if (param.equals("w3schools")) {
			response.sendRedirect("https://www.w3schools.com/");
		} else if (param.equals("google")) {
			response.sendRedirect("https://www.google.com/");
		}
	}
}