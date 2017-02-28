package OAresource;

import javax.annotation.Resource;

public class Menu {
	
	// @Resource는 생성자에서는 사용할 수 없다
	public Menu() {
		System.out.println("Menu 샌드위치 객체 생성자 호출");
	}
	
	// type검색하는 @Autowired를 사용하는 것을 더 선호함!
	// name값에 bean의 id값을 넣어서 우선순위 설정 가능. 설정해주지 않으면 autowired와 마찬가지로 type검색부터 ㄱㄱ
	@Resource(name="egg")
//	@Qualifier("hamham")
	private ISand sand;
	
	public void print() {
		sand.info();
	}
}
