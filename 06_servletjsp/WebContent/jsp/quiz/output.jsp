<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    int dan = Integer.parseInt(request.getParameter("dan"));
%> 
<h1>단 :<%= dan %></h1> <br>
<%  
	for(int i = 1; i <= 9; i++) {
	int cal = dan * i; 
%>
	<%= dan%> * <%= i%> = <%= cal%> <br>
<% 
	}
%>
</body>
</html>