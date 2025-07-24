package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/* [요구사항]
 * +, -, *, / 연산의 결과를 반환하는 클래스(Calc) 생성. 
 * result 필드 생성하여. 생성자 통해서 결과 얻고, getResult()로 결과 반환. 
 * */
@WebServlet("/calcServlet2") 
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");    //그냥 문자 타입 
		PrintWriter out = response.getWriter();

		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");

		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		String op = request.getParameter("operator");

		Calc calc = new Calc(num1, num2, op);
		int result = calc.getResult();

		out.print(result); 
		out.close();
	}
}







