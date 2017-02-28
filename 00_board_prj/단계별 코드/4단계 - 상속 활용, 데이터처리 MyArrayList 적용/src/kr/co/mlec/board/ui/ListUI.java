package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.MyArrayList;

public class ListUI extends BaseUI {
	private BoardDAO dao;
	
	public ListUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		MyArrayList list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t글쓴이");
		System.out.println("------------------------------------");
		for (int i = list.size() - 1; i >= 0; i--) {
			BoardVO board = (BoardVO)list.get(i);
			System.out.printf(
					"%d\t%s\t%s\n", 
					board.getNo(), board.getTitle(), board.getWriter());
		}
		if (list.size() == 0) {
			System.out.println("입력된 게시물이 없습니다.");
		}
		System.out.println("------------------------------------");
	}
}
