package reflection;

import java.util.ArrayList;
import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		try {
		//	exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exam01() throws Exception {
		// 클래스 정보를 얻는 방법 : 3가지
		
		//1. 클래스 이름.class: 클래스의 static 필드인 class 이용
		Class<?> clz = Dog.class;
		// Dog 클래스의 method area에 접근하여 사용할 수 있게 한다. 클래스 타입을 받았을 때 변수 이름을 clz 또는 clazz 라고 쓴다. 
		// 제너릭<>안에 ?을 쓰면 어떤 타입이든지 다 받겠다라는 뜻
		
		//2. Class.forName("패키지명.클래스명");
		//   Class.forName("oracle.jdbc.driver.OracleDriver");에서 사용해본 적 있음
		Class<?> clz2 = Class.forName("reflection.Dog"); // 예외처리 필수. 클래스 정보가 문자열로 제공되는 경우 2번 사용
		
		// clz와 clz2는 방식만 다를 뿐 Dog라는 클래스 객체의 서로 같은 공간을 바라보고 있다
		System.out.println(clz == clz2);
		// 참조변수의 값이 같다는 건 서로 같은 공간을 바라보고 있다는 것!
		
		//3. 객체.getClass()
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		// 제약 조건이 없으면 무조건 1번으로 쓰고, 문자열밖에 못받으면 2번, 객체 형태로 받으면 1번 혹은 3번 -> 상황에 따라 다름!
		
		
		// 1) 클래스의 정보 중 이름 얻기
		System.out.println(clz.getName()); // 클래스의 풀네임(패키지 포함)
		System.out.println(clz.getSimpleName()); // 패키지명이 제외된 클래스명
		
	}
	
	private static void exam02() throws Exception {
		/*
		Object obj = new String();
		Class<?> clz = obj.getClass(); // obj객체의 클래스 타입을 얻어올래
		System.out.println(clz.getName());
		*/
		
		Object obj = randomObject();
		Class<?> clz = obj.getClass(); // obj객체의 클래스 타입을 얻어올래
		System.out.println(clz.getName());
		switch (clz.getName()) {
		case "java.lang.String":
			System.out.println("문자열 클래스 넘어옴");
			break;
		case "java.lang.ArrayList":
			System.out.println("ArrayList 클래스 넘어옴");
			break;
		case "java.lang.Integer":
			System.out.println("Integer 클래스 넘어옴");
			break;
		}
		// 조건에 맞게 여러가지 작업 가능
		
	}
	private static Object randomObject() throws Exception {
		Object [] arr = {
				new String(),
				new ArrayList<String>(),
				new Integer(100),
		};
		Random r = new Random();
		return arr[r.nextInt(arr.length)];
	}
}
























