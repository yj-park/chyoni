package advance;
/*
 * 트랜잭션 테스트용 테이블
  -----------------------------------------------
  create table tb_account (
      id varchar2(10),
      money number(8)
  );
  insert into tb_account(id, money) values ('a', 100000);
  insert into tb_account(id, money) values ('b', 200000);
  -----------------------------------------------
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test10 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			// 자동 커밋 상태를 변경
			// 트랜잭션 실행됨
			con.setAutoCommit(false);
			
			
			String sql1 = "update tb_account set money = money + 50000 where id = 'a'";
			String sql2 = "update tb_account set money = money - 50000 where id = 'b'";
			pstmt = con.prepareStatement(sql1);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();
			// 2번 sql문의 컬럼명이 다르기 때문에 오류 발생.
			// 1번 sql문 역시 수행 전으로 돌아가야지 제대로 처리가 된 것
			// JDBC는 auto commit됨. 트랜잭션 처리가 되지 않음!
			// 오류가 나면 catch문으로 이동
			
			// 정상적 수행 시 commit하기
			con.commit();
			System.out.println("데이터 베이스 적용 완료");
			
		} catch (Exception e) {
			// 실행이 잘못되었을 경우 rollback 하기
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

}
