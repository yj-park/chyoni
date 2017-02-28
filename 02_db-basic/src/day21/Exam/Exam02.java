package day21.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Exam02 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);

		try {
			con = ConnectionPool.getConnection();
			String sql = "select department_name, manager_id "
					   + "from departments " 
					   + "where department_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			ResultSet rs = pstmt.executeQuery();
			
			System.out.print("부서번호 : ");
			sc.nextLine();
			System.out.printf("입력하신 부서아이디(%d)에 해당하는\n", sc);
			System.out.println("부서명 : " + rs.getString("department_name"));
			System.out.println("부서장 아이디 : " + rs.getInt("department_id"));


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

}
