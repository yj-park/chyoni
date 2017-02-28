package sticky;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnect;

public class StickyDao {
	public void insert(StickyVO sticky) throws Exception {
		Connection con = new DBConnect().getConnection();
		String sql = "select seq_sticky_id.nextVal from dual";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		sticky.setId(rs.getInt(1));
		sql = "insert into tb_sticky values(?, ?, ?, '')";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sticky.getId());
		pstmt.setInt(2, sticky.getPosX());
		pstmt.setInt(3, sticky.getPosY());
		pstmt.executeUpdate();

		pstmt.close();
		con.close();
	}

	public void update(StickyVO sticky) throws Exception {
		Connection con = new DBConnect().getConnection();
		String sql = "update tb_sticky set pos_x = ?, pos_y = ?, content = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sticky.getPosX());
		pstmt.setInt(2, sticky.getPosY());
		pstmt.setString(3, sticky.getContent());
		pstmt.setInt(4, sticky.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public List<StickyVO> list() throws Exception {
		List<StickyVO> list = new ArrayList<>();
		Connection con = new DBConnect().getConnection();
		String sql = "select * from tb_sticky order by id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			StickyVO vo = new StickyVO();
			vo.setId(rs.getInt("id"));
			vo.setPosX(rs.getInt("pos_x"));
			vo.setPosY(rs.getInt("pos_y"));
			vo.setContent(rs.getString("content"));
			list.add(vo);
		}
		pstmt.close();
		con.close();
		return list;
	}
}











