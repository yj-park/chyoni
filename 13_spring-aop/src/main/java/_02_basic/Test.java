package _02_basic;


// 핵심 기능 자체는 깔끔해졌지만 실행하는 클래스가 굉장히 복잡해짐

public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new BoardController();
			
			// 공통 기능 - 실행시간 측정 후 출력
			long s = System.currentTimeMillis(); 
			
			controller.execute();
			
			long e = System.currentTimeMillis();
			double time = (e - s) / 1000d;
			System.out.println("BoardController execute 메소드 실행시간 : " + time);
			
			controller = new MemberController();
			
			// 공통 기능 - 실행시간 측정 후 출력
			s = System.currentTimeMillis(); 
			
			controller.execute();
			
			e = System.currentTimeMillis();
			time = (e - s) / 1000d;
			System.out.println("MemberController execute 메소드 실행시간 : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
