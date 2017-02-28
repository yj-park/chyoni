<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	BoardDAO dao = new BoardDAO();
	List<BoardVO> list = dao.selectBoard();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
</head>
<body>	
	<h2>네트워크 게시판</h2>
	전체 <%=list.size()%> 개<br>
	<hr>
	<table width='70%' border='1'>
	<tr>
	 <th>번호</th>
	 <th>제목</th>
	 <th>글쓴이</th>
	 <th>등록일</th>
	</tr>
<% 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	for (int i = 0; i < list.size(); i++) {
		BoardVO board = list.get(i);
%>
		<tr>
		 <td> <%=board.getNo()%> </td>
		 <td> <a href='detail?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
		 <td> <%=board.getWriter()%></td>
		 <td> <%=sdf.format(board.getRegDate())%></td>
		</tr>
<% 
	}
	if (list.size() == 0) {
%>
		<tr>
		 <td colspan='4'> 입력된 게시물이 없습니다. </td>
		</tr>
<%
	}
%>
	</table>
	<a href='writeForm'>글쓰기</a>
</body>
</html>