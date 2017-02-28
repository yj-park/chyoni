package day17.Exam05;

public class ListService extends BaseService {
	private ProductDAO dao;
	
	public ListService(ProductDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		MyArrayList<Product> list = dao.selectBoard();
		
		System.out.println("------------------------");
		System.out.println("상품 정보");
		System.out.printf("총 %d개\n", list.size());
		System.out.println("------------------------");
	}

}
