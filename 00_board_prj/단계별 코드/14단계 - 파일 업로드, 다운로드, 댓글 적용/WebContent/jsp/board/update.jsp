<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
		게시물 수정이 완료되었습니다.
		<a href='list'> 목록</a>
	</div> 
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>