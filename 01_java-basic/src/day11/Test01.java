package day11;

public class Test01 {
	public static void main(String[] args) {
		Student std = new Student("s901", "이기수", 28);
		// new는 heap공간에 생성
		String info = std.toString();
		System.out.println(info);
		
	}

}
