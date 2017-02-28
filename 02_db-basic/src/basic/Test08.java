package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test08 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			String sql = "select no, title, writer, content, reg_date "
					   + "from tb_board "
					   + "order by no desc";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVO> list = new ArrayList<>();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				// vo.setRegDate(rs.getDate("reg_date"));
				// sql에는 시,분,초 정보가 없음
				// TimeStamp를 활용하자
				vo.setRegDate(rs.getTimestamp("reg_date"));
				list.add(vo);
			}
			for (BoardVO vo : list) {
				System.out.printf(
						"%d\t%s\t%s\t%s\n",
						vo.getNo(), vo.getTitle(), vo.getWriter(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getRegDate()));
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
