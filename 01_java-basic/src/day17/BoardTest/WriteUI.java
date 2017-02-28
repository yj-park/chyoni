package day17.BoardTest;

public class WriteUI extends BaseUI {
	private BoardDAO dao;
	
	public WriteUI(BoardDAO dao) {
		this.dao = dao;
	}
	public void execute() {
		BoardVO board = new BoardVO();
		System.out.println("-------------------------------");
		System.out.print("제목을 입력하세요: ");
		board.setTitle(sc.nextLine());
		System.out.print("글쓴이를 입력하세요: ");
		board.setWriter(sc.nextLine());
		System.out.print("내용을 입력하세요: ");
		board.setContent(sc.nextLine());
		dao.insertBoard(board);
		System.out.println("게시물 등록이 완료되었습니다.");
		System.out.println("-------------------------------");
	}
	

}
