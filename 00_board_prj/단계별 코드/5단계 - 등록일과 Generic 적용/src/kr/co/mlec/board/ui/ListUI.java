package kr.co.mlec.board.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.MyArrayList;

public class ListUI extends BaseUI {
	private BoardDAO dao;
	
	public ListUI(BoardDAO dao) {
		this.dao = dao;
	}

	
	public void execute() {
		MyArrayList<BoardVO> list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t등록일");
		System.out.println("------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 매번 객체를 생성하기 때문에 이 위치가 좋음(Detail이랑 다름)
		for (int i = list.size() - 1; i >= 0; i--) {
			BoardVO board = list.get(i);
			// Generic을 해줬기때문에 형변환 필요없음
			System.out.printf(
					"%d\t%s\t%s\t%s\n", 
					board.getNo(), 
					board.getTitle(), 
					board.getWriter(), 
					sdf.format(board.getRegDate()));
			//날짜 객체를 문자열로 바꿔줌
		}
		if (list.size() == 0) {
			System.out.println("입력된 게시물이 없습니다.");
		}
		System.out.println("------------------------------------");
	}
}
