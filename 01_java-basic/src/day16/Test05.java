package day16;

import java.io.FileReader;

public class Test05 {
	public static void main(String[] args) {
		// InputStream이나 Reader는 데이터타입만 다를 뿐 작동 방식은 똑같음
		// 따라서 a.txt에 있는 한글 가를 출력하기 위해 FileInputStream을 FileReader로 이름만 바꿔주면 됨 
		FileReader fis = null;
		try {
			fis = new FileReader("data/a.txt");
			// 어떤 파일을 읽을건지 줘야해
			// 파일의 기준점이 필요 (어디서부터 얼마나 읽어야하는지 지정해줘야해)
			while(true) {
				int ch = fis.read();
				// 더 이상 읽을 게 없으면 빠져나가를 신호로 -1 을 준다.
				if( ch == -1) break;
				System.out.print((char)ch);
				// 원래 파일에 있는 내용을 그대로 출력하기위해 형변환 필수
				// \r\n도 파일 그대로 읽기 때문에 println이 아님!
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// IO 객체를 닫는 작업 수행
			// try에서도 쓰고 finally에서도 쓰기위해 밖에서 선언
			if (fis != null) {
				// 1.7버전 전에 쓰는 방법. 꼭 객체를 닫아줘야하기 때문에 알고 있어야해
				try {
					fis.close();
					// 만약 fis가 null이면 점프할 곳이 없는데 점프해서 가져오라고 하기 때문에
					// NullPointException 발생
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
