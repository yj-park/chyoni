package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller는 절대 빠지면 안돼!
@Controller
public class HelloController {
	@RequestMapping("/hello/hello.do") 
	public ModelAndView hello() { 
		ModelAndView mav = new ModelAndView("hello/hello");
		// 공유영역에 request로 msg란 이름으로 데이터 공유
		mav.addObject("msg", "hi 스프링 MVC~~"); 
		
		return mav; 
	} 
}
