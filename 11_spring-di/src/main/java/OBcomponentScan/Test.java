package OBcomponentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("componentScan/test.xml");
		
		Menu menu = (Menu)container.getBean("menu");
		menu.print();
	}
}
