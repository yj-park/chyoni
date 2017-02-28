<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%-- 참고용으로 알아두기 (페이지 이동)  
	자바의 forward, sendRedirect와 같다 --%>
	<%
	//response.sendRedirect("http://www.naver.com");
	%>
	<c:redirect url="http://www.naver.com"/>	
</body>
</html>