package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test12 {
	public static void main(String[] args) {
		System.out.println("=================================");
		view("tb_board");
		System.out.println("=================================");
		view("employees");; //오류 발생. 컬럼명이 다르기때문
	}
	public static void view(String tName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select * from " + tName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// resultset의 기초 데이터 정보를 나타냄
			ResultSetMetaData rsmd = rs.getMetaData();
			// rs에서 조회된 컬럼의 개수 반환 (실제 select절에서 조회한)
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String cName = rsmd.getColumnName(i);
				System.out.printf("%15s", cName);
			}
			
			System.out.println();
			while(rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
				String cName = rsmd.getColumnName(i);
				System.out.printf("%15s", rs.getString(cName));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

}
