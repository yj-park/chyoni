package org.springframework.mvc;

import java.lang.reflect.Method;

/*
 *  사용자가 요청하는 URL에 대한 연관된 컨트롤러 객체와 메서드 정보를 표현 
 */
public class CtrlAndMethod {
	private Object target;
	private Method method;
	
	public CtrlAndMethod(Object target, Method method) {
		this.target = target;
		this.method = method;
	}
	
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
}
