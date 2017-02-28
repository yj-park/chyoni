package day11;

class Parent /* extends java.land.Object 
                    명시적으로 extends를 사용하지 않는 이상 자동 상속!
             java.lang은 자동으로 import되는 기본클래스
             ex-String, System.in,*/
{
	Parent() {} // 매개변수 있는 생성자를 만들 때 문제가 없게 만들고 싶다면
	            // 보험용으로 항상 매개변수 없는 메소드 만들어두기
	Parent(String name) {
		
	}
}

class Child extends Parent {
	Child() {
		// super(); 가 자동 추가됨 -> 부모 클래스의 매개변수가 없는 것을 찾아갈 수 없기 때문에 오류 발생
		super("aaa"); // 매개변수 형태에 맞춰서 직접 호출코드를 추가하게 되면 해결! 
		System.out.println("C-1");
	}
	Child(String name) {
		super("aaa"); // 직접 호출코드를 추가하게 되면 해결! 
		System.out.println("C-2");	
	}
}

public class Test02 {

}
