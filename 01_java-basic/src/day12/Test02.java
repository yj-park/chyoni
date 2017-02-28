package day12;

interface InterA {
	public void a();
}
interface InterB extends InterA {
	public void b();
}
// 인터페이스가 인터페이스를 상속받을때: 추상 메소드가 확장되는 개념이므로 extends사용


// 파일은 따로 만드는 것이 좋음
// 인터페이스는 클래스를 쓰지 않고 interface를 쓴다
interface InterSuper {
	// 인터페이스에 선언되는 변수에는 public static final 키워드가 자동으로 생성된다.
	int PORT = 8000;
	// = public static final int PORT = 8000;
	// 상수는 값이 고정되어있으므로 변경할 수 없고 대문자로 써준다!
	// static이면 객체를 생성하지 않고 직접 접근 가능하므로 확인해볼 수 있음. 
	// (클래스이름.변수이름) 직접 접근 방법
	
    // 인터페이스 내에는 일반 구현된 메소드가 올 수 없음. 무조건 추상 메소드(바디가 없는)
	// public abstract라는 키워드가 자동 생성됨.
	void call();
	// = public abstract void call(); 
	void print();
	
	default void test1() {
		//기본으로 구현된 메소드
		System.out.println("default");
	}
	static void test2() {
		//static으로 구현된 메소드
		System.out.println("static");
	}
	
}
// 인터페이스가 상속받을 때는 extends가 아닌 implements를 쓴다. 구현의 개념
// 구현받고자 하는 인터페이스 내의 모든 추상메소드를 메소드를 전부 다 재정의해야되기 때문에
class InterSub implements InterSuper, InterB {
	// 인터페이스와 클래스 간의 상속에서는 다중 상속 가능
	public void a() {
		System.out.println("InterA의 재정의된 a()메소드");
		// InterB가 상속받은 인터페이스의 구현되지않은 메소드
	}
	public void b() {
		System.out.println("InterB의 재정의된 b()메소드");		
	}
	
	// 오류 발생. 접근제한자의 범위가 좁아졌기때문에 
	//void call() {
	public void call() {
		System.out.println("재정의된 call()메소드입니다.");
	}
	public void print() {
		System.out.println("재정의된 print()메소드입니다.");
	}

}

public class Test02 {
	public static void main(String[] args) {
		// InterSuper iSuper = new InterSuper();
		// 자식 클래스를 이용하여 객체 생성 가능
		InterSuper iSuper = new InterSub();
		iSuper.call();
		iSuper.print();
		InterB ib = new InterSub();
		InterA ia = new InterSub();
		
		System.out.println(InterSuper.PORT);
		System.out.println(iSuper.PORT);
		//The static field InterSuper.PORT should be accessed in a static way
		//static field니까 직접 접근(클래스명.변수명)하라고 알려주는 중
		//InterSuper.PORT = 9000;
		//final 개념이기 때문에 변수에 값 할당할 수 없음(오류발생)
	}
}
