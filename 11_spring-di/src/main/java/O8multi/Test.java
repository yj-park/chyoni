package O8multi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext(
		//		new String[] {"multi/test.xml", "multi/test1.xml"}
				"multi/test2.xml"
				);
				
				
		// xml에 bean을 등록시키자~
		// xml 문서가 로딩되자마자 객체가 생성됨!
		
	}
}
