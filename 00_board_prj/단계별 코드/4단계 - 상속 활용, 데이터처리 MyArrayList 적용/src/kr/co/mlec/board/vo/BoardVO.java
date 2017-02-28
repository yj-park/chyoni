package kr.co.mlec.board.vo;

/**
 * 게시물에 대한 정보를 표현하는 데이터 클래스
 * @author Administrator
 */
public class BoardVO {
	
	/** 글번호 */
	private int no;
	/** 글쓴이 */
	private String writer;
	/** 제목 */
	private String title;
	/** 내용 */
	private String content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}











