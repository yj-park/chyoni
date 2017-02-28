package day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		Date d = new Date(); 
		// 날짜 정보를 가지고 있는 객체에서 꺼내기위해 d.get~~()을 사용할 수 있지만 번거롭고 수정 어려움
		
		// 날짜 정보를 손쉽게 꺼낼 수 있음(패턴 문자를 가지고) / 문자열 ->날짜, 날짜 ->문자열
		// SimpleDateFormat sdf = new SimpleDateFormat(pattern);		
		/*
		 * 패턴문자
		 * y: 년도
		 * M: 월
		 * d: 일
		 * h: 12시간 / H: 24시간
		 * m: 분
		 * s: 초 
		 * 
		 * ex)2016-11-11 -> yyyy-MM-dd
		 * ex)11:50:23   -> hh:mm:ss
		 * ex)2016-11    -> yyyy-MM
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// format: 날짜정보에서 문자열 얻기, 반환타입:String
		String timeStr = sdf.format(new Date());
		System.out.println(timeStr);
		// parse: 문자열에서 날짜 객체 얻기
		try {
			Date date = sdf.parse("2015-01-01");
			System.out.println("변경된 날짜 정보 : " + date);
		} catch(ParseException pe) {
			System.out.println("날짜 파싱 중 오류 발생");
			pe.printStackTrace();
		}
	}

}
