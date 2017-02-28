package day03.Exam;

 import java.util.Scanner;
 
public class Exam07 {
	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("숫자를 입력하세요 : " + s);
		
		int num = Integer.parseInt(s);
		
		if (num < 0){
			int num2 = - num;
			System.out.println(num + "의 절대값: " + num2 );
		} else {
			System.out.println(num + "의 절대값: " + num);
		}

		
	}
 
}
