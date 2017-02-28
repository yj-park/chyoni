package day07;

/*
 * 멤버변수는 private(접근제한자)로 선언
 * 멤버변수에 대한 값을 설정, 추출하는 메소드를 만들어서 활용
 */

public class Singer {
	private String name;  // 현재 선언된 클래스 내에서만 직접 접근 가능.
	private int age;      // 데이터 정의 클래스는 무조건 이렇게!
	
	// 멤버변수에 대한 설정(setter)과 추출(getter)를 선언! -> 왜? 멤버변수가 막혀서 -> 문제생길건데 왜 막니? -> 오류날 수 있으니까 예방해야지
	
	// setter 선언
	// 접근제한자	반환타입 	메소드명 	(매개변수)
    // public	void 	set변수명 	 변수에 들어갈 값의 타입
	
	// name에 대한 setter
	public void setName(String _name) {
		name = _name; // _를 붙이는 이유: _없으면 가까운 곳에서 변수를 찾기 때문에 9라인 name으로 가지않고
		              // 20라인의 name으로 가기 때문에 구분해줌!!
		
		this.name = name; 
		// this는 컴파일러가 자동 생성해줌.
		// /*Singer this,*/의 히든변수가 숨겨져있으므로 인스턴스 메소드에 자동으로 생성 (클래스(-static을 사용하는) 메소드에는 x)
		
	
	}
	// getter 선언
	// 접근제한자	반환타입 	 메소드명 	 (매개변수)
	// public	변수의타입  get변수명   (있는 값을 주기 때문에 없음!)

	// name에 대한 getter
	public String getName() {
		return name;
	}
	
	// age에 대한 setter
	public void setAge(int _age) {
		age = _age;
	}
	
	// age에 대한 getter
	public int getAge() {
		return age;
	}
	// 특수문자 중 _와 $는 허용 but 권장 X

}
