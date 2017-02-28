package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test09 {
	public static void main(String[] args) {
		// Kalimba.mp3 파일 복사하기
		// byte단위로 읽을 수 있는 클래스 사용
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("data/Kalimba.mp3");
			fos = new FileOutputStream("data/Kalimba2.mp3");
			
			System.out.println("복사 시작");
			// buffer바구니 크기는 1024를 좋아함
			byte[] buffer = new byte[32 * 1024];
			long s = System.currentTimeMillis();
			while(true) {
				// 바구니 가져가!하고 담아줌
				// ch는 실제 담은 개수
				int ch = fis.read(buffer);
				// -1이 나오기 전에는 실제 읽은 개수가 나타남
				// 배열은 초기값이 0으로 설정되어있기 때문에 
				if(ch == -1) break;
				// 실제 읽은 개수만큼만 써
				fos.write(buffer, 0 , ch);
			}
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("파일 복사 성공 : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
