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
	<h2>로그인</h2>
	<hr>
	<div>
	<%-- 공유영역에 msg가 있다면 출력 없으면 X --%>
		<c:out value="${msg}" />
	</div>
	<form action="${pageContext.request.contextPath}/jsp/session/login" method="post">
		<input type="text" name="id" placeholder="아이디"/> <br>
		<input type="text" name="password" placeholder="패스워드"/> <br>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>

	<%-- /가 포함되어있음 --%>
	<%-- 
	<h2>${pageContext.request.contextPath}</h2>
	--%>