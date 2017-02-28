package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;

@WebServlet("/board/commentList")
public class CommentListServlet extends HttpServlet {

	private BoardDAO dao;
	public CommentListServlet() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		response.setContentType("text/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		// ajax로 처리하기위해 페이지 이동 X. 결과를 화면으로 쏴줄 뿐!
		// 하나의 {}가 commentVO의 내용으로 이루어짐
		out.println(new Gson().toJson(dao.selectBoardCommentByNo(no)));
	}
}











