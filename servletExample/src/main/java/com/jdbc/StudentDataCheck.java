package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

/**
 * Servlet implementation class StudentDataCheck
 */
@WebServlet("/studentCheck")
public class StudentDataCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String subjectNumber = request.getParameter("subjectNumber");
		
		SubjectVO vo = new SubjectVO();
		vo.setSubjectNumber(subjectNumber);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		int count = dao.studentDataCheck(vo);
		
		out.print(count);
	}
}







