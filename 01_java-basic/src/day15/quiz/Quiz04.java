package day15.quiz;

import java.util.Arrays;

public class Quiz04 {
	public static void main(String[] args) {
		Data d1 = new Data(3);
		Data d2 = new Data(9);
		Data d3 = new Data(5);
		
		Data[] arr = {d1, d2, d3};
		
		// 코딩추가
		/*
		 * sort의 대상이 되는 클래스는 Comparable 인터페이스의 자식클래스이어야 한다.
		 * 정렬의 기준은 compareTo 메소드를 정의한다.
		 * 
		 */
		// 정렬을 하려면 기준이 필요!
		// comparable 이라는 인터페이스를 상속받게하여 형변환시켜 자동으로 호출되게해야한다.
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		
		/*
		// 배열 안 데이터를 오름차순 정렬
		int[] iArr = {3,9,5};
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		
		// 문자열도 정렬할 수 있는 기준 有 -> 아스키 코드
		String[] sArr = {"hello", "test", "java"};
		Arrays.sort(sArr);
		System.out.println(Arrays.toString(sArr));
		*/
		
	}

}
