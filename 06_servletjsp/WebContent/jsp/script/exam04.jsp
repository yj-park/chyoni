<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- 지시문<%@ %>의 종류에는 
  page: 현재 페이지에 대한 부가적인 정보 (ex: <%@ page import="java.util.*" %>,
  include,
  taglib 등이 있다 --%>
  
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> list = new ArrayList<String>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
%>

<%
	for (String data : list) {
%>
	<%= data %> <br>
<% 			
	}
%>

</body>
</html>