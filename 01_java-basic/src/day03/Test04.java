package day03;

public class Test04 {
 public static void main(String[] args) {
     /*
	 if(조건식-참 or거짓인 문장)
	  실행할 문장(조건식이 참일 경우)
	  
	  
	 주의사항)
	 if 문에 블럭을 같이 사용하지 않을 경우에는 한 문장만을 대상으로 처리한다.
	 2문장 이상을 if문의 대상으로 하려면 반드시 블럭({})과 같이 사용해야한다.
	 ;은 문장을 나누는 단위
	 
	 */
	 /*
  int a=4;
  if (a>5)
	  System.out.println("a는 5보다 크다");
      System.out.println("a는"+a); //if가 적용되는 구간이 아니기때문에 if조건과 상관없이 a값 출력
  
  if (a>5){
	  System.out.println("a는 5보다 크다");
      System.out.println("a는"+a); }
  
  
  //a가 짝수일 경우 "짝수입니다"를 화면에 출력
  if (a%2==0)
	  System.out.println("짝수입니다");
 */
	 
	 /*
  //a가 짝수일 경우 "짝수입니다"를 홀수일 경우 "홀수입니다"를 화면에 출력
	int a=10;
	if (a%2==0)
		  System.out.println("짝수입니다");
	if (a%2==1)
		System.out.println("홀수입니다");  //결과는 맞지만 효율성 떨어짐
	/*
	 2가지 상황일 경우
	 if(조건식)
	 참을 경우 실행할 문장
	 else
	 참이 아닐 경우 실행할 문장
	 */
	 /*
	if (a%2==0){
		 System.out.println("짝수입니다");
	}else{ 
	System.out.println("홀수입니다");}
	
	if (a%2==0) {
		 System.out.println("짝수입니다");
	     System.out.println("a는"+a); }
	else 
	System.out.println("홀수입니다");
	

	 */
	 
   int a=10;
  //a는 5보다 크다, a는 5이다, a는 5보다 작다
   if(a>5) {
	   System.out.println("a는 5보다 크다");
   } else {
	   if(a==5) {
		 System.out.println("a는 5이다");  
	   }else {
		   System.out.println("a는 5보다 작다");
	   } //동시에 발생할 수 없는 상황이므로 동일 선상에 두고 처리하는 것이 좋음→다중if문
	   
	   /* 다중 if문
	    * if(조건식){
	    * 참일 경우 수행
	    * }else if(조건식){
	    * 참일 경우 수행
	    * }else{
	    * 
	    * }
	    * 
	    *
	    */
    if(a>5) {
	   System.out.println("a는 5보다 크다");
   } else if(a>5) {
	   System.out.println("a는 5이다");  
	   }else {
		   System.out.println("a는 5보다 작다");
	   }
   
	
	
 }
 }
 }

