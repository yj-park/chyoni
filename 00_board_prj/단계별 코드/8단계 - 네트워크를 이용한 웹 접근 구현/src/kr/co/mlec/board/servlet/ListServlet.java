package kr.co.mlec.board.servlet;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class ListServlet extends HttpServlet {
	
	private BoardDAO dao;
	public ListServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardVO> list = dao.selectBoard();
		
		response.write("<html>");
		response.write("<head><title>네트워크 게시판</title></head>");
		response.write("<body>");		
		response.write("<h2>네트워크 게시판</h2>");		
		response.write("전체 " + list.size() + "개<br>");
		response.write("<hr>");
		response.write("<table width='70%' border='1'>");
		response.write("<tr>");
		response.write("  <th>번호</th>");
		response.write("  <th>제목</th>");
		response.write("  <th>글쓴이</th>");
		response.write("  <th>등록일</th>");
		response.write("</tr>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			response.write("<tr>");
			response.write("  <td>" + board.getNo() + "</td>");
			response.write("  <td><a href='detail?no=" + board.getNo() + "'>" + board.getTitle() + "</a></td>");
			response.write("  <td>" + board.getWriter() + "</td>");
			response.write("  <td>" + sdf.format(board.getRegDate()) + "</td>");
			response.write("</tr>");			
		}
		if (list.size() == 0) {
			response.write("<tr>");
			response.write("  <td colspan='4'>입력된 게시물이 없습니다.</td>");
			response.write("</tr>");	
		}
		response.write("</table>");
		response.write("<a href='writeForm'>글쓰기</a>");
		response.write("</body>");
		response.write("</html>");
	}
}














