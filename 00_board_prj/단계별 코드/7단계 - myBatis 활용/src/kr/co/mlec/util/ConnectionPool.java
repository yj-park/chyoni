package kr.co.mlec.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	static {
		try {
			for (int i = 1; i <= INIT_COUNT; i++) {
				free.add(ConnectionFactory.getConnection());
			}
		} catch (Exception e) {
			System.out.println("초기 연결 풀 생성시 오류 발생");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		if (free.isEmpty()) {
			throw new Exception("사용할 수 있는 커넥션이 없습니다");
		}
		
		// 쉬는풀에서 제거
		Connection con = free.remove(0);
		// 사용풀로 이동
		used.add(con);
		return con;
	}
	
	// 사용자의 사용이 끝나고 반환 처리
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 10
					; i++) {
				Thread.sleep(2000);
				
				// 커넥션풀을 사용하는 쪽의 코드
				Connection con = ConnectionPool.getConnection();
				System.out.println("사용자 요청 CON : " + con);
				
				// 연결 정리 요청
				ConnectionPool.releaseConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

















