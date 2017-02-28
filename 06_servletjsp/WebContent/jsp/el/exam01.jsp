<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	5 + 5 = <%= 5 + 5 %><br>
	5 + 5 = ${5 + 5}<br>
	5 % 3 = ${5 % 3}<br>
	5 mod 3 = ${5 mod 3}<br>
	<!-- 키워드 방식도 가능한 el -->
	5 == 5 = ${5 == 5}<br>
	5 == 5 = ${5 eq 5}<br>
	empty str : ${empty str}<br>
	empty "" : ${empty ""}<br>
	empty "a" : ${empty "a"}<br>
	<!-- 비어있지 않을 때 true값 출력 -->
	not empty str : ${not empty str}<br>
	!empty str : ${!empty str}<br>
	
</body>
</html>