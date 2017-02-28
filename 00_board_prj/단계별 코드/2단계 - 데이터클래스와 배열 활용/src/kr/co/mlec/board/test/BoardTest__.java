package kr.co.mlec.board.test;

import java.util.Scanner;
import kr.co.mlec.board.vo.BoardVO; // *를 쓰면 VO밑에 있는 모든 클래스를 쓰겠다는 뜻

public class BoardTest_ {
	public static void main(String[] args) {
		
		// 게시물 번호
		int no = 0;
		// 게시물이 배열에 들어갈 인덱스 위치와 실제 들어간 데이터의 크기
		int pos = 0;
		BoardVO[] list = new BoardVO[3]; 
		/* 배열의 선언. 선언된 배열의 길이를 확장할 수는 없음(메모리가 붙어있다는 가정 하에 여러 개로 나눌 수 있는 것이 배열)
		 * 새로운 배열을 만들어주면 해결! 기존 배열이 새로운 배열로 복사됨,새로운 배열의 길이 = 기존 * 2로 만들어줌, 사이트 이용 방식에 따라서 기준은 다름.
		 * list[pos] = new BoardVO(); -> 이 시점에서 증가 작업 고고씽
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		outer: 
		while (true) {
			System.out.println("-----------------");
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			System.out.println("-----------------");
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.printf("전체 %d개\n", pos);
				System.out.println("-----------------");
				System.out.println("번호\t제목\t글쓴이");
				System.out.println("-----------------");
				for (int i = pos - 1; i >= 0; i--) {
					System.out.printf(
							"%d\t%s\t%s\n", list[i].no, list[i].title, list[i].writer);
				}
				if (pos == 0) {
					System.out.println("입력된 게시물이 없습니다.");
				}
				System.out.println("-----------------");
				break;
			case 2:
				System.out.print("조회할 글번호를 입력하세요 : ");
				int findNo = Integer.parseInt(sc.nextLine());
				System.out.println("-----------------");
				boolean search = false;
				for (int i = 0; i < pos; i++) {
					if (list[i].no != findNo) continue;
					
					search = true;
					System.out.println("번호 : " + findNo);
					System.out.println("제목 : " + list[i].title);
					System.out.println("글쓴이 : " + list[i].writer);
					System.out.println("내용 : " + list[i].content);
					break;
				}
				if (search == false) {
					System.out.println("글번호에 해당하는 게시물이 없습니다.");
				}
				System.out.println("-----------------");
				System.out.println();
				break;
			case 3:
				// 실제 입력된 데이터의 크기와 배열의 크기가 동일하다면
				// 배열의 크기를 기존의 2배로 확장한다.
				if (pos == list.length) {
					BoardVO[] temp = new BoardVO[list.length * 2];
					System.arraycopy(list, 0, temp, 0, pos);
					list = temp;
				}
				
				list[pos] = new BoardVO();
				// 게시물 번호 입력
				list[pos].no = ++no;
				System.out.print("제목을 입력하세요 : ");
				list[pos].title = sc.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
				list[pos].writer = sc.nextLine();
				System.out.print("내용을 입력하세요 : ");
				list[pos].content = sc.nextLine();	
				pos++;
				System.out.println("게시물 등록이 완료되었습니다.");
				break;
			case 4:
				System.out.print("수정할 글번호를 입력하세요 : ");
				int findNoMod = Integer.parseInt(sc.nextLine());
				System.out.println("-----------------");
				
				boolean searchMod = false;
				for (int i = 0; i < pos; i++) {
					if (list[i].no != findNoMod) continue;
					
					searchMod = true;
					System.out.println("변경할 제목을 입력하세요  : ");
					list[i].title = sc.nextLine();
					System.out.println("게시물 수정이 완료되었습니다.");
					break;
					}
				if(searchMod == false){
					System.out.println("입력된 번호는 존재하지 않습니다.");
				}
				System.out.println("-----------------");
				System.out.println();
				break;
			case 5:
				System.out.print("삭제할 글번호를 입력하세요 : ");
				int findNoDel = Integer.parseInt(sc.nextLine());
				System.out.println("-----------------");
				
				boolean searchDel = false;
				for (int i = 0; i < pos; i++) {
					if (list[i].no != findNoDel) continue;
					
					searchDel = true;
					list[i] = null;
					System.out.println("게시물 삭제가 완료되었습니다.");
					break;
					}
				if(searchDel == false){
					System.out.println("입력된 번호는 존재하지 않습니다.");
				}				
				System.out.println("-----------------");
				System.out.println();
				break;
			case 0:
				System.out.println("게시판 프로그램을 종료합니다.");
				break outer;
			}
		}
	}
}










