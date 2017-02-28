package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test05 {
	private static void a() throws FileNotFoundException {
		FileReader fr = new FileReader("a.txt");
	}
	private static void b() throws ArithmeticException {
		System.out.println(1 / 0);
		// ArithmeticException은 RuntimeException이기 때문에
		// 실행 시 예외 발생을 알 수 있다.
	}

	public static void main(String[] args) {
		// a()를 부른 쪽에서 예외처리를 해줌
		try {
		a();
		b();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
	}
	}


}
