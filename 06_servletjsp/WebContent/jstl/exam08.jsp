<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	 <%--
	 SimpleDateFormat과 동일한 기능의 fmt
	 <%
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM-dd");
	 // 날짜 -> 문자열
	 String sDate = sdf.format(new Date());
	 
	 // 문자열 -> 날짜
	 Date d = sdf.parse("2017-01-17");
	 %>
<fmt:formatDate />
	 --%>
<fmt:parseDate var="date" value="2017-01-17" pattern="yyyy-MM-dd"/>
날짜 변환 정보 출력 : <c:out value="${date.year + 1900}" />년 <c:out value="${date.month + 1}" />월 <br>
날짜 정보에서 문자열 추출 :
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
</body>
</html>