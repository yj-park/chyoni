package OBcomponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	
	public Menu() {
		System.out.println("Menu 샌드위치 객체 생성자 호출");
	}
	@Autowired
	private ISand eggSand;
	
	public void print() {
		eggSand.info();
	}
}
