package day05.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		int [] arr = {6, 8, 3, 9, 7, 4};
		
		/*
		 * 출력형식 >
		 * 바꿀 인덱스 : 2
		 * 바꿀 인덱스 : 4
		 * arr 배열의 결과 : [6, 8, 7, 9, 3, 4]
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("바꿀 인덱스 : ");
		int i1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("바꿀 인덱스 : ");
		int i2 = Integer.parseInt(sc.nextLine());
		
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
		
		
		System.out.print("arr 배열의 결과 : ");
        System.out.println(Arrays.toString(arr));		
	}

}
