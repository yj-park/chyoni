<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
<%@ include file="/jsp/include/basicInclude.jsp" %>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	<div class="content">
		<ol class="breadcrumb">
		  <li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
		  <li class="active">로그인</li>
		</ol>	
		<hr>
		<div>
			<c:out value="${msg}"	/>
		</div>
	    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        <div class="panel panel-success">
	            <div class="panel-heading">
	                <div class="panel-title">환영합니다!</div>
	            </div>
	            <div class="panel-body">
	                <form id="login-form" action="${pageContext.request.contextPath}/login/login.do" method="post">
	                    <div>
	                        <input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요" autofocus>
	                    </div>
	                    <div>
	                        <input type="password" class="form-control" name="password" placeholder="패스워드를 입력하세요">
	                    </div>
	                    <div>
	                        <button type="submit" class="form-control btn btn-primary">로그인</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
		
	</div>
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
</body>
</html>