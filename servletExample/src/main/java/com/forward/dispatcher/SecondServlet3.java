package com.forward.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondDispatcher")
public class SecondServlet3 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      //String language = request.getParameter("language");
      
      // 바인딩
      String language = (String)request.getAttribute("language");  // 반환형이 object라 형변환 필수 
      String name = (String)request.getAttribute("name");
      String address = (String)request.getAttribute("address");
      int age = (int) request.getAttribute("age");
      Date today = (Date)request.getAttribute("now");
      
      out.println("<!DOCTYPE html><html>");
      out.println("<head><meta charset='UTF-8' />");
      out.println("<title>dispatcher 예제</title>");
      out.println("<link rel='icon' href='data:,'></head>");
      out.println("<body>");
      out.println("<div> 우리가 배운 언어 : " + language + "</div>");
      out.println("<div> 나의 이름 : " + name + "</div>");
      out.println("<div> 나의 주소 : " + address + "</div>");
      out.println("<div> 나의 나이 : " + age + "</div>");
      out.println("<div> 현재 날짜 : " + new SimpleDateFormat("yyyy년 MM월 dd일").format(today) + "</div>");
      out.println("</body></html>");   
   }
}











