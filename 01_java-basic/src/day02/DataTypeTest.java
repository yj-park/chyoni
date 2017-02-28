package day02;

public class DataTypeTest {
 public static void main(String [] args) {
	//기본형은 8가지이고 소문자로 시작한다.
	//논리형, 문자형, 숫자
	boolean bool=true;
	bool=false; //선언은 아님. 데이터 타입은 없고 이름만 있기 때문. 값을 할당하는 것
	            //모든 변수 공간에는 하나의 값만 저장. 제일 마지막 값이 유지됨
	System.out.println(bool);
	
	char ch='가';
     //ch='가나' char는 한 글자만 가능. 문자열은 String 사용. 
	char ch2=97; //문자를 숫자형태로 관리 아스키 코드 (A=65 a=97으로 관리)
	char ch3='\u0061';//16진수인 유니코드로 표현. 문법적으로 가능한 표현
	System.out.println(ch);
	System.out.println(ch2);
	System.out.println(ch3);
	
	/*
	 * //숫자형 (크기의 범위가 다름)
	byte b=1; //1byte  -128~127까지만 가능. 
	short s=1; //2byte 
	int i=1;
	long l=1l; 
    l=1L; //숫자 뒤에 L or l자를 붙이면 long 타입 강제 부여
	
    //float은 반드시 실수형 숫자 뒤에 f,F를 붙여야한다. (데이터의 크기 때문에 오류가 발생할 수 있기 때문)
    float f=1.1f;
    f=1.1F;
    
    double d= 1.1; //가장 많이 사용하는 형태
    
    */
    
}
}