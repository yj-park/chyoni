package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;

import kr.co.mlec.board.dao.MemberDAO;
import kr.co.mlec.board.vo.MemberVO;

public class LoginController {
	
	private MemberDAO dao;
	public LoginController() {
		dao = new MemberDAO();
	}
	
	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO member = dao.getMemberInfo(id, password);
		
		if(member == null) {
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return new ModelAndView("login/loginForm");
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
			ModelAndView mav = new ModelAndView("login/loginForm");
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return mav;
		}
	}
	
	@RequestMapping("/login/loginForm.do")
	public void loginForm() throws Exception { }
	
	@RequestMapping("/login/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		//세션을 삭제한 후 main.jsp 페이지로 이동시킨다.
		HttpSession session = request.getSession();
		session.invalidate();//세션삭제
		
		return "redirect:" + request.getContextPath() + "/main/main.do";
	}
}
