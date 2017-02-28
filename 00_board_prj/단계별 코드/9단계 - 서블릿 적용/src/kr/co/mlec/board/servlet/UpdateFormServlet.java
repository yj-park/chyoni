package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/updateForm")
public class UpdateFormServlet extends HttpServlet {
	
	private BoardDAO dao;
	
	public UpdateFormServlet() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = dao.selectOneBoard(no);
		
		out.write("<html>");
		out.write("<head><title>네트워크 게시판</title></head>");
		out.write("<body>");		
		out.write("<h2>네트워크 게시판</h2>");		
		out.write("<hr>");
		out.write("<form action='update' method='post'>");
		out.write("  <input type='hidden' name='no' value='" + no + "'>");
		out.write("  제목 : <input type='text' name='title' value='" + board.getTitle() + "' /><br>");
		out.write("  글쓴이 : <input type='text' name='writer' readonly value='" + board.getWriter() + "' /><br>");
		out.write("  내용 : <br>");
		out.write("  <textarea name='content' rows='5' cols='70'>" + board.getContent() + "</textarea><br>");
		out.write("  <input type='submit' value='수정' />");
		out.write("</form>");
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
	}
}














