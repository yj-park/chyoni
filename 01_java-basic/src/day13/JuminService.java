package day13;

public class JuminService {
	// throws 호출하는 쪽에서 처리해줘
	public boolean valid(String juminNo) throws JuminNumberException {
		
		// 유효하지 않은 주민번호일 경우 예외를 발생시킨다.
		juminNo = juminNo.replace("-", "");
		if (juminNo.length() != 13) {
			throw new JuminNumberException("주민번호는 13자리입니다.("+ juminNo +")");
		}
		
		for (int i = 0; i < juminNo.length(); i++) {
			char c = juminNo.charAt(i); //한 글자씩 꺼내오기
			if (c < '0' || c > '9') {
				throw new JuminNumberException("주민번호는 숫자로 이루어집니다.(" + juminNo + ")");				
			}
		}
		
		return true;
	}

}
