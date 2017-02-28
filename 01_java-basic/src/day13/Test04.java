package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test04 {
	public static void main(String[] args) {		
		try {
			System.out.println(1);
			FileReader fr = new FileReader("a.txt");
			fr.read();
			System.out.println(2);
		}
		// 예외가 없으면 catch문을 수행하지 않음!
		catch(Exception ex) {
			System.out.println(3);
			// return; -> 1, 3, 4출력
			// System.exit(0); - 1, 3출력
		}
		// finally는 무!조!건! 수행
		// finally는 return보다 우선 but exit(0)은 최강
		finally {
			System.out.println(4);
		}
		System.out.println(5);
	}

}
