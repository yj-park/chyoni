package annotation.quiz;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 8번 try, catch문 만들기
		try {
			// 1번 클래스 불러오기
			Class<?> clz = BoardController.class;
			// 7번 비교하기위해서 새로운 인스턴스 객체 만들기
			Object obj = clz.newInstance();
			
			// 2번 메소드 가져오기
			Method[] mArr = clz.getDeclaredMethods();
			
			while (true) {
				System.out.print("경로 : ");
				String url = sc.nextLine();
				if (url.equals("quit")) break;
				// 3번 
				for (Method m : mArr) {		
					RequestMapping anno = m.getAnnotation(RequestMapping.class);
					// 4번 없을 수도 있으니 처리해주기!
					if (anno == null) continue;
					// 5번 value값 가져오기
					String val = anno.value();
					// 6번 사용자 입력값과 value값 비교
					if (url.equals(val)) {
						m.invoke(obj);
					}
				}
					System.out.println("url : " + url);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 사용자가 입력한 url과 BoardController 객체의 RequestMapping 어노테이션의 value 속성 값과 맵핑시켜줘야해 
		 */
		}
	}

