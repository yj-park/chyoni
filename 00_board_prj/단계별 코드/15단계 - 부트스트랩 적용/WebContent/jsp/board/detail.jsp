<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
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
		<table class="table table-no-border">
		<tr>
			<td class="td-txt-right td-wp10">번호</td>
		 	<td><c:out value="${boardVO.no}"/></td>
		</tr>
		<tr>
			<td class="td-txt-right td-wp10">제목</td>
		 	<td><c:out value="${boardVO.title}"/></td>
		</tr>
		<tr>
			<td class="td-txt-right td-wp10">글쓴이</td>
		 	<td><c:out value="${boardVO.writer}"/></td>
		</tr>
		<tr>
			<td class="td-txt-right td-wp10">내용</td>
		 	<td><c:out value="${boardVO.content}"/></td>
		</tr>
		<tr>
			<td class="td-txt-right td-wp10">첨부파일</td>
		 	<td><a href="${pageContext.request.contextPath}/upload${file.filePath}/${file.systemName}">${file.oriName}</a>(${file.fileSize} byte)</td>
		</tr>
		<tr>
			<td class="td-txt-right td-wp10">등록일</td>
		 	<td><fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
		</tr>
		</table>
		
		<div class="row">
		    <div class="col-md-9"></div>
		    <div class="col-md-3">
				<a href='updateForm?no=${param.no}' class="btn btn-success btn-lg">수정</a>
				<a href='delete?no=${param.no}' class="btn btn-danger btn-lg">삭제</a>
				<a href='list' class="btn btn-info btn-lg">목록</a>
		    </div>
		</div>
		<hr>	
		<%-- 댓글 관련 파트 시작 --%>
		<div id="comment">
			<form class="form-inline" method="post" action="commentRegist">
				<input type="hidden" name="no" value="${boardVO.no}" />	
				<input type="hidden" name="id" value="${user.id}" />	
			    <div class="form-group">
				    <input type="text" name="userId" class="form-control" value="<c:out value="${user.id}" />" placeholder="아이디를 입력하세요">
			    </div>
			    <div class="form-group">
				    <input type="text" name="content" class="form-control input-wp1" placeholder="내용을 입력하세요">
			    </div>
			  	<button type="submit" class="btn btn-primary">등록</button>
			</form>		
		</div>		
		<hr>
		<form action="commentUpdate" method="post">
			<input type="hidden" name="no" value="${boardVO.no}" />
			<input type="hidden" name="commentNo" value="${commentNo}" />
		
		<div id="commentList">
		  <table class="table table-hover table-bordered">
		  <colgroup>
		  	  <col width="7%">
		  	  <col width="*">
		  	  <col width="14%">
		  	  <col width="10%">
		  </colgroup>
		  <tr>
			<c:forEach var="comment" items="${commentList}">
			<c:choose>
		  		<c:when test="${commentNo eq comment.commentNo}">	
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td>
					  	<div class="form-group">
						    <input type="text" name="content" value="<c:out value="${comment.content}" />" class="form-control input-wp2" placeholder="내용을 입력하세요">
					    </div>
					  </td>
					  <td colspan="2">
					  	  <input type="submit" class="btn btn-success btn-sm" value="수정" />
					  	  <a href='detail?no=${comment.no}' class="btn btn-warning btn-sm" role="button">취소</a>		
					  </td>
					 </tr>
			 	</c:when>
			 	<c:otherwise>
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td><c:out value="${comment.content}" /></td>
					  <td><fmt:formatDate var="regDate" value="${comment.regDate}" 
					                      pattern="yyyy-MM-dd HH:mm:ss" />
					      <c:out value="${regDate}" />
					  </td>
					  <td>
					  	  <a href='detail?commentNo=${comment.commentNo}&no=${comment.no}' class="btn btn-success btn-sm" role="button">수정</a>	
					  	  <a href='commentDelete?commentNo=${comment.commentNo}&no=${comment.no}' class="btn btn-danger btn-sm" role="button">삭제</a>	
					  </td>
					 </tr>
			 	</c:otherwise>
			 </c:choose>	
			 </c:forEach>
			 <c:if test="${empty commentList}">
			 <tr>
			    <td colspan='4'>댓글이 존재하지 않습니다.</td>
			 </tr>
		 	</c:if>
		 </table>
		</div>
		</form>			
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"	/>
	</div>
		
</div>
</body>
</html>