package org.springframework.mvc;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import javax.servlet.http.HttpServletRequest;

// 메소드의 파라미터 정보 꺼내고, 꺼낸 파라미터의 타입과 이름을 얻어내서 request.getParameter()한 후 그에 해당하는 값을 배열로 묶어서 그 값을 넘겨주는 역할
// 메소드 & request 객체 필수템!
public class PreParameterProcess {
	public Object[] process(Method method, HttpServletRequest request) throws Exception {
		// 메소드에서 파라미터 정보를 추출하자
		// ex) update(int no, String title) -> pArr에는 두 가지의 정보 
		Parameter[] pArr = method.getParameters();
		
		
		int index = 0;
		// 파라미터 배열의 길이와 같아야한다
		// rArr 우리가 쓸 정보
		Object[] rArr = new Object[pArr.length];
		
		for (Parameter p : pArr) {
			// Parameter p가 int no인 경우
			
			// Class<?> pType => int
			Class<?> pType = p.getType();
			// 패키지를 제외한 타입 이름 가져오기
			// tName -> int
			String tName = pType.getSimpleName();
			System.out.println(tName);
			
			// @RequestParam(value="no") int no
			// 파라미터 이름 : no
			String name = p.getName();
			
			// 어노테이션이 있는지 확인하고 있으면 이름 바꿔줄게~
			RequestParam rp = p.getAnnotation(RequestParam.class);
			if (rp != null) name = rp.value();
			
			// 사용자에게 넘겨줘야할 값
			switch (tName) {
			case "int":
				rArr[index++] = Integer.parseInt(request.getParameter(name));
				break;
			case "HttpServletRequest":
				rArr[index++] = request;
				break;
			// 사용자가 만든 VO니까 default로~
			default:
				rArr[index++] = WebUtil.getParamToVO(request, pType);
			}
		}
		return rArr;
	}
	
}
