package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Test03 {
	public static Map<String, Character> randomMap() {
		Map<String, Character> map = new HashMap<> ();
		Random r = new Random();
		String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < 10; i++) {
			int keyNum = r.nextInt(52);
			map.put(String.valueOf(keyNum), alpha.charAt(keyNum));
		}
		// 랜덤한 숫자로 key값 선택하므로 출력하기 힘들어
		return map;
	}
	
	public static void main(String[] args) {
		//randomMap을 부름 - key값을 모르는 경우 확인하는 방법
		
		Map<String, Character> map = randomMap();
		System.out.println(map);
		
		// map에 있는 모든 data출력
		// key값들을 keySet에 담아두는 구조
		// keySet은 set을 반환
		// key와 Set은 중복 값을 허용하지 않기때문에 의미가 맞음!
		// map에 있는 generic 값을 줌 (맵의 키값을 받으므로)
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println("key : " + key+ ", value : " + map.get(key));
		}
		
		// 두 개 이상의 연관관계에 있는 데이터를 관리하기 위해서는 클래스로!
		// key+value만을 관리하기 위해 Entry라는 이름으로 map클래스의 내부클래스를 생성해줌(내부클래스는 안드로이드에서)
		// entry는 put에 들어오는 데이터를 관리. entry클래스도 generic 사용
		Set<Entry<String, Character>> entrySet = map.entrySet();
		for(Entry<String, Character> entry : entrySet) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		
		
		/*
		Map<String, String> map = new HashMap<> ();
		map.put("name", "이재명");
		map.put("name", "표창원");
		map.put("addr", "국회의사당");
		map.put("homepage", "nabo@ass.com");
		System.out.println(map);
		// map에서 key값은 중복 허용 X, 기존에 있는 값을 새로 입력된 값으로 교체 
		
		String name = map.get("name");
		System.out.println(name);
		System.out.println(map.get("age"));
		// 없는 값을 출력하면 null 출력
		
		Map<String, String> temp = new HashMap<> ();

		// Map의 name에 해당하는 데이터를 temp로 이동(key는 알고있다는 전제하에) 
		// temp.put("name", map.get("name"));
		// map.remove("name");
		// 어떤 값이 저장되어있는지 알 수 있는 방법을 모르기때문에 이렇게 표현한 것
		temp.put("name", map.remove("name"));
		System.out.println(map);
		
		// remove()는 String 타입의 값을 반환
		String rName = map.remove("name");
		System.out.println(map);
		System.out.println("삭제된 값: " + rName);
		
		*/
	
	}

}
