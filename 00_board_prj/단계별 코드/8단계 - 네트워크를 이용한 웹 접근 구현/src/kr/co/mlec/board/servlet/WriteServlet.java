package kr.co.mlec.board.servlet;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class WriteServlet extends HttpServlet {
	private BoardDAO dao;
	public WriteServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		boardVO.setContent(request.getParameter("content"));
		dao.insertBoard(boardVO);
		response.write("<html>");
		response.write("<body>");
		response.write("<h2>게시물 등록이 완료되었습니다.</h2>");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
	}
}














