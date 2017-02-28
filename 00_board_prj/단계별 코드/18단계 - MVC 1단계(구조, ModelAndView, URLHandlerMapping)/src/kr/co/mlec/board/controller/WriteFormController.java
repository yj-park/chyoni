package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

public class WriteFormController implements Controller {
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		return new ModelAndView("/jsp/board/writeForm.jsp");
	}
}

