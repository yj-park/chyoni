package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 실행 시 화면에 "쫑"이 출력됨
		ApplicationContext container = new ClassPathXmlApplicationContext("quiz/test.xml");
		
		Person p = (Person)container.getBean("user");
		Animal ani = p.getAnimal();
		ani.info();
	}
}
