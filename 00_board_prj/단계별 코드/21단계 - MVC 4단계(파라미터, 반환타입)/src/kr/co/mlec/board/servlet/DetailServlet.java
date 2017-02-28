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
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/detail.jsp");
		rd.forward(request, response);
	}
}