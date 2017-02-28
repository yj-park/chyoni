package annotation.exam01;

@Marker
public class Test {
	
	@Type1(value="test")
	@Type2(name="test")
	public void call() {}
	
	// Single Value 형태의 어노테이션의 경우
	// 속성명이 value 인 경우 생략이 가능함
	@Type1("test")
//	@Type2("test")   // 에러 발생
	public void call2() {}
}










