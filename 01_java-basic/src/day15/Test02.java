package day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		// Set<String> set = new Set<>();
		// 인터페이스라서 객체 생성 불가능
		Set<String> set = new HashSet<>();
		System.out.println(set.add("one"));
		System.out.println(set.add("two"));
		System.out.println(set.add("three"));
		// boolean형
		
		// two는 한 번만. 중복된 데이터를 허용하지 않기 때문에 기존에 있던 two와 겹쳐서 그 후의 two는 반영되지 않음
		System.out.println(set.add("two"));
		System.out.println(set);
		
		// size() 크기
		System.out.println(set.size());
		
		// 삭제는 Object를 직접 선택해서!	
		set.remove("one");
		System.out.println(set);
		
		// set의 데이터 확인하기
		// 인덱스를 이용한 반복문 사용불가: set은 인덱스 접근이 불가능하기때문에
		// for(int i = 0; i < set.size(); i++) { }
		// set은 원하는 위치의 데이터를 꺼낼 수 없다.
		
		for (String s : set) {
			System.out.println(s);
		}
		
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		
		
	}

}
