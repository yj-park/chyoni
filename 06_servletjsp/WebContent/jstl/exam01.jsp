<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- coretag : c --%>
<%--
	공유영역에 올리는 것을 대체함(setAttribute)
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	변수 cnt를 공유영역(page)에 설정<br>
	<%
		pageContext.setAttribute("cnt", "1"); //자바 코드일 경우
	%>
	<c:set var="cnt" value="1" scope="page"/>
	page영역에 설정된 cnt를 출력 : ${cnt}<br>
	<%-- 디폴트가 page --%>
	
	변수 cnt를 공유영역(request)에 1의 값으로 설정  
	<c:set var="cnt" value="1" scope="request"/>
	request 영역에 설정된 cnt를 출력 : :${requestScope.cnt} <br>
	
	request 영역의 cnt의 값을 page 영역에 있는 cnt값을 가져와서 1을 증가시킨다. <br>
	<c:set var="cnt" value="${cnt + 1}" scope="request"/>
	증가된 cnt 출력 : ${requestScope.cnt}
	
	page 영역의 cnt를 삭제<br>
	<%-- 
	c:remove var="cnt" scope="page"/>
	--%>
	<c:remove var="cnt"/>
	page 영역의 cnt를 출력 : ${pageScope.cnt}<br>
	request 영역의 cnt를 출력 : ${requestScope.cnt}<br>
</body>
</html>