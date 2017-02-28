package kr.co.mlec.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.board.dao.MemberDAO;
import kr.co.mlec.board.vo.MemberVO;

@WebServlet("/login/login")
public class Login extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.getMemberInfo(id, password);
		
		if(member == null) {
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/loginForm.jsp");
			rd.forward(request, response);
		}
		
		if(id.equals(member.getUserId()) && password.equals(member.getPassword())) {
			
			MemberVO login = new MemberVO();
			login.setUserId(member.getUserId());
			login.setPassword(member.getPassword());
			login.setEmail(member.getEmail());
			
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			
			response.sendRedirect(request.getContextPath() + "/main/main");
		}
		else {
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/loginForm.jsp");
			rd.forward(request, response);
		}
	}
}
