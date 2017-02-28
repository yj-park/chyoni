package _03_basic;

// ProxyController가 공통의 기능을 대신 실행해주는 역할을 함! 
public class ProxyController implements Controller {
	
	private Controller controller;
	
	
	public ProxyController(Controller controller) {
		this.controller = controller;
	}
	
	
	@Override
	public void execute() throws Exception {
		// controlle 객체의 클래스명 구하기 (simpleName아니니까 패키지명까지 포함됨)
		String clzName = controller.getClass().getName();
		
		// 공통 기능 - 실행시간 측정 후 출력
		long s = System.currentTimeMillis(); 
		
		controller.execute();
		
		long e = System.currentTimeMillis();
		double time = (e - s) / 1000d;
		System.out.println(clzName + " execute 메소드 실행시간 : " + time);
	}
	
}
