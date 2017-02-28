package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;

public class CommentRegistController implements Controller {

	private BoardDAO dao;
	public CommentRegistController() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		BoardCommentVO comment = new BoardCommentVO();
		comment.setNo(no);
		comment.setContent(request.getParameter("content"));
		comment.setUserId(request.getParameter("userId"));
		
		// 게시물 저장 처리 부탁..
		dao.insertBoardComment(comment);
		
		return new ModelAndView("ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(no)));
	}
}











