<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
<%@ include file="/jsp/include/basicInclude.jsp" %>
</head>
<body>
<div class="container">

	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>

	<div class="content">
		<ol class="breadcrumb">
		  <li><a href="${pageContext.request.contextPath}/main/main">Home</a></li>
		  <li class="active">자유게시판</li>
		</ol>
		<hr>		
		<div class="row">
		    <div class="col-md-11"></div>
		    <div class="col-md-1">
				전체 <c:out value="${fn:length(list)}"/>개
		    </div>
		</div>
		<div class="table-responsive">
		<table class="table table-hover">
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
			</tr>
			</thead>
			<c:forEach var="board" items="${list}">
				<tr>
					<td><c:out value="${board.no}" /></td>
					<td><a href='detail?no=<c:out value="${board.no}"/>'><c:out value="${board.title}" /></a></td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				</tr>
			</c:forEach>
	
			<c:if test="${empty list}">
				<tr>
					<td colspan='4'>입력된 게시물이 없습니다.</td>
				</tr>
			</c:if>
		</table>
		</div>
		<div class="row">
		    <div class="col-md-11"></div>
		    <div class="col-md-1">
				<a href='${pageContext.request.contextPath}/board/writeForm' class="btn btn-info" role="button">글쓰기</a>
		    </div>
		</div>
	</div>		
	   
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"/>
	</div>
	
	<script>
		if ('${msg}') {
			alert('${msg}');
		}
	</script>
</div>
</body>
</html>


















