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
 * Servlet implementation class SubjectDelete
 */
@WebServlet("/delete")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subjectNumber = request.getParameter("subjectNumber");
		
		SubjectVO vo = new SubjectVO();
		vo.setSubjectNumber(subjectNumber);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		boolean result = dao.subjectDelete(vo);
		
		if(result) {
			response.sendRedirect("/servletExample/list");  // 다시 list요청하겠다. 
		}else {
			request.setAttribute("message", "학과 삭제 실패!");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} // mapping은 list로.  
	}
}






