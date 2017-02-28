package day02;

public class VariableScopeTest 
{
 public static void main(String [] args)
 {
	 
	 {
	 //선언 전에는 사용이 불가능하다.
	 //System.out.println(a); //에러 발생
	 int a = 10;
	 //선언된 이후로는 사용이 가능하다.
	 
	 
	 // int a = 10; 중복되는 선언이 있는 경우 에러 발생
	 System.out.println(a);
	 }
	 /*	변수의 범위를 벗어나서 정의되었기때문에 System.out.println(a);는 오류가 발생 
	 ->변수 a가 선언되어있는지 or 범위를 벗어나지는 않았는지 or 변수 이름 오류(복붙을 이용해)인지 확인 
	 */
	 int a = 20;
	 System.out.println(a); //새로운 선언 가능 범위가 달라졌기 때문에
}
}