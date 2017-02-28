package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;

public class DeleteUI extends BaseUI {
	private BoardDAO dao;
	public DeleteUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		if (dao.deleteBoard(no) == 1) {
			System.out.println("게시물 삭제가 완료되었습니다.");
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
	}
}
