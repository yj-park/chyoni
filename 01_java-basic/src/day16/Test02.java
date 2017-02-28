package day16;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		File f = new File("data");
		//files객체를 배열로 줌 (list면 문자열)
		File[] fList = f.listFiles();
		for (File sub : fList) {
			/*
			String type = "";
			 
			if (sub.isDirectory()) {
				type = "D";
			} else if (sub.isFile()) {
				type = "F";
			}
			System.out.println(type + ":" + sub.getName());
			*/
			
			// 삼항연산자
			//String type = sub.isDirectory() ? "D" : "F";
			
			System.out.printf("%s:%s\n",sub.isDirectory()? "D" : "F", sub.getName());
		}
		
		
		
		/*
		// File path 밑에 있는 디렉토리와 파일 이름을 출력(상위 폴더만 출력)
		String[] list = f.list();
		for (String name : list) {
			File temp = new File("data/" + name);
			// 문자열을 data라는 폴더 밑의 파일로 만들어줌
			String type = "";
			if (temp.isDirectory()) {
				type = "D";
			} else if (temp.isFile()) {
				type = "F";
			}
			System.out.println(type + ":" + name);
		}
		*/
	}

}
