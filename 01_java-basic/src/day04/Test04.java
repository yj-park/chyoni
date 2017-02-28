package day04;

public class Test04 {
	public static void main(String[] args) {
		
		/*
		 * 
		 * for (1. 초기값; 2. 조건식; 3. 증감){
		 *      4. 실행문장들
		 * }
		 * 5. ... //조건식이 거짓일 때 빠져나옴
		 * 
		 * while (조건식) {
		 * 
		 * }   //조건식이 참일 때 빠져나옴
		 *
		 * //while문 → for문
		 * 1.초기값
		 * while (2.조건식) {
		 *       4.실행문장들
		 *       5.증감 
		 * }
		 *
		 */
		
		System.out.println("for 문");
		for (int i = 1; i <= 10; i++){
			System.out.println(i);
		}
		
		System.out.println("while 문");
		int i = 1;
		while(i <= 10) {
		     System.out.println(i);
		     i++;
		     
		     
		}
	}

}
