package day11;

public class Person {
	//private String name; 처럼 접근제한자를 막으면 person의 클래스 내에서만 사용하겠다는 선언이기 때문에 접근 범위가 허용되지 않으므로 상속한 자식클래스인 student에서 접근이 불가능하므로 오류가 발생하게됨
	String name;
	int age;
	
	public Person() {}
	
	// 생성자 메소드: 클래스와 이름이 같으나 반환타입이 없는 메소드
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// 오버로딩: 이름이 같으나 매개변수의 개수나 타입이 다른 것
	
	public String toString() {
		// System.out.printf("name = %s, age = %d",name, age); 이 보기 쉬우나 반환타입이 없음. 따라서 String.format 사용이 편함
		return String.format("name = %s, age = %d", name, age);
	}

}
