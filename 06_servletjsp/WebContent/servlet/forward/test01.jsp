<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	 String msg = (String)request.getAttribute("msg");
	 Date time = (Date)request.getAttribute("time");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h1>msg : <%= msg %></h1>
	<h1>time : <%= time %></h1>
</body>
</html>