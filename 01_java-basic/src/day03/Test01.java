package day03;

public class Test01 {
public static void main(String[] args) {
	
	Test01 t01=new Test01();    //만든 클래스를 데이터타입으로 사용 가능
	
	
	int i=100;
	byte b=100;
	
	//묵시적 형변환, 암묵적 형변환, 업캐스팅 
	int i2=b;
	
	//byte b2=i; //컴파일 오류 발생
	
	//명시적 형변환, 다운캐스팅
	byte b2=(byte)i;
	
	System.out.println(i2);
	System.out.println(b2);
	
    int i100=257;
    byte b200=(byte) i100;
    System.out.println(b200);
    
    int i50=128;
    byte b50=(byte)i50;
    System.out.println(b50);

	char c='a';
	int i3=c;
	
	System.out.println(i3);

	//'C'의 아스키 코드를 화면에 출력하시오
	char c2='C';
	int i4=c2;
	System.out.println(i4);  //초보자. 변수 사용 多 .한 번 쓰이는 코드를 최대한 줄이려 노력할 것. 
	
	int i5='C';
	System.out.println(i4);   // i5 변수 역시 한 번만 쓰임. 더 줄이려고 노력.
	
	System.out.println((int)'C');
	
	
	
}
}


