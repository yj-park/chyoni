package day04.Exam;

import java.util.Random;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt();
		
		Scanner sc = new Scanner(System.in);	
		System.out.print("수를 입력하세요 : ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("수를 입력하세요 : ");		
		int b = Integer.parseInt(sc.nextLine());
		
		int sum = 0;
		for (int i=a; i <=b; i++){
			sum += i;
		} System.out.printf("%d부터 %d까지의 합은 %d입니다.", a, b, sum);
		
		
	}

}
