package day02.quiz;

public class Quiz01 {
 public static void main(String [] args) 
 { int i=0;
	 //i변수에 값을 할당하는 것은 try블럭에서 해야만 한다.
	 //오류가 나지 않도록 코드를 수정하시오.
	
	 /*제일 큰 범위에서 int i 선언
	  * int i; The local variable i may not have been initialized.→i의 값을 초기화 
	  * int i=0
	  */
	 try
	 {
		 i=100;
	 }
	 catch (Exception e)
	 {
		 System.out.println(e);
	 }
	 finally 
	 {
		
		 System.out.println(i);
	 }
 }
}
