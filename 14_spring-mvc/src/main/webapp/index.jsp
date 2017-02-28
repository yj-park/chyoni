<!-- webapp 밑에 있어야 직접 연결 가능  -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/hello/hello.do"> hello </a><br />
	<!-- spring container가 url로 찾아보니 두 개가 나오네?!근데 폼태그로 묶이지 않았으니 GET방식이군 -->
	<a href="${pageContext.request.contextPath}/method/method.do"> method </a><br />
	<!-- controller의 RequestMapping url을 검색해보자-->
	<a href="${pageContext.request.contextPath}/form/joinForm.do"> form </a><br />
	<a href="${pageContext.request.contextPath}/ajax/resBody.do"> 문자열 응답 </a><br />
	<a href="${pageContext.request.contextPath}/ajax/resBody.json"> JSON 응답 </a><br />
	<a href="${pageContext.request.contextPath}/ajax/resVOBody.json"> JSON VO 응답 </a><br />
	<a href="${pageContext.request.contextPath}/ajax/resStringListBody.json"> JSON List(문자열) 응답 </a><br />
	<a href="${pageContext.request.contextPath}/ajax/resVOListBody.json"> JSON List(VO) 응답 </a><br />
	<a href="${pageContext.request.contextPath}/rest/resBody.do"> rest 문자열 응답 </a><br />
	<a href="${pageContext.request.contextPath}/rest/resBody.json"> rest JSON 응답 </a><br />
	<a href="${pageContext.request.contextPath}/rest/resVOBody.json"> rest JSON VO 응답 </a><br />
	<a href="${pageContext.request.contextPath}/rest/resStringListBody.json"> rest JSON List(문자열) 응답 </a><br />
	<a href="${pageContext.request.contextPath}/rest/resVOListBody.json"> rest JSON List(VO) 응답 </a><br />
	<a href="${pageContext.request.contextPath}/file/uploadForm.do"> 파일 업로드 </a><br />
	<a href="${pageContext.request.contextPath}/interceptor/loginForm.do"> 로그인폼 </a><br />
	<a href="${pageContext.request.contextPath}/path/memberInfo.do?id=a"> PathVariable 파라미터 </a><br />
	<a href="${pageContext.request.contextPath}/path/b/pathMemberInfo.do"> PathVariable 경로처리 </a><br />

</body>
</html>