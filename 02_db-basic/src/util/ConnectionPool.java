package util;

import java.nio.charset.MalformedInputException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	// 초기 개수를 3개로 만들겠다
	private static List<Connection> free = new ArrayList<>();
	// 현재 사용가능한 connection을 담는 공간
	private static List<Connection> used = new ArrayList<>();
	// 현재 사용 중인 connection을 담는 공간
	
	static {
		try {
			for (int i = 1; i <= INIT_COUNT; i++) {
				free.add(ConnectionFactory.getConnection());
			}
		} catch (Exception e) {
			System.out.println("초기 연결 풀 생성시 오류 발생");
			e.printStackTrace();
			// 혹시 오류가 난다면 오류를 체크하기 위해서 설정함
		}
	}
	
	public static Connection getConnection() throws Exception {
		if (free.isEmpty()) {
			throw new Exception("사용할 수 있는 커넥션이 없습니다.");
			// 먼저 연결할 수 있는 커넥션이 있는 지 확인한 후 진행 
		}
		// 쉬는 풀에서 제거
		Connection con = free.remove(0);
		// list니까 계속 0번째부터 시작 (배열이 아니니깐!) 
		// 사용 풀로 이동
		used.add(con);
		// 요청한 커넥션 반환
		return con;
		// 누군가 사용하겠다고 요청이 왔기 떄문에 free라는 공간에서 첫번째를 꺼내와서 꺼내온 것을 반환함 
		// -> 그리고나서 다른 사람에게 줄 수 없기 때문에 free에서 삭제 & used에 추가시킴
	}
	
	// 사용자의 사용이 끝나고 나면 다시 free로 반환할 메소드
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(2000);
					
				// 커넥션 풀을 사용하는 쪽의 코드
				Connection con = ConnectionPool.getConnection();
				System.out.println("사용자 요청 CON: " + con);
				// 커넥션 풀에 3개 밖에 없는데 요청을 4번하니까 4번째에서 오류가 발생하는 것
				// 꼭 release를 해서 free쪽에 옮겨야지만 (닫는 건 아니지만 닫는 작업이라고 생각해) 오류가 발생하지 않는다.
				// 연결 요청이 모자라다면 그건 release를 안해줬다는 뜻!
				ConnectionPool.releaseConnection(con);
				// 내가 얻어 온 커넥션을 release해줘 -> 그래야 free로 옮겨지니까
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
		
}


