package day21.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Exam01 {
	public static void printEmployee(String cityName, int salary) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		List<EmployeesVO> list = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();
			String sql = "select l.city, e.first_name, e.salary "
					   + "from employees e "
					   + "inner join departments d "
					   + "on d.department_id = e.department_id "
					   + "inner join locations l "
					   + "on d.location_id = l.location_id "
					   + "where l.city like ? "
					   + "and salary >= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + cityName + "%");
			pstmt.setInt(2, salary);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmployeesVO vo = new EmployeesVO();
				vo.setCity(rs.getString("city"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
			for (EmployeesVO vo : list) {
				System.out.printf("%-10s\t%-10s\t%-10d\n", vo.getCity(), vo.getFirst_name(), vo.getSalary());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("=====================================================");
		printEmployee("cisco", 6000);
		System.out.println("=====================================================");
		printEmployee("attle", 15000);
		System.out.println("=====================================================");
		
	}

}
