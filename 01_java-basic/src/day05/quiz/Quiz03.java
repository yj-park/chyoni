package day05.quiz;

public class Quiz03 {
	public static void main(String[] args) {
		int [] arr = {1, 5, 3, 9, 7, 11};
		/*
		 * 출력형식>
		 * 배열의 모든 요소가 홀수입니다.
		 * 
		 * 배열의 모든 요소가 홀수는 아닙니다.
		 */
		
		
		boolean flag = false;
		for(int i = 0; i < arr.length; i++){
			if( arr[i] % 2 == 0 ){
				flag = true;
				break;
			}
		}
		/*	if (flag == false) {
				System.out.println("배열의 모든 요소가 홀수입니다.");
			}else {
				System.out.println("배열의 모든 요소가 홀수는 아닙니다.");
			}
		
	     String msg = "홀수는 아닙니다.";
	     if (flag == false) {
	    	 msg = "홀수입니다.";
	     }
	     System.out.println("배열의 모든 요소가" + msg);
	     }*/
	     
	}
          // System.out.printf("배열의 모든 요소가 %s", flag ==false ? "홀수입니다." : "홀수는 아닙니다.");
}	


           //flag == false 대신에 i == arr.length 


	     
	
	

