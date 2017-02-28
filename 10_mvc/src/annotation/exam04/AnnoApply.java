package annotation.exam04;

@ClassAnno("클래스 설정")
@RunAnno1("런타임 설정")
public class AnnoApply {
	
	// 메소드만 설정 가능. 실행 시 참조 가능한 어노테이션 만들기
	@RunAnno2(id="tester", msg="Hi~~")
	public void info() {}
	
	public void call() {}
}
