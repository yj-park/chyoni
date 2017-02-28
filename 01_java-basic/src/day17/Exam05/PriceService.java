package day17.Exam05;

public class PriceService extends BaseService {
	private ProductDAO dao;
	
	public PriceService(ProductDAO dao) {
		this.dao = dao;
	}
	
	public void execute() {
		System.out.println("-------------------------");
		System.out.println("금액으로 검색");
		System.out.println("-------------------------");
		
	}

}
