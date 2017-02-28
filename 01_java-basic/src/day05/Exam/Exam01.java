package day05.Exam;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		String[] sArr = {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신이 태어난 년도를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		

			
		for (int i = 0; i < sArr.length ; i++){
			if (num % 12 == i){ 
			System.out.printf("%d년에 태어난 당신은 %s띠입니다.",num, sArr[i]);
			}
		}
	}

}
