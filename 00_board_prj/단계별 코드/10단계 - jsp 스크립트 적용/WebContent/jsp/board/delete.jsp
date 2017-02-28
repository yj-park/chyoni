<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>	
<%  
	BoardDAO dao = new BoardDAO();
	int no = Integer.parseInt(request.getParameter("no"));
	dao.deleteBoard(no);
%>
	게시물 삭제가 완료되었습니다.<br>
	<a href='list.jsp'>목록</a>
	
</body>
</html>