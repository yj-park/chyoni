package day04.Exam;

import java.util.Random;

public class Exam09 {
	public static void main(String[] args) {
		Random r = new Random();
		int rNum = r.nextInt(11)+10;
		System.out.println("숫자: " + rNum);
		System.out.print("소수: " );
		
		int findPNum = 0;
		int findNum = 0;
		int nct = 0;
		
		for (findPNum = 2; findPNum <= 100; findPNum++) {
			int count = 0;
			for (findNum = 1; findNum <= findPNum; findNum++) {
				if (findPNum % findNum == 0) count++;
			} 
			if (count == 2) {
				nct++;
				if (nct == rNum + 1) break;
				System.out.print(findPNum + " ");
			}
		}
	}

		
		
}



