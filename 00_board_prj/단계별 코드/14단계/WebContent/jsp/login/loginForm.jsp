<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	<div class="content">
		<h2>로그인</h2>
		<hr>
		<div>
			<c:out value="${msg}"	/>
		</div>
		<form action="${pageContext.request.contextPath}/login/login" method="post">
			<input type="text" name="id" placeholder="아이디"	/><br>
			<input type="password" name="password" placeholder="패스워드"	/><br>
			<input type="submit" value="로그인"	/>
		</form>
	</div>
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>