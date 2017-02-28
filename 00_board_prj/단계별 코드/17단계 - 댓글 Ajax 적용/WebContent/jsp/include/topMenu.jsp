<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">비트90기</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/main/main">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/board/list">자유게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
	<c:choose>
	  <c:when test="${empty user}">
	    <li><a href="#1"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
	    <li><a href="${pageContext.request.contextPath}/login/loginForm"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	  </c:when>
	  <c:otherwise>
		<li><a href="${pageContext.request.contextPath}/login/logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
	  </c:otherwise>
	</c:choose>
    </ul>
  </div>
</nav>