package day03.Exam;

 import java.util.Random;
 
public class Exam09 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int num = r.nextInt(100)+1;
		
		System.out.println(num);
		String type; 
		
		 if (num % 2 == 0) {
			 type = "짝수";
		 } else {
			 type = "홀수";
		 } 
			 System.out.printf("생성된 숫자 (%d)은 %s입니다.", num, type);
			 
			 
	     /* 3항연산자 사용
	      * System.out.printf("생성된 숫자 (%d)은 %s입니다.", 
	      *                    num, 
	      *                  ( num % 2 == 0) ? "짝수" : "홀수");
	      */
		 
			 
			 
		 //영향을 받는 부분과 받지 않는 부분을 구분
			 
		 /*if ((num) % 2 == 0) {
			 System.out.printf("생성된 숫자 (%d)은 짝수 입니다.", num);
		 } else {
			 System.out.printf("생성된 숫자 (%d)은 홀수 입니다.", num);
		 }*/
	
		
	}

}
