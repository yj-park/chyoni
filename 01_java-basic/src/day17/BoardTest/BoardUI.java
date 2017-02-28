package day17.BoardTest;

import java.util.Scanner;

public class BoardUI {
	private BoardDAO dao;
	private Scanner sc;
	
	public BoardUI () {
		dao = new BoardDAO();
		sc = new Scanner(System.in);
	}
	
	public void execute() {
		BaseUI ui = null;
		while(true) {
			switch(menu()) {
			case 1: ui = new ListUI(dao); break;
			case 2: ui = new DetailUI(dao); break;
			case 3: ui = new WriteUI(dao); break;
			case 4: ui = new ModUI(dao); break;
			case 5: ui = new DeleteUI(dao); break;
			case 0: ui = new ExitUI(dao); break;
			}
			ui.execute();
		}
	}
	
	private int menu() {
		System.out.println("----------------------------------");
		System.out.println("1.전체 게시물 조회");
		System.out.println("2.글번호 조회");
		System.out.println("3.글등록");
		System.out.println("4.글수정");
		System.out.println("5.글삭제");
		System.out.println("0.종료");
		System.out.println("----------------------------------");
		System.out.print("메뉴 중 실행할 항목을 선택하세요: ");
		return Integer.parseInt(sc.nextLine());
	}

}
