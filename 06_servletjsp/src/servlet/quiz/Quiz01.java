package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz01")
public class Quiz01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SubQuiz01 s01 = new SubQuiz01();
		
		
		int cal = Integer.parseInt(request.getParameter("operator"));
		int num1 = Integer.parseInt(request.getParameter("cal1"));
		int num2 = Integer.parseInt(request.getParameter("cal2"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		switch(cal) {
		case 1: out.println(num1 + " + " + num2 + " = " + s01.add(num1, num2)); break;
		case 2: out.println(num1 + " - " + num2 + " = " + s01.sub(num1, num2)); break;
		case 3: out.println(num1 + " / " + num2 + " = " + s01.div(num1, num2)); break;
		case 4: out.println(num1 + " * " + num2 + " = " + s01.mul(num1, num2)); break;
		}
		out.println("<a href='http://localhost:9090/06_servletjsp/servlet/quiz/quiz01.html'>다시하기</a>");

		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	

}
