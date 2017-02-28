package _01_basic;

public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new BoardController();
			controller.execute();
			
			controller = new MemberController();
			controller.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
