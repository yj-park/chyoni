package kr.co.mlec.webserver;

public class HttpServletResponse {
	private StringBuffer msg = new StringBuffer();
	
	public void write(String data) {
		msg.append(data);
	}
	
	public String getMsg() {
		return msg.toString();
	}
}
