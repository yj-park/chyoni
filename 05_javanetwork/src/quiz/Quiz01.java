package quiz;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Quiz01 {
	/*
	 * 출력형식 >
	 * 도메인 주소를 입력하세요 : http://www.naver.com
	 * 도메인 주소는 www로 시작해야합니다.
	 * 
	 * 도메인 주소를 입력하세요 : www.naver.com
	 * www.naver.com에서 사용하는 주소정보
	 * -----------------------------------------
	 * 220.189.20.111
	 * 220.189.20.64
	 * -----------------------------------------
	 * 
	 * 도메인 주소를 입력하세요 : www.aidfjeijf.com
	 * 존재하지 않는 도메인 주소입니다.
	 * 
	 * 도메인 주소를 입력하세요 : quit
	 * 프로그램을 종료합니다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("도메인 주소를 입력하세요 : ");
			try {
				String s = sc.nextLine();
				if (s.startsWith("www") ) {
					InetAddress[] ip = InetAddress.getAllByName(s);
					
					System.out.println(s + "에서 사용하는 주소정보");
					System.out.println("---------------------------");
					for (InetAddress ipAddr : ip) {
						System.out.println(ipAddr.getHostAddress());
					}
					System.out.println("---------------------------");
				} else if(s.equals("quit")) {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				else {
					System.out.println("도메인 주소는 www로 시작해야합니다.");
				}
			} catch (UnknownHostException e) {
				System.out.println("존재하지 않는 도메인 주소입니다.");
			}
		}
	}
	

}
