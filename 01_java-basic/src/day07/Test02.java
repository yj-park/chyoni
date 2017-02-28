package day07;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Sub02 s02 = new Sub02();
		s02.method01();
		int val = s02.method01(); // int 타입으로 넘겨주니 int로 받을게 
		System.out.println("method01 : " + val);
		
		char ch = s02.method02();
		System.out.println("method02 : " + ch);
		
		
		String s = s02.method03();
		//"성공"이 출력된다.
		System.out.println("method03 : " + s);
		
		Random r = s02.method04();
		System.out.println("method04 : " + r.nextInt());
		
		int[] arr = s02.method05();
		
		HaHa ha = s02.method06(new KiKi());
		
	}

}
