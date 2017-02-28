<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<c:set var="msg" value="fn test"/>
	fn.length : <c:out value="${fn:length(msg)}"/> <br>
	fn.substring : <c:out value="${fn:substring(msg, 0, 6)}"/> <br>
	fn.substring : <c:out value="${fn:substring(msg, 0, -1)}"/> <br>
	fn.replace : <c:out value="${fn:replace(msg, 'fn', 'test')}"/> <br>
	fn.indexOf : <c:out value="${fn:indexOf(msg, 'es')}"/> <br>
	fn.startsWith : <c:out value="${fn:startsWith(msg, 'fn')}"/> <br>
	fn.endsWith : <c:out value="${fn:endsWith(msg, 'est')}"/> <br>
	fn.contains : <c:out value="${fn:contains(msg, 'est')}"/> <br>
</body>
</html>