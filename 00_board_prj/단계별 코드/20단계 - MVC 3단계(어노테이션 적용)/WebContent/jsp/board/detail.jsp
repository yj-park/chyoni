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
		  <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
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
				<a href='updateForm.do?no=${param.no}' class="btn btn-success btn-lg">수정</a>
				<a href='delete.do?no=${param.no}' class="btn btn-danger btn-lg">삭제</a>
				<a href='list.do' class="btn btn-info btn-lg">목록</a>
		    </div>
		</div>
		<hr>	

		<%-- 댓글 관련 파트 시작 --%>		
		<div id="comment">
			<form id="rForm" class="form-inline">
			    <div class="form-group">
				    <input type="text" name="userId" class="form-control" value="<c:out value="${user.userId}" />" placeholder="아이디를 입력하세요">
			    </div>
			    <div class="form-group">
				    <input type="text" name="content" class="form-control input-wp1" placeholder="내용을 입력하세요">
			    </div>
			  	<button class="btn btn-primary">등록</button>
			</form>					
		</div>
		<hr>
		<div id="commentList"></div>
		<%-- 댓글 관련 파트 끝 --%>		
		
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"	/>
	</div>
	<script>
		// 댓글 등록 처리
		$("#rForm").submit(function () {
			$.ajax({
				url: "commentRegist.do",
				type: "POST",
				data: {
					no: "${boardVO.no}", 
					content: $("#rForm input[name=content]").val(), 
					userId: $("#rForm input[name=userId]").val()
				},
				dataType: "json"
			})
			.done(function (result) {
				if (!'${user.userId}') {
					$("#rForm input[name=userId]").val("");
				}
				$("#rForm input[name=content]").val("");
				
				makeCommentList(result);
			});
			// 서브밋 이벤트 중지시킴
			return false;
		});
		
		function commentDelete(commentNo) {
			$.ajax({
				url: "commentDelete.do",
				data: {
					no: "${boardVO.no}", 
					commentNo: commentNo
				},
				dataType: "json"
			})
			.done(makeCommentList);	
		}
		
		function commentUpdateForm(commentNo) {
			
			$("#commentList tr[id^=row]").show();
			$("#commentList tr[id^=modRow]").remove();
			
			var modId = $("#row" + commentNo + " > td:eq(0)").text();
			var modContent = $("#row" + commentNo + " > td:eq(1)").text();
			
			var html = '';
			html += '<tr id="modRow' + commentNo + '">';
			html += '	<td>' + modId + '</td>';
			html += '	<td>';
			html += '		<div class="form-group">';
			html += '			<input type="text" name="content" value="' + modContent + '" class="form-control input-wp2" placeholder="내용을 입력하세요">';
			html += '		</div>';
			html += '	</td>';
			html += '	<td colspan="2">'; 
			html += '		<a href="javascript:commentUpdate(' + commentNo + ');" class="btn btn-success btn-sm" role="button">수정</a>';
			html += '		<a href="javascript:commentCancel(' + commentNo + ');" class="btn btn-warning btn-sm" role="button">취소</a>';
			html += '	</td>';
			html += '</tr>';
			$("#row" + commentNo).after(html);	
			$("#row" + commentNo).hide();
		}
		
		function commentUpdate(commentNo) {
			$.ajax({
				url: "commentUpdate.do",
				type: "POST",
				data: {
					no: "${boardVO.no}", 
					content: $("#modRow" + commentNo + " input[name=content]").val(), 
					commentNo: commentNo
				},
				dataType: "json"
			})
			.done(function (result) {
				makeCommentList(result);
			});
		}
		
		function commentCancel(commentNo) {
			$("#row" + commentNo).show();
			$("#modRow" + commentNo).remove();
		}
		
		// 댓글 목록 만드는 공통 함수
		function makeCommentList(result) {

			var html = "";
			html += '<table class="table table-hover table-bordered">';
			html += '	<colgroup>'; 
			html += '		<col width="7%">'; 
			html += '		<col width="*">'; 
			html += '		<col width="14%">'; 
			html += '		<col width="10%">'; 
			html += '	</colgroup>'; 
			  
			for (var i = 0; i < result.length; i++) {
				var comment = result[i];
				html += '<tr id="row' + comment.commentNo + '">';
				html += '	<td>' + comment.userId + '</td>';
				html += '	<td>' + comment.content + '</td>';
				var date = new Date(comment.regDate);
				var time = date.getFullYear() + "-" 
				         + (date.getMonth() + 1) + "-" 
				         + date.getDate() + " "
				         + date.getHours() + ":"
				         + date.getMinutes() + ":"
				         + date.getSeconds();
				html += '	<td>' + time + '</td>';  
				html += '	<td>';    
				html += '		<a href="javascript:commentUpdateForm(' + comment.commentNo + ')" class="btn btn-success btn-sm" role="button">수정</a>';    
				html += '		<a href="javascript:commentDelete(' + comment.commentNo + ')" class="btn btn-danger btn-sm" role="button">삭제</a>';    
				html += '	</td>';    
				html += '</tr>';
			}
			if (result.length == 0) {
				html += '<td colspan="4">댓글이 존재하지 않습니다.</td>';
			}
			$("#commentList").html(html);
		}
		
		// 댓글 목록 조회
		function commentList() {
			$.ajax({
				url: "commentList.do",
				data: {no: "${boardVO.no}"},
				dataType: "json"
			})
			.done(makeCommentList);
		}
		
		// 상세 페이지 로딩시 댓글 목록 조회 ajax 호출
		commentList();
		
	</script>	
</div>
</body>
</html>