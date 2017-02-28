<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("msg", "pageContext msg");
	request.setAttribute("msg", "request msg");

%>
<!-- 접근 범위의 차이에 따라 4가지 공유영역 나뉘어짐
     pageContext : 나만 쓸래(private)
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	msg : ${msg}<br>
	request msg : ${requestScope.msg}<br>
	
</body>
</html>