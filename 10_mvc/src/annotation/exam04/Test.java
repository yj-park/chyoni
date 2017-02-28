package annotation.exam04;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		//AnnoApply에 대한 클래스 정보를 가져와
		Class<?> clz = AnnoApply.class;
		// 클래스 타입에 선언된 어노테이션 중에 이 어노테이션이 있는 지 판단하는 거야
		// 있으면 주소값, 없으면 null
		ClassAnno cAnno = clz.getAnnotation(ClassAnno.class);
		RunAnno1 rAnno1 = clz.getAnnotation(RunAnno1.class);
		
		// Retention이 CLASS이기 때문에 실행 시점에는 참조할 수가 없어서 null
		// 따라서 개발자는 Retention을 Runtime으로 해!
		// Retention의 default는 CLASS야! 그래서 annotation을 프로그램에서 응용하고 싶다면 반드시 Runtime으로 설정해줘야해!
		System.out.println(cAnno);
		System.out.println(rAnno1);
		// 어노테이션에 설정한 속성 값을 동적으로 가져올 수 있음
		System.out.println(rAnno1.value());
		
		// 클래스 안 메소드에 접근
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			RunAnno2 anno = m.getAnnotation(RunAnno2.class);
			if (anno == null) continue;
			
			System.out.println("메소드명 : " + m.getName());
			System.out.println("id : " + anno.id());
			System.out.println("msg : " + anno.msg());
			
			// call 메소드에는 설정된 게 없으므로 무시~
		}
	}
}
