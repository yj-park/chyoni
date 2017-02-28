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
		dao.deleteBoard(no);
		
		request.setAttribute("msg", "게시물이 삭제되었습니다");
		
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);

	}
}










