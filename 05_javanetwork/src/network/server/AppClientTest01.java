package network.server;

import java.net.Socket;

public class AppClientTest01 {
	public static void main(String[] args) {
		// localhost = 내컴퓨터 
		try {
			// Socket s = new Socket("192.168.0.100", 10001);
			Socket s = new Socket("localhost", 10001);
			System.out.println("객체 생성과 동시에 접속 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
