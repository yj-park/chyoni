package jsp.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/cookie/test01")
public class Test01 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String value = 
				URLEncoder.encode(request.getParameter("value"), "utf-8");
		
		// 쿠키 생성
		Cookie c = new Cookie(name, value);
		
		// 쿠키 유효시간 설정(초단위 설정)
		c.setMaxAge(60 * 60);
		// 1시간 유효함
		
		// 유효시간 0 -> 쿠키를 삭제하라
		// 유효시간 설정 X -> default: -1. 사용자가 브라우저를 열어두는 동안 유지
		
		response.addCookie(c);

		// 페이지 이동 시키기(공유역역과는 무관. 단순한 페이지 이동만 필요함)
		response.sendRedirect("exam01.jsp");
		
	}
	

}
