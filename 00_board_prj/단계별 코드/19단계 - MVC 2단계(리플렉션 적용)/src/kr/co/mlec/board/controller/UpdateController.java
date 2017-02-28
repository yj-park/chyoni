package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.WebUtil;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class UpdateController implements Controller {
	private BoardDAO dao;
	public UpdateController() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		request.setCharacterEncoding("utf-8");
		
		/*
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(Integer.parseInt(request.getParameter("no")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setContent(request.getParameter("content"));
		dao.updateBoard(boardVO);
		*/
		
		dao.updateBoard((BoardVO)WebUtil.getParamToVO(request, BoardVO.class));

		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 수정되었습니다");
		return mav;
	}
}
















