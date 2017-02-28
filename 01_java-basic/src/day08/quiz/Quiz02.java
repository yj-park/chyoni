package day08.quiz;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	
	public static void totalMovieCount() throws Exception {
		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		int count = 0;
		while (sc.hasNextLine()) {
			sc.nextLine();
			count++;
	}
	System.out.printf("전체 상영된 영화 %d편\n", count);
}
	public static void getMovieCountByNameLength(int len) throws Exception {	
		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		int count = 0;
		while (sc.hasNextLine()) {
			 String line = sc.nextLine();
			 String[] arr = line.split(":");
			 if (arr[0].length() == len) 
			count++;	
		} 
		System.out.printf("제목이 %d글자인 영화 %d편\n", len, count);
	}
	public static void getMoviecountByYear(int year) throws Exception {	
		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		int count = 0;
		while (sc.hasNextLine()) {
			 String line = sc.nextLine();
			 String[] arr = line.split(":");
			 if (Integer.parseInt(arr[2]) == year ) 
			count++;	
		} 
		System.out.printf("%d년도에 상영한 영화 %d편\n", year, count);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		// 실행시에 아래와 같은 결과가 출력되도록 코드를 작성하시오
		
		// 전체 상영된 영화 카운트
		totalMovieCount();
		// 제목이 지정된 글자수와 같은 영화
		getMovieCountByNameLength(2);
		// 영화 상영 년도를 기준으로 카운트 조회
		getMoviecountByYear(2016);
	
	
	//연관된 데이터는 클래스로 관리	
		
    }
}