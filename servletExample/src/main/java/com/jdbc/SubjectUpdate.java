package com.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

/**
 * Servlet implementation class SubjectUpdate
 */
@WebServlet("/update")
public class SubjectUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String subjectNumber = request.getParameter("subjectNumber");
		String subjectName = request.getParameter("subjectName");
		
		SubjectVO vo = new SubjectVO();
		vo.setSubjectNumber(subjectNumber);
		vo.setSubjectName(subjectName);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		boolean result = dao.subjectUpdate(vo);
		
		if(result) {
			response.sendRedirect("/servletExample/list");
		}else {
			request.setAttribute("message", "학과 수정 실패!");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
