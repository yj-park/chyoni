package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.MyAppSqlConfig;

public class BoardDAO {

	private static SqlSession session = null;

	public BoardDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertBoard(BoardVO board) {
		session.insert("board.BoardDAO.insertBoard", board);
		session.commit();
	}

	public int updateBoard(BoardVO board) {
		int cnt = session.update("board.BoardDAO.updateBoard", board);
		session.commit();
		return cnt;
	}

	public int deleteBoard(int no) {
		int cnt = session.delete("board.BoardDAO.deleteBoard", no);
		session.commit();
		return cnt;
	}

	public List<BoardVO> selectBoard() {
		return session.selectList("board.BoardDAO.selectBoard");
	}

	public BoardVO selectOneBoard(int findNo) {
		return session.selectOne("board.BoardDAO.selectBoardByNo", findNo);
	}

}
