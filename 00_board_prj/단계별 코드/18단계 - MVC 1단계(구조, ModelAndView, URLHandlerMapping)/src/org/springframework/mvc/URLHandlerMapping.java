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
	public URLHandlerMapping() {
		mappings.put("/board/list.do", new ListController());
		mappings.put("/board/detail.do", new DetailController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/update.do", new UpdateController());
		mappings.put("/board/writeForm.do", new WriteFormController());
		mappings.put("/board/write.do", new WriteController());
		mappings.put("/board/delete.do", new DeleteController());
		mappings.put("/board/commentRegist.do", new CommentRegistController());
		mappings.put("/board/commentDelete.do", new CommentDeleteController());
		mappings.put("/board/commentUpdate.do", new CommentUpdateController());
		mappings.put("/board/commentList.do", new CommentListController());
		mappings.put("/login/login.do", new LoginController());
		mappings.put("/login/loginForm.do", new LoginFormController());
		mappings.put("/login/logout.do", new LogoutController());
		mappings.put("/main/main.do", new MainController());
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}













