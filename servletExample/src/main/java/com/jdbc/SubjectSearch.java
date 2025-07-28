package com.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;


/**
 * Servlet implementation class SubjectSearch
 */
@WebServlet("/search")
public class SubjectSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
        String subjectName = request.getParameter("subjectName");
        
		SubjectVO vo = new SubjectVO();
		vo.setSubjectName(subjectName);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		List<SubjectVO> list = dao.getSubjectSearch(vo);
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject/subjectList.jsp");
		dispatcher.forward(request, response);

	}

}