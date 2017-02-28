package O7collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("collection/test.xml");
		// xml에 bean을 등록시키자~
		// xml 문서가 로딩되자마자 객체가 생성됨!
		
		Menu menu = (Menu)container.getBean("menu");
		System.out.println("==========================================");
		System.out.println("List");
		System.out.println("==========================================");
		menu.printList();
		System.out.println("==========================================");
		System.out.println("Set");
		System.out.println("==========================================");
		menu.printSet();
		System.out.println("==========================================");
		System.out.println("Map");
		System.out.println("==========================================");
		menu.printMap();
		System.out.println("==========================================");
		System.out.println("Prop");
		System.out.println("==========================================");
		menu.printProp();
		System.out.println("==========================================");
		
	}
}
