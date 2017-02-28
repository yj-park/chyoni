package day08;

public class Test01 {
	public static void main(String[] args) {
		String s1 = new String("java is easy.");
		String s2 = "java is easy.";
		// 문자열이 아닌 특별한 데이터 형태를 가지고 문자를 만들고자 할 때 1번 방법 사용
		byte[] bArr = {97, 98, 99};
		String s3 = new String(bArr);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		// byte코드가 가지고 있는 배열의 값을 아스키 코드에 해당하는 값의 문자로 바꿔준다.
		
		System.out.println(s1 == s2);
		// s1의 값과 s2의 값을 비교하면 답은 false.
		// 자체의 주소값을 가지고 있기 때문에! 만약 메소드를 가지고 비교하면 달라질 수 있음.
		
		String s4 = "a";
		String s5 = "a";
		
		System.out.println(s4 == s5);
		// "" 안에 있는 값을 비교하면 답은 true
		
		s4 = "b";
		System.out.println(s4 == s5);
		
		System.out.println(s4 + "aa");
		// 할당하지 않았기 때문에 s4의 값이 변하지 않는다.
		// String 클래스는 상수
		
		
		//s4 = s4 + "b";
		//System.out.println(s4);
	}

}
