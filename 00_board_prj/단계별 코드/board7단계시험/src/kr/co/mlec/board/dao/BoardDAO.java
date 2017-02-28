package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.ConnectionPool;

public class BoardDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	// 전체 게시글 조회
	public List<BoardVO> selectBoard() throws Exception {
		List<BoardVO> boardList = sqlMapper.selectList("kr.co.mlec.board.dao.BoardMapper.getBoardList");
		return boardList;
	}
	
	
	// 글번호에 해당하는 게시물 조회
	public BoardVO selectOneBoard(int no) throws Exception {
		BoardVO board = sqlMapper.selectOne("kr.co.mlec.board.dao.BoardMapper.getBoardOne", no);
		return board;
	}

	
	// 글등록
	public void insertBoard(BoardVO vo) throws Exception {
		sqlMapper.insert("kr.co.mlec.board.dao.BoardMapper.insertBoard", vo);
		sqlMapper.commit();
	}
	
	// 글수정
	public boolean updateBoard(BoardVO vo) throws Exception {
		sqlMapper.update("kr.co.mlec.board.dao.BoardMapper.updateBoard", vo);
		sqlMapper.commit();
        return true;
	}
    // 글삭제
	public boolean deleteBoard(int no) throws Exception {
		sqlMapper.delete("kr.co.mlec.board.dao.BoardMapper.deleteBoard", no);
		sqlMapper.commit();
		return true;
	}
}














