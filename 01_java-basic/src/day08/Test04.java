package day08;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * cwd(current working directory)
		 * 프로젝트부터 찾기 시작하므로 그 바로 밑에 파일이 있어야함
		 * 
		 */
		File f = new File("data/day08/test04.txt"); //특정한 파일 경로를 인식시키기 위해 쓰는 문장이므로 정확한 위치 필요
		Scanner sc = new Scanner(f);  // 파일이 없을 경우 스캔할 수 없는 상황(=오류)이 발생할 있으므로 대비할 것을 미리 경고해줌
		// 한 줄 읽기 System.out.println(sc.nextLine()); 
		// 두 줄 읽기System.out.println(sc.nextLine()); 
	    // 전체 파일을 읽고 싶은 경우? 파일의 총 길이를 모르니까 정할 수 없어
	    // scanner에 읽을 문장이 있는지 파악할 수 있는 메소드가 있음
	    while (sc.hasNextLine()){   // 내용이 있는지 확인 후 읽고 체크포인트가 그 다음 줄로 저절로 이동 false가 나올때까지 반복
            System.out.println(sc.nextLine());
	    }
	
	}

}
