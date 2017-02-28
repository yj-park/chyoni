package network.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;


public class AppClientTest03 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10001); //1번 (2번이 수행되는 순간 얘도 다음 실행)
			// 연결된 소켓으로부터 서버가 전송한 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			String msg = dis.readUTF();
			System.out.println("서버에서 전송된 데이터 : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

