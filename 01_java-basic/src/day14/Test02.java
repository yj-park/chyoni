package day14;

import java.util.Calendar;

public class Test02 {
	public static void main(String[] args) {
		// 추상클래스이기 때문에 객체를 생성할 수 없음
		// Calendar c = new Calendar();
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		// 출력: [클래스내 변수들 time: 현재 시간 정보/ Zoneinfo: 위치/ 년월일 정보(월 정보는 -1된 값이 반환됨(0~11). 따라서 출력할 땐 +1을 해줄 것/ DAT_OF_WEEK: 일요일-1,월요일-2,토요일-7/ 상수정보로 저장) ]
		
		// Calendar 클래스에서는 c.get()만을 통해서 매개변수(1:year, 2:month...누구나 통일해서 쓸 수 있도록)를 달리해 정보를 꺼낼 수 있다.
		
		// 정보 얻기
		// int year = c.get(1);
		int year = c.get(Calendar.YEAR);
		// int month = c.get(2)+1;
		// 해당하는 숫자값을 다 외울 수 없으니 Calendar클래스 안에 있는 상수 field값을 통해 찾을 수 있음
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(year);
		System.out.println(month);
		int date = c.get(Calendar.DATE);
		System.out.println(date);
		
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		String[] dayWords = {"일", "월", "화", "수", "목", "금", "토"};
		/*
		String dayWord = "";
		switch(dayOfWeek) {
		case 1: dayWord = "일요일"; break;
		case 2: dayWord = "월요일"; break;
		case 3: dayWord = "화요일"; break;
		case 4: dayWord = "수요일"; break;
		case 5: dayWord = "목요일"; break;
		case 6: dayWord = "금요일"; break;
		case 7: dayWord = "토요일"; break;
		}
		System.out.printf("오늘은 %s입니다.\n", dayWord);
		*/
		System.out.printf("오늘은 %s요일입니다.\n", dayWords[dayOfWeek-1]);
		
		
	}

}
