package kr.co.mlec.board.test;

import java.util.Scanner;

public class BoardTest {
	public static void main(String[] args) {
		
		int i = 1;
	    Scanner sc = new Scanner(System.in);
	    while (true){
	    	System.out.println("-------------------");
	    	System.out.println("1. 전체 게시물 조회");
	    	System.out.println("2. 글번호 조회");
	    	System.out.println("3. 글등록");
	    	System.out.println("4. 글수정");
	    	System.out.println("5. 글삭제");
	    	System.out.println("0. 종료");
	    	System.out.println("-------------------");
			System.out.print("메뉴 중 처리할 항목을 선택하세요:");
			i = Integer.parseInt(sc.nextLine());
		
			
			if ( i == 1) {
				System.out.println("전체 게시글 조회 메뉴 선택함");
			} else if ( i == 2){
				System.out.print("조회할 글번호를 입력하세요 : ");
				sc.nextLine();
				System.out.println("글번호 조회 메뉴 선택함");
			} else if ( i == 3){
				System.out.print("제목을 입력하세요 : ");
				sc.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
				sc.nextLine();
				System.out.println("글등록 메뉴 선택함");
			} else if ( i == 4){
				System.out.print("수정할 글번호를 입력하세요 : ");
				sc.nextLine();
				System.out.print("변경할 제목을 입력하세요 : ");
				sc.nextLine();
				System.out.println("글수정 메뉴 선택함");
			} else if ( i == 5){
				System.out.print("삭제할 글번호를 입력하세요 : ");
				sc.nextLine();
				System.out.println("글삭제 메뉴 선택함");
			} else if ( i == 0){
				System.out.println("게시판 프로그램을 종료합니다.");
				break;
			}
		
	    }
	}

}
