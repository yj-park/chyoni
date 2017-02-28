package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

public class LogoutController implements Controller {
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션을 삭제한 후 main.jsp 페이지로 이동시킨다.
		HttpSession session = request.getSession();
		session.invalidate();//세션삭제
		return new ModelAndView("redirect:" + request.getContextPath() + "/main/main.do");
	}
}