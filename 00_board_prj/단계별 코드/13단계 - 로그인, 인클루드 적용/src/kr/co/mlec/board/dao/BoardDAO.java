package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.db.MyAppSqlConfig;

public class BoardDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	// 전체 게시글 조회
	public List<BoardVO> selectBoard() {
		List<BoardVO> boardList = sqlMapper.selectList("kr.co.mlec.board.dao.BoardMapper.getBoardList");
		return boardList;
	}
	
	
	// 글번호에 해당하는 게시물 조회
	public BoardVO selectOneBoard(int no) {
		BoardVO board = sqlMapper.selectOne("kr.co.mlec.board.dao.BoardMapper.getBoardOne", no);
		return board;
	}

	
	// 글등록
	public void insertBoard(BoardVO vo) {
		sqlMapper.insert("kr.co.mlec.board.dao.BoardMapper.insertBoard", vo);
		sqlMapper.commit();
	}
	
	// 글수정
	public boolean updateBoard(BoardVO vo) {
		sqlMapper.update("kr.co.mlec.board.dao.BoardMapper.updateBoard", vo);
		sqlMapper.commit();
        return true;
	}
    // 글삭제
	public boolean deleteBoard(int no) {
		sqlMapper.delete("kr.co.mlec.board.dao.BoardMapper.deleteBoard", no);
		sqlMapper.commit();
		return true;
	}
}














