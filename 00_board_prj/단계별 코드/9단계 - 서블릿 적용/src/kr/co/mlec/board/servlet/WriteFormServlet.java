package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/writeForm")
public class WriteFormServlet extends HttpServlet {
	
	public WriteFormServlet() { }
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.write("<html>");
		out.write("<head><title>네트워크 게시판</title></head>");
		out.write("<body>");		
		out.write("<h2>네트워크 게시판</h2>");		
		out.write("<hr>");
		out.write("<form action='write' method='post'>");
		out.write("  제목 : <input type='text' name='title' /><br>");
		out.write("  글쓴이 : <input type='text' name='writer' /><br>");
		out.write("  내용 : <br>");
		out.write("  <textarea name='content' rows='5' cols='70'></textarea><br>");
		out.write("  <input type='submit' value='등록' />");
		out.write("</form>");
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
	}
}














