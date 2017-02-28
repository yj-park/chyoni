package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/exam04")
public class exam04 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String msg = request.getParameter("msg");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>서버 전송 : " + msg + "</h1>");
		out.close();
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String msg = request.getParameter("msg");
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>서버 전송 : " + msg + "</h1>");
		out.close();
		
	}
}
