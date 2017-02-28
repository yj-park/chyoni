package _04_schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("schema/test.xml");
			
			// spring이 자동으로 Controller 상속받아서 동적으로 proxy객체를 만드는데 
			// BoardController로 형변환하려면 xml에서 proxy-target-class="true"로 변경한다
			Controller controller = (BoardController)context.getBean("board");
			controller.execute();

			controller = (MemberController)context.getBean("member");
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
