package ajax.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/quiz/member")
public class Member extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		MemberVO mem = dao.getMemberInfo(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("id"));
		if (mem != null) {
			out.println("이미 사용 중인 아이디입니다.");
		} else {
			out.println("사용 가능한 아이디입니다.");
		}
		out.close();
	}
	
}
