package day16;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Test06 {
	public static void main(String[] args) {
		FileWriter fos = null;
		
		try {
			fos = new FileWriter("data/a2.txt", true);
			// true를 쓰면 덮어쓰기가 아닌 uphand옵션. 추가하겠다는 뜻
			
			// 파일이 없으면 자동생성, 있으면 덮어쓰기
			fos.write(97);
			// 'a'를 줘도 자동 형변환되기 때문에 가능
			fos.write('a');
			fos.write('가');
			// byte단위 처리 클래스이기 때문에 '가'가 제대로 써지지 않음
			// 한글을 처리하기 위해 FileWriter 사용
			System.out.println("파일쓰기 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
				fos.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
	}

}
