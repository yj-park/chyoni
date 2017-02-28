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
	<h1>메인 페이지!!!!!</h1>
	<%-- jsp가 아닌 servlet으로 이동하게 바꿔야돼 --%>
	<c:choose>
		<%-- user가 없으면 loginForm으로 이동 --%>
		<c:when test="${empty user}">
			<h2><a href="loginForm.jsp">로그인</a></h2>
		</c:when>
		<c:otherwise>
			<%-- 로그아웃하고나면 세션 삭제 & 다시 메인 화면 ㄱㄱ --%>
			<h2><a href="logout">로그아웃</a></h2>
		</c:otherwise>
	</c:choose>
</body>
</html>