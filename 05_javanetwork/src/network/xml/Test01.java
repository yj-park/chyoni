package network.xml;
// xml 데이터를 파싱하는 API 연습 (규칙에 의해 내가 원하는 정보만 추출)
/*
 * 1. Dom : 메모리에 올려두기 때문에 메소드 호출을 통해 재사용이 가능함. 속도가 느림. 보통 돔형식 사용. 돔파서 객체(document builder) 필수
 *          javascript의 돔형식과 유사함
 * 2. Sax : 이벤트 방식 처리기 때문에 한 번만 사용 가능. 속도가 빠름. 메모리에 부담이 적음. 데이터 양이 많은 경우 무조건 sax형식!
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test01 {
	public static void main(String[] args) {
		try {
			// 파서 객체를 가져오기 위한 팩토리 객체 얻기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			// xml 내용을 파싱할 파서 준비
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			// xml 형식의 데이터 파싱처리하기
			Document dom = builder.parse("src/network/xml/family.xml");
			NodeList list = dom.getElementsByTagName("family");
			
			int len = list.getLength();
			System.out.println("family의 수 : " + len);
			for(int i = 0; i < len; i++) {
				Node cNode =list.item(i);
				String cName = cNode.getNodeName();
				// 각각의 family 에 태그 접근
				System.out.println("cNode name : " + cName);
				
				NodeList chList = cNode.getChildNodes();
				int chLen = chList.getLength();
				System.out.println("family의 자식 수: " + chLen);
				for (int j = 0; j < chLen; j++) {
					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					if("#text".equals(chName)) continue;
					
					String value = chNode.getTextContent();
	
					System.out.println(chName +  ", "+ value);
				}		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
