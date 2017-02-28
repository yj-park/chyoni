package network.webserver;
// tomcat이 있으면 안해도 됨ㅋㅋ

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while (true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨");

				// 요청 포멧 형식 출력하기 
				// 클라이언트 -> 서버 (REQUEST)
				/*
				  시작라인
				  헤더
				  
				  바디
				 */
				InputStream in = client.getInputStream();
				// 한 줄씩 읽어내기 위한 클래스 사용
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				// 첫째줄은 시작라인
				String reqStartLine = br.readLine();
				// 두번째줄부터 공백이 나오기 전까지는 헤더. 
				String reqHeaders = "";
				while (true) {
					String line = br.readLine();
					if (line.equals("")) break;
					reqHeaders += line + "\n";
				}
				System.out.println("====================================");
				System.out.println("요청시작라인 : " + reqStartLine);
				System.out.println("요청헤더");
				System.out.println(reqHeaders);
				System.out.println("====================================");
				
				
				// 서버 -> 클라이언트 (RESPONSE)
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//String time = sdf.format(new Date());
				String msg = "성공";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers= "Cache-Control: no-cache\r\n"
						      + "Content-Type: text/html; charset=UTF-8\r\n"
						      + "Content-Length: " + msg.getBytes().length + "\r\n\r\n" ;
				// 네트워크는 바이트의 크기를 주어야함 
				// 내가 응답하는 결과에 한글이 포함될 수 있다
				String body = msg;
				
				String data = startLine + headers + body;
				
				
				OutputStream out = client.getOutputStream();
				out.write(data.getBytes());
				// 문자열에 있는 바이트 배열을 꺼내와서 넘겨주겠다
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
