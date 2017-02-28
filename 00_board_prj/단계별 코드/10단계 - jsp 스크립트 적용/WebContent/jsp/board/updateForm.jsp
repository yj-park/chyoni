<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
</head>
<body>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.selectOneBoard(no);
%>
	<h2>네트워크 게시판</h2>
		<hr>
		<form action='update.jsp' method='post'>
			<input type='hidden' name='no' value='<%= no %>'>
			 제목 : <input type='text' name='title' value='<%= board.getTitle() %>'/><br>
			 글쓴이 : <input type='text' name='writer' readonly value='<%= board.getWriter() %>'/><br>
			 내용 : <br>
			 <textarea name='content' rows='5' cols='70'><%= board.getContent() %></textarea><br>
			 <input type='submit' value='수정'/>
		</form>
		<a href='list.jsp'>목록</a>
</body>
</html>