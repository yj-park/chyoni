<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="logout.do">로그아웃</a>
	<div>
	<!-- 세션에 있는 정보 출력 -->
	<!-- 로그인을 한 상태에서만 보여야하는 페이지인데도 불구하고 myPage.do url을 입력하면 이동 가능 -> 오류 발생 -> interceptor로 해결하자 -->
		<h2>아이디 : ${user.id}</h2>
		<h2>이름 : ${user.name}</h2>
	</div>
</body>
</html>