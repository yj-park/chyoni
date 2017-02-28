package day08;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("시간 측정 시작");
		String s1 = "a";
		// String은 메모리를 계속해서 생성하며 문자열을 만듦
		// 자기 자신의 공간 값을 지속적으로 바꾸는 StringBuffer와 StringBuilder 
		// StringBuffer(동기화)- 동시작업 불가능, 속도가 느리지만 안전
		// StringBuilder(비동기화) - 동시작업 가능, 속도가 빠르지만 충돌 위험 有
		
		StringBuffer s2 = new StringBuffer("a");
		// " "을 쓸 수 있는 건 오직 String class만 가능.
		// StingBuffer는 생성자메소드. 클래스와 이름이 같은 메소드니까!
		
		// 1.5이후부터 사용 가능
		StringBuilder s3 = new StringBuilder("a");
		
		
		long s = System.currentTimeMillis();
		// 기준점 1970년 1월 1일 0시 0분 0초 기준
		// 만약 1000이 나오면 1970년 1월 1일 0시 0분 1초라는 뜻
		for (int i = 0; i < 50000; i++) {
			s1 += i;
		}
		long e = System.currentTimeMillis();
		double time = (e - s) / 1000.0;
		System.out.println("String : " + time);
		
		s = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			s2.append(i); // 문자열 추가
		}
		e = System.currentTimeMillis();
		time = (e - s) / 1000.0;
		System.out.println("StringBuffer : " + time);
	
	}


}
