<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="navi" %>   
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
		  <li><a href="#1">Home</a></li>
		  <li class="active">자유게시판</li>
		</ol>
		<hr>		
		<div class="row">
		    <div class="col-md-10"></div>
		    <div class="col-md-2" style="text-align: right">
				전체 <c:out value="${pageResult.count}"/>개
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
						<td><c:out value="${board.title}" /></td>
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
		 <!-- 개발자가 만든 페이지 처리 태그 -->
		<navi:page data="${pageResult}" />
		<!-- 공유영역에 pageResult라는 이름으로 올려준 정보를 data로 넘겨서 사용할거야. 원하는 이름으로 쓰기 위해서! url도 가능 -->
	</div>		
</div>
<script>
	$("ul.nav.navbar-nav > li").removeClass("active");
	$("ul.nav.navbar-nav > li:eq(4)").addClass("active");
	
	function goPage(pageNo) {
		location.href = "list5.do?pageNo=" + pageNo;
	}
</script>
</body>
</html>















