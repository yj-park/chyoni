package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Test02 {
	public static void main(String[] args) {
		try {
//			exam01();
//			exam02();
			exam03();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ArrayList 메서드 이름이 get으로 시작하는 메서드
	private static void exam02() {
		Class<?> clz = ArrayList.class;
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			String mName = method.getName();
			if (!mName.startsWith("get")) continue;
			
			System.out.println(mName);
		}
	}
	
	// ArrayList 반환타입이 void 인 메서드
	private static void exam03() {
		Class<?> clz = ArrayList.class;
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			Class<?> rClz = method.getReturnType();
			String rName = rClz.getName();
			if (!rName.equals("void")) continue;
			
			System.out.println(method.getName());
		}
	}

	private static void exam01() throws Exception {
		// 클래스의 메서드 정보 가져오기
		Class<?> clz = Dog.class;
		System.out.println("모든 메서드 정보 출력");
		System.out.println("-----------------------");
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			System.out.println("메서드 이름 : " + method.getName());
			// public String getName()
			Class<?> rClz = method.getReturnType();
			System.out.println("반환 이름 : " + rClz.getName());
			
			System.out.println("파라미터 정보 : ");
			System.out.println("=========================");
			Parameter[] pArr = method.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType();	
				System.out.print(t.getTypeName() + " ");
				System.out.println(p.getName());
			}
			System.out.println("=========================");
			
		}
		System.out.println("-----------------------");
		
		// setName 메서드에 대한 접근
		// String -> Class<?>
//		Method m = clz.getDeclaredMethod("setName", String.class);
		// getName
//		Method m = clz.getDeclaredMethod("getName");
		// setAge
		Method m = clz.getDeclaredMethod("setAge", int.class);
		System.out.println("메서드 이름 : " + m.getName());
		// public String getName()
		Class<?> rClz = m.getReturnType();
		System.out.println("반환 이름 : " + rClz.getName());
		
		System.out.println("파라미터 정보 : ");
		System.out.println("=========================");
		Parameter[] pArr = m.getParameters();
		for (Parameter p : pArr) {
			Type t = p.getParameterizedType();	
			System.out.print(t.getTypeName() + " ");
			System.out.println(p.getName());
		}
		System.out.println("=========================");
		
		
	}
	
}










