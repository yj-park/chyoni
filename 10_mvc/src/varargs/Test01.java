package varargs;

public class Test01 {
	
	/*
	public static void call() {
		System.out.println("call1");
	}
	
	public static void call(int i) {
		System.out.println("call2");
	}
	
	public static void call(int i, int j) {
		System.out.println("call3");
	}
	
	public static void call(int i, int j, int k) {
		System.out.println("call4");
	}
	
	public static void call(int[] arr) {
		System.out.println("call5");
	}
	*/
	
	public static void main(String[] args) {
		call();
		call(1);
		call(2, 3);
		call(4, 5, 6);
		call(new int[] {1});
		// 다수의 메소드를 불러야 하는 경우 정수형 배열 사용 가능 -> 매개변수를 {}형태로 줘야하는 불편함 
	}
	
	// (매개변수가 몇 개가 필요한 지 모를 때)동일한 데이터 타입을 가변적으로 처리할 수 있는 기법 -> variable arguments
	public static void call(int...arr) {
		System.out.println("call5");
	}
	
	/*
	public Object invoke(Object obj, Object...arr) {
		return null;
	}
	매개변수가 하나만 와도 여러개가 와도 처리할 수 있게
	*/
	
}
