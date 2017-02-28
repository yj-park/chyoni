package kr.co.mlec.webserver;

import java.io.OutputStream;
import java.net.Socket;

import kr.co.mlec.board.servlet.DeleteServlet;
import kr.co.mlec.board.servlet.DetailServlet;
import kr.co.mlec.board.servlet.ListServlet;
import kr.co.mlec.board.servlet.UpdateFormServlet;
import kr.co.mlec.board.servlet.UpdateServlet;
import kr.co.mlec.board.servlet.WriteFormServlet;
import kr.co.mlec.board.servlet.WriteServlet;

public class WebClient {
	private Socket client;
	public WebClient(Socket client) {
		this.client = client;
	}
	
	public void service() {
		try {
			// 사용자 요청 처리
			HttpServletRequest request = new HttpServletRequest(client.getInputStream());
			// 사용자 응답 처리
			HttpServletResponse response = new HttpServletResponse();
			
			System.out.println("요청 URI : " + request.getRequestUri());
			String uri = request.getRequestUri();
			HttpServlet servlet = null;
			switch (uri) {
			case "/board/list": 
				servlet = new ListServlet();
				break;
			case "/board/writeForm": 
				servlet = new WriteFormServlet();
				break;
			case "/board/write": 
				servlet = new WriteServlet();
				break;
			case "/board/detail": 
				servlet = new DetailServlet();
				break;
			case "/board/delete": 
				servlet = new DeleteServlet();
				break;
			case "/board/updateForm": 
				servlet = new UpdateFormServlet();
				break;
			case "/board/update": 
				servlet = new UpdateServlet();
				break;
			}

			String msg = "";
			if (servlet == null) {
				msg = "<h1>등록되지 않은 URL 입니다.</h1>";
			} else {
				servlet.service(request, response);
				msg = response.getMsg();
			}
			
			String startLine = "HTTP/1.1 200 OK\r\n";
			String headers = "Cache-Control: no-cache\r\n"
					       + "Content-Type: text/html; charset=UTF-8\r\n"
					       + "Content-Length: " + msg.getBytes().length + "\r\n\r\n";
			String body = msg;
			String data = startLine + headers + body;
			OutputStream out = client.getOutputStream();
			out.write(data.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






