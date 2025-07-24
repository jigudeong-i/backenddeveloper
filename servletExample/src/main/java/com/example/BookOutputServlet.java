package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookOutput")
public class BookOutputServlet extends HttpServlet {

	private static final long serialVersionUID = 8141455246227457480L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 이러면 하나씩 다 받아야 됨. 
		//String title = (String)request.getAttribute("title");
		//String author = (String)request.getAttribute("author");
		//String publisher = (String)request.getAttribute("publisher");
		
		// 이러면 하나만 받아와서 필요한 거만 꺼내 쓰면 됨.
		BookDTO ka = (BookDTO)request.getAttribute("apple");  // getAttribute는 object로 값반환. 그래서 (BookDTO)로 형변환.
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>책정보 출력</title>");
		out.println("<link rel='icon' href='data:,'>");
		out.println("<style type='text/css'>");
		out.println("table{border-collapse: collapse; width:300px}");
		out.println("caption{font-size:14px;}");
		out.println("td{border:1px solid #000;}");
		out.println("</style>");
		out.println("</head><body>");
		
		out.print("<table><caption>[입력한 책정보]</caption>");
		out.print("<tr><td>책제목</td><td>"+ka.getTitle()+"</td></tr>");
		out.print("<tr><td>책저자</td><td>"+ka.getAuthor()+"</td></tr>");
		out.print("<tr><td>출판사</td><td>"+ka.getPublisher()+"</td></tr>");
		out.print("</table>");
		
		out.println("</body></html>");
		out.close();
	}
}







