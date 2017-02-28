package kr.co.mlec.board.vo;

public class PageVO {
	private int pageNo = 1;
	
	// (요청한 페이지 번호 - 1) * 목록에 보여줄 개수 + 1
	public int getBegin() {
		return (pageNo -1) * 10 + 1;
	}
	// 목록에 보여줄 개수 * 페이지 번호
	public int getEnd() {
		return pageNo * 10;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
