package kr.co.mlec.board.servlet;

import java.text.SimpleDateFormat;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class DetailServlet extends HttpServlet {
	private BoardDAO dao;
	public DetailServlet() {
		this.dao = new BoardDAO();
	}

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO boardVO = dao.selectOneBoard(no);
		
		response.write("<html>");
		response.write("<head><title>네트워크 게시판</title></head>");
		response.write("<body>");		
		response.write("<h2>네트워크 게시판</h2>");		
		response.write("<hr>");		
		if (boardVO != null) {
			response.write("번호 : " + no + "<br>");
			response.write("제목 : " + boardVO.getTitle() + "<br>");
			response.write("글쓴이 : " + boardVO.getWriter() + "<br>");
			response.write("내용 : " + boardVO.getContent() + "<br>");
			response.write(
					"등록일 : " + 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate()));
		} else {
			response.write("글번호에 해당하는 게시물이 없습니다.");
		}
		response.write("<hr>");
		response.write("<a href='updateForm?no=" + no + "'>수정</a>");
		response.write("<a href='delete?no=" + no + "'>삭제</a>");
		response.write("<a href='list'>목록</a>");
		response.write("</body>");
		response.write("</html>");
	}
}








