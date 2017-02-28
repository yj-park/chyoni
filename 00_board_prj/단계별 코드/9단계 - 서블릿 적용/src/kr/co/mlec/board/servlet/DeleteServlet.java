package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
					throws ServletException, IOException{
		int no = Integer.parseInt(request.getParameter("no"));
		dao.deleteBoard(no);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("<body>");
		out.write("게시물 삭제가 완료되었습니다.");
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
		
	}
}







