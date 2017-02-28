package org.springframework.mvc;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	// controller가 작업한 내용을 담을 페이지 정보 view
	// model은 데이터 공유
	private String view;
	private Map<String, Object> model = new HashMap<>();

	public ModelAndView() {}
	
	public ModelAndView(String view) {
		this.view = view;
	}
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public void addAttribute(String key, Object value) {
		// 만들어둔 model 맵에 넣어주자
		model.put(key, value);
	}
}
