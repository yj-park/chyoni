package kr.co.mlec.board.servlet;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class UpdateFormServlet extends HttpServlet {
	
	private BoardDAO dao;
	
	public UpdateFormServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = dao.selectOneBoard(no);
		
		response.write("<html>");
		response.write("<head><title>네트워크 게시판</title></head>");
		response.write("<body>");		
		response.write("<h2>네트워크 게시판</h2>");		
		response.write("<hr>");
		response.write("<form action='update' method='post'>");
		response.write("  <input type='hidden' name='no' value='" + no + "'>");
		response.write("  제목 : <input type='text' name='title' value='" + board.getTitle() + "' /><br>");
		response.write("  글쓴이 : <input type='text' name='writer' readonly value='" + board.getWriter() + "' /><br>");
		response.write("  내용 : <br>");
		response.write("  <textarea name='content' rows='5' cols='70'>" + board.getContent() + "</textarea><br>");
		response.write("  <input type='submit' value='수정' />");
		response.write("</form>");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
	}
}














