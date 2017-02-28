package day07;

import java.util.Random;

class HaHa {}
class KiKi {}

public class Sub02 {
	// 반환타입 有 -> return 有
	/*
	 * 반환타입이 void가 아니라면
	 * 1.반드시 메소드내에 return이 존재해야 한다.
	 * 2.return문 뒤에는 반환타입이 받을 수 있는 값을 설정해야한다.
	 * 
	 */
	int method01() {
		return 100;
	}
	char method02() {
		return 'a';
	}
	String method03() {
		return "성공";
	}
	Random method04() {
		return new Random();
	}
	int[] method05() {
		 return new int[3];
	}
	HaHa method06(KiKi ki){
		return new HaHa(); 
	}

}

