package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int score = Integer.parseInt(request.getParameter("score"));
		
		String hakjum = "";
		if(score >=90 && score<=100 ){
			hakjum = "A";
		} else if(score >=80){
			hakjum = "B";
		} else if(score >=70){
			hakjum = "C";
		} else if(score >=60){
			hakjum = "D";
		} else {
			hakjum = "F";
		}
		
		request.setAttribute("hakjum", hakjum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("implicitobject/score1.jsp");
		dispatcher.forward(request, response);
	}
}


