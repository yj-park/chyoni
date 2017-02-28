package day03.Exam;

import java.util.Scanner;

public class Exam03 {
   public static void main(String[] args) {

	 System.out.print("원의 반지름을 입력하세요:");
	 Scanner sc = new Scanner(System.in);
	 String s = sc.nextLine();
	 System.out.println("원의 반지름을 입력하세요:" + s);
	 
	 int rad = Integer.parseInt(s);
	 final double PI = 3.141592;  
	 double ext = (rad*rad)*PI;
	 
	 System.out.printf("반지름이 %d인 원의 면적은 %8.4f입니다.\n",rad,ext);
}
}
