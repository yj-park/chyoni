<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>네트워크 게시판</title>
</head>
<body>
	<h2>네트워크 게시판</h2>
	<hr>
		번호 : <c:out value="${boardVO.no}" /><br>
		제목 : <c:out value="${boardVO.title}" /><br>
		글쓴이 : <c:out value="${boardVO.writer}" /><br>
		내용 : <c:out value="${boardVO.content}" /><br>
		등록일 :
		<fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
	<hr>
	<a href='updateForm?no=<c:out value="${param.no}" />'>수정</a>
	<a href='delete?no=<c:out value="${param.no}" />'>삭제</a>
	<a href='list'>목록</a>
</body>
</html>







