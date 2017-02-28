package jsp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 호출 경로 -> http://localhost:9090/06_servletjsp/jsp/session/test01


@WebServlet("/jsp/session/test01")
public class Test01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 세션 가져오기 (null X)
		// 호출한 사용자와 연관된 세션이 존재하는 경우 사용하는 세션을 반환하고
		// 만약, 연관된 세션이 없다면 새로운 세션을 생성해서 반환한다.
		HttpSession session = request.getSession();
		
		// 만들어진 ID(=JSESSION ID) 가져오기
		String id = session.getId();
		
		// 세션 유지 시간 바꾸기
		session.setMaxInactiveInterval(3);
		
		out.println("<h1>설정된 JSESSIONID : " + id + "</h1>");
		out.close();
	}

}
