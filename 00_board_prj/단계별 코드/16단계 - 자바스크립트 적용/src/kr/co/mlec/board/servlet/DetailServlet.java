package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
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
					throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시물 정보 추출
		BoardVO boardVO = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("boardVO", boardVO);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = dao.selectBoardFileByNo(no);
		request.setAttribute("file", fileVO);
		
		// 게시물 댓글과 연관된 정보 추출
		// 댓글 수정폼 처리부분
		String commentNo = request.getParameter("commentNo");
		if (commentNo != null) {
			request.setAttribute("commentNo", commentNo);			
		}
		
		// 댓글 목록 정보 공유
		List<BoardCommentVO> commentList = dao.selectBoardCommentByNo(no);
		request.setAttribute("commentList", commentList);
				
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/detail.jsp");
		rd.forward(request, response);
	}
}