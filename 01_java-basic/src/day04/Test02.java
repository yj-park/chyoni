package day04;

 import java.util.Scanner;
 
public class Test02 {
	public static void main(String[] args) {
		
		/*for (int i = 1; i <= 10; i++) {
			System.out.println(i); */
		
		
		
		/*
		 *  화면 출력>
		 *  **********
		 *  
		 *  for (int i = 1; i <= 10; i++) {
			System.out.print("*");
		 *  
		 */
		
		
		/*
		 * 화면 출력>
		 * *
		 * **
		 * ***
		 * 
		 * for (int i = 1; i <= 1; i++) {
			System.out.print("*");
			}
			System.out.println();
			for (int i = 1; i <= 2; i++) {
			System.out.print("*");
			}
			System.out.println();
			for (int i = 1; i <= 3; i++) {
			System.out.print("*");
			}
			System.out.println();
			
		   for (int i = 1; i <= 4; i++){
			  for (int i = 1; i <= 1; i++) {
			   System.out.print("*");
			  }
		    }			
		 */
		
		
		/*for (int i = 1; i <= 4; i++){
			for (int k = 1; k <= i; k++) {
			   System.out.print("*");
			}
			System.out.println();*/
			
		/*Scanner sc = new Scanner(System.in);
		System.out.print("별 개수 : ");
		int num = sc.nextInt(); // int num = Integer.parseInt(sc.nextInt());
		System.out.println();
  
		
		for (int i = 1; i <= num; i++){
			for (int k = 1; k <= i; k++) {
			   System.out.print("*");
			}
			System.out.println(); */
		
		/*Scanner sc = new Scanner(System.in);
		System.out.print("숫자 증가 : ");
		int num = sc.nextInt(); 
		System.out.println();
  
		
		for (int i = 1; i <= num; i++){
			for (int k = 1; k <= i; k++) {
			   System.out.print(k + " ");
			}
			System.out.println();*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("별 개수 : ");
		int num = sc.nextInt(); 
		System.out.println();
  
		
		for (int i = 1; i <= num; i++){
			//공백 찍기
			for (int k = 1; k <= num-i; k++){
			    System.out.print(" ");
			}
			//별 찍기
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}System.out.println(); 
		}
			
	}
	
}

