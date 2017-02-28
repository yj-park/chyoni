package annotation.exam01;

// 만들어둔 어노테이션을 사용하는 방법: @+어노테이션명
@Marker
public class Test {
	
	// value라는 속성을 가진 Type1이라는 이름의 어노테이션
	@Type1(value="test")
	@Type2(name="dars")
	public void call() {}

	// Single-value 형태의 어노테이션의 경우
	// 속성명이 value인 경우 생략 가능
	// 우리가 배운 @WebServlet이 이 경우이다!
	@Type1("test")
//	@Type2("dars") -> 에러 발생
	public void call2() {}
}
