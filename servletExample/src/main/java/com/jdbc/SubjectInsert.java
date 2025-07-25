package com.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;


@WebServlet("/insert")
public class SubjectInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String subjectNumber = request.getParameter("subjectNumber");
		String subjectName = request.getParameter("subjectName");
		
		SubjectVO vo = new SubjectVO();
		vo.setSubjectNumber(subjectNumber);
		vo.setSubjectName(subjectName);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		boolean result = dao.subjectInsert(vo);
		
		if(result) {
			response.sendRedirect("/servletExample/list");
		}else {
			request.setAttribute("message", "학과 등록 실패");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
