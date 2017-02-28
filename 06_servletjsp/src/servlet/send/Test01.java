package servlet.send;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/send/test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "redirect는 데이터 공유 안됨";
		
		request.setAttribute("msg", msg);
		
		// sendRedirect - 이동
		// http://localhost:9090/06_servletjsp/servlet/send/test01 - servlet 주소
		// http://localhost:9090/06_servletjsp/servlet/send/test01.jsp - 페이지를 이동하고자 하는 jsp
		// forward와 달리 "/"로 시작할 경우 프로젝트 경로를 표시해야한다.(필수)
		// response.sendRedirect("/06_servletjsp/servlet/send/test01.jsp");
		// "/"로 시작하지 않을 경우에는 다른 부분만 표시하면 됨
		response.sendRedirect("test01.jsp");
	}
	

}
