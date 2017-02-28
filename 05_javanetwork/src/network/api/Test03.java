package network.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class Test03 {
	public static void main(String[] args) {
		// 어떤 정보를 요구하는지 알려줄 parameter가 필요함
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter = "?apikey=91e1456c006a3e2107b81e67b283f2ad&q=java&result=3&output=json";
		
		String apiUrl = requestUrl + parameter;
		System.out.println(apiUrl);
		
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);  // 한글 깨짐 방지
			BufferedReader br = new BufferedReader(isr);        // 한 줄씩 읽고 싶어
			String json = "";
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				json += line;
			}
			System.out.println(json);
			
			Gson gson = new Gson();
			BlogJsonVO jsonVO = gson.fromJson(json, BlogJsonVO.class);
			
			// 꺼내오기
			List<BlogJsonItemVO> item = jsonVO.getChannel().getItem();
			System.out.println("=========================================");
			System.out.println("다음 블로그 정보");
			for (BlogJsonItemVO blogVO : item) {
				System.out.println("=========================================");
				System.out.println(blogVO.getTitle());
				System.out.println(blogVO.getLink());
			}
			System.out.println("=========================================");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
