package day05;

import java.util.Arrays;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		//배열에 입력된 요소를 확인하는 방법
		int[] iArr = {10, 20, 30};
		
		
		//1번 방법: 배열의 크기만큼 반복
		System.out.println("1번 방법");
		for (int i = 0; i < iArr.length; i++){
			System.out.println(iArr[i]);
		}
		System.out.println("--------------------");
		
		//2번 방법: 향상된 for문(1.5이후부터 가능)
		System.out.println("2번 방법");
		for (int i : iArr){                // for (배열 요소(받을 수 있는 데이터 타입) : 배열명)
			System.out.println(i);
		}
		System.out.println("--------------------");
		
		boolean [] bArr = {true, false, true};
		for (boolean b : bArr){                
			System.out.println(b);
		}
		System.out.println("--------------------");
		
		char [] cArr = {'a', 'b', 'c'};
		for (char c : cArr) {
			System.out.println(c);
		}
		System.out.println("--------------------");
		
		
		Random[] rArr = {null, null, null};
		for ( Random r : rArr) {
			System.out.println(r);
		}
		System.out.println("--------------------");
		
		//3번 방법: 단순히 배열의 요소값만을 확인
		System.out.println("3번 방법");		
		String data = Arrays.toString(iArr); 
		//toString은 Arrays라는 클래스에 속해있는 메소드로 iArr이라는 배열의 내용을 문자열로 바꿔준다
		System.out.println(data);
		
		System.out.println(Arrays.toString(iArr)); //data라는 변수는 한 번밖에 사용하지 않으므로 줄여서 쓸 것
		
	}

}
