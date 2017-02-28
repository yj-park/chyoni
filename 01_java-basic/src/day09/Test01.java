package day09;

public class Test01 {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("로뎅");
		d.setAge(8);
		
		Dog d2 = new Dog("로뎅", 8);
	 	
		System.out.println(d.getName() + "," +d.getAge());
		System.out.println(d2.getName() + "," +d2.getAge());
	}

}

//Dog d = new Dog(100); 
//Dog d2 = new Dog();  모든 메소드는 호출 시 호출할 대상인 생성자 필요. 없으면 오류 발생
// 개발자가 생성자를 지정하지 않았을 때 자바 컴파일러가 기본적으로 생성자를 만들어줌 -> 디폴트 생성자 (클래스 이름(){})
// 예외 경우: Scanner, File