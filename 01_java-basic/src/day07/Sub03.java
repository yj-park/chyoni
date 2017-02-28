package day07;

import java.util.Random;
import java.util.Scanner;

public class Sub03 {
	/*
	 * add : 두 수의 합을 구한 뒤 결과를 반환
	 * sub : 두 수의 차를 구한 뒤 결과를 반환
	 * mul : 두 수의 곱을 구한 뒤 결과를 반환
	 * div : 두 수의 제를 구한 뒤 결과를 반환
	 */
	int add(int num1, int num2) {
		return num1 + num2;
	} 
	int sub(int num1, int num2) {
		return num1 - num2;
	} 
	int mul(int num1, int num2) {
		return num1 * num2;
	} 
	int div(int num1, int num2) {
		return num1 / num2;
	} 
	
	/*
	 * 위의 정의된 사칙연산과 연관된 기능을 하나로 합치자
	 */
	
	/**
	 * @param type : 1(더하기), 2(빼기), 3(곱하기), 4(나누기)
	 * @param num1
	 * @param num2
	 * @return
	 */
	int cal(int type, int num1, int num2) { //어떤 계산을 할 지 결정하는 매개변수가 하나 더 필요(int type)
		if (type == 1) return num1 + num2;
		if (type == 2) return num1 - num2;
		if (type == 3) return num1 * num2;
		if (type == 4) return num1 / num2;
		return 0;
	}
	
	/*
	 * 1부터 10사이의 정수를 랜덤하게 5개 생성해서 배열에 담아 반환한다.
	 */
	/* 리팩토링 전 
	 * int[] makeNumbers() {
		// int[] mN = new int[5];
		Random r = new Random();
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = r.nextInt(10)+1;	
		}
		return arr;
	}
	// 배열의 크기 -> 사용자 지정
	int[] makeNumbers(int count) {
		Random r = new Random();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = r.nextInt(10)+1;	
		}
		return arr;
	}
	// 배열의 크기 & 랜덤숫자의 범위 -> 사용자 지정
	int[] makeNumbers(int count, int max) {
		Random r = new Random();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = r.nextInt(max)+1;	
		}
		return arr;
	}*/
	
	// 리팩토링 후 (기능이 제일 많은 코드를 기본으로 남겨두고 중복 삭제)
	int[] makeNumbers() {
		return makeNumbers(5, 10);		
	}
	// 배열의 크기 -> 사용자 지정
	// 같은 클래스 내에서는 .(jump)필요 X
	int[] makeNumbers(int count) {
		return makeNumbers(count, 10);
	}
	// 배열의 크기 & 랜덤숫자의 범위 -> 사용자 지정
	int[] makeNumbers(int count, int max) {
		Random r = new Random();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = r.nextInt(max)+1;	
		}
		return arr;
	}
	
	
	
	
}
	


