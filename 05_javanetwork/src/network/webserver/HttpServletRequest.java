package network.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	// 생성자에서 받아온 변수는 항상 멤버변수로 선언할 것!
	private InputStream in;
	private String method;   // GET or POST (사용자가 서버에 요청한 데이터 처리 방식)
	private String requestUri; // 사용자가 요청한 URI(파라미터 제외)
	private String queryString; // URI에서 ? 다음의 모든 파라미터 문자열 
	private Map<String, String> paramMap;
	
	
	public HttpServletRequest(InputStream in) throws Exception {
		this.in = in;
		init();
	}
	
	private void init() throws Exception {
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String startLine = br.readLine();
		if (startLine == null) return;
		
		String[] data = startLine.split(" ");
		method = data[0];  // 요청 메소드 설정
		
		
		String[] uri = data[1].split("\\?"); 
		requestUri = uri[0];
		
		if (uri.length == 2) {
			queryString = uri[1];
			setParamMap();
		}
		
		// POST 방식 처리하기
		// 파라미터가 시작라인이 아닌 바디에 넘어오기 때문에 헤더 정보를 읽고난 후
		// 바디에 있는 데이터를 꺼낸다.
		
		// 헤더 데이터 읽기
		while (true) {
			String line = br.readLine();
			if (line.equals("")) break;
		}
		
		// POST 방식일 경우에만 바디 내용을 읽는다.
		if ("POST".equals(method)) {
			String bodyParam = "";
			// 읽어온 데이터의 크기
			int ch = 0;
			// while(true)로 읽으면 block에 빠짐
			// br.ready() 방법은 버그 형태로 준비가 되면 읽으라는 뜻으로 block에 빠지는 것을 방지한다.
			while (br.ready()) {
				ch = br.read();
				bodyParam += (char)ch;
			}
			// bodyParam의 값은 처음에 0이니까 정보를 읽었다면 0보다 크겠지
			// POST 방식의 경우 파라미터 값이 바디에 담기니까 그 정보를 맵에 담아 파싱하자
			if (bodyParam.length() > 0) {
				queryString = bodyParam;
				setParamMap();
			}
			// POST방식은 form태그를 통해서만 불러낼 수 있어 (ex : <form method="post">) 
			// GET방식처럼 URL에 우리가 주소를 찍어서 확인할 수 X
		}
		
		
 	}
	
	// GET이나 POST방식 모두 파싱해서 map에 담아야하기때문에 공통부분이라서 메소드로 따로 만듦!
	private void setParamMap() throws Exception {
		paramMap = new HashMap<>();
		String[] params = queryString.split("&");
		for (String param : params) {
			String[] pArr = param.split("=");
			paramMap.put(pArr[0], URLDecoder.decode(pArr[1], "utf-8"));
		}
	}
	
 	public String getMethod() {
		return method;
	}
	
	public String getRequestUri() {
		return requestUri;
	}
	
	public String getQueryString() {
		return queryString;
	}
	
	public String getParameter(String key) {
		return paramMap == null ? null : paramMap.get(key);
	} 
	// 파라미터의 값이 key&value 쌍으로 이루어져있기 때문에 map에 담아두면 좋음!
	// map에서 key에 해당하는 값을 꺼내겠다
	// map이 생성이 안되는 경우 有 -> null , key값이 없는 경우 -> null
	
	

}
