package day17.Exam05;

import java.util.Scanner;

public class ProductService {
	private ProductDAO dao;
	private Scanner sc;
	
	public ProductService() {
		dao = new ProductDAO();
		sc = new Scanner(System.in);
	}
	public void execute() {
		BaseService svc = null;
		while(true) {
			switch(menu()) {
			case 1: svc = new ListService(dao); break;
			case 2: svc = new PriceService(dao); break;
			case 3: svc = new NameService(dao); break;
			case 4: svc = new ExitService(dao); break;
			}
		}
	}

	private int menu() {
		System.out.println("----------------------------");
		System.out.println("상품관리 시스템");
		System.out.println("----------------------------");
		System.out.println("1.전체 검색");
		System.out.println("2.금액 검색");
		System.out.println("3.상품명 검색");
		System.out.println("4.종료");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택: ");
		return Integer.parseInt(sc.nextLine());
	}
	

}
