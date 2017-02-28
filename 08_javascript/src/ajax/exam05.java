package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/exam05")
public class exam05 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 내보낼 파일은 xml이야 하고 contentType도 바꿔줬어
		String xml = ""	;
		xml += "<members>";
		xml += "	<member>";
		xml += "		<name>윤균상</name>";
		xml += "		<age>33</age>";
		xml += "	</member>";
		xml += "	<member>";
		xml += "		<name>김상중</name>";
		xml += "		<age>57</age>";
		xml += "	</member>";
		xml += "</members>";
		// xml보다 json이 훨씬 편해서 요즘엔 별로 안써
		out.println(xml);
		out.close();
		
	}
	
}
