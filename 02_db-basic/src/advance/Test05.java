package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test05 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
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
			ConnectionFactory.close(pstmt);
		    ConnectionPool.releaseConnection(con);
		}
		
	}

	}

