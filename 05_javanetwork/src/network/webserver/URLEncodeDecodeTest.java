package network.webserver;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeDecodeTest {
	public static void main(String[] args) {
		String word = "자바";
		try {
			// url형태에 맞게 인코딩 해주는 클래스
			String encodeWord = URLEncoder.encode(word, "utf-8");
			System.out.println(encodeWord);
			
			// url형태에 맞게 디코딩 해주는 클래스
			String decodeWord = URLDecoder.decode(encodeWord, "utf-8");
			System.out.println(decodeWord);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
