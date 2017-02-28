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

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test09 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql1 = "update tb_account set money = money + 50000 where id = 'a'";
			String sql2 = "update tb_account set money = mony - 50000 where id = 'b'";
			pstmt = con.prepareStatement(sql1);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();
			// 2번 sql문의 컬럼명이 다르기 때문에 오류 발생.
			// 1번 sql문 역시 수행 전으로 돌아가야지 제대로 처리가 된 것
			// JDBC는 auto commit됨. 트랜잭션 처리가 되지 않음!
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

}
