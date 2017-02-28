package day09;

class Sub03 {
	static int count = 0;
	
}

public class Test03 {
	int i = 100;
	static int k = 100;
	public void call() {
		Sub03 sub = new Sub03();
		System.out.println(sub.count); 
		sub.count = 100;
		//왔다갔다 두 번 일해야되는데 왜 이런 방식으로 쓰니?하고 노란색으로 경고해줌ㅋㅋ
		System.out.println(Sub03.count); // 어차피 Sub03으로 가서 찾아야하니 클래스 이름.으로 주렴
		Sub03.count=200;
		System.out.println(sub.count);
		
		// non-static영역에서는 static영역의 변수 또는 메소드를 접근할 수 있다.
		System.out.println(i);
		System.out.println(k);
	}
	
	
	public static void main(String[] args) {
		/*
		 * static영역에서 non-static(instance)영역의 변수 또는 메소드를 직접 접근할 수 X
		 * System.out.println(i); 메모리 영역이 다르기때문에 오류 발생
		 * call(); //인스턴스 변수니까 Heap공간에 생성. 메모리 생성 후 접근할 수 있음
		 */
		
		//인스턴스 영역의 변수 또는 메소드는 메모리를 생성한 후 접근해야한다.
		Test03 t03 = new Test03();
		System.out.println(t03.i); //직접 접근 불가능. 객체이름.변수이름으로 접근
	    t03.call();
	    System.out.println(Sub03.count);
	    
	    
	}

}
