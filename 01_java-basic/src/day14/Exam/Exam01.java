package day14.Exam;

import java.util.Calendar;

public class Exam01 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.printf("%d년 %d월\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH));
		System.out.print("일\t월\t화\t수\t목\t금\t토\t일\t");
		
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int nlCnt = 0;
		for(int i = 1; i <= lastDay; i++) {
			System.out.println(i + "\t");
			nlCnt++;
			if(nlCnt % 7 == 0) {
				System.out.println();
			}
		}
	}		
	
}

