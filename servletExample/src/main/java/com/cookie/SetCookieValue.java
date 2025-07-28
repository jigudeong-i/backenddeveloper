package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/setCookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = dateFormat.format(d);
		
		Cookie c1 = new Cookie("connectTime", URLEncoder.encode(now, "utf-8"));
		c1.setMaxAge(24 * 60 * 60);
		//c1.setMaxAge(-1);  // -1은 브라우저 종료될 때 쿠키도 삭제.
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("cookieString", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));
		//c2.setMaxAge(24 * 60 * 60);
		c2.setMaxAge(-1); 
		response.addCookie(c2);
		
		Cookie c3 = new Cookie("cookieName", "Youngsu");
		c3.setMaxAge(24 * 60 * 60);
		response.addCookie(c3);
		
		out.println("<!DOCTYPE html><html>");
	    out.println("<head><meta charset='UTF-8' />");
	    out.println("<title>Cookie 예제</title>");
	    out.println("<link rel='icon' href='data:,'></head>");
	    out.println("<body>");
	    
		out.println("<div>현재시간 : " + now + "</div>");
		out.println("<div>문자열을 Cookie에 저장합니다.</div>");
		out.println("</body></html>");
		out.close();
	}
}