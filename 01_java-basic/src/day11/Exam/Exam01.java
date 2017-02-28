package day11.Exam;


public class Exam01 {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		// list.get(0)일 경우 "one"을 반환
		String data = (String)list.get(1);
		// data : two가 출력됨
		System.out.println("data : " + data);
		
		// add한 데이터들의 크기 반환
		int size = list.size();
		// 입력된 데이터의 크기 : 4가 출력됨
		System.out.println("입력된 데이터의 크기 : " + size);
		
		// two 데이터를 삭제 처리함
		list.remove(1);
		
		size = list.size();
		// 삭제 후 데이터의 크기 : 3이 출력됨
		System.out.println("삭제 후 데이터의 크기 : " + size);
		
		// 전체 데이터 삭제
		list.clear();
		
		size = list.size();
		// 전체 삭제 후 데이터의 크기 : 0이 출력됨
		System.out.println("전체 삭제 후 데이터의 크기 : " + size);
		
		list.add("test");
		list.add("java");
		
		// MyArrayList[test, java]를 출력함
		System.out.println(list);
		
		
		
		
	}

}
