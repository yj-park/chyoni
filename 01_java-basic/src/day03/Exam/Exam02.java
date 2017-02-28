package day03.Exam;

import java.util.Scanner;

public class Exam02 {
   public static void main(String[] args) {

	   
	Scanner sc = new Scanner(System.in);
	System.out.print("초를 입력하세요 :");
	String s = sc.nextLine();
	System.out.print("초를 입력하세요 :"+s);
	
	int num = Integer.parseInt(s);
	int hrs = num / 3600;
	int min = (num % 3600) / 60;
	int sec = (num % 3600 % 60);
	
	System.out.printf("\n%d초는 %d시간 %d분 %d초입니다.\n",num,hrs,min,sec);
		
}
}
