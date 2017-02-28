package kr.co.mlec.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;

public class MainController {
	@RequestMapping("/main/main.do")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/main/main.jsp");
	}
}