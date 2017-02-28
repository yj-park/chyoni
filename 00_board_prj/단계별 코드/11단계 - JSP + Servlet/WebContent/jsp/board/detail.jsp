<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
BoardVO boardVO = (BoardVO)request.getAttribute("boardVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>네트워크 게시판</title>
</head>
<body>
<%
	if (boardVO != null) {
%>
	<h2>네트워크 게시판</h2>
	<hr>
		번호 <%=boardVO.getNo()%> <br>
		제목 <%=boardVO.getTitle()%> <br>
		글쓴이 <%=boardVO.getWriter()%> <br>
		내용 <%=boardVO.getContent()%> <br>
		등록일 <%new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate());%> <br>
<% 
	} else {
%>
		글번호에 해당하는 게시물이 없습니다.
<%
	}
%>
	<hr>
	<a href='updateForm?no=<%=no%>'>수정</a>
	<a href='delete?no=<%=no%>'>삭제</a>
	<a href='list'>목록</a>
</body>
</html>