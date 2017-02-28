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
		
		<form name="wForm" action='write.do' method='post' enctype="multipart/form-data">
			<table class="table table-no-border">
			<tr>
				<td class="td-txt-right td-wp10">제목</td> 
			 	<td>
			 		<div class="form-group">
			 			<input type='text' name='title' class="form-control input-wp1" />
			 		</div>
			 	</td>
			</tr>
			<tr>
				<td class="td-txt-right td-wp10">글쓴이</td>
			 	<td>
			 		<div class="form-group">
			 			<input type='text' name='writer' class="form-control input-wp5" />
			 		</div>
			 	</td>
			</tr>
			<tr>
				<td class="td-txt-right td-wp10">내용</td>
			 	<td><div class="form-group">
			 		<textarea name='content' rows='5' cols='70' class="form-control"></textarea>
			 		</div>
			 	</td>
			</tr>
			<tr>
				<td class="td-txt-right td-wp10">첨부파일</td>
			 	<td><div class="form-group">
			 			<input type="file" name="attachFile" />
					</div>
			 	</td>			 			
			</tr>
			</table>
			
			<div class="row">
			    <div class="col-md-10"></div>
			    <div class="col-md-2">
					<button class="btn btn-primary btn-lg">등록</button>
					<a href='list.do' class="btn btn-info btn-lg">목록</a>
			    </div>
			</div>
		</form>
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
	<script>
		document.wForm.onsubmit = function () {
			var f = document.wForm;
			if (isEmpty(f.title, "제목을 입력하세요")) return false;
			if (isEmpty(f.writer, "글쓴이를 입력하세요")) return false;
			if (isEmpty(f.content, "내용을 입력하세요")) return false;
			return true;
		};
	</script>
</div>	
</body>
</html>















