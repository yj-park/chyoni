package day11;

public class Student extends Person {
	String no;
	// String name; 상속관계에 있으므로 삭제!
	// int age; 자식 클래스에 없는데도 오류가 나지 않는다면 부모클래스를 참조!
	// person클래스에서 학번이 추가된 클래스 -> 상속받을 수 있다
	// 유연하게 변경될 수 있는 구조: '~ = ~이다' ex)student는 person이다.
	
	
	
	public Student() {
		//super(); 
		//this([인자,..]),super([인자,..])형태의 호출이 없는 경우 super()코드가 자동 생성됨
	}
	public Student(String no, String name, int age) {
		super(name, age); 
		//1.생성자는 객체가 생성될 때만 호출이 가능하기때문에 생성자 안에서만 사용 가능
		//2.생성자에 대한 호출은 무조건 first statement로 써야만함
		this.no = no;
		/*
		// 부모에 선언된 변수에 접근해서 사용하게 된다.
		// 주의사항!
		// 접근제한자가 허용되는 범위 내에서만 사용이 가능함
		this.name = name;
		this.age = age;
		// 부모클래스와 중복되는 표현 정리
		*/
	}
	public String toString() { 
		//public을 빼고 String toString()만 사용한다면 부모클래스보다 범위가 적기때문에 오류가 발생함
		//만약 해결법으로 부모클래스의 toString메소드에서 public을 default값으로 바꿔버리면 
		//모든 자바클래스의 기본 부모클래스인 Object클래스의 toString메소드 범위보다 좁기 때문에 오류가 발생함
		//따라서, student를 재정의하기 위해서는 toString메소드 범위를 public으로 바꾸는 방법밖에 없음
		//return String.format("no = %s, name = %s, age = %d", no, name, age);
		//return String.format("no = %s, %s", no, toString());
		// toString을 쓰게되면 가장 가까운 곳인 이 클래스내에서 찾기때문에 계속 반복되다가 결국 stack over flow오류 발생
		return String.format("no = %s, %s", no, super.toString());
		// 부모클래스에서 가져와서 쓰게되면 내용의 유지보수에 용이함
	}
}
