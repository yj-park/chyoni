package _03_basic;

public class Test {
	public static void main(String[] args) {
		try {
			// ProxyController를 실행할 때 BoardController를 실행하라고 주는거야
			ProxyController controller = new ProxyController(new BoardController());
			controller.execute();
			
			controller = new ProxyController(new MemberController());
			controller.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
