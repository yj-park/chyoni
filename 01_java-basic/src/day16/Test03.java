package day16;

import java.io.File;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		File f = new File("data/a1.txt");
		// 파일 삭제 (실행하는 순간 삭제)
		f.delete();		
		boolean result = f.delete();
		if (result) {
			System.out.println("파일 삭제 성공");
		} else {
			System.out.println("파일 삭제 실패");
		}
		
		
		/*
		// 파일 생성
		if (!f.exists()) {
			System.out.println("파일 생성");
			// 파일생성을 금지시키거나 꽉 찬 경우 불가능하기 때문에 예외처리
			try {
				boolean result = f.createNewFile();
				if (result) {
					System.out.println("파일 생성 성공");
				} else {
					System.out.println("파일 생성 실패");
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 파일이 가지고 있는 데이터의 크기를 byte로 반환
		// UIF-8은 한글: 3byte, 영어&숫자: 1byte
		long length = f.length();
		System.out.println("length: " + length);
		// f의 full path 제공
		String path = f.getPath();
		// f의 full path 중 제일 마지막 자리
		String name = f.getName();
		// f의 full path 중 제일 마지막 자리의 부모
		String parent = f.getParent();
		System.out.println("path: " + path);
		System.out.println("name: " + name);
		System.out.println("parent: " + parent);
		*/
	}

}
