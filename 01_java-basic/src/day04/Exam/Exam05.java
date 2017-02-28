package day04.Exam;

import java.util.Scanner;

public class Exam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.print("수를 입력하세요: ");
		int num = Integer.parseInt(sc.nextLine());
		
	
		int sum = 0;
		for(int i = 1; i < num; i++){
			if(num % i == 0){
				sum += i;
			}
		 }
		if(sum == num){
			System.out.printf("%d은 완전수입니다.", num);
		}
		
	}
}	


