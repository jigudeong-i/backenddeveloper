package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookInput")
public class BookInputServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title"); // name이 title인 요소의 값을 가져오겠다.
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");

		// 1. 각각 설정 (이러면 정보가 많아질수록 불편)
		//request.setAttribute("title", title);
		//request.setAttribute("author", author);
		//request.setAttribute("publisher", publisher);

		// 2. VO(value object)로 또는 DTO로 설정하여 전달.
		BookDTO book = new BookDTO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);

		request.setAttribute("apple", book);     // book 데이터의 이름을 apple로 세팅하겠다.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookOutput");  // 포워드할 서블릿의 맵핑 적기 
		dispatcher.forward(request, response);
	}
}







