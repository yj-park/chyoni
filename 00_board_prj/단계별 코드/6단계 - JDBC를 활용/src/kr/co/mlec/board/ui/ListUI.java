package kr.co.mlec.board.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class ListUI extends BaseUI {
	private BoardDAO dao;
	
	public ListUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		List<BoardVO> list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t등록일");
		System.out.println("------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			System.out.printf(
					"%d\t%s\t%s\t%s\n", 
					board.getNo(), 
					board.getTitle(), 
					board.getWriter(), sdf.format(board.getRegDate()));
		}
		if (list.size() == 0) {
			System.out.println("입력된 게시물이 없습니다.");
		}
		System.out.println("------------------------------------");
	}
}

