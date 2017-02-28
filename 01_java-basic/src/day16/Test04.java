package day16;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04 {
	public static void main(String[] args) {
		
		// IO클래스를 활용한 화면에서 데이터 읽기
		// 지금 우리가 쓰는 방법은 Scanner로 읽기(1.5이후 추가된 기능)
		// InputStream -> 입력받을 때 byte타입으로 받겠다.
		// byte단위로만 읽기 때문에 한글 깨짐 -> ImputStreamReader 사용
		
		InputStream in = System.in; 
		InputStreamReader isr = new InputStreamReader(in);
		try {
			while(true) {
				int ch = isr.read();
				System.out.print((char)ch);
			 } 
		} catch (Exception e) {
					e.printStackTrace();
				}
		
		
		/*
		InputStream in = System.in; 
		System.out.print("입력 : ");
		try {
			while(true) {
				int ch = in.read();
				//System.out.println(ch);
				System.out.print((char)ch);
				// (char)로 형변환시켰기때문에 \r\n도 문자열이 됨 
				// 더이상 읽을 문자열이 없으면 대기
			}
		 } catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// a 입력 시 97이라는 아스키코드 값 반환
		// 1 입력 시 49라는 아스키코드 값 반환
		// 문자에 대한 아스키코드 값이 출력됨
		// byte단위 처리 메소드기 때문에 1byte만 읽어냄. 
		// 따라서 여러 문자열을 입력해도 하나의 문자열에 대한 아스키코드 값만 반환
		// 여러개의 문자열을 읽어내려면 반복문 이용
	}

}
