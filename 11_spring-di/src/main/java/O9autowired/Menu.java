package O9autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {
	
	// 멤버변수를 통한 주입 방법이 가장 많이 쓰임!!!!
//	@Autowired
//	@Qualifier("hamham")
	// 여러 개의 ISand 중에서 "egg"라는 이름을 가진 sand로 주입해
	// qualifier태그를 사용하여 "hamham"이라는 이름을 가진 sand로 주입해
	private ISand sand;
	
	/*
	@Autowired
	public void setSand(ISand sand) {
		this.sand = sand;
		System.out.println("set 메소드 실행");
	}
	sand일 때는 egg,ham이랑 둘 중 어떤 것을 넣을 지 모르니까 오류 발생
	*/
	
	@Autowired
	public void setSand(ISand ham) {
		this.sand = ham;
		System.out.println("set 메소드 실행");
	}
	

//	@Autowired
	public Menu() {
		this.sand = sand;
		System.out.println("Menu 샌드위치 객체 생성자 호출");
	}

	
	public void print() {
		sand.info();
	}
}
