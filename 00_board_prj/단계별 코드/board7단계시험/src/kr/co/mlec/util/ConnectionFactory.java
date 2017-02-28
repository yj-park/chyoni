package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	// 연결 객체를 return하게 하는 역할

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
	}
	
	// pstmt를 닫아주는 역할
	public static void close(PreparedStatement pstmt) {
		   if (pstmt != null) {
		    	try {
		    		pstmt.close();		    	
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	}
		    }
	}
	

}
