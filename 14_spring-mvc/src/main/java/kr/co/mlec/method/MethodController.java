package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
	
	// component-scan에 의해서 bean 등록
	// controller에 선언된 값은 공통으로 사용 가능
	@Controller
	@RequestMapping(value = "/method/method.do")
	public class MethodController {
		// 동일한 url에 대해서 get과 post로 방식 구분 가능
		@RequestMapping(method = RequestMethod.GET)
		public String callGet() {
			// 반환타입이 문자열이라면 뷰 페이지 정보를 나타냄
			return "method/methodForm";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String callPost() {
			return "method/methodProcess";
		}
		
	}
