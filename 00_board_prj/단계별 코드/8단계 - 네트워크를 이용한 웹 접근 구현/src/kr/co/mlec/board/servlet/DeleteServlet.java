package kr.co.mlec.board.servlet;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private BoardDAO dao;
	public DeleteServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		dao.deleteBoard(no);

		response.write("<html>");
		response.write("<body>");
		response.write("게시물 삭제가 완료되었습니다.");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
		
	}
}
