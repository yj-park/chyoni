package kr.co.mlec.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.form.MemberVO;

@Controller
@RequestMapping("/interceptor")
public class MyPage {
	@RequestMapping("/myPage.do")
	public void info(Model model) {
	//public String info(HttpSession session, Model model) {
		
		/*
		// 해결했지만 필요한 부분에 다 들어가야한다는 문제점 발생 -> interceptor로 해결하자
		MemberVO member = (MemberVO) session.getAttribute("user");
		if (member == null) {
			return "redirect:loginForm.do";
		}
		model.addAttribute("msg", "반갑습니다");
		return "interceptor/myPage";
		 */
		
		// 로그인을 한 상태에서만 보여야하는 페이지인데도 불구하고 myPage.do url을 입력하면 이동 가능 -> 오류 발생 -> interceptor로 해결하자
		// model객체에 저장하면 화면에서 바로 사용 가능
		model.addAttribute("msg", "반갑습니다");
	}
}
