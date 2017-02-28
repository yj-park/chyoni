package org.springframework.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class URLHandlerMapping {
	private Map<String, CtrlAndMethod> mappings = new HashMap<>();
	public URLHandlerMapping(String ctrlNames) throws Exception {
		/*
		kr.co.mlec.board.controller.BoardController;
  		kr.co.mlec.login.controlleller.LoginContror;
		kr.co.mlec.main.controller.MainController	
		 */
		String[] arr = ctrlNames.split(";"); 
		for (String ctrlInfo : arr) {
			// kr.co.mlec.board.controller.BoardController
			Class<?> clz = Class.forName(ctrlInfo.trim());
			
			Object target = clz.newInstance();
			Method[] mArr = clz.getDeclaredMethods();
			for (Method m : mArr) {
				RequestMapping rm = m.getAnnotation(RequestMapping.class);
				if (rm == null) continue;
				
				mappings.put(rm.value(), new CtrlAndMethod(target, m));
			}
		}
	}
	
	public CtrlAndMethod getCtrlAndMethod(String url) {
		return mappings.get(url);
	}
}













