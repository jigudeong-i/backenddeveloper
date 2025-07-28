package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/session")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getSession() or getSession(true): 기존 세션 객체 존재시 반환. 없으면 객체 생성.
		// getSession(false): 기존 세션 객체 존재시 반환. 없으면 null 반환.
		HttpSession session = request.getSession();
		
	    out.println("<!DOCTYPE html><html>");
	    out.println("<head><meta charset='UTF-8' />");
	    out.println("<title>session 객체의 메서드 예제</title>");
	    out.println("<link rel='icon' href='data:,'></head>");
	    out.println("<body>");
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		out.println("세션 아이디 : " + session.getId() + "<br />");
		out.println("최초 세션 생성 시각 : " + sdf.format(new Date(session.getCreationTime())) + "<br />");
		out.println("최근 세션 접근 시각 : " + sdf.format(new Date(session.getLastAccessedTime())) + "<br />");
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br />");
		if (session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
		out.println("</body></html>"); 
		out.close();
	}

}