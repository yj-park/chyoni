package day03.Exam;

 import java.util.Scanner;
 
public class Exam05 {
	
	public static void main(String[] args) {
		System.out.print("나이를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("나이를 입력하세요 : " + s);
		
		int age = Integer.parseInt(s);
		
		if (age < 5) {
			System.out.println("입장료는 무료입니다.");
		} else if (age >= 5 && age <= 11 ) {
			System.out.println("입장료는 2500원입니다.");
		} else {
			System.out.println("입장료는 5000원입니다.");
		}
	}
	
}
