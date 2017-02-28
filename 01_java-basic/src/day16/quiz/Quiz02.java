package day16.quiz;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Quiz02 {
	public static void main(String[] args) {
		/*
	   화면에서 문자를 입력받아 입력받은 문자를 출력
       단, 문자는 한문자만 입력 받는다.
       입력받은 문자가 'Q' 또는 'q' 일경우 
       화면에 "종료합니다" 메시지 출력 
       
       실행결과 >
       한문자를 입력하세요 : m
       입력된 문자는 m 입니다.
       한문자를 입력하세요 : q
       종료합니다. 
		 */
		InputStream in = System.in; 
		try {
			while(true) {
				System.out.print("한문자를 입력하세요 : ");
				int ch = in.read();
				if (ch =='Q' || ch == 'q') break;
				int ch1 = in.read(); // \r
				int ch2 = in.read(); // \n
				System.out.print("입력된 문자는" + (char)ch + "입니다.\n");
			 } 
			System.out.println("종료합니다.");
		} catch (Exception e) {
					e.printStackTrace();
				}
		
		
		
		
	}
}
