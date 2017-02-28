package day04;

public class Test01 {
	public static void main(String[] args) {
		/*
		 *  for ( 초기값 ; 조건식 ; 증감 ) 
		 *       실행문장 ;   
		 *       
		 *       
		 *  for ( 1.초기값 ; 2.조건식 ; 3.증감 ) {
		 *        4.실행문장 ;    실행문장이 여러개일 때 블럭 설정
		 *          실행문장 ;
		 *       }
		 *       5.
		 *       
		 * 수행순서: 1 -> 2(참일 경우) -> 4 -> 3 
		 *          -> 2(참일 경우) -> 4 -> 3
		 *          ....... 
		 *          ....... 
		 *          -> 2(거짓일 경우) -> 반복문 종료(5)
		 *          
		 * 참고        
		 * 1, 2, 3번 항목 모두를 비워둘 수 있다.무한반복용도. 선택사항일 뿐 필수 X
		 * for ( 1.초기값 ; ; 3.증감 )
		 * for ( 1.초기값 ; ; )
		 * for ( ; 2.조건식 ; )
		 * for ( ; ; )
		 *
		 */
				
		int i = 0;
		for (i = 1; i <= 10; i++){
			
			if (i%3 ==0){
				System.out.println(i);
			} else {
				System.out.println(i * 2);
			}
			
			/*또다른 코딩 tip int val = i;
			if (i%3 != 0) val = i * 2;
			System.out.println(val); + 3항연산자 방식도 공부해*/ 
		
		
		//for 뒤에 쓰인 i 변수는 블록 안에서만 쓸 수 있음
		
		
		
		/* 무한반복 실행
		 * int val = 1;
		for (;;) {
			System.out.println(val++);
		*/
			
		
			
	}

	}
}
