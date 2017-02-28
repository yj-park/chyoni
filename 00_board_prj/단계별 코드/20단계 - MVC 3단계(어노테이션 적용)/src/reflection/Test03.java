package reflection;

import java.lang.reflect.Method;

public class Test03 {
	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exam01() throws Exception {
		// 리플렉션을 이용한 객체 생성
//		Dog d = new Dog();
		
		Class<?> clz = Dog.class;
		
		Object obj = clz.newInstance();
		Dog d = (Dog)obj;
		d.setName("쫑");
		System.out.println(d.getName());
	}
	
	private static void exam02() throws Exception {
		// 리플렉션을 이용한 메서드 실행
		Class<?> clz = Dog.class;
		
		Object obj = clz.newInstance();
		Method m = clz.getDeclaredMethod("setName", String.class);
		// 실행 : invoke
		m.invoke(obj, "쫑");
		// 설정된 이름 꺼내기
		// getName 메서드 객체 얻기
		
		Method m2 = clz.getDeclaredMethod("getName");
		String value = (String)m2.invoke(obj);
		System.out.println(value);
		
		Method m3 = clz.getDeclaredMethod("setAge", int.class);
		m3.invoke(obj, 2);
		
		Method m4 = clz.getDeclaredMethod("getAge");
		int age = (int)m4.invoke(obj);
		System.out.println("age : " + age);
	}
}












