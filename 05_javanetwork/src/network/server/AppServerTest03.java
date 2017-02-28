package network.server;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerTest03 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			
			while (true) {
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept(); //2번
				// 접속한 클라이언트에게 메세지 전송하기
				OutputStream out = client.getOutputStream(); //3번
				DataOutputStream dos = new DataOutputStream(out);
				String str = "트위티 세젤귀";
				dos.writeUTF(str);
				System.out.println(str + ":" + client);
				
				// write메소드는 string을 보낼 수 없으므로 getBytes메소드를 사용함.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
