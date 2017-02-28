<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<!-- 파일은 꼭 post방식으로! enctype을 적지 않으면 오류는 나지 않지만 request body에 파일 내용을 붙여서 전송하지 못하기 때문에 파일 내용 없이 이름만 전송됨 -->
	<!-- form action="upload" method="post" -->
	<form action="upload" method="post" enctype="multipart/form-data" >
		<input type="text" name="msg" /><br>
		<input type="file" name="attachFile" /><br>
		<button>전송</button>
		<!-- 버튼의 default는 submit이야 -->
	</form>
</body>
</html>