<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<h1>one.jsp 페이지 포함하기</h1>
	<hr>
	<%-- 실행된 결과를 가져와 합치는 방식 사용 
		 변수를 공유할 수 없다.
		 파라미터 정보는 넘길수 있다.
	--%>
	<jsp:include page="one.jsp" />
	<hr>
	
	<jsp:include page="one.jsp">
		<jsp:param name="msg" value="test" />
	</jsp:include>
	<hr>
	
	<jsp:include page="bottom.jsp" />
</body>
</html>


