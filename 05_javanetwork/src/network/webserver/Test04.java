package network.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test04 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while (true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨");

				InputStream in = client.getInputStream();
				HttpServletRequest request = new HttpServletRequest(in);
				
				// id가 한글(ex:홍길동)인 경우 한 자당 %3개씩 -> UTF-8로 인코딩되었기때문!
				// http://localhost:10001/test?id=%ED%99%8D%EA%B8%B8%EB%8F%99&pass=1111
				// 인코딩되어있는 문자를 원상태로 돌리는 것 -> 디코딩
				
				
				
				//method : GET
				String method = request.getMethod();
				// URI : /test
				String uri = request.getRequestUri();
				// QueryString : id=aaa&pass=1111
				String queryString = request.getQueryString();
				// id : aaa
				String id = request.getParameter("id");
				// pass : 1111
				String pass = request.getParameter("pass");
			     
				
				System.out.println("method : " + method);
				System.out.println("uri : " + uri);
				System.out.println("queryString : " + queryString);
				System.out.println("id : " + id);
				System.out.println("pass : " + pass);
			
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
