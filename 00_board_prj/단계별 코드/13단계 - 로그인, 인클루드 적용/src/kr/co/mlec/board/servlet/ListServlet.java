package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	
	private BoardDAO dao;
	
	public ListServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {

		// 공유 데이터 
		List<BoardVO> list = dao.selectBoard();
		// 데이터 공유하기
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/list.jsp");
		rd.forward(request, response);
		
	}
}
