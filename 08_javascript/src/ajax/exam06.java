package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/exam06")
public class exam06 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// plain : 일반 텍스트야
		response.setContentType("text/plain; charset=utf-8");
		
		// gson 라이브러리가 다 해줌!ㅋㅋ 이건 테스트용이야
		PrintWriter out = response.getWriter();
		String json = ""	;
		json += "[";
		// 쉼표 까먹지마~~
		json += "	{\"name\" : \"윤균상\", \"age\" : \"33\"},";
		json += "	{\"name\" : \"김상중\", \"age\" : \"57\"}";
		json += "]";
		out.println(json);
		out.close();
		
	}
	
}
