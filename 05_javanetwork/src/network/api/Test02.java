package network.api;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import network.xml.FamilyVO;

public class Test02 {
	public static void main(String[] args) {
		// 어떤 정보를 요구하는지 알려줄 parameter가 필요함
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter = "?apikey=91e1456c006a3e2107b81e67b283f2ad&q=java&result=3&output=xml";
		
		String apiUrl = requestUrl + parameter;
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			
			// Dom Parser에게 입력 스트림 처리를 넘기기
			
			// 파서 객체를 가져오기 위한 팩토리 객체 얻기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			// 내용을 파싱할 파서 준비
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			
			// input stream에 넘어오는 내용을 파싱해라
			Document dom = builder.parse(in);
			
			NodeList list = dom.getElementsByTagName("item");
			
			int len = list.getLength();
			
			List<ItemVO> items = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				ItemVO item = new ItemVO();
				Node cNode =list.item(i);
				NodeList chList = cNode.getChildNodes();
				int chLen = chList.getLength();
				
				for (int j = 0; j < chLen; j++) {
					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					if("#text".equals(chName)) continue;
					
					String value = chNode.getTextContent();
					switch(chName) {
					case "title" : item.setTitle(value); break;
					case "description" : item.setDescription(value); break;
					case "link" : item.setLink(value); break;
					case "author" : item.setAuthor(value); break;
					case "comment" : item.setComment(value); break;
					case "pubDate" : item.setPubDate(value); break;
					}
				}
				items.add(item);
			}	
			System.out.println("-------------------------------------");	
			System.out.println("블로그 검색 결과");
			System.out.println("-------------------------------------");	
			for (ItemVO it : items) {
				System.out.printf(
						"%s   %s   %s   %s   %s   %s\n",
						it.getTitle(), it.getDescription(), it.getLink(),
						it.getAuthor(), it.getComment(), it.getPubDate());
			}
			System.out.println("-------------------------------------");	
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
