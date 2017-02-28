package day03.Exam;

 import java.util.Random;
 
public class Exam08 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int num = r.nextInt(101);
		
		if (num + 1 > 60) {
 		System.out.printf("생성된 점수 : %d점(합격)", num + 1);
  	    } else {
  		  System.out.printf("생성된 점수 : %d점(불합격)", num + 1);
  	  }
	
	}

}
