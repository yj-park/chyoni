package day16;

import java.io.File;

public class Test01 {
	public static void main(String[] args) {
		File f = new File("data/mya/aa/bb"); 
		// 파일 클래스는 무조건 매개변수 필요 (디렉토리, 확장자를 가진 파일) 
		// 없는 파일의 이름을 써도 오류 발생 X. 없으면 없다고 나옴 (ex.new File("data1");
		boolean bool = f.exists();
		// 파일의 데이터라는 객체의 존재여부를 물어보는 메소드
		if (bool) {
			System.out.println("존재하는 경로임");
			// 파일의 객체는 디렉토리 or 확장자를 가진 파일이기때문에 확인 할 수 있음
			if( f.isDirectory()) { 
				System.out.println("디렉토리임");
			} else if (f.isFile()){
				System.out.println("파일임");
			}
		} else {
			System.out.println("존재하지 않는 경로임");
			// 존재하지 않는 경로일 경우 생성하겠다.
			// if (f.makdir())
			if (f.mkdirs()) {
				System.out.println("디렉토리 생성 성공");
			} else {
				System.out.println("디렉토리 생성 실패");
			}
			// 이클립스는 실시간이 아니기 때문에 F5번을 누르면 생성된 데이터를 확인할 수 있다.
			// mkdir은 마지막에 있는 것만 만들 수 있음.
			// 여러개를 생성하고 싶을 때는 f.mkdirs()사용
		}
		
		
	}

}
