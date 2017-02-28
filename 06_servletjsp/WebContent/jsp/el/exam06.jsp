<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String [] names = {"홍", "길", "동", "민", "중", "의"};
	pageContext.setAttribute("names", names);
	
	List<String> list = new ArrayList<>();
	list.add("홍");
	list.add("길");
	list.add("동");
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	names[0] : ${names[0]}<br>
	names[5] : ${names[5]} <br>
	
	list[0] : ${list[0]}<br>
</body>
</html>