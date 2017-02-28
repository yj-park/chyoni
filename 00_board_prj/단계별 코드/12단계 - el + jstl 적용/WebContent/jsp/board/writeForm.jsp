<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
</head>
<body>
	<h2>네트워크 게시판</h2>
	<hr>
	<form action='write' method='post'>
		제목 : <input type='text' name='title' /><br>
		글쓴이 : <input type='text' name='writer' /><br>
		내용 : <br>
		<textarea name='content' rows='5' cols='70'></textarea><br>
		<input type='submit' value='등록'/>
		</form>
		<a href='list.jsp'>목록</a>
</body>
</html>