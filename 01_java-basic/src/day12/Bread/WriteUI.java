package day12.Bread;

public class WriteUI extends BaseUI{
	private BreadDAO dao;
	public WriteUI(BreadDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		BreadVO bread = new BreadVO();
		System.out.print("이름을 입력하세요 : ");
		bread.setName(sc.nextLine());
		System.out.print("가격을 입력하세요 : ");
		bread.setPrice(Integer.parseInt(sc.nextLine()));
		System.out.print("설명을 입력하세요 : ");
		bread.setContent(sc.nextLine());
		dao.insertBoard(bread);
		System.out.println("등록이 완료되었습니다.");
	}

}
