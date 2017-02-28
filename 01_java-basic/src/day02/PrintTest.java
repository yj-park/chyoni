package day02;

public class PrintTest {
 public static void main(String[] args) {
	/*
	 * System.out.println(); 줄넘김 O. 문자열을 출력하고 난 뒤 커서가 밑에 줄에 생성
	 * System.out.print(); 줄넘김 X. 문자열을 출력하고 나면 그 문자열의 옆에 커서 생성
	 * System.out.printf(); 줄넘김 X. C에서 가져온 언어인 f(format). 여러개의 값(변수+문자열)을 합쳐서 출력할 때 유용함. 가독성이 좋음
	 
	 System.out.println("나의");
	 System.out.print("이름은 홍\t길\t동입니다.\n"); // \n(new line) 줄넘김 , \t(tab) 띄우기=>답이 고정되어있는 상수, 문자열 상수*/
	 /*나의 
	   이름은
	  
	  홍길동입니다_
	  */
	// System.out.print("나의\n이름은\n\n홍길동입니다.");
 
	 //나의 이름은 홍길동이고 나이는 33세 입니다.
	 String name = "홍길동";
	 int age = 33;
	 System.out.printf("나의 이름은 %s이고 나이는 %d세 입니다.\n",name,age);//%의 개수만큼 ,적고 변수명을 적어줌
	 // 줄넘기기 위해서 \n을 쓰거나 System.out.println();쓴다
	 System.out.printf("나의 이름은 %s이고 나이는 %5d세 입니다.\n",name,age); //%5d age의 값을 넣을 때 5칸의 공간을 확보하라
	 System.out.printf("|%5d|\n",age); //오른쪽
	 System.out.printf("|%-5d|\n",age); //왼쪽
	 System.out.printf("|%05d|\n",age); //전체자리수앞에 0을 주게되면 나머지 자리가 0으로 채워짐
	 System.out.printf("|%f|\n",3.14); //기본 소수점 6자리까지
	 System.out.printf("|%.2f|\n",3.14); //소수점 2자리까지만
	 System.out.printf("|%5.2f|\n",3.14); //오른쪽
	 System.out.printf("|%-5.2f|\n",3.14); //왼쪽
	 
 }
}
