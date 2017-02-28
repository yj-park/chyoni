package network.webserver;
// tomcat이 있으면 안해도 됨ㅋㅋ

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while (true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//String time = sdf.format(new Date());
				String time = "<html>" 
							  + "   <head>"
							  + "     <style>"
							  + "			div {"
							  + "				font-size: 50px;"
							  + "				background:tomato;"
							  + "				color:white;"
							  + "				text-align: center;"
							  + "				margin: 100px;"
							  + "				padding: 50px;"
							  + "   			border: 10px solid black;"
							  + "				transition: 1s;"
							  + "			    }"
							  + "         div:hover { background: black;} "
							  + " 	 </style>"
							  + "  </head>"
							  + "	<body>"
							  + "	<div>"
							  + "			현재시간 :" + sdf.format(new Date())
							  + "	</div>"
							  + "   </body>"
							  + "  </html>";
							  
							  
				
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers= "Cache-Control: no-cache\r\n"
						      + "Content-Type: text/html; charset=UTF-8\r\n"
						      + "Content-Length: " + time.getBytes().length + "\r\n\r\n" ;
				// 네트워크는 바이트의 크기를 주어야함 
				// 내가 응답하는 결과에 한글이 포함될 수 있다
				String body = time;
				
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
