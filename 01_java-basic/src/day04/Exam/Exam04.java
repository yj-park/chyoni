package day04.Exam;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요(2 - 10) : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.printf("%d의 배수 : ", num);
		
		for(int i = 1; i <= 10; i++){
			System.out.printf("%-4d", num * i);
		}
	}

}
