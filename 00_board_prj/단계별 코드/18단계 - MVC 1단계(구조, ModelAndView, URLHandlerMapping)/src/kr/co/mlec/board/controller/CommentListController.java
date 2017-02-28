package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;

public class CommentListController implements Controller {

	private BoardDAO dao;
	public CommentListController() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		return new ModelAndView("ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(no)));
	}
}











