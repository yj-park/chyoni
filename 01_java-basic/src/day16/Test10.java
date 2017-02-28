package day16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test10 {
	public static void main(String[] args) {
		// Kalimba.mp3 파일 복사하기
		// byte단위로 읽을 수 있는 클래스 사용
		// 1차 스트림: 목적 데이터를 직접 접근
		FileInputStream fis = null;
		FileOutputStream fos = null;
		// 속도향상이 목표일 뿐 파일을 읽지는 않는다.
		// 2차 스트림: 매개변수가 스트림
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
	
		
		try {
			fis = new FileInputStream("data/Kalimba.mp3");
			fos = new FileOutputStream("data/Kalimba4.mp3");
			// 속도를 높여 처리해야할 대상이 ()안에 들어감
			// bis를 통해서 버퍼 안에 있는 바구니 크기를 가지고 fis를 읽을거야
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			System.out.println("복사 시작");
			// buffer바구니 크기는 1024를 좋아함
			long s = System.currentTimeMillis();
			while(true) {
				// 바구니 가져가!하고 담아줌
				// ch는 실제 담은 개수
				int ch = bis.read();
				// -1이 나오기 전에는 실제 읽은 개수가 나타남
				// 배열은 초기값이 0으로 설정되어있기 때문에 
				if(ch == -1) break;
				// 실제 읽은 개수만큼만 써
				bos.write(ch);
			}
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("파일 복사 성공 : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
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
