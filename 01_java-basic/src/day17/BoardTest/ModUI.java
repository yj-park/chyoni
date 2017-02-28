package day17.BoardTest;


public class ModUI extends BaseUI {
	private BoardDAO dao;
	
	public ModUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		BoardVO board = new BoardVO();
		System.out.print("수정할 글번호를 입력하세요: ");
		board.setNo(Integer.parseInt(sc.nextLine()));
		System.out.println("변경할 제목을 입력하세요: ");
		board.setTitle(sc.nextLine());
		
		if (dao.updateBoard(board)) {
			System.out.println("게시물 수정이 완료되었습니다.");
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
	}

}
