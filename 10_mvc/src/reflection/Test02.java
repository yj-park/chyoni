package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Test02 {
	public static void main(String[] args) {
		try {
		//	exam01();
			exam02();
			exam03();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ArrayList 메소드명이 get인 메소드
	private static void exam02() throws Exception {
		Class<?> clz = ArrayList.class;
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			String mName = method.getName();
			if (!mName.startsWith("get")) continue;
			
			System.out.println(mName);
		}
	}
	
	// ArrayList 반환타입이 void인 메소드
	private static void exam03() throws Exception {
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
		// 클래스의 메소드 정보 가져오기 
		// (접근제한자,반환타입,메소드명,파라미터,예외 등의 정보) -> reflection에 이와 같은 연관된 정보를 클래스로 만들어둠. 
		// Method라는 클래스(사용자들이 직접 파싱하지 않고도 정보를 손쉽게 뽑아낼 수 있게 만들어둔거야)!
		Class<?> clz = Dog.class;
		System.out.println("모든 메소드 정보 출력");
		System.out.println("--------------------------------");
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			System.out.println("메소드 이름 : " + method.getName());
			
			// String에 대한 Class<?>타입을 얻어오겠다.
			//	Method m = clz.getDeclaredMethod("setName", String.class);
			//	getName
			//	Method m = clz.getDeclaredMethod("getName");
			//	System.out.println("메소드 이름: " + m.getName());
			//  setAge
			Method m = clz.getDeclaredMethod("setAge", int.class);
			
			// 반환타입 정보의 반환타입은 Class라는 클래스! 따라서 rClz로 받아서 getName해주면 알 수 있음(?) 
			Class<?> rClz = method.getReturnType();
			System.out.println("반환타입 이름 : " + rClz.getName()); 
			
			// 파라미터의 타입뿐만 아니라 파라미터명까지 알 수 있음
			System.out.println("파라미터 정보 : ");
			System.out.println("===============================================");
			Parameter[] pArr = method.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType();
				System.out.print(t.getTypeName() + " ");
				System.out.println(p.getName()); // 파라미터명
			}
			System.out.println("===============================================");
			
		}
		System.out.println("--------------------------------");
		
		
	}
	
}








