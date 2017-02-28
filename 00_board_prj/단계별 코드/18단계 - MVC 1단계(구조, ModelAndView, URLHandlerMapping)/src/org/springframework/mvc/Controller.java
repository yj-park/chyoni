package org.springframework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
