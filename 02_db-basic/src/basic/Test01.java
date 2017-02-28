package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1단계 : 드라이버 로딩
			// 오라클 드라이버 클래스명 : 오라클 제공
			// ojdbc14.jar에 포함된 클래스명(패키지 포함)
			// 오류 발생 이유 : 1_ 클래스 이름 오류 or 2_빌더 설정 X
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 2단계 : 연결객체 얻어오기
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			System.out.println("연결정보 : " + con);
			// : -> 프로토콜명. 프로토콜 : 약속
			// 127.0.0.1 
			// 순수 thin은 자바로 이뤄진 타입
			
			// 3단계 : SQL문 작성하기
			// 줄넘김 시 꼭 공백 한 칸 주기 (공백이 없으면 컬럼명이 되버림)
			String sql = "insert into tb_board(no, title, writer, content) "
					   + "values(s_board_no.nextVal, 'test', 'hong', 'exam')";
			
			// 4단계 : SQL 실행 객체 얻기
			pstmt = con.prepareStatement(sql);
			
			// 5단계 : SQL 실행하기
			int cnt = pstmt.executeUpdate();
			
			// 6단계 : 결과 처리
			System.out.println(cnt + "개의 행이 변경되었습니다.");
			
			// 7단계 : 객체 닫기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    if (con != null) {
		    	try {
		    		con.close();		    	
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	}
		    if (pstmt != null) {
		    	try {
		    		pstmt.close();		    	
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	}
		    	
		    }
		}
		
	}

	}
}
