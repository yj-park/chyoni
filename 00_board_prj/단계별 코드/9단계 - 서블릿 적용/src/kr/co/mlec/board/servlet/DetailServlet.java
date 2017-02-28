package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private BoardDAO dao;
	public DetailServlet() {
		this.dao = new BoardDAO();
	}

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO boardVO = dao.selectOneBoard(no);
		
		
		out.write("<html>");
		out.write("<head><title>네트워크 게시판</title></head>");
		out.write("<body>");		
		out.write("<h2>네트워크 게시판</h2>");		
		out.write("<hr>");		
		if (boardVO != null) {
			out.write("번호 : " + no + "<br>");
			out.write("제목 : " + boardVO.getTitle() + "<br>");
			out.write("글쓴이 : " + boardVO.getWriter() + "<br>");
			out.write("내용 : " + boardVO.getContent() + "<br>");
			out.write(
					"등록일 : " + 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate()));
		} else {
			out.write("글번호에 해당하는 게시물이 없습니다.");
		}
		out.write("<hr>");
		out.write("<a href='updateForm?no=" + no + "'>수정</a>");
		out.write("<a href='delete?no=" + no + "'>삭제</a>");
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
	}
}








