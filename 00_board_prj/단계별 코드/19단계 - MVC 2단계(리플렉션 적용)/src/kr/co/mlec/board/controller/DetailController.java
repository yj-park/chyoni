package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;

public class DetailController implements Controller {
	private BoardDAO dao;
	public DetailController() {
		this.dao = new BoardDAO();
	}

	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시물 정보 추출
		BoardVO boardVO = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
		
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = dao.selectBoardFileByNo(no);
		
		ModelAndView mav = new ModelAndView("/jsp/board/detail.jsp");
		mav.addAttribute("boardVO", boardVO);
		mav.addAttribute("file", fileVO);
		return mav;
	}
}












