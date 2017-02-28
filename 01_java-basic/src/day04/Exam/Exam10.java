package day04.Exam;

import java.util.Scanner;

public class Exam10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출력할 행의 수를 입력하세요(1-10) : ");
		int num1 = Integer.parseInt(sc.nextLine());		
		System.out.print("출력할 열의 수를 입력하세요(1-10) : ");		
		int num2 = Integer.parseInt(sc.nextLine());		
		
		if (num1 % 2 == 1) {
			for(int c = 1; c <= num1; c++){
				for(int r = 1; r <= num2; r++){
					if (c % 2 == 1) System.out.print("<");
				}
				System.out.println(">");
			}
		} 
	}
}
		
		

