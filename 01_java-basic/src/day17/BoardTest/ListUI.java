package day17.BoardTest;

import java.text.SimpleDateFormat;

public class ListUI extends BaseUI {
	private BoardDAO dao;
	
	public ListUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		MyArrayList<BoardVO> list = dao.selectBoard();
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("---------------------------");
		System.out.println("번호\t제목\t글쓴이\t등록일");
		System.out.println("---------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = list.size() - 1; i >= 0; i--) {
			BoardVO board = list.get(i);
			System.out.printf("%d\t%s\t%s\t%s\n", board.getNo(), board.getTitle(), board.getWriter(), sdf.format(board.getRegDate()));
		}
		if(list.size() == 0) {
			System.out.println("등록된 게시물이 없습니다.");
		}
		System.out.println("---------------------------");
	}

}
