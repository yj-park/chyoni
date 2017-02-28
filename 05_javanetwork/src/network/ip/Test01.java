package network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) {
		try {
			// 현재 실행중인 컴퓨터의 주소 정보를 조회할 때 사용
			InetAddress local = InetAddress.getLocalHost();
			// IO와 마찬가지로 무조건 예외가 발생하기 때문에 예외처리 필수
			System.out.println(local.getHostName());
			// 컴퓨터 이름 반환
			System.out.println(local.getHostAddress());
			// . . 으로 구분된 IP주소 반환
			
			// 특정 사이트의 아이피 주소를 조회할 때 사용
			// http로 시작하면 안됨!
			InetAddress bit = InetAddress.getByName("www.bitjobedu.co.kr");
			System.out.println(bit.getHostName());
			System.out.println(bit.getHostAddress());
			// web 브라우저에서의 기본 설정 포트 번호는 80임. 따라서 웹에서는 별도로 포트 번호를 지정해주지 않아도(52.79.123.237:80) 접속 가능
			// 기본적으로 모든 사이트는 80이 열려있음 but 특정한 사이트의 경우에는 포트 80을 막아두기도함
			
			// 특정 사이트의 모든 아이피 주소 조회 시 사용
			// 규모가 큰 사이트의 경우 여러개의 아이피 사용
			InetAddress[] naverIp = InetAddress.getAllByName("www.naver.com");
			for (InetAddress naver : naverIp) {
				System.out.println(naver.getHostName() + ", ");
				System.out.println(naver.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
