package day04;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		// 반복문을 중간에 빠져나가기      : break
		// 반복문의 나머지 부분을 무시하기 : continue
		
		/*Random r = new Random();
		int num = r.nextInt(9)+1; // num의 범위: 1 ~ 9
		System.out.println("num : " + num);
		System.out.println("break");
		
		for (int i = 1; i < 10; i++){
			System.out.println(i);
			if (i == num) break;   
				
		}
		System.out.println("continue");
		for (int i = 1; i < 10; i++){
			if (i == num) continue; 
			System.out.println(i);
				
		}
		*/
		Random r = new Random();
		int breakNum = r.nextInt(4);
		
		/*boolean flag = false;
		for (int i = 0; i < 3; i++){
			System.out.println("i = " + i);
			for (int k = 0; k < 3; k++){
				System.out.println("k = " + k);
				if ( k == breakNum) break;
				    flag = true;
				    break;
			} 
			if (flag = true){
				break;
			}
	//flag라는 변수 공간을 새로 만들어서 if의 조건을 만족하는지 아닌지 확인한 후 break를 줄 수 있음
	//즉, k==breakNum가 충족되었다면 flag의 값이 변하고 충족되지 않았다면 flag의 값이 그대로이기 때문에 전체 블록에 break문을 써서 빠져나올 수 없다.
		
          */
		
		outer :         //label. 반복문의 이름 설정. break와 continue 둘 다 사용 가능
		for (int i = 0; i < 3; i++){
				System.out.println("i = " + i);
				for (int k = 0; k < 3; k++){
					System.out.println("k = " + k);
					if ( k == breakNum) {
						break outer; //outer라는 이름을 가진 반복문을 빠져나가겠다. 범위에 해당하는 중첩된 부분만 실행
					}
					  
			
				}
		}
		
	}

}
