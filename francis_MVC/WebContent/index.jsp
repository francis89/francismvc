<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty sessionScope.id}">
		<c:set var="str">MARVEL 블로그</c:set>
	</c:when>
	
	<c:otherwise>
		<c:set var="str">안녕하세요 ${sessionScope.id} 님!!</c:set>
	</c:otherwise>
</c:choose>

<c:set var="title">Francis MVC</c:set>
	<c:if test="${not empty sessionScope.id && sessionScope.grade=='A'}">
		<c:set var="title">관리자 페이지</c:set>
	</c:if>
 

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 24px; 
} 
</style> 
<link href="${pageContext.request.contextPath}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body leftmargin="0" topmargin="0">
<jsp:include page="./menu/top.jsp"/>

<DIV class="content">
	<h2>${title}</h2>
	<img src="${pageContext.request.contextPath}/images/shield.png" width="50%">
	<h1>${str }</h1>
	<br>
	<br>
	
</DIV>
 
<jsp:include page="/menu/bottom.jsp"/>

</body>
 
</html> 