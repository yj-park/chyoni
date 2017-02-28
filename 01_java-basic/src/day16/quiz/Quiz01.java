package day16.quiz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz01 {
	public static void main(String[] args) {
		// 프로그램 실행시 현재 날짜 정보를 기준으로 디렉토리 생성
		// 출력결과
		/*
		 * data/2016/12/26/09 폴더가 생성된다.
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
		String path = "data/" + sdf.format(new Date());
		System.out.println(path);
		File f = new File(path);
		
		if (f.exists()) {
			System.out.println("이미 존재하는 디렉토리임");
		} else {
			if (f.mkdirs()) {
				System.out.println("생성 성공");
			} else {
			System.out.println("생성 실패");
			}
		}
		
	}

}
