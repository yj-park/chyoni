package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import kr.co.mlec.board.dao.BoardDAO;

public class DeleteController implements Controller {
	
	private BoardDAO dao;
	public DeleteController() {
		this.dao = new BoardDAO();
	}
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		dao.deleteBoard(no);
		
		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 삭제되었습니다");
		return mav;
	}
}










