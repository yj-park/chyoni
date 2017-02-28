package day03.Exam;

 import java.util.Scanner;
 
public class Exam04 {
 
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("정수를 입력하세요 : ");
	int num1 = sc.nextInt();
	
	
	System.out.print("나눌 수를 입력하세요 : ");
	int num2 = sc.nextInt();
	
	
	int mok = num1 / num2;
	int nmg = num1 % num2;


	System.out.println("몫 : " + mok);
	System.out.println("나머지 : " + nmg);
	
	
	
 }
	
	
}
