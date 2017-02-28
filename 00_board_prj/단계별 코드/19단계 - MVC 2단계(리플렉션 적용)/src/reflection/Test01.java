package reflection;

import java.util.ArrayList;
import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exam01() throws Exception {
		// 클래스 정보를 얻는 방법 : 3가지
		
		// 1. 클래스 이름.class : 클래스의 static 필드인 class 이용
		Class<?> clz = Dog.class;
		
		// 2. Class.forName("패키지명.클래스명");
		//    Class.forName("oracle.jdbc.driver.OracleDriver");
		Class<?> clz2 = Class.forName("reflection.Dog");
		
		// 3. 객체.getClass() 
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2);
		
		System.out.println(clz.getName());
		System.out.println(clz.getSimpleName());
	}
	
	private static void exam02() throws Exception {
		/*
		Object obj = new String();
		Class<?> clz = obj.getClass();
		System.out.println(clz.getName());
		*/
		
		Object obj = randomObject();
		Class<?> clz = obj.getClass();
		switch (clz.getName()) {
		case "java.lang.String":
			System.out.println("문자열 클래스 넘어옴...");
			break;
		case "java.lang.Integer":
			System.out.println("Integer 클래스 넘어옴...");
			break;
		case "java.util.ArrayList":
			System.out.println("ArrayList 클래스 넘어옴...");
			break;
			
		}
	}
	
	private static Object randomObject() throws Exception {
		Object [] arr = {
			new String(),
			new ArrayList<String>(),
			new Integer(100)
		};
		Random r = new Random();
		return arr[r.nextInt(arr.length)];
	}
}










