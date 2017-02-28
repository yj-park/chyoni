package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test06 {
	public static void main(String[] args) {
		try {
			a();
		} catch (Exception e) {
			System.out.println("점장 예외 총괄 처리");
		}
	}
	
	private static void a() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("a.txt");	
		} catch (FileNotFoundException f) {
			System.out.println("알바 자체 원인 처리");
			// 예외의 강제 발생
			throw f;
			// 직접 처리(try,catch) & 간접 처리(throws) 둘 다 가능
		}
	} 


}
