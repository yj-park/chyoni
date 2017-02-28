package org.springframework.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// 어떤 작업 Controller로 옮겨줄 지 결정 
public class URLHandlerMapping {
	private Map<String, CtrlAndMethod> mappings = new HashMap<> ();
	public URLHandlerMapping(String ctrlNames) throws Exception {
		/*
		ctrlNames에 이 값이 넘어가
		kr.co.mlec.board.controller.BoardController;
		kr.co.mlec.login.controller.LoginController;
		kr.co.mlec.main.controller.MainController;
		 */
		
		// ;을 기준으로 한 문장씩 분리하기
		String[] arr = ctrlNames.split(";");
		for (String ctrlInfo : arr) {
			/*
			 * 바뀌기 전 설명~
			// xml파일을 그대로 가져오기 때문에 꼭 공백을 제거해줘야해!
			// System.out.println(ctrlInfo.trim());
			// 이제 잘라줘야할 값이 없어~
			// String[] ctrlArr = ctrlInfo.trim().split("=");
			// url
			// System.out.println(ctrlArr[0]);
			// 문자열로 이루어진 클래스로 만들어줘야할 객체 정보
			// System.out.println(ctrlArr[1]);
			// 이름에 해당하는 클래스의 정보를 얻어올 수 있음
			// 예외 처리 필수(dispatcher로 넘겨)
			// Class<?> clz = Class.forName(ctrlArr[1]);
			// 클래스 객체를 얻었으므로 이 정보를 직접 활용해
			// controller 인터페이스로 형변환 시켜주자
			*/
			
			Class<?> clz = Class.forName(ctrlInfo.trim());
			// 메소드와 연결하여 실행할 객체를 얻어오기
			Object target = clz.newInstance();

			Method[] mArr = clz.getDeclaredMethods();
			for (Method m : mArr) {
				RequestMapping rm = m.getAnnotation(RequestMapping.class);
				if (rm == null) continue;
				
				mappings.put(rm.value(), new CtrlAndMethod(target, m));
			}
		}
	}
	
	// url에 해당하는 controller를 반환
	public CtrlAndMethod getCtrlAndMethod(String url) {
		return mappings.get(url);
	}
}
