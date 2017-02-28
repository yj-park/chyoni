package kr.co.mlec.board.servlet;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	private BoardDAO dao;
	public UpdateServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(Integer.parseInt(request.getParameter("no")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setContent(request.getParameter("content"));
		dao.updateBoard(boardVO);
		
		response.write("<html>");
		response.write("<body>");
		response.write("게시물 수정이 완료되었습니다.");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
	}
}







