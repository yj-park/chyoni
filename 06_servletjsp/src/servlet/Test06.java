package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test06")
public class Test06 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String method = request.getMethod();
		// 요청 방식이 post일 경우 파라미터의 한글 처리 지정
		if ("POST".equals(method)) {
			request.setCharacterEncoding("utf-8");
		}
		
		response.setContentType("text/html; charset=utf-8"); // 브라우저가 해석할 수 없는 타입인 경우 다운로드받으라고 뜨는데 그건 거의 오타난거야
		PrintWriter out = response.getWriter();
		
		// 서버가 클라이언트에게 보내고싶어 (니가 작성한 게 이거란다)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.println("<html>");
		out.println("<body>");
		out.println(	"<h1>응답 성공</h1>");
		out.println(	"<h1>id :" + id + " </h1>");
		out.println(	"<h1>pass :" + pass + " </h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}

}
