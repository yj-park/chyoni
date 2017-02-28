package org.springframework.mvc;

import java.util.HashMap;
import java.util.Map;

import kr.co.mlec.board.controller.CommentDeleteController;
import kr.co.mlec.board.controller.CommentListController;
import kr.co.mlec.board.controller.CommentRegistController;
import kr.co.mlec.board.controller.CommentUpdateController;
import kr.co.mlec.board.controller.DeleteController;
import kr.co.mlec.board.controller.DetailController;
import kr.co.mlec.board.controller.ListController;
import kr.co.mlec.board.controller.UpdateController;
import kr.co.mlec.board.controller.UpdateFormController;
import kr.co.mlec.board.controller.WriteController;
import kr.co.mlec.board.controller.WriteFormController;
import kr.co.mlec.login.controller.LoginController;
import kr.co.mlec.login.controller.LoginFormController;
import kr.co.mlec.login.controller.LogoutController;
import kr.co.mlec.main.controller.MainController;

public class URLHandlerMapping {
	private Map<String, Controller> mappings = new HashMap<>();
	public URLHandlerMapping(String ctrlNames) throws Exception {
		
		String[] arr = ctrlNames.split(";"); 
		for (String ctrlInfo : arr) {
			String[] ctrlArr = ctrlInfo.trim().split("=");
			Class<?> clz = Class.forName(ctrlArr[1]);
			mappings.put(ctrlArr[0], (Controller)clz.newInstance());
		}
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}













