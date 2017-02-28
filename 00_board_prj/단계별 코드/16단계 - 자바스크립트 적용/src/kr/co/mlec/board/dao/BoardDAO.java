package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
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
	public int insertBoard(BoardVO board) {
		sqlMapper.insert("kr.co.mlec.board.dao.BoardMapper.insertBoard", board);
		sqlMapper.commit();
		return board.getNo();
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
	
	/* =================================================== */
	/* 파일 관련                                             */
	/* =================================================== */
	public void insertBoardFile(BoardFileVO boardFile) {
		sqlMapper.insert("kr.co.mlec.board.dao.BoardMapper.insertBoardFile", boardFile);
		sqlMapper.commit();
	}
	
	public BoardFileVO selectBoardFileByNo(int no) {
		return sqlMapper.selectOne("kr.co.mlec.board.dao.BoardMapper.selectBoardFileByNo", no);
	}
	
	
	/* =================================================== */
	/* 댓글 관련                                             */
	/* =================================================== */
	public void insertBoardComment(BoardCommentVO comment) {
		sqlMapper.insert("kr.co.mlec.board.dao.BoardMapper.insertBoardComment", comment);
		sqlMapper.commit();
	}
	public List<BoardCommentVO> selectBoardCommentByNo(int no) {
		return sqlMapper.selectList("kr.co.mlec.board.dao.BoardMapper.selectBoardCommentByNo", no);
	}
	public void deleteBoardComment(int commentNo) {
		sqlMapper.delete("kr.co.mlec.board.dao.BoardMapper.deleteBoardComment", commentNo);
		sqlMapper.commit();
	}
	public void updateBoardComment(BoardCommentVO comment) {
		sqlMapper.update("kr.co.mlec.board.dao.BoardMapper.updateBoardComment", comment);
		sqlMapper.commit();
	}
}














