package day15.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		//data/day15/quiz06.txt 파일의 내용을 읽어서 아래와 같이 출력
		/*
		 * 성적 발표
		 * ----------------------------
		 * 1. 이름 :    총점 :
		 * 2. 이름 :    총점 :
		 * 3. 이름 :    총점 :
		 * ----------------------------
		 * 
		 * 
		 */
		try {
		List<StudentVO> list = new ArrayList<>();
		File f = new File("data/day15/quiz06.txt");
		Scanner sc = new Scanner(f);
		 while (sc.hasNextLine()){   
			 String[] arr = sc.nextLine().split(":");
				list.add(new StudentVO(
						arr[0], 
						Integer.parseInt(arr[1]), 
						Integer.parseInt(arr[2]), 
						Integer.parseInt(arr[3]) 
				));
			}
			Collections.sort(list);
			System.out.println("성적 발표");
			System.out.println("========================");
			int num = 1;
			for (StudentVO student : list) {
				System.out.printf(
					"%d. 이름 : %s, 총점 : %d\n", num++, student.getName(), student.getSum());
				if (num == 4) break;
			}
				
			System.out.println("========================");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


