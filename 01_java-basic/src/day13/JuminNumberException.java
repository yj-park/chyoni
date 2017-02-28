package day13;

// 네이밍룰: 예외 클래스의 이름 마지막은 Exception
public class JuminNumberException extends Exception {
	// API의 예외처럼 멘트 넣기
	public JuminNumberException () {
		super("잘못된 주민번호 형식입니다.");
		}
	public JuminNumberException (String errMsg) {
		super(errMsg);
	}
}
