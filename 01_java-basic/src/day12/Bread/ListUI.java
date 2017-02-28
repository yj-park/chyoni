package day12.Bread;

import java.text.SimpleDateFormat;

public class ListUI extends BaseUI {
	private BreadDAO dao;
	
	public ListUI(BreadDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		MyArrayList<BreadVO> list = dao.selectBoard();
		System.out.printf("전체 %d개\n", list.size());
		System.out.println("-----------------------");
		System.out.println("번호\t이름\t가격\t설명\t제조일\t");
		System.out.println("-----------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = list.size() - 1; i >= 0; i--) {
			BreadVO bread = list.get(i);
			
			System.out.printf("%d\t%s\t%d\t%s\t%s\n",
					bread.getNo(),bread.getName(), bread.getPrice(), bread.getContent(), sdf.format(bread.getMadeDate()));
		}if(list.size() == 0) {
			System.out.println("등록된 게시물이 없습니다.");
				
		}
		System.out.println("-----------------------");
	}
}
