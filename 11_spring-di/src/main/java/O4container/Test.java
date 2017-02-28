package O4container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("container/test.xml");
		// xml에 bean을 등록시키자~
		
		// xml 문서가 로딩되자마자 객체가 생성됨!
		ISand sand = (ISand)container.getBean("ham");
		sand.info();
	}
}
