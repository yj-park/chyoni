package day09;

public class Dog {
	// 디폴트 생성자가 생성
	// public Dog() {}
	private String name;
	private int age;
	
	public Dog() {
		this("이름 모름",0);
		//this.name = "이름 모름";
		//this.age = 0;
	}
	public Dog(String name) {
		//이 클래스에 있는 생성자 호출. 생성자 안에서만 사용 가능! 일반 메소드에서는 안됨. 
		//생성자 내에서 첫번째 구문으로 선언되어야함.
		//this.메소드 호출, 변수 호출 & this()생성자 호출
		this(name,1); 
		
		//this.name = name;
		//this.age = 1;
		//같은 코드가 반복되므로 하나로 처리하고 싶어 -> 
		//Dog(name, 1);은 오류!new와 같이 쓸 수 있음->새로운 메모리 공간을 만드니까 의미 없음 
		//this사용 가능
	}
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		// 특정 객체의 값을 이미 다 알고있는 경우 & 필수값(ex.이름)인 경우 사용
		// 생성과 동시에 값 초기화
		// set & get은 값이 수정될 가능성이 있는 경우 필수
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
// 클래스 내의 순서
// 멤버변수 -> 생성자 -> 메소드
// main메소드가 있으면 제일 마지막에!




// 상속 관계에서 문제가 발생할 수 있기 때문에
// 매개변수가 있는 생성자를 만든 경우 꼭!!!!! 기본 생성자 만들어주기


// void Dog(){} 일반 메소드인데 클래스랑 이름이 같음
// 다형성: 동일한 이름을 가지고 서로 다른 동작을 수행하는 특징
// 그 중에서도 메소드의 이름은 같으나 매개변수의 타입이나 개수를 다르게 한 것을 오버로딩이라고 한다.
// ex) Dog(int i){} & Dog(){} 
// 오버로딩, 오버라이딩(상속에서 나옴), 변수의 다형성(형변환?)







//Dog(int i) {           // new할 때 호출
//	System.out.println("Dog(int)호출됨");
//}
//Dog() {
//	System.out.println("Dog()호출됨");		
//}