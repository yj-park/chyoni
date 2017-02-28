package day03.Exam;

 import java.util.Random;
 
public class Exam10 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(101);
		System.out.println(num + 1);
		
		if ((num + 1) < 60) {
			System.out.println("재수강");
		} else if ((num + 1) >= 60 && (num + 1) <=90 ) {
			System.out.println("잘했어요");
		} else {
			System.out.println("당신은 장학생");
		}
		
		
		
	}

}
