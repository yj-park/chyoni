package org.springframework.mvc;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class WebUtil {
	public static Object getParamToVO(MultipartRequest request, Class<?> clz) throws Exception {
		
		Object obj = clz.newInstance();
		
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			String mName = m.getName();
			if (!mName.startsWith("set")) continue;
			
			// setNo
			// setTitle
			// setWriter
			// setContent
			// setRegDate
			mName = mName.substring("set".length());
			
			// No, Title, Writer, Content, RegDate
			mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1);
			
			// no, title, writer, content, regDate
			String pValue = request.getParameter(mName);
			// set 메서드 이름에 해당하는 파라미터가 없을 경우
			if (pValue == null) continue;
			
			// set 메서드의 파라미터 타입을 조회해서 int 인 경우 파라미터의 값을 int로 변환
			String pTypeName = m.getParameterTypes()[0].getName();
			// pTypeName 이 int 라면 int로 변환 후 set 메서드 실행
			switch (pTypeName) {
			case "int":
				m.invoke(obj, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(obj, pValue);
				break;
			}
		}
		return obj;
	}
	public static Object getParamToVO(HttpServletRequest request, Class<?> clz) throws Exception {
		
		Object obj = clz.newInstance();
		
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			String mName = m.getName();
			if (!mName.startsWith("set")) continue;
			
			// setNo
			// setTitle
			// setWriter
			// setContent
			// setRegDate
			mName = mName.substring("set".length());
			
			// No, Title, Writer, Content, RegDate
			mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1);
			
			// no, title, writer, content, regDate
			String pValue = request.getParameter(mName);
			// set 메서드 이름에 해당하는 파라미터가 없을 경우
			if (pValue == null) continue;
			
			// set 메서드의 파라미터 타입을 조회해서 int 인 경우 파라미터의 값을 int로 변환
			String pTypeName = m.getParameterTypes()[0].getName();
			// pTypeName 이 int 라면 int로 변환 후 set 메서드 실행
			switch (pTypeName) {
			case "int":
				m.invoke(obj, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(obj, pValue);
				break;
			}
		}
		return obj;
	}
}


















