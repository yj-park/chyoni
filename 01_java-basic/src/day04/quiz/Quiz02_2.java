package day04.quiz;

import java.util.Scanner;
import java.util.Random;

public class Quiz02_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//정답 숫자
		Random r = new Random();
		int answer = r.nextInt(1000)+1;		
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");
		
		int i = 1;
		for ( ; i <= 10; i++) {
			System.out.print(i + "회. 숫자를 입력하세요(1 - 1000) : ");
			int input = Integer.parseInt(sc.nextLine());
			if ( answer == input){
				System.out.println("정답입니다.");
				break;
			}
			System.out.printf(
					"%d보다 %s 값 입니다.\n", input, (answer > input) ? "큰" : "작은" );
		}
		if (i == 11);
		System.out.println("10회 안에 맞추기 게임에 실패하셨습니다.");
		System.out.printf("정답은 %d입니다.", answer);
	}

}
