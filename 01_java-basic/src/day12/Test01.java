package day12;

// 추상클래스
abstract class ABsSuper {
	// 추상클래스는 추상메소드를 가져야만한다 X 필수요건 아님!
	// 추상메소드를 가지는 클래스는 추상클래스로 선언되어야함. 필수
	// 추상메소드: 구현되지 않은 메소드
	public abstract void test();
	public void call() {
		System.out.println("메소드 바디");
	} // 바디{}가 있으므로 구현된 메소드
}

class AbsSub extends ABsSuper {
	public void test() {
		System.out.println("재정의된 메소드입니다.");
	}
}


public class Test01 {
	public static void main(String[] args) {
		// ABsSuper absSuper = new AbsSuper();
		// 추상클래스는 new 키워드를 통한 인스턴스 생성이 불가능.
		// 추상클래스의 객체는 상속관계를 바탕으로 자식클래스를 이용.
		ABsSuper absSuper = new AbsSub();
		absSuper.call();
		absSuper.test();
		
	}
}
