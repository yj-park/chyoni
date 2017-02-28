package day06;

//하나의 파일에 여러 개의 클래스를 선언할 수 있지만 권장 X

class Test01Sub {
	int val;
	String msg;
	//모든 클래스가 메인 메소드를 가질 필요 X
}

public class Test01 {
	public static void main(String[] args) {
		Test01Sub sub = new Test01Sub();
		System.out.println(sub.val);
		System.out.println(sub.msg);

		
		Test01Sub sub2 = new Test01Sub();
		System.out.println(sub2.val);
		System.out.println(sub2.msg);
		
		
		Test01Sub sub3 = sub2;
		
		sub.val = 100;
		sub2.val = 200;
		sub3.val = 300;
		System.out.printf("%d, %d, %d\n", sub.val, sub2.val, sub3.val);
		
		
		
	}

}
