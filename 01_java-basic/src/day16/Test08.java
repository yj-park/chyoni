package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test08 {
	public static void main(String[] args) {
		// Kalimba.mp3 파일 복사하기
		// byte단위로 읽을 수 있는 클래스 사용
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("data/Kalimba.mp3");
			fos = new FileOutputStream("data/Kalimba.mp3");
			
			System.out.println("복사 시작");
			long s = System.currentTimeMillis();
			while(true) {
				int ch = fis.read();
				if(ch == -1) break;
				fos.write(ch);
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
