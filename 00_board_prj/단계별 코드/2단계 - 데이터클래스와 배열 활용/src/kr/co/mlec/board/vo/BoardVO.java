package kr.co.mlec.board.vo;

/** 게시물에 대한 정보를 표현하는 데이터 클래스 
 * 문서화 주석문 (클래스/메소드/멤버변수(클래스 구성요소)에 대한 설명을 할 수 있다.), 쓰는 습관 들이기
 * @author Bitcamp 박유전
 *
 */
public class BoardVO {                  //데이터 중심 클래스.
	/** 글번호 */
	public int no;         //public은 누구나 다 접근해서 쓸 수 있다는 표시. 제한 X 
	/** 글쓴이 */
	public String writer;
	/** 제목 */
	public String title;
	/** 내용 */
	public String content;
}
