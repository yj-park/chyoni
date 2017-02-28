package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;

public class Test01 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1 & 2단계: 하나를 공유해서 쓰면 되니까 굳이 위에 따로 두지 않아도 됨
			
			
			// 1단계 : 드라이버 로딩
			// 오라클 드라이버 클래스명 : 오라클 제공
			// ojdbc14.jar에 포함된 클래스명(패키지 포함)
			// 오류 발생 이유 : 1_ 클래스 이름 오류 or 2_빌더 설정 X
			// 2단계 : 연결객체 얻어오기
			con = ConnectionFactory.getConnection();
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
