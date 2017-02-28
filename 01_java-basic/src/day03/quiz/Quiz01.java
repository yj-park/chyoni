package day03.quiz;

import java.util.Scanner;

public class Quiz01 {
 public static void main(String[] args) {
	//화면에서 아래와 같이 출력될 수 있도록 코딩을 작성하시오
	/*
	 * 조건:
	 * 5000원 미만을 입력할 경우 "치즈버거를 살 수 있습니다."출력
	 * 5000원~10000원 사이일 경우  "불고기버거 세트를 살 수 있습니다."출력
	 * 10000원보다 클 경우 "패밀리 세트를 살 수 있습니다."출력
	 * 
	 * 출력형식>
	 * 
	 * 어서오세요 고객님 롯데리아입니다.
	 * 
	 * 현재 가진 돈을 입력하세요:_3500
	 * 치즈버거를 살 수 있습니다.
	 * 
	 * 현재 가진 돈을 입력하세요:_5100
	 * 불고기버거 세트를 살 수 있습니다.
	 * 
	 * 현재 가진 돈을 입력하세요:_10100
	 * 패밀리 세트를 살 수 있습니다.
	 * 
	 */

	 System.out.println("어서오세요 고객님 롯데리아입니다.");
	 Scanner sc=new Scanner(System.in);
	 System.out.print("현재 가진 돈을 입력하세요:");
	 String mon=sc.nextLine();
	 System.out.println("현재 가진 돈을 입력하세요:"+mon);
	 
	 
	 int mon2=Integer.parseInt(mon);
	 if(mon2<5000) {
		   System.out.println("치즈버거를 살 수 있습니다");
	 } else if(mon2>=5000 && mon2<10000) {
		   System.out.println("불고기버거 세트를 살 수 있습니다.");  
	 } else {
			   System.out.println("패밀리 세트를 살 수 있습니다.");
		   }
	 }
	 
	 
}
