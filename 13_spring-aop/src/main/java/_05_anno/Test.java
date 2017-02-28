package _05_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("anno/test.xml");
			
			// spring이 자동으로 Controller 상속받아서 동적으로 proxy객체를 만드는데 
			// BoardController로 형변환하려면 xml에서 proxy-target-class="true"로 변경한다
			Controller controller = (Controller)context.getBean("board");
			controller.execute();

			controller = (Controller)context.getBean("member");
			controller.execute();
			
			/*
			ProxyController controller = new ProxyController(new BoardController());
			controller.execute();
			
			controller = new ProxyController(new MemberController());
			controller.execute();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
