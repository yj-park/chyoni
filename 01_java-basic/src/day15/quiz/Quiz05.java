package day15.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz05 {
	public static void main(String[] args) {
		List<Data> list = new ArrayList<>();
		list.add(new Data(3));
		list.add(new Data(9));
		list.add(new Data(5));
		
		// arrays는 배열 위주 but collections 활용
		Collections.sort(list);
		System.out.println(list);
		
		// 거꾸로
		Collections.reverse(list);
		System.out.println(list);
		
		/*
		int[] numbers = new int[45]; 
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		// 셔플 개념
		Random r = new Random();
		for (int i = 0; i<2000; i++) {
			int index = r.nextInt(45);
			int temp = numbers[0];
			numbers[0] = numbers[index];
			numbers[0] = temp;
		}
		*/

		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			numbers.add(i);
			//로또 볼 45개가 통에 들어가있는 상황
		}
		Collections.shuffle(numbers);
		// 로또 볼 섞기
		for(int i = 1; i < 7; i++) {
			try {
			Thread.sleep(1000);
			} catch(InterruptedException e) { 
				e.printStackTrace();
			}
			System.out.println(i + "번째 볼 : " + numbers.get(i - 1));
		}
	}

}
