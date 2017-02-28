package kr.co.mlec.board.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.MyArrayList;

public class BoardDAO {
	private MyArrayList<BoardVO> list = new MyArrayList<>();
	//MyArrayList는 BoardVO만 담을거야
	
	// 게시물 번호
	private int no = 0;
	
	// 전체 게시글 조회
	public MyArrayList<BoardVO> selectBoard() {
		return list;
	}
	
	// 글번호에 해당하는 게시물 조회
	public BoardVO selectOneBoard(int no) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			// Generic을 적용했기때문에 형변환이 필요없음
			if (board.getNo() == no) return board;
		}
		return null;
	}
	
	public void insertBoard(BoardVO boardVO) {
		boardVO.setNo(++no);
		boardVO.setRegDate(new Date());
		// 글쓰는 시점에 날짜 정보 등록
		list.add(boardVO);
	}
	
	public boolean updateBoard(BoardVO boardVO) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			// Generic을 적용했기때문에 형변환이 필요없음
			if (board.getNo() == boardVO.getNo()) {
				board.setTitle(boardVO.getTitle());
				return true;
			}
		}
		return false;
	}

	public boolean deleteBoard(int no) {
		int delIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			BoardVO board = list.get(i);
			// Generic을 적용했기때문에 형변환이 필요없음
			if (board.getNo() == no) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			return false;
		}
		
		list.remove(delIndex);
		return true;
	}
}









