package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

public class LoginFormController implements Controller {
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/login/loginForm.jsp");
	}
}
