<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list = new ArrayList<>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	 <%-- 
	      특정범위
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		} 
      --%>
     <%-- step의 default=1 --%>
     <c:forEach var="i" begin="1" end="10" step="1">
	   <c:out value="${i}" /><br> 
	 </c:forEach>	 
	 
	 생년월일 :
	 <select>
     <c:forEach var="i" begin="1970" end="2010" >
	   <option><c:out value="${i}" /></option> 
	 </c:forEach>	 
	 </select>
	 <br>
	 
	 <%--
	   특정방식(배열 등)
      for(String s : list) {
      	 System.out.println(s);
      } 
      --%>
      <%-- 공유영역에 있는 list를 불러와야함. --%>
      <c:forEach var="s" items="${list}">
      	<c:out value="${s}" /><br>
      </c:forEach>
      
      <%-- 한 줄에 ,와 출력하기 --%>
      <c:set var="first" value="true"/>
      <c:forEach var="s" items="${list}">
      	<c:if test="${not first}" >,</c:if>
      	<c:out value="${s}"/>
      	<c:set var="first" value="false"/>
      </c:forEach>
      
      
      <br>
      <%-- loop가 자바 코드로 변경되면 VO같은 클래스 객체가 된다. 반복된 값의 상태같은 것을 포함--%>
      <c:forEach var="s" items="${list}" varStatus="loop">
      	${loop.first}:::${loop.last}:::${loop.index}:::${loop.count}<br>
      	<%-- 반복문의 최초/ 반복문의 마지막/ 반복문의 인덱스/ 반복횟수 --%>
      </c:forEach>
      
      <%-- 한 줄에 ,와 출력하기 (응용)--%>
      <c:forEach var="s" items="${list}" varStatus="loop">
      	<c:if test="${not loop.first}" >,</c:if>
      	<c:out value="${s}"/>
      </c:forEach>
</body>
</html>