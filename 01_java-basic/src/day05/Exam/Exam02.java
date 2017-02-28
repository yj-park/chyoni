package day05.Exam;

import java.util.Random;

public class Exam02 {
	public static void main(String[] args) {
		Random r = new Random();
		
		int[] iArr = new int[4];
		
		System.out.println("요소\t 생성된 수\t\t 출력");
		int iNum = 0;
		for(iNum = 0; iNum < iArr.length; iNum++){
			int rNum =  r.nextInt(10)+1;
			System.out.printf("%d \t %d \t\t ", iNum, rNum);
		for(int s = 1; s <= rNum; s++)
				System.out.print("*");
			System.out.println();
		}		
	}

	
}
