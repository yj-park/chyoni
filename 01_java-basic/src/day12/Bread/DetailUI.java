package day12.Bread;

import java.text.SimpleDateFormat;

public class DetailUI extends BaseUI {
	private BreadDAO dao;
	
	
	public DetailUI(BreadDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		System.out.print("조회할 빵번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		BreadVO bread = dao.selectOneBoard(no);
		
		if(bread != null) {
		System.out.println("-----------------------");
		System.out.println("번호 : " + no);
		System.out.println("이름 : " + bread.getName());
		System.out.println("가격 : " + bread.getPrice());
		System.out.println("설명 : " + bread.getContent());
		System.out.println("제조일 : " + 
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bread.getMadeDate()));
		} else {
			System.out.println("번호에 해당하는 메뉴가 없습니다.");
		}
		System.out.println("-----------------------");
		System.out.println();
	}

}
