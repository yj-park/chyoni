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
		첨부파일 : <a href="${pageContext.request.contextPath}/upload${file.filePath}/${file.systemName}">${file.oriName}</a>(${file.fileSize} byte)<br>
		등록일 : <fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
		<hr>
		
		<a href='updateForm?no=${param.no}'>수정</a>
		<a href='delete?no=${param.no}'>삭제</a>
		<a href='list'>목록</a>
			
		<%-- 댓글 관련 파트 시작 --%>
		<div id="comment">
			<form method="post" action="commentRegist">
				<input type="hidden" name="no" value="${boardVO.no}" />	
				<table width="70%">
				<tr>
					<td><input type="text" name="userId" value="${user.userId}" /></td>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><input type="submit" value="등록" /></td>
				</tr>	
				</table>
			</form>
		</div>
		
		<form action="commentUpdate" method="post">
			<input type="hidden" name="no" value="${boardVO.no}" />
			<input type="hidden" name="commentNo" value="${commentNo}" />
		
		<div id="commentList">
		  <table width='80%' border='1'>
		  <tr>
			<c:forEach var="comment" items="${commentList}">
			<c:choose>
		  		<c:when test="${commentNo eq comment.commentNo}">	
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td>
					  	<textarea name="content" rows="2" cols="60"><c:out value="${comment.content}" /></textarea>
					  </td>
					  <td colspan="2">
					  	  <input type="submit" value="수정" />	
					  </td>
					 </tr>
			 	</c:when>
			 	<c:otherwise>
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td>
					  		<c:out value="${comment.content}" /></td>
					  <td><fmt:formatDate var="regDate" value="${comment.regDate}" 
					                      pattern="yyyy-MM-dd HH:mm:ss" />
					      <c:out value="${regDate}" />
					  </td>
					  <td>
					  	  <a href="commentDelete?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>	
					  	  <a href="detail?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>	
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