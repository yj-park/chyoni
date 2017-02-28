package day14;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		// 1번
		Date d = new Date();
		System.out.println(d);
		
		// Scanner가 File을 읽어들일때
		File f = new File("data/a.txt");
		// 이 파일의 마지막 수정시간 정보를 출력할 수 있음
		long time = f.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat();
		// 2번
		Date d2 = new Date(time);
		System.out.println(d2);
		
		int year = d.getYear() + 1900; // deprecated되었기때문에 자동으로 표시해줌
		System.out.println(year);
		
		
		// 3번
		// long값 형태의 시간정보를 출력할 때 사용
		long currTime = d.getTime();
		d2.setTime(currTime);
		// d가 가진 시간정보를 d2에 저장
		
		System.out.println(d);
		System.out.println(d2);
	}

}
