package kr.co.mlec.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;

@WebServlet("/board/commentUpdate")
public class CommentUpdateServlet extends HttpServlet {

	private BoardDAO dao;
	public CommentUpdateServlet() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		BoardCommentVO comment = new BoardCommentVO();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(commentNo);
		
		dao.updateBoardComment(comment);
		
		response.sendRedirect("detail?no=" + no);
	}
}











