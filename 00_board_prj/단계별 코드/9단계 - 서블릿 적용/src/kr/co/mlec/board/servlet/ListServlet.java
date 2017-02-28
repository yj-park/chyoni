package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	
	private BoardDAO dao;
	public ListServlet() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<BoardVO> list = dao.selectBoard();
		
		out.write("<html>");
		out.write("<head><title>네트워크 게시판</title></head>");
		out.write("<body>");		
		out.write("<h2>네트워크 게시판</h2>");		
		out.write("전체 " + list.size() + "개<br>");
		out.write("<hr>");
		out.write("<table width='70%' border='1'>");
		out.write("<tr>");
		out.write("  <th>번호</th>");
		out.write("  <th>제목</th>");
		out.write("  <th>글쓴이</th>");
		out.write("  <th>등록일</th>");
		out.write("</tr>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			out.write("<tr>");
			out.write("  <td>" + board.getNo() + "</td>");
			out.write("  <td><a href='detail?no=" + board.getNo() + "'>" + board.getTitle() + "</a></td>");
			out.write("  <td>" + board.getWriter() + "</td>");
			out.write("  <td>" + sdf.format(board.getRegDate()) + "</td>");
			out.write("</tr>");			
		}
		if (list.size() == 0) {
			out.write("<tr>");
			out.write("  <td colspan='4'>입력된 게시물이 없습니다.</td>");
			out.write("</tr>");	
		}
		out.write("</table>");
		out.write("<a href='writeForm'>글쓰기</a>");
		out.write("</body>");
		out.write("</html>");
	}
}














