<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%--
	type : A 관리자
	type : U 일반사용자
	type : A와 U가 아닌 모든 값은 잘못된 값
	 --%>
	<c:set var="type" value="A"	/>
	<c:choose>
		<c:when test="${type eq 'A'}">
			<h2>관리자 계정입니다.</h2>
		</c:when>
		<c:when test="${type eq 'U'}">
			<h2>일반 사용자 계정입니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>잘못된 사용자 입니다.</h2>
		</c:otherwise>
	</c:choose>
    <%-- myBatis에 동일한 것 있음 다시 공부하기! --%>	
</body>
</html>