package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
// 모듈에 대한 경로를 공통으로 빼주기
@RequestMapping("/form")
public class MemberController {
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}

	@RequestMapping("/join.do")
	public String join(MemberVO member, RedirectAttributes attr) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		attr.addFlashAttribute("msg", "가입이 완료되었습니다.");
		return "redirect:/form/joinForm.do";
	}

	/*
	// ★★★가장 많이 사용하는 방법★★★
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		// Model 객체 선언만 하면 따로 객체를 생성하지 않고도 포워드 방식을 통해 메세지 공유와 같은 추가적인 작업 가능  
		model.addAttribute("msg", "가입이 완료되었습니다.");
		// 포워드 방식은 한 번의 호출에 의해서 서버에서 옮겨지므로 데이터의 공유가 가능하고
		// sendRedirect는 공유 영역에 있는 데이터를 쓸 수 없어 ->  RedirectAttributes를 통해 1회성 데이터 전송 가능
	 // return "form/joinForm";
		return "redirect:/form/joinForm.do";
	}
	*/

	/* 다섯번째
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		ModelAndView mav = new ModelAndView();
		// 넘어갈 페이지
		mav.setViewName("form/memberInfo");
		// 그 페이지에서 사용할 데이터 공유
		mav.addObject("member", member);
		return mav;
	}
	*/

	/* 네번째
	@RequestMapping("/join.do")
	// 클래스명이 너무 길면 힘드니까 JSP에서 사용할 공유 객체명 변경 가능!
	public String join(@ModelAttribute("member")MemberVO member) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		return "form/memberInfo";
	}
	*/
	
	/* 세번째
	@RequestMapping("/join.do")
	public String join(MemberVO member) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		// 화면에 넘겨주는 과정이 없음
		// spring은 파라미터에 값을 설정할 뿐만 아니라 포워딩되는 페이지 화면에서 사용할 수 있도록 자동 setAttribute함
		// HOW? member는 value값이야. key값은 별도로 설정하지 않았으므로 클래스이름(MemberVO)에서 첫글자를 소문자로 바꿔서 memberVO로 설정한다!
		return "form/memberInfo";
	}
	*/

	/* 두번째
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request, 
			@RequestParam("id") String id, 
			@RequestParam("password") String pass,
			@RequestParam("name") String name) {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(pass);
		member.setName(name);
		request.setAttribute("member", member);
		return "form/memberInfo";
	}
	*/
	
	/* 첫번째
	@RequestMapping("/join.do")
	// form의 데이터를 request를 통해서 꺼내고 setAttribute해서 공유영역에 올렸지 -> 초기 방법
	public String join(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
	*/
}
