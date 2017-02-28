package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppClientTest04 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.0.8", 10001); //1번 (2번이 수행되는 순간 얘도 다음 실행)
			// 연결된 소켓으로부터 서버가 전송한 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 연결된 서버에게 데이터 전송하기
			OutputStream out = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			// 전송할 메세지 입력받기
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.print("보낼 메세지 : ");
				String sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				
				if (sendMsg.equals("quit")) break;
				
				String recvMsg = dis.readUTF();
				System.out.println("에코 메세지 : " + recvMsg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}