<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h1>one.jsp 페이지 포함하기</h1>
	<hr>
	<%-- 소스코드를 가져와 합치는 방식 사용
	       변수를 같이 사용할 수 있다.
	       파라미터는 넘길 수 없다. --%>
	<%@ include file="one.jsp" %>
	<hr>
	<%= s %>
	
	<%@ include file = "bottom.jsp" %>
	<hr>
</body>
</html>