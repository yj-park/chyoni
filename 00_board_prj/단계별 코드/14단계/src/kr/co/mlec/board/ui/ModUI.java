package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class ModUI extends BaseUI {
	private BoardDAO dao;
	public ModUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		BoardVO boardVO = new BoardVO();
		System.out.print("수정할 글번호를 입력하세요 : ");
		boardVO.setNo(Integer.parseInt(sc.nextLine()));
		System.out.print("변경할 제목을 입력하세요 : ");
		boardVO.setTitle(sc.nextLine());
		
		if (dao.updateBoard(boardVO) == 1) {
			System.out.println("게시물 수정이 완료되었습니다.");
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
	}
}
