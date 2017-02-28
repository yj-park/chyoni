package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class UpdateFormController implements Controller {

	private BoardDAO dao;

	public UpdateFormController() {
		this.dao = new BoardDAO();
	}

	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

		BoardVO board = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
		
		ModelAndView mav = new ModelAndView("/jsp/board/updateForm.jsp");
		mav.addAttribute("board", board);
		return mav;
	}
}










