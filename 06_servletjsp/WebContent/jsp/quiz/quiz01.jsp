<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date"%>
<%-- import해야할 클래스명 뒤에 ctrl+space 하면 자동 import됨 --%>

<%--
	화면에 현재 시간 정보를 출력한다.
	--------------------------------
	오늘은 2017-01-13 입니다.
	현재 시간은 11:02:11 입니다.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<%  
    Date d = new Date();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
%>
	-------------------------------- <br>
	오늘은 <%= sdf1.format(d) %>입니다. <br>
	현재 시간은 <%= sdf2.format(d) %>입니다. <br>
	
</body>
</html>