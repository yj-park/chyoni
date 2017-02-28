package network.server;

import java.io.InputStream;
import java.net.Socket;

public class AppClientTest02 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10001); //1번 (2번이 수행되는 순간 얘도 다음 실행)
			// 연결된 소켓으로부터 서버가 전송한 데이터 읽기
			InputStream in = s.getInputStream();
			byte[] buffer = new byte[1024];
			int count = in.read(buffer);
			// 바구니에 한꺼번에 1024개가 들어갈 수 있으나 1024개가 있는 게 아니니 실제 개수를 count로 받아줌 
			// buffer 배열에 있는 byte 값을 count수만큼 바꾸기
			String msg = new String(buffer, 0, count);
			System.out.println("서버에서 전송된 데이터 : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
