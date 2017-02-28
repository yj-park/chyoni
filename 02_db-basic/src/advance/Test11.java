package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test11 {
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
				String typeName = rsmd.getColumnTypeName(i);
				System.out.println("컬럼명 : " + cName + ", " + typeName);
			}
			/*
			while(rs.next()) {
				System.out.print(rs.getString("no") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("writer") + "\t");
				System.out.print(rs.getString("content") + "\t");
				System.out.print(rs.getString("reg_date") + "\n");
				// 데이터타입을 모를때 getString으로 받으면 다 가능(숫자는 문자열로 받을 수 있음)
				// 테이블명을 사용자가 결정 -> 테이블에서 컬럼명과 데이터명을 보여주고 싶음
				// view 메소드를 만들어주고 매개변수도(String tName)으로 설정
				// but 컬럼명을 지정해뒀기때문에 tb_board만 가능한 것
				// rs.get~부분이 사용자가 지정해준 컬럼명이 된다면 어떤 테이블이든 불러올 수 있음
				//
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

}
