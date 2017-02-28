<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h2>쿠키 정보</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			String name = c.getName(); 
			String value = URLDecoder.decode(c.getValue(), "utf-8"); 
	%>
			<h3>이름 : <%= name %>, 값 : <%= value %></h3>
	<% 
		}
	}
	%>
	
	
	<h2>쿠키 설정</h2>
	<form action="test01">
		이름 : <input type="text" name="name" /><br>
		값 : <input type="text" name="value" /><br>
		<input type="submit" value="쿠키 설정" />
	</form>
</body>
</html>