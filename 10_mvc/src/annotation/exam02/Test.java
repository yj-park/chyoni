package annotation.exam02;

public class Test {
//	@FullValue(name="test2", value="fullvalue")
//	@FullValue("a")
	// 속성명이 value인 경우 속성명 생략은 가능하지만 값 생략 X
//	@FullValue(name="a")
	// 모든 속성에 기본값이 설정되어있는 경우 선택적으로 선언 가능
//	@FullValue(value="b")
//	@FullValue(name="b")
//	@FullValue
	// value 속성을 하나만 쓰는 경우 속성명 생략이 가능하지만 
	// full-value인 경우 어느 값이 value값인지 모르니까 오류 발생. 속성명 필수!
//	@FullValue("A", name="b")
	public void call() {}
	
}
