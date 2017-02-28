package day14;

import java.util.Calendar;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		// Calendar -> Date 객체 얻기
		Date d = c.getTime();
		
		// Date의 시간정보를 이용해서 Calendar 시간 설정
		c.setTime(d);
		
		long time = d.getTime();
		c.setTimeInMillis(time);
		
		/*
		// 마지막날짜
		int val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		
		// 2월 
		c.set(Calendar.MONTH, 1);
		val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		
		//11월
		c.set(Calendar.MONTH, 10);
		val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		*/
		
		
		
		// 날짜 정보 변경
		// c.set(field, value); - 하나의 정보만 바꾸고 싶은 경우 필드 지정 & 값 지정
		c.set(2014, 1, 10); // 2014.02.10
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		// 출력시에 + 1 
		int date = c.get(Calendar.DATE);
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		
		// c.set(2014, 1, 1); 2014.02.01
		c.set(Calendar.DAY_OF_MONTH, 1); //2014.02.01
		int month2 = c.get(Calendar.MONTH) + 1;
		System.out.println(month2);
		int date2 = c.get(Calendar.DATE);
		System.out.println(date2);
		
		// 이전 or 다음 정보 변경
		c.add(Calendar.MONTH, 1); //현재 Calendar의 월을 1개월만큼 증가시켜라
		c.add(Calendar.MONTH, -1); //현재 Calendar의 월을 1개월만큼 감소시켜라
		
		
		
	}

}
