package network.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test02 {
	
	// 보이스피싱에서 이렇게 쓰는거야!헐~~~ 
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.daum.net");
			InputStream in =url.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			// 한글표시를 위해!
			BufferedReader br = new BufferedReader(isr);
			// 속도를 개선시키겠다
			// openStream의 반환타입 : InputStream
			while(true) {
				String line = br.readLine();
				if (line == null) break;
				// stream에서 줄단위로 읽어서 넘겨주겠다
				System.out.println(line);

				// int ch = isr.read();
				// if (ch == -1) break;
				// System.out.print((char)ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
