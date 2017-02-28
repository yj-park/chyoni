package day04.Exam;

import java.util.Random;

public class Exam03 {
	public static void main(String[] args) {
		
		int i = 0;
		int sum = 0;

		for (i = 1; i <= 5 ; i++){
			Random r = new Random();
		    int num = r.nextInt(100)+1;
		    System.out.println(num);
		    
		    sum = sum + num;
		    
		    if (i == 6){
		    	break;
		    } 
			   
		}   int ave = 0;
	        ave = sum / (i-1) ;
	        System.out.println("평균 :" + ave);
		    System.out.println("합계 :" + sum);
		
		
		
	}

}
