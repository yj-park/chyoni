<%@page import="kr.co.mlec.board.vo.BoardVO"%>
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
	request.setCharacterEncoding("utf-8");
	BoardDAO dao = new BoardDAO();
	BoardVO boardVO = new BoardVO();
	boardVO.setNo(Integer.parseInt(request.getParameter("no")));
	boardVO.setTitle(request.getParameter("title"));
	boardVO.setContent(request.getParameter("content"));
	dao.updateBoard(boardVO);
%>
	게시물 수정이 완료되었습니다.<br>
	<a href='list.jsp'>목록</a>
</body>
</html>