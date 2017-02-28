<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jsp.Exam02"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<Exam02> list = new ArrayList<>();
Exam02 e = new Exam02();
e.setMsg("성공");
list.add(e);
pageContext.setAttribute("list", list);   
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%--
		실행 시 화면에 "성공"이라고 뜨도록 코딩 작성 
	 --%>
	 ${list[0].msg}
</body>
</html>