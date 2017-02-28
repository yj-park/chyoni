package kr.co.mlec.board.servlet;

import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class WriteFormServlet extends HttpServlet {
	
	public WriteFormServlet() { }
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.write("<html>");
		response.write("<head><title>네트워크 게시판</title></head>");
		response.write("<body>");		
		response.write("<h2>네트워크 게시판</h2>");		
		response.write("<hr>");
		response.write("<form action='write' method='post'>");
		response.write("  제목 : <input type='text' name='title' /><br>");
		response.write("  글쓴이 : <input type='text' name='writer' /><br>");
		response.write("  내용 : <br>");
		response.write("  <textarea name='content' rows='5' cols='70'></textarea><br>");
		response.write("  <input type='submit' value='등록' />");
		response.write("</form>");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
	}
}














