package day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Test01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		// 인터페이스기 때문에 객체 생성 X
		
		// add() 등록하기
		list.add("one");
		list.add("two");
		list.add("three");
		
		// 리스트의 데이터 확인하기
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 반복되는 메소드의 크기만큼 메소드가 실행됨
		
		for(int i = 0, size = list.size(); i < size; i++) {
			System.out.println(list.get(i));
		}
		// 메소드의 호출은 한 번만 하고 변수에 넣어줌. 범위가 넓은 경우에 더 효율적
		
		
		// 1.2버전 데이터 확인 방식
		Iterator<String> ite = list.iterator(); 
		// list에 있는 generic타입과 같은 타입을 적어줌. 
		// Iterator : 순환자, list가 가지고 있는 data를 처음부터 끝까지(데이터가 없어서 false값이 반환될때까지) 읽어줌
		while(ite.hasNext()) {
		System.out.println(ite.next());
		}
		// hasNext()를 통해 데이터가 있는지 없는지 먼저 확인(있으면 true, 없으면 false)하고 하나 꺼내고 next()로 포인트 이동
		// hasNext()는 sc.hasNextLine()과 유사!
		
		
		// 1.5이후 데이터 확인 방식
		for (String s : list) {
			System.out.println(s);
		}
		
		
		/*
		// get(int index); 불러오기
		System.out.println(list.get(1));

		// remove(int index); 삭제
		list.remove(0);
		System.out.println(list.get(1));
		// 삭제 이후 순서 당겨짐
		list.remove("three");
		// 직접 내용을 써서 삭제할 수도 있음
		
		System.out.println(list);
		// toString 호출한 결과와 같음, 오버라이딩을 하지 않았다면 @형태 출력
		
		list.add(0, "one");
		// add()시 위치를 지정할 수 있음 but 사용할 일 없음ㅋㅋ
		list.add("three");
		System.out.println(list);
		
		//clear() 전체 삭제
		list.clear();
		System.out.println(list);
		list.add("one");
		
		List<String> sub = new ArrayList<>();
		sub.add("two");
		sub.add("three");
		
		// addAll(~) (~)에 있는 내용을 모두 추가할게
		list.addAll(sub);
		System.out.println(list);
		
		// isEmpty() 비어있으면 true, 아니면 false 출력
		System.out.println(list.isEmpty());
		
		// contains(~) list의 data를 확인할 수 있음. (~)있으면 true, 없으면 false 출력
		System.out.println(list.contains("one"));
		
		// indexOf(~) (~)의 인덱스값을 알려줘. 인덱스값뿐만 아니라 데이터가 list에 있는지도 알 수 있음
		System.out.println(list.indexOf("one"));
		System.out.println(list.indexOf("four"));
		// list에 없는 데이터라면 -1 출력
		*/
		
		
		
		
	}

}
