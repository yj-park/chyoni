<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
<base href="http://www.bitjobedu.co.kr">
</head>
<body>
	<h1>one.jsp 페이지 포함하기</h1>
	<hr>
	<%-- 실행된 결과를 가져와 합치는 방식 사용 
	       변수를 공유할 수 없다.
	       파라미터 정보는 넘길 수 있다.
	--%>
	<c:import url="one.jsp" />
	<hr>
	
	<c:import url="one.jsp" >
	
		<c:param name="msg" value="test"/>
	</c:import>
	<hr>

	
	<c:import url="http://www.bitjobedu.co.kr"/>
	
	<c:import url ="bottom.jsp" />
</body>
</html>