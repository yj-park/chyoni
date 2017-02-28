<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		  <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
		  <li class="active">자유게시판</li>
		</ol>	
		
		<form action='update.do' method='post'>
			<input type="hidden" name="no" value="<c:out value="${board.no}"/>" /> 
			<table class="table table-no-border">
			<tr>
				<td class="td-txt-right td-wp10">제목</td> 
			 	<td>
			 		<div class="form-group">
			 			<input type='text' name='title' class="form-control input-wp1" value="<c:out value="${board.title}"/>" />
			 		</div>
			 	</td>
			</tr>
			<tr>
				<td class="td-txt-right td-wp10">글쓴이</td>
			 	<td>
			 		<div class="form-group">
			 			<input type='text' name='writer' class="form-control input-wp5" value="<c:out value="${board.writer}"/>" />
			 		</div>
			 	</td>
			</tr>
			<tr>
				<td class="td-txt-right td-wp10">내용</td>
			 	<td><div class="form-group">
			 		<textarea name='content' rows='5' cols='70' class="form-control"><c:out value="${board.content}"/></textarea>
			 		</div>
			 	</td>
			</tr>
			</table>
			
			<div class="row">
			    <div class="col-md-10"></div>
			    <div class="col-md-2">
					<button class="btn btn-primary btn-lg">수정</button>
					<a href='list.do' class="btn btn-info btn-lg">목록</a>
			    </div>
			</div>
		</form>
	</div>
	
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>

</div>
</body>
</html>