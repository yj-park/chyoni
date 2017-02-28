package kr.co.mlec.board.test;

import kr.co.mlec.webserver.WebServer;

public class BoardTest {
	public static void main(String[] args) {
		try {
			WebServer server = new WebServer(9090);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}