package day17.BoardTest;

public class ExitUI extends BaseUI {
	private BoardDAO dao;
	
	public ExitUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		System.out.println("게시판 프로그램을 종료합니다.");
		System.exit(0);
	}

}
