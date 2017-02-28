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
	<c:set var="msg" value="test" />
	<c:set var="msg" value="<h1>test</h1>" />
	
	<%-- 공유 영역 접근은 el 사용, 보안 목적으로 사용. 태그의 실행을 막아줌 --%>
	msg (out 태그) : <c:out value="${msg}" /><br>

	<%-- false를 주게되면 태그가 있을지도 모르지만 그냥 실행해 --%>
	msg (out 태그 escape) : <c:out value="${msg}" escapeXml="false"/><br>
	
	msg (el) : ${msg}<br>
	<%-- 값이 존재하지 않을 때 기본적으로 실행할 값 입력가능 --%>
	msg2 : <c:out value="${msg2}" default="msg2 없음"/><br>
	
	
</body>
</html>