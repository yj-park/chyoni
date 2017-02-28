package day17.BoardTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// 연결 객체를 return하게 하는 역할

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
	}

}
