<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--String msg = "hello jsp"; 이렇게만 쓰면 문자열로 인식하고 그대로 브라우저에 출력함. 자바코드로서 쓰고 싶다면 <% %>를 사용하여 쓴다. 즉, 반복문, 변수 선언 등 다 가능해 --%> 

<% 
String msg = "hello jsp"; 
String dan = request.getParameter("dan");
%> 
<%-- .java 파일로 바꾸는 service 메소드에 request가 선언되어있기때문에 오류가 나지 않음 --%>

<%-- 별도의 선언없이 사용할 수 있는 변수(=내장객체)
	 서비스 메소드에 미리 선언되어있는 변수로서
	 request,response,pageContext,config,out,page,_jspx_out,_jspx_page_context 총 8가지 --%>
	 
	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 자바코드를 브라우저에 출력하기 위해서는 <%= %>를 사용하며 자바코드와 jsp를 분리해야한다! 꼭! --%>
dan : <%= dan %> <br>
msg : <%= msg %> <br>
<%
	for (int i = 1; i <= 10; i++) {
%>
		<%= i %> <br>
<% 	}
%>	
</body>
</html>