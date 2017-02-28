package day12;

import java.util.Random;

// final 클래스의 경우 상속받을 수 없다.
// class MyString extends String {}
class OverClass {
	/*final*/ public void test() {}
}
class SubClass extends OverClass {
	public void test() {
		System.out.println("오버라이딩된 메소드");
	}
}

// API 클래스가 상속받는 법도 똑같음
class MyRandom extends Random {
	public int nextInt(int max) {
		return super.nextInt(max) + 1;
	 // return 10; // 재정의된 자식의 오버라이딩된 메소드 값이 출력됨
	}
}

public class Test03 {
	public static void main(String[] args) {
		Random r = new MyRandom(); // 부모는 자식을 받을 수 있다. 묵시적 형변환
		int num = r.nextInt(10)+1;
		System.out.println(num);
	}
}
