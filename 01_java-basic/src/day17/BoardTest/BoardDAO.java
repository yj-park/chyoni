package day17.BoardTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDAO {
	private List<BoardVO> list = new ArrayList<> ();
	private int no = 0;
	
	public List<BoardVO> selectBoard() {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionFactory.getConnection();
			String sql = "select no, title, writer, reg_date "
					   + "  from tb_board "
					   + " order by no desc ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
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
		} return list;
	}
	
	public BoardVO selectOneBoard(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionFactory.getConnection();
			String sql = "select no, title, writer, content, reg_date "
					   + "  from tb_board "
					   + " where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setNo();

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
		return null;
	}
	
	public void insertBoard(BoardVO board) {
		board.setNo(++no);
		board.setRegDate(new Date());
		list.add(board);
	}
	
	public boolean updateBoard(BoardVO board) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO board2 = list.get(i);
			if (board2.getNo() == board.getNo()) {
				board2.setTitle(board.getTitle());
				return true;
			}
		} return false;
	}
	
	public boolean deleteBoard(int no) {
		int delIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			if (board.getNo() == no) {
				delIndex = i;
				break;
			}
		} if (delIndex == -1) {
				return false;
		} 
		list.remove(delIndex);
		return true;
	}

}
