package day07;

import java.util.Arrays;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		Sub03 s03 = new Sub03();
		
		int result1 = s03.add(20, 10);
		System.out.println("두 수의 합 : " + result1);
		
		int result2 = s03.sub(20, 10);
		System.out.println("두 수의 차 : " + result2);
		
		System.out.println("두 수의 차 : " + s03.sub(20, 10));
		System.out.println("두 수의 곱 : " + s03.mul(20, 10));
		System.out.println("두 수의 제 : " + s03.div(20, 10));
		
		System.out.println("합 : " + s03.cal(1, 20, 10));
		System.out.println("차 : " + s03.cal(2, 20, 10));
		System.out.println("곱 : " + s03.cal(3, 20, 10));
		System.out.println("제 : " + s03.cal(4, 20, 10));
		
		int[] arr = s03.makeNumbers();
		System.out.println(Arrays.toString(arr)); //day05의 Test03
		
		System.out.println(Arrays.toString(s03.makeNumbers(10))); 
		// 10 = count
		System.out.println(Arrays.toString(s03.makeNumbers(6, 45)));  //여기서 중복체크만 하면 로또
	}

}
