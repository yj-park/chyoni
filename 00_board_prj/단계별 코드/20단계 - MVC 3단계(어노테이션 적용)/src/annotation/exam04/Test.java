package annotation.exam04;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		Class<?> clz = AnnoApply.class;
		ClassAnno cAnno = clz.getAnnotation(ClassAnno.class);
		RunAnno1 rAnno1 = clz.getAnnotation(RunAnno1.class);
		
		System.out.println(cAnno);
		System.out.println(rAnno1);
		System.out.println(rAnno1.value());
		
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			RunAnno2 anno = m.getAnnotation(RunAnno2.class);
			if (anno == null) continue;
			
			System.out.println("메서드명 : " + m.getName());
			System.out.println("ID : " + anno.id());
			System.out.println("MSG : " + anno.msg());
			
		}
	}
}















