package kr.co.mlec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mlec.form.MemberVO;

// interceptor는 상속 필수
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	// 실행되기 전에 수행하라! preHandler / postHandler는 실행 후 수행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("user");
		// null이 아니라는 건 세션 생성! 로그인 성공이라는 뜻
		if (member != null) {
			return true;
		}
		// 세션이 존재하지 않다면 중간에 가로채서 특정한 로그인 페이지로 이동시킬게
		response.sendRedirect("loginForm.do");
		return false;
	}
}