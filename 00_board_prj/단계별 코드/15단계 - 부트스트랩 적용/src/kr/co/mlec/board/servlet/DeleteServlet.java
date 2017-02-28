package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	
	private BoardDAO dao;
	public DeleteServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		boolean flag = dao.deleteBoard(no);
		
		request.setAttribute("no", no);
		request.setAttribute("flag", flag);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/delete.jsp");
		rd.forward(request, response);

	}
}
