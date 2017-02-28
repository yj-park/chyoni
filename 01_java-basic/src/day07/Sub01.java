package day07;

import java.util.Random;
import java.util.Scanner;

public class Sub01 {
	void method01 () {    //반환타입이 없으므로 return 필수 아님
		System.out.println("01");
	}
	void method02 (int i) {    
		System.out.println("02");
	}
	void method03 (int i, int j) {  //int i, j처럼 선언할 수 없음. 따로 변수 선언   
		System.out.println("03");
	}
	void method04 (char ch) {    
		System.out.println("04");
	}
	void method05 (String s) {    
		System.out.println("05");
	}
	void method06 (Random r) {    
		System.out.println("06");
	}


}
