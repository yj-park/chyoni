<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${pageResult.count != 0}">
			<nav>
			  <ul class="pagination">
			    <li class="<c:if test="${pageResult.prev eq false}">disabled</c:if>">
			      <a href="<c:if test="${pageResult.prev eq true}">javascript:goPage(${pageResult.beginPage - 1});</c:if>" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>

				<c:forEach var="i" begin="${pageResult.beginPage}" end="${pageResult.endPage}">
				    <c:choose>
				    	<c:when test="${i eq pageResult.pageNo}">
						    <li class="active"><a href="#1">${i}</a></li>
				    	</c:when>
				    	<c:otherwise>
						    <li><a href="javascript:goPage(${i});">${i}</a></li>
				    	</c:otherwise>
				    </c:choose>
				</c:forEach>
				
			    <li class="<c:if test="${pageResult.next eq false}">disabled</c:if>">
			      <a href="<c:if test="${pageResult.next eq true}">javascript:goPage(${pageResult.endPage + 1});</c:if>" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>	
			    	    
			  </ul>
			</nav>
</c:if>			