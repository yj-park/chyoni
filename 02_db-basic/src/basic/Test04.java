package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
	// 조회된 결과값을 저장하기 위한 리스트 선언
	List<EmployeesVO> list = new ArrayList<>();
	Connection con = null;
	PreparedStatement pstmt = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

			String sql = "select employee_id, last_name, salary "
			           + "from employees " 
					   + "order by last_name ";

			pstmt = con.prepareStatement(sql);

			// 실행하기
			ResultSet rs = pstmt.executeQuery();
			// 조회된 데이터 접근하기
			while (rs.next()) {
				// boolean형을 반환하므로 false값이 반화되면 끝
				EmployeesVO vo = new EmployeesVO();
				vo.setEmployees_id(rs.getInt("employee_id"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
			for (EmployeesVO vo : list) {
				System.out.printf(
						"%4d%12s%6d\n", vo.getEmployees_id(), vo.getLast_name(), vo.getSalary());
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
