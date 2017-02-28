package day05.quiz;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int [] arr = {6, 8, 3, 9, 7, 4};
		/*
		 * 수를 입력 : 3
		 * 배열에 1개가 들어있습니다.
		 * 
		 * 수를 입력 : 1
		 * 배열에 0개가 들어있습니다.
		 * 
		 * 수를입력 : -1
		 * 종료합니다.
		 */
		
		Scanner sc = new Scanner(System.in);		
		while(true){
			System.out.print("수를 입력 : ");
		    int num = Integer.parseInt(sc.nextLine());
		    System.out.println();
		    if (num == -1) break;
		
		    int count = 0;
		    for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				count++;
				
			/*
			 * int count = 0;
			 * for(int val : arr) {
			 *    if (val == num) 
			 *    count++;
			 *    }
			 *     
			 *     for (int i = 0; i < arr.length; i++) {
			 *         if (arr[i] == num) {
			 *         count++;
			 *         }
			 *        } 	
			 */
			} 
		}
		System.out.printf("배열에 %d개가 들어있습니다.\n", count);

	  }
		System.out.println("종료합니다.");
	
	}
	}


