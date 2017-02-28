package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz02")
public class Quiz02 extends HttpServlet {
	private int count = 1;
	public int getCount() {
		return count++;
	}

	public void setCount(int count) {
		this.count = count;
	}

	Random r = new Random();
	int ansNum = r.nextInt(100)+1;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("정답 : " + ansNum + "<br>");
		out.println(getCount() + "회 시도 <br>");
		if (rNum > ansNum) {
			out.println("작은 수를 입력하세요<br>");
		} else if (rNum < ansNum) {
			out.println("큰 수를 입력하세요<br>");
		} else if (rNum == ansNum) {
			out.println("정답입니다.<br>");
		}
		out.println("<a href='http://localhost:9090/06_servletjsp/servlet/quiz/quiz02.html'>다시입력</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	

}
