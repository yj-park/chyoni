package network.server;

import java.net.ServerSocket;
import java.net.Socket;

public class AppServerTest01 {
	public static void main(String[] args) {
		try {
			// 10001번 포트를 사용하는 서버 준비
			ServerSocket server = new ServerSocket(10001);
			
			System.out.println("사용자의 요청을 대기한다. (accept)");

			while (true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속 : " + client);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
