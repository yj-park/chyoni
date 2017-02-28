package day05;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		String[] arr = {"치킨", "피자", "콜라","스파게티"};
		
		String[] dest = new String [arr.length];    // 배열 복사를 위해 길이를 arr과 같이 만들어줌
		
		//arr 배열의 내용을 dest 배열에 복사
		//for (int i = 0; i < arr.length; i++){
		//	dest[i] = arr[i];
		//}
		
		//규칙을 찾아서 변경하기
		//for (int i = 0; i < 3; i++){
		//	dest[i+1] = arr[i];			
		//}
		
		//for (int i = 0; i < 3; i++){
		//	dest[i] = arr[i+1];	
		//}
		
		
		System.arraycopy(arr, 0, dest, 1, 3);
		
		System.out.println(Arrays.toString(dest));	
		
	}

}
