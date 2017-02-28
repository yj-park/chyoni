package day04.Exam;

import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		
		int i = 0;
		int k = 0;
		if (a == b) {
			for (i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", a, i, a * i);
			}
		}
		else if (a > b) {
			for (k = b; k <= a; k++) {
				for (i = 1; i <=9 ; i++) {
					System.out.printf("%d * %d = %d\n", k, i, k * i);
				}
			}
		}
		else if (a < b){
			for (k = a; k <= b; k++) {
				for (i = 1; i <=9 ; i++) {
					System.out.printf("%d * %d = %d\n", k, i, k * i);
				}	
			}
		}
	}
}
	

		

		
		
	


