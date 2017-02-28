package network.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		// 어떤 정보를 요구하는지 알려줄 parameter가 필요함
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter = "?apikey=91e1456c006a3e2107b81e67b283f2ad&q=java&result=3&output=xml";
		//String parameter = "?apikey=91e1456c006a3e2107b81e67b283f2ad&q=java&result=3&output=json";
		
		String apiUrl = requestUrl + parameter;
		//System.out.println(apiUrl);
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
