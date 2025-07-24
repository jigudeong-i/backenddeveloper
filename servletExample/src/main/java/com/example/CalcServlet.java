package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// POST 요청을 처리하기 위한 메서드
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String num1Str = request.getParameter("num1");      //getParameter는 10을 받아도 '10'이라는 문자로 받는다.
			String num2Str = request.getParameter("num2");
			
			int num1 = Integer.parseInt(num1Str);    //문자->숫자
			int num2 = Integer.parseInt(num2Str);
			String op = request.getParameter("operator");
			
			// calc() 메서드 호출로 결과 받아옴.
			int result = calc(num1, num2, op);
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html>");
			out.println("<head><meta charset='UTF-8' /><title>간단한 연산 결과</title>");
			out.println("<link rel='icon' href='data:,'></head>");
			out.println("<body>");
			out.println("<h2>계산결과</h2>");
			out.println("<hr style='width:28%; margin-left:0px' />");
			out.println(num1 + " " + op + " " + num2 + " = " + result);
			out.println("</body></html>");
			
			out.close();
	} // doPost() 메서드 종료.
	
	// 실제 계산 기능을 수행하는 메서드
	public int calc(int num1, int num2, String op) {
		int result = 0;
		if(op.equals("+")) {       //문자 비교이기에 equals. 
			result = num1 + num2;
		} else if(op.equals("-")) {
			result = num1 - num2;
		} else if(op.equals("*")) {
			result = num1 * num2;
		} else if(op.equals("/")) {
			if(num2 != 0)
				result = num1 / num2;
			else 
				result =0;
		}
		return result;
	}
}







