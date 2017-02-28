package day15.quiz;

import java.util.Arrays;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		 * 실행 시 화면 출력이 다음과 같도록 코딩 작성
		 * [9, 5, 3]
		 */
		int[] arr = {3, 9, 5};
		
		// 셀력션 소트를 이용해서 정렬
		//
		int temp = 0;
		
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	
		/*
		버블정렬
		for(int i = 0; i < arr.length;){
			if(arr[i] < arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				i++;
			} if (i == 2) break;
		}
		*/
	}
}

