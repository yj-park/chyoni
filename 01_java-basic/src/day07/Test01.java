package day07;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Sub01 s01 = new Sub01(); 
		// 메소드를 사용하기 위해서는 메소드가 존재하는 클래스의 객체를 메모리에 올려줌
		// 메소드 호출: 객체변수.메소드명
		// s01.method01(1) 오류 발생, void일때는 값을 받을 수 없음
		s01.method01(); // 메소드니까 () 필수 
		
		/* 
		 * s01.method02(i); 오류 발생, 변수로 받을 수 없음!
		 * method02(100); 오류 발생, s01.와 같이 jump할 곳 꼭 필수!
		 */
		
		s01.method02(100);    
		
		s01.method03(1, 2);
		
		s01.method04('a');
		
		s01.method05("a"); //메소드 실행하고 다시 돌아옴
		
		Random r1 = new Random();
		s01.method06(new Random());
		// 값 만들기가 곤란한 건 -> 주소값 생성. new를 사용해서!
		

	}

}
