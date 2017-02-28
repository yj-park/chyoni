package network.url;

import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com/test?msg=hello");
			
			System.out.println(url.getProtocol());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getPort());
			// 포트가 설정되어있지 않기 때문에 -1출력
			// 만약 "http://www.naver.com:8000"이라면 8000출력
			System.out.println(url.getHost());
			System.out.println(url.getFile());
			// 실제 찾고자하는 부분. /이후의 모든것을 출력함
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			// msg=hello -> query, parameter
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
