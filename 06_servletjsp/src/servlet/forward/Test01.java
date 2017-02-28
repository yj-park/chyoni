package servlet.forward;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/servlet/forward/test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet페이지를 특정한 jsp페이지로 자동 이동 - servlet/forward/test01.jsp
		// 단순한 페이지 이동이 아닌 이동되는 페이지에서 사용하도록 데이터를 공유영역에 등록한다.
		
		// 공유하려는 데이터
		String msg = "테스트";
		Date time = new Date();
		
		// 공유영역에 등록해야함
		// msg라는 이름으로 msg를 공유
		request.setAttribute("msg", msg);
		request.setAttribute("time", time);
		
		// 페이지를 이동시키기 위한 객체 얻기
		// http://localhost:9090/06_servletjsp/servlet/forward/test01 : servlet 경로
		// http://localhost:9090/06_servletjsp/servlet/forward/test01.jsp : 이동할 페이지 주소
		
		// request객체를 얻어오기
		RequestDispatcher rd = request.getRequestDispatcher("test01.jsp");
		// servlet과 jsp의 주소가 맨 마지막만 다르니까 
		// RequestDispatcher rd = request.getRequestDispatcher("servlet/forward/test01.jsp");
		
		// forward하기
		rd.forward(request, response);
		
		/* 
		 * 경로에 "/"로 시작했을 때 프로젝트 경로가 자동 포함되는 경우
		 * 1.web.xml
		 * 2.@WebServlet
		 * 3.RequestDispatcher
		 */
		
		
	}
	

}
