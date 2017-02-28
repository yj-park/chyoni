package network.server;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class AppServerTest02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			/*
			 * String[] msgs = {"0", "1000", "2000", "3000", "4000", "5000" };
			 * Random r = new Random();
			 * 
			 * String sendMsg= msgs[r.nextInt(msg.length)];
			 */
			while (true) {
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept(); //2번
				// 접속한 클라이언트에게 메세지 전송하기
				OutputStream out = client.getOutputStream(); //3번
				String str = "hello~";
				out.write(str.getBytes("utf-8"));
				// write메소드는 string을 보낼 수 없으므로 getBytes메소드를 사용함.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
