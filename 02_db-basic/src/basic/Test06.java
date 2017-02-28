package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1단계: 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계: 연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			// 3단계: sql 작성
			String sql = "update tb_board set title = ? where no = ?";
			// 4단계: sql 실행 객체 얻기
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "연습중");
			pstmt.setInt(2, 13);
			// 5단계: sql 실행
			int cnt = pstmt.executeUpdate();
			// 6단계: 결과처리
			System.out.println(cnt + "개의 행이 변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7단계: 닫기
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
