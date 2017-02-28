package day03;

public class Test03 {
 public static void main(String[] args) {
	//배정 연산자
	int a = 10;
	a *= 3 + 4; // 설명: a*=7,a=a*7/ a=a*(3+4) , 연산자 우선순위
	
	 
	 
	 
	 
	/* //논리 연산자(&&,||)
	 int a=10;
	 int b=5;
	 boolean bool = (a<10 && b++ == 5);
	// boolean bool = (a<10 & b++ == 5); A가 거짓인데 B도 계산하는 경우임. 불필요 
	 System.out.println("bool: "+bool);
	 System.out.println("a: "+a);
	 System.out.println("b: "+b);
	 
	 //&&연산에서 A가 거짓이면 결과에 영향을 줄 수 없기 때문에 그 뒤의 연산은 실행하지 않음
	 //따라서 b의 값은 증가하지않고 그대로 5로 출력
	 
	 
	/* 
	 //비교 연산자
	 int a=10;
	 int b=20;
	 System.out.println((a==b)?"같다":"다르다");
	 System.out.println((a!=b)?"다르다":"같다");

	 
	 boolean flag=false;

	  // System.out.println((a=b)?"같다":"다르다");
	  // a=b이면 a에 b의 값을 대입하여 a=20이 됨
	 System.out.println((flag==false)?"false":"true");
	 System.out.println((flag=false)?"false":"true");
     //flag=false로 썼기때문에 flag에 false값을 대입. flag=false가 조건식이므로 true 출력. 잡아내기 어려운 오류.
	 
	 
	 
	  //산술 연산자
	System.out.println('a'+'A'); //int보다 작은 단위의 산술 연산 결과는 int
	
	byte b=1;
	byte b2=2;
	byte b3=(byte)(b+b2); //산술연산의 결과는 int보다 작은 타입들은 int로 변환된다.
	//(byte)를 해주지 않으면 int를 byte에 옮겨야하기때문에 오류가 발생한다.
	
	System.out.println(b+b2); 
	 
	 System.out.println(1%2);
	 System.out.println(2%2);
	 System.out.println(3%2);
	 System.out.println(4%2);
	 System.out.println(5%2);
	 
	 int val=1;
	 System.out.println(val++%2);
	 System.out.println(val++%2);
	 System.out.println(val++%2);
	 System.out.println(val++%2);
	 System.out.println(val++%2); //반복제어문 필요
	 
	 
	 System.out.println((1%2)==0?"짝수":"홀수"); //홀짝 구분
	 
	 
	 
	 /*삼항연산자
 int a=5;
 int b=3;
 
 // String result = (a>b)?a:b; 
 String result = (a>b)?"a는 b보다 크다":"a는 b보다 작다";
 System.out.println(result);
 //a와 b의 크기가 같을 경우 오류 발생.
 int a2=5;
 int b2=5;
 String result2 = (a2>b2)?"크다"
		        :(a2==b2)?"같다": "작다";
 System.out.println(result2);
 //2개 이상의 결과가 발생할 때 3항 연산자를 하나 더 사용하여 문제 해결
 //가독성 측면에서 상황이 2가지로 나뉘는 경우 해석하기 좋음. 그 이상은 조건문 사용 권장

 
 /*int result = (a>b)?a:b; //결과값이 정수형태기 때문에 int로 받아줌
 System.out.println(result);
	 
 int a2=5;
 int b2=3;
 int result2 = (a<b)?a:b;
 System.out.println(result2);

 System.out.println((a<b)?a:b); //간단하게 줄이는 방법 */
 
 
 
}
}
