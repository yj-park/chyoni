package kr.co.mlec.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import kr.co.mlec.form.MemberVO;

// 클래스명이 같은 경우 bean의 이름도 똑같이 등록되기 때문에 이렇게 이름을 따로 설정해주는 것이 좋다! 
@RestController("kr.co.mlec.rest.RestBodyController")
@RequestMapping("/rest")
public class RestBodyController {
	@RequestMapping("/resBody.do")
	// 페이지 이동이 아닌 servlet처럼 브라우저로 직접 결과 문자열 값을 전송. ajax처럼 비동기방식(?)
	public String resStringBody() {
		return "OK, 성공";
	}

	@RequestMapping("/resBody.json")
	// Map객체를 (json 형태의) 문자열로 변환하여 전송하겠다!
	public Map<String, String> resJsonBody() {
		Map<String, String> result = new HashMap<>();
		result.put("id", "sbc");
		result.put("name", "hong");
		result.put("addr", "서울");
		return result;
	}

	@RequestMapping("/resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("sbc");
		vo.setName("sbc");
		vo.setPassword("1234");
		return vo;
	}

	@RequestMapping("/resStringListBody.json")
	public List<String> resJsonStringListBody() {
		List<String> list = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}

	@RequestMapping("/resVOListBody.json")
	public List<MemberVO> resJsonVOListBody() {
		List<MemberVO> list = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("sbc");
			vo.setName("sbc");
			vo.setPassword("1234");
			list.add(vo);
		}
		return list;
	}
}
