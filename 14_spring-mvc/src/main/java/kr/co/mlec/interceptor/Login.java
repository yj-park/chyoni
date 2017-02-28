package kr.co.mlec.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.form.MemberVO;

@Controller
@RequestMapping("/interceptor")
public class Login {
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/login.do")
	public String login(HttpSession session) {
		MemberVO member = new MemberVO();
		member.setId("admin");
		member.setName("관리자");
		// 세션에 user정보 등록
		session.setAttribute("user", member);
		
		return "redirect:myPage.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		// 로그아웃 하니까 세션 종료 & 다시 로그인 화면으로 이동
		session.invalidate();
		return "redirect:loginForm.do";
	}
}
