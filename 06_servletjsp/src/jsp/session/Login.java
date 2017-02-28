package jsp.session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/login")
public class Login extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 아이디는 한글 못받지롱. 만약 받을 수 있다면 request.setCharacterEncoding("utf-8"); 필요
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// id가 a이고 password가 1일 경우에만 로그인 성공처리(DB 연동은 스스로 공부해서 해봐)
		if ("a".equals(id) && "1".equals(password)) {
			// 단순한 페이지 이동일 뿐 로그인을 했는지 아닌지 main이 몰라 
			// -> session에 로그인 성공 정보 저장하기(보통 로그인한 사용자 정보를 클래스로 만들어서 객체로 저장함(ex:LoginVO))
			LoginVO login = new LoginVO();
			login.setId("a");
			login.setName("정찬성");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			login.setLoginTime(sdf.format(new Date()));
			
			// 세션에 로그인 성공 정보 저장 (user라는 이름으로 login객체 저장)
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			
			// el을 통해서 ${user}로 있으면 로그인을 했구나 알 수 있음
			
			response.sendRedirect("main.jsp");
		} 
		
		// 로그인 실패 시 다시 loginForm.jsp로 이동한다.
		else {
			// 메세지를 보내줘야하니 우선 데이터 공유가 필요함
			// 공유 영역에 메세지가 있으면 -> 실패 이동, 없으면 -> 최초 이동
			// 페이지 이동 기술 : forward & sendRedirect
			
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
		    
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
			rd.forward(request, response);
			
			
			
			
		}
	}
	
 
}
