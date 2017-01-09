<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">패스워드 변경처리</DIV>
 <DIV class="content">
 <c:choose>
 	<c:when test="${flag }">
 		success<br><br>
 		please Login<br>
 	</c:when>
 	<c:otherwise>
 		<h1>fail</h1><br>
 		try again<br>
 	</c:otherwise>
 </c:choose>

 
 </DIV>

  
  <DIV class='bottom'>
  <c:choose>
  	<c:when test="${flag }">
  		<input type='button' value='LogIn' onclick="location.href='./login.do'">
  	</c:when>
  	<c:otherwise>
  		<input type='button' value='try Again' onclick="history.back()">
  	</c:otherwise>
  </c:choose>

    <input type='button' value='Home' onclick="location.href='../index.jsp'">
  </DIV>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 