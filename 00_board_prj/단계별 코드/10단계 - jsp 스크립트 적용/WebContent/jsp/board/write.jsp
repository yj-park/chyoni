<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	BoardVO boardVO = new BoardVO();
	boardVO.setTitle(request.getParameter("title"));;
	boardVO.setWriter(request.getParameter("writer"));
	boardVO.setContent(request.getParameter("content"));
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(boardVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h2>게시물 등록이 완료되었습니다.</h2><br>
	<a href='list.jsp'>목록</a>
</body>
</html>