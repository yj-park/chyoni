package day08;

import java.util.Arrays;

// 객체지향인 자바 언어는 내가 만들 수 있는 것도 중요하지만
// 이미 만들어져있는 것을 찾아쓰는 것도 능력! 미리미리 연습해

public class Test03 {
	public static void main(String[] args) {
		
		// 1)다양한 타입을 문자열로 바꾸기
		// static String	valueOf(boolean b)
		String result = String.valueOf(true);
		System.out.println(result);	
		
		/*
		System.out.printf("나이 : %d, 이름 : %s\n", 33, "이진호");
		// 화면에 출력되는 정보
		
		String.format("나이 : %d, 이름 : %s\n", 33, "이진호");
		// 2)문자열로 저장하기 (파일이나 DB에 저장하여 지속적인 조작이 가능함)
		// 클래스이름으로 직접 부를 수 있는 메소드는 static이 붙어있음
		
		// static String	format(String format, Object... args)
		// ...->0개 이상의 매개변수가 나올 수 있음. 가변적으로 처리할 수 있다. Object는 모든 클래스 계층의 부모(superclass,뿌리)
		String result = String.format("나이 : %d, 이름 : %s\n", 33, "이진호");
		System.out.println(result);
		
		
		String s = "java is easy";
		// 3)문자열의 앞과 뒤 공백 제거
		// String	trim()
		s = "     a b c d e     ";
		System.out.println("|" + s + "|");
		System.out.println("|" + s.trim() + "|");
		// 모든 공백 제거해서 출력하기
		System.out.println("|" + s.replace(" ","") + "|");
				
		// 4)특정한 규칙에 맞춰 분리시키기 
		// String[]	split(String regex)
		s = "수지:33:분당:su@a.com"; // 복합적 정보를 갖고 있음
		// 약속 (=프로토콜) -> 이름 : 나이 : 주소 : 이메일
		//  -temp 생성, 문자열의 길이만큼 반복, : 앞까지
		//  -인덱스 위치 : 별로 자르기
		
		String[] result = s.split(":"); // -> :를 기준으로 자르기
		System.out.println(Arrays.toString(result)); 
		
		// 5)일부 문자열 추출하기
		// String	substring(int beginIndex)
		// String	substring(int beginIndex, int endIndex)
		// endIndex는 포함되지 않고 범위에서 -1 시키기 때문에 하나 더 길게 지정해줘야함 ex-2~3까지면 2,4로 지정
		String result = s.substring(2);
		System.out.println(result);
		
		result = s.substring(2, 3);
		System.out.println(result);		
		
		// 6)문자열의 내용 바꾸기 
		// String	replace(CharSequence target, CharSequence replacement)
		String result = s.replace("easy", "hard");
		System.out.println(result);
		// s는 상수클래스 -> s를 출력하면 java is easy / 바꾸고 싶으면 = 써서 할당해줌 s = s.replace("easy", "hard")
		
		s = "abc123def456ghi";
		// 숫자 부분을 *로 바꿔서 표시하기
		s = s.replace("123","***");
		s = s.replace("456","***");
		System.out.println(s);
		
		s = "a2345576xhsoce009487256";
		// 0~9까지 반복문 
		for (int i = 0; i < 10; i++) {
			s = s.replace("" + i, "*"); //문자열 + ____ = 문자열
		}
		System.out.println(s);
		
		s = "a2345576xhsoce009487256";
		// 영문자를 *로 바꿔서 표시하기
		for (char c = 'a'; c <= 'z'; c++) {
			s = s.replace(c, '*');
		}
		System.out.println(s);
		
		// 정규표현식(regular expression) 
		// => 문자열의 조작, 변경 등에 쉽게 사용할 수 있음 but 사용빈도가 적어 어려움
		// 이메일, 신용카드, 홈페이지 주소 등 형식에 맞게 쓰여져있는지 확인하는 용도로 사용됨. 공부하면 좋다! 나의 무기가 됨
		// String	replaceAll(String regex, String replacement)
		s = "a2345576xhsoce009487256";
		s = s.replaceAll("[0-9]", "*");
		System.out.println(s);
		
		s = "a2345576xhsoce009487256";
		s = s.replaceAll("[A-Za-z]", "*");
		System.out.println(s);
		// 정규표현식에서 대괄호[]는 범위를 나타냄. []안에 하나하나 나열해도됨
		// 문자열 조작시 엄청 유용함!
		
		
		
		// 7)기존 문자열을 문자 배열로 바꾸기
		// char[]	toCharArray()
		char[] arr = s.toCharArray();
		System.out.println(Arrays.toString(arr));
		
		// 8)문자열의 값을 소문자 & 대문자로 바꾸기
		// String	toLowerCase()
		// String	toUpperCase()
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());
		
		// 9)문자열의 특정 시작 값 찾기
		// boolean	startsWith(String prefix)
		boolean bool = s.startsWith("java");
		System.out.println(bool);
		
		bool = s.startsWith("java1");
		System.out.println(bool);
		// s가 가지고 있는 문자열의 내용이 java로 시작하고 있나요?
		
		// 10)문자열의 특정 마지막 값 찾기
		// boolean	endsWith(String suffix)
		bool = s.endsWith("easy");
		System.out.println(bool);
		
		// 11)문자열의 인덱스 값 찾기 (끝부터 시작)
		// int	lastIndexOf(String str) 
		// int	lastIndexOf(String str, int fromIndex)
		int index = s.lastIndexOf("a"); 
		System.out.println(index);
		
		index = s.lastIndexOf("a", 8); 
		System.out.println(index);		
		
		// 12)문자열의 인덱스 값 찾기 (처음부터 시작)
		// int	indexOf(String str)
		// int	indexOf(String str, int fromIndex)
		int index = s.indexOf("is"); // is의 시작하는  인덱스 값을 주세요
		System.out.println(index);
		
		index = s.indexOf("a"); // 무조건 첫번째 a를 찾아내기 때문에 v부터 주거나 int fromIndex 사용 
		System.out.println(index);
		 = s.indexOf("a", 2);
		System.out.println(index);
		index = s.indexOf("a", index + 1);
		System.out.println(index); 
		// 반복문으로 사용가능. 0부터 시작, 없는 경우도 있으니까 음수값 -1을 반환값으로 주기
		index = s.indexOf("ab");
		System.out.println(index); 
		
		// 13)문자열의 특정 내용 찾기
		// boolean	contains(CharSequence s)
		boolean bool = s.contains("is");
		System.out.println(bool);
		System.out.println(s.contains("is"));
		// 매개변수가 다르네?! int가 형변환 할 수 있는 모든 것을 받을 수 있듯 CharSequence가 받을 수 있는 모든 타입은 다 들어갈 수 있음
		// 객체의 형변환에서 다룰 예정! (부모는 자식을 받을 수 있음)
		
		 
		 
		// 14)문자열의 내용 비교     (* 문자열의 위치 비교는 = 로!)
		// boolean	equals(Object anObject) -> 대문자 & 소문자도 비교
		// boolean	equalsIgnoreCase(String anotherString) -> 대문자 & 소문자는 무시 같은 글자로 취급 
		// 메소드명에 Case가 나오면 대소문자와 관련
		String s1 = "Java Is Easy";
		
		boolean bool = s.equals(s1); //s의 문자열의 내용이 s1의 문자열 내용과 같은지 비교
		System.out.println(bool);
		
		bool = s.equalsIgnoreCase(s1);
		System.out.println(bool);
		
		
		// 15)문자열의 위치 비교
		// char charAt(int index); 
		// 반환타입         (매개변수);
		char c = s.charAt(0);
		System.out.println(c);
		
		// i가 출력되도록 
		c = s.charAt(5);
		System.out.println(c);
		
		System.out.println(s.charAt(5));
		
		// 16)문자열의 길이 비교
		// int	length(); 
		int len = s.length();
		System.out.println("문자열의 길이 : " + len);
		System.out.println("문자열의 길이 : " + s.length());
		*/

		
	}

}
