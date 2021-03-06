package day07.test;

import java.util.Scanner;
import day07.test.BoardVO;

/**
 * @author Bitcamp 박유전 게시판 테스트 1
 *
 */
public class BoardTest {
	public static void main(String[] args) {
		
		int no = 0;
		int pos = 0;
		
		BoardVO [] list = new BoardVO[3];
		Scanner sc = new Scanner(System.in);
		
		outer :
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
				System.out.println();
				
				switch (menu) {
				case 1 :
					System.out.printf("전체 %d개 \n" , pos);
					System.out.println("-----------------");
					System.out.println("번호 \t 글쓴이 \t 제목 \t");
					System.out.println("-----------------");
					for (int i = pos - 1; i >= 0; i--){
						System.out.printf("%d \t %s \t %s \t", list[i].no, list[i].writer, list[i].title);

					} if (pos == 0) {
						System.out.println("게시물이 존재하지 않습니다.");
					}
					System.out.println("-----------------");
					System.out.println();
					break;
				case 2 :
					System.out.print("조회할 글번호를 입력하세요 : \n");
					int findNo = Integer.parseInt(sc.nextLine());
					System.out.println("-----------------");
					
					boolean search = false;
					for (int i = 0; i < pos; i++) {
						if (list[i].no != findNo) continue;
						
						search = true;
						System.out.println("번호 : " + findNo);
						System.out.println("글쓴이 : " + list[i].writer);
						System.out.println("제목 : " + list[i].title);
						System.out.println("내용 : " + list[i].content);
						break;
					} 
					if (search == false) { 
						System.out.println("입력된 번호는 존재하지 않습니다.");
					}
					System.out.println("-----------------");
					System.out.println();
					break;
				case 3 :
					if (pos == list.length) {
						BoardVO [] temp = new BoardVO [list.length * 2];
						System.arraycopy(list, 0, temp, 0, pos);
						list = temp;
					}
					list[pos] = new BoardVO();
					
					
					list[pos].no = ++no;  
					System.out.print("제목을 입력하세요 : ");
					list[pos].title = sc.nextLine();
					System.out.println();
					System.out.print("글쓴이를 입력하세요 : ");
					list[pos].writer = sc.nextLine();
					System.out.println();
					System.out.print("내용을 입력하세요 : ");
					list[pos].content = sc.nextLine();
					System.out.println();
					pos++;
					System.out.println("게시글 등록이 완료되었습니다.");
					break;
					
				case 4 : 
					System.out.print("수정할 글번호를 입력하세요 : \n");
					int modNo = Integer.parseInt(sc.nextLine());
					System.out.println("-----------------");
					
					boolean modFlag = false;
					for (int i = 0; i < pos; i++) {
						if (list[i].no != modNo) continue;
						
						modFlag = true;
						System.out.print("변경할 제목을 입력하세요 : \n");
						list[i].title = sc.nextLine();
						System.out.println("게시글이 수정되었습니다.");
						break;
					} 
					if (modFlag == false) {
						System.out.println("입력된 번호는 존재하지 않습니다.");
					}
					System.out.println("-----------------");
					System.out.println();
					break;
				case 5 :
					System.out.print("삭제할 글번호를 입력하세요 : \n");
					int delNo = Integer.parseInt(sc.nextLine());
					int delIndex = -1;
					
					for (int i = 0; i < pos; i++){
						if (list[i].no == delNo){
							delIndex = i;
					        break;
						}
					}
					
					if (delIndex == -1){
						System.out.println("입력하신 번호에 해당하는 게시글이 없습니다.");
						break;
					}
					
					int length = pos - (delIndex + 1);
					if (length > 0) {
						System.arraycopy(list, delIndex + 1, list, delIndex, length);
						
					}
					list[--pos] = null;
					
					System.out.println("게시글이 삭제되었습니다.");
					System.out.println();
					break;
				case 0 :
					System.out.println("게시판 프로그램을 종료합니다.");
					break outer;
						
					
									
				
				}
				
			}
		
		
		
		
		
	}
	
	

}
