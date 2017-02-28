<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jsp.Count"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    Count c = new Count();
	Map<String, String> map = new HashMap<>();
	c.setNum(100);
	
	pageContext.setAttribute("c", c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	프로젝트 경로명 : ${pageContext.request.contextPath}<br>
	c.num : ${c.num}<br>
	c["num"] : ${c["num"]}<br>
	<%-- c.val : ${c.val}<br> 
	오류 발생 PropertyNotFoundException. class에 존재하는 것만 사용 가능 --%>
	<%-- c.getNum()으로 해석됨, get메소드 호출 --%>
	<%-- ${pageContext(el내장객체).request.getContextPath} : pageContext.getRequest().getContextPath()로 해석 --%>
	<%-- 현재 프로젝트 경로명을 동적으로 주는 방법 (코드 수정없이 코드 실행 가능) --%>
</body>
</html>