package reflection;

import java.lang.reflect.Method;

public class Test03 {
	public static void main(String[] args) {
		try {
			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exam01() throws Exception {
		// 리플렉션을 이용한 객체 생성
//		Dog d = new Dog();
		
		Class<?> clz = Dog.class;
		// 새로운 인스턴스(객체)를 만들어라
		Object obj = clz.newInstance();
		
		Dog d = (Dog)obj;
		d.setName("쫑");
		System.out.println(d.getName());
		
	}
	private static void exam02() throws Exception {
		// 리플렉션을 이용한 메소드 실행
		Class<?> clz = Dog.class;
		
		Object obj = clz.newInstance();
		// m이라는 이름으로 setName메소드를 받아올게!
		// Dog d = new Dog(); -> 가져오는건 성공함
		// d.setName("쫑"); -> 이걸 하고싶은거야!
		// 우선 메소드가 어떤 객체와 묶여있는지 알아야해. 
		// 어떤 객체에 대한 정보는 obj에 있는거고 m에는 메소드 정보만 있는거야 즉 두 개가 묶여야 메소드 실행 가능
		Method m = clz.getDeclaredMethod("setName", String.class);
		// 그리고 메소드를 실행하기 위해서 값이 필요해!
		// 실행: invoke
		// m이라는 메소드를 obj에 실행할거고/ 실행할 값은 "쫑"이야 
		m.invoke(obj, "쫑");
		// 설정된 값 꺼내기
		// getName 메소드 객체 얻기
		Method m2 = clz.getDeclaredMethod("getName");
		Object value = (String)m2.invoke(obj);
		System.out.println(value);
		
		Method m3 = clz.getDeclaredMethod("setAge", int.class);
		m3.invoke(obj, 7);
		Method m4 = clz.getDeclaredMethod("getAge");
		// int나 Integer나 같음!
		Object age = (int)m4.invoke(obj);
		System.out.println(age);
		
	}
	
}
