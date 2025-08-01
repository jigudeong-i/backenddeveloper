package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.subject.SubjectDAO;

/**
 * Servlet implementation class subjectNumber
 */
@WebServlet("/subjectNumber")
public class SubjectNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SubjectDAO dao = SubjectDAO.getInstance();
		String subjectNumber = dao.getSubjectNumber();
		
		out.print(subjectNumber);
	}
}
