package day12.Bread;

import java.util.Scanner;

public class BreadUI {
	private BreadDAO dao;
	private Scanner sc;

	public BreadUI() {
		dao = new BreadDAO();
		sc = new Scanner(System.in);
	}
	public void execute() {
		BaseUI ui = null;
		while(true) {
			switch(menu()) {
			case 1: ui = new ListUI(dao); break;
			case 2: ui = new DetailUI(dao); break;
			case 3: ui = new WriteUI(dao); break;
			}
			ui.execute();
		}
	}
	
	private int menu() {
		System.out.println("------------------");
		System.out.println("1.전체 메뉴");
		System.out.println("2.개별 조회");
		System.out.println("3.빵등록");
		System.out.println("------------------");
		System.out.print("메뉴 중 실행할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
