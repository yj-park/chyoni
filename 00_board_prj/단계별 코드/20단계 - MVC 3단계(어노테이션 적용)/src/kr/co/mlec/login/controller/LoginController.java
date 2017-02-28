package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;

import kr.co.mlec.board.vo.MemberVO;
import kr.co.mlec.login.dao.LoginDAO;

public class LoginController {

	private LoginDAO dao;
	public LoginController() {
		dao = new LoginDAO();
	}

	@RequestMapping("/login/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션을 삭제한 후 main.jsp 페이지로 이동시킨다.
		HttpSession session = request.getSession();
		session.invalidate();//세션삭제
		return new ModelAndView("redirect:" + request.getContextPath() + "/main/main.do");
	}
	
	@RequestMapping("/login/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/jsp/login/loginForm.jsp");
	}
	
	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO member = dao.getMemberInfo(id, password);
		
		if(member == null) {
			ModelAndView mav = new ModelAndView("/jsp/login/loginForm.jsp");
			mav.addAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return mav;
		}
		
		if(id.equals(member.getUserId()) && password.equals(member.getPassword())) {
			
			MemberVO login = new MemberVO();
			login.setUserId(member.getUserId());
			login.setPassword(member.getPassword());
			login.setEmail(member.getEmail());
			
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			
			return new ModelAndView("redirect:" + request.getContextPath() + "/main/main.do");
		}
		else {
			ModelAndView mav = new ModelAndView("/jsp/login/loginForm.jsp");
			mav.addAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return mav;
		}
	}
}












