package day16;

import java.io.FileReader;
import java.io.FileWriter;

public class Test07 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("data/a.txt");
		    fw = new FileWriter("data/acopy.txt");
		    
		    while(true) {
		    	int ch = fr.read();
		    	if (ch == -1) break;
		    	fw.write(ch);
		    }
		    System.out.println("파일 복사 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
			try {
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (fw != null) {
				try {
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
     }
	}
}
