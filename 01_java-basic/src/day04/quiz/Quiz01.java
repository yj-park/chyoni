package day04.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		// 1 - 10 까지의 숫자의 합을 구하시오
		// 출력형식>
		// 1 - 10 까지의 합 : 55   변수가 2개 필요함
		// 짝수의 합 : 30
		// 홀수의 합 : 25
		
		//int sum = 0;
		int a = 0, b = 0;   //연관성있는 변수의 경우 한 줄에 써도 OK
		for (int i = 1; i <= 10; i++) {
	      // sum = sum + i;
	      // sum += i;   sum을 굳이 두 번 구하지 않아도 됨! 
			/* if (i % 2 == 0){
				 a += i;
			 } else {
				 b += i;
			 }
			 */
			
		   	 if (i % 2 == 0){
				 a += i;
			     continue; 
			 }
				 b += i;            //continue 사용 시 효율성 ↑
			
		}
		System.out.println("1 - 10 까지의 합 : " + (a+b));		
		System.out.println("짝수의 합 : " + a);
		System.out.println("홀수의 합 : " + b);
		
	}

}

