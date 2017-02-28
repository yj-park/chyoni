package day05.Exam;

import java.util.Random;

public class Exam03 {
	public static void main(String[] args) {
		Random r = new Random();
		
		int [] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
				      11, 12, 13, 14 ,15 ,16, 17, 18, 19, 20,
				      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				      31, 32, 33, 34, 35 ,36 ,37, 38, 39, 40,
				      41, 42, 43, 44, 45};
		int [] cArr = new int[45];
				
		int i = 1, c = 0;
		for(i = 1; i <= 10000; i++){
			for (c = 0; c < iArr.length; c++){
				int rNum = r.nextInt(45)+1;
				if (rNum == iArr[c]){
					cArr[c]++;
					}
				if (i == 10000){
				System.out.printf("%2d : %d\n" , iArr[c], cArr[c]);
				}
			}
			
		}
		
	}
}

