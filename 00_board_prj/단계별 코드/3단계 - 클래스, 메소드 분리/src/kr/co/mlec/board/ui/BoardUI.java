package kr.co.mlec.board.ui;

import java.util.Scanner;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class BoardUI {
	
	private Scanner sc = new Scanner(System.in);
	private BoardDAO dao;
	public BoardUI() {
		dao = new BoardDAO();
	}

	public void execute() {
		while (true) {
			switch (menu()) {
			case 1: showBoardList(); break;
			case 2: showBoardByNo(); break;
			case 3: writeBoard();    break;
			case 4: modBoard();      break;
			case 5: delBoard();      break;
			case 0: exitBoard();     break;
			}
		}
	}
	
	
	/**
	 *   사용자에게 메뉴를 보여준다.
	 */
	private int menu() {
		System.out.println("------------------------------------");
		System.out.println("1. 전체 게시물 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("------------------------------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	private void showBoardList() {
		BoardVO[] list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.length);
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t글쓴이");
		System.out.println("------------------------------------");
		for (int i = list.length - 1; i >= 0; i--) {
			System.out.printf(
					"%d\t%s\t%s\n", 
					list[i].getNo(), list[i].getTitle(), list[i].getWriter());
		}
		if (list.length == 0) {
			System.out.println("입력된 게시물이 없습니다.");
		}
		System.out.println("------------------------------------");
	}

	private void showBoardByNo() {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		BoardVO boardVO = dao.selectOneBoard(no);
		
		System.out.println("------------------------------------");
		if (boardVO != null) {
			System.out.println("번호 : " + no);
			System.out.println("제목 : " + boardVO.getTitle());
			System.out.println("글쓴이 : " + boardVO.getWriter());
			System.out.println("내용 : " + boardVO.getContent());
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
		System.out.println("------------------------------------");
		System.out.println();
	}
	
	private void writeBoard() {
		BoardVO boardVO = new BoardVO();
		System.out.print("제목을 입력하세요 : ");
		boardVO.setTitle(sc.nextLine());
		System.out.print("글쓴이를 입력하세요 : ");
		boardVO.setWriter(sc.nextLine());
		System.out.print("내용을 입력하세요 : ");
		boardVO.setContent(sc.nextLine());
		dao.insertBoard(boardVO);
		System.out.println("게시물 등록이 완료되었습니다.");
	}
	
	private void modBoard() {
		BoardVO boardVO = new BoardVO();
		System.out.print("수정할 글번호를 입력하세요 : ");
		boardVO.setNo(Integer.parseInt(sc.nextLine()));
		System.out.print("변경할 제목을 입력하세요 : ");
		boardVO.setTitle(sc.nextLine());
		
		if (dao.updateBoard(boardVO)) {
			System.out.println("게시물 수정이 완료되었습니다.");
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
	}

	private void delBoard() {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		if (dao.deleteBoard(no)) {
			System.out.println("게시물 삭제가 완료되었습니다.");
		} else {
			System.out.println("글번호에 해당하는 게시물이 없습니다.");
		}
	}

	private void exitBoard() {
		System.out.println("게시판 프로그램을 종료합니다");
		System.exit(0);
	}
}



















