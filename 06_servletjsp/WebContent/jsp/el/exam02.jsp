<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	param(id) : <%= request.getParameter("id")%><br>
	param(id) : ${param.id}<br>
	<!-- null값을 자동처리해주는 el -->
</body>
</html>