package day03.Exam;

import java.util.Scanner;

public class Exam06 {
   public static void main(String[] args) {
	
	System.out.print("물건값을 입력하세요(만원) : ");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	System.out.println("물건값을 입력하세요(만원) : " + s);
	
	int mon = Integer.parseInt(s);
	
	if (mon <= 10) {
		int mon2 = mon*9700;
		System.out.println("할인된 금액은 " + mon2 + " 원입니다.");
	} else if (mon > 10 && mon <= 20) {
		int mon3 = mon*9500;
		System.out.println("할인된 금액은 " + mon3 + " 원입니다.");
	} else if (mon > 20 && mon <= 30) {
		int mon4 = mon*9200;
		System.out.println("할인된 금액은 " + mon4 + " 원입니다.");
	} else {
		int mon5 = mon*9000;
		System.out.println("할인된 금액은 " + mon5 + " 원입니다.");
	}
   	
}
}
