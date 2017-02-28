<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<hr>
			번호 : <c:out value="${boardVO.no}"/><br>
			제목 : <c:out value="${boardVO.title}"/><br>
			글쓴이 : <c:out value="${boardVO.writer}"/><br>
			내용 : <c:out value="${boardVO.content}"/><br>
			첨부파일 : <br>
			등록일 : <fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
			<hr>
			
			<a href='updateForm?no=${param.no}'>수정</a>
			<a href='delete?no=${param.no}'>삭제</a>
			<a href='list'>목록</a>
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"	/>
	</div>
		
</div>
</body>
</html>