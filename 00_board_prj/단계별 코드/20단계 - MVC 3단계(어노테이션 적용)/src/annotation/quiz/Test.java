package annotation.quiz;

import java.lang.reflect.Method;
import java.util.Scanner;

/*
경로 : /board/write
-- BoardController.write 메서드 실행시킨다.

url : /board/write
경로 : /board/list
url : /board/list
경로 : quit
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class<?> clz = BoardController.class;
			Object obj = clz.newInstance();
			Method[] arr = clz.getDeclaredMethods();
			while (true) {
				System.out.print("경로 : ");
				String url = sc.nextLine();
				if (url.equals("quit")) break;
				
				for (Method m : arr) {
					RequestMapping rm = m.getAnnotation(RequestMapping.class);
					if (rm == null) continue;
					
					String val = rm.value();
					if (url.equals(val)) {
						m.invoke(obj);
					}
				}
				System.out.println("url : " + url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











