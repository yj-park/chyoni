package network.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test02 {
	// 자바 객체를 json으로 직접 변경하기
	private static void exam01() {
		
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(22);
		
		// 위의 객체의 내용을 json형태의 문자열로 변경
		String result = "{\"name\":\""+ m.getName() +"\", \"age\":" + m.getAge() + "}";
		System.out.println(result);
	}
	
	private static void exam02() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(22);
		
		// 자바 객체를 gson으로 변경  (나중에 reflection 공부하면 직접 할 수 있음)
		Gson gson = new Gson();
		String result = gson.toJson(m);
		System.out.println(result);
		// System.out.println(new Gson().toJson(m));
	}
	
	private static void exam03() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(22);
		
		// List인 자바 객체를 gson으로 변경
		List<String> hobbys = new ArrayList<>();
		hobbys.add("독서");
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		
		m.setHobbys(hobbys);
		
		System.out.println(new Gson().toJson(m));
	}
	
	private static void exam04() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(22);
		
		List<String> hobbys = new ArrayList<>();
		hobbys.add("독서");
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		m.setHobbys(hobbys);
		
		Address addr = new Address();
		addr.setPostNo("12345");
		addr.setBasic("서울특별시 서초구");
		addr.setDetail("서초동 비트아카데미 빌딩");
		m.setAddr(addr);
		
		System.out.println(new Gson().toJson(m));
	}
	
	// json 문자열을 자바 객체에 적용하기
	private static void exam05() {
		// 자바 스크립트에서는 문자열을 ''으로도 표현가능!
		String json = "{'name' : '홍길동', 'age' : 22}";
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		// json문자열로부터 Member클래스 타입으로 적용시켜 자바 객체로 만들어줌
		System.out.println(m.getName());
		System.out.println(m.getAge());
	}
	
	private static void exam06() {
		String json = "{'name': '홍길동', 'age': 22, 'hobbys': ['영화감상', '음악감상']}";
	
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		// json문자열로부터 Member클래스 타입으로 적용시켜 자바 객체로 만들어줌
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getHobbys());
	}
	
	private static void exam07() {
		String json = "{'name': '홍길동', 'age': 22, 'hobbys': ['영화감상', '음악감상'], 'addr': {'postNo': '12345', 'basic':'서울 서초구', 'detail':'비트아카데미'}}";
		
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		// json문자열로부터 Member클래스 타입으로 적용시켜 자바 객체로 만들어줌
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getHobbys());
		Address addr = m.getAddr();
		System.out.println(addr.getPostNo());
		System.out.println(addr.getBasic());
		System.out.println(addr.getDetail());
	}
	
	public static void main(String[] args) {
//		exam01();
//		exam02();
//		exam03();
//		exam04();
//		exam05();
//		exam06();
		exam07();
	}

}
