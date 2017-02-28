package kr.co.mlec.board.dao;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAO {
	// 게시물이 배열에 들어갈 인덱스 위치와 실제 들어간 데이터의 크기
	private int pos = 0;
	private BoardVO[] list = new BoardVO[3];
	// 게시물 번호
	private int no = 0;
	
	// 전체 게시글 조회
	public BoardVO[] selectBoard() {
		BoardVO[] rList = new BoardVO[pos];
		System.arraycopy(list, 0, rList, 0, pos);
		return rList;
	}
	
	// 글번호에 해당하는 게시물 조회
	public BoardVO selectOneBoard(int no) {
		for (int i = 0; i < pos; i++) {
			if (list[i].getNo() == no) return list[i];
		}
		return null;
	}
	
	public void insertBoard(BoardVO boardVO) {
		// 실제 입력된 데이터의 크기와 배열의 크기가 동일하다면
		// 배열의 크기를 기존 2배로 확장한다.
		if (pos == list.length) {
			BoardVO[] temp = new BoardVO[pos * 2];
			// 기존 입력된 내용을 새롭게 생성된 배열로 복사
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		boardVO.setNo(++no);
		list[pos++] = boardVO;
	}
	
	public boolean updateBoard(BoardVO boardVO) {
		for (int i = 0; i < pos; i++) {
			if (list[i].getNo() == boardVO.getNo()) {
				list[i].setTitle(boardVO.getTitle());
				return true;
			}
		}
		return false;
	}

	public boolean deleteBoard(int no) {
		int delIndex = -1;
		for (int i = 0; i < pos; i++) {
			if (list[i].getNo() == no) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			return false;
		}
		int length = pos - (delIndex + 1);
		if (length > 0) {
				// 삭제하려는 인덱스 다음 위치의 게시물들을 한칸씩 앞으로 이동시킨다.
			System.arraycopy(list, delIndex + 1, list, delIndex, length);
		}
		
		// 제일 마지막 위치값을 null 처리함
		list[--pos] = null;
		
		return true;
	}
}














