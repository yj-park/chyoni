package kr.co.mlec.webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private int port;
	public WebServer() {
		this(9090);
	}
	public WebServer(int port) {
		this.port = port;
	}
	public void start() throws Exception {
		ServerSocket server = new ServerSocket(port);
		while (true) {
			// 브라우져에서 http://localhost:9090/board/list
			Socket socket = server.accept();
			WebClient client = new WebClient(socket);
			client.service();
		}
	}
}










