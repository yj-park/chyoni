package day04.quiz;

import java.util.Scanner;
import java.util.Random;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정답 숫자
		Random r = new Random();
		int answerNum = r.nextInt(1000)+1;
		
		boolean flag = false;
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");
		for (int count = 1; count <= 10 ; count++ ){
			System.out.print(count + "회. 숫자를 입력하세요(1 - 1000) : ");
			    int tryNum = Integer.parseInt(sc.nextLine());
				if (tryNum == answerNum) {
					flag = true;
					System.out.println("정답입니다.");
					break;
				} 
				if (tryNum < answerNum) {
					System.out.println(tryNum + "보다 큰 값 입니다.");
				} else
					System.out.println(tryNum + "보다 작은 값 입니다.");
					
				}
			if (flag == false){
				System.out.println("10회 안에 맞추기 게임에 실패하였습니다.");
		        System.out.printf("정답은 %d입니다.", answerNum);
			}
		}
	}


