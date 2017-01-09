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

<DIV class='content'>
<c:choose>
	<c:when test="${flag }">
		회원가입 했습니다
	</c:when>
	<c:otherwise>
		회원가입 실패했습니다
	</c:otherwise>
</c:choose>

</DIV> 
<c:choose>
	<c:when test="${flag }">
		<DIV class='bottom'>
    		<input type='button' value='로그인' onclick="location.href='../login.do'">
    		<input type='button' value='홈' onclick="location.href='../index.jsp'">
  		</DIV>
	</c:when>
	<c:otherwise>
		<DIV class='bottom'>
    		<input type='button' value='다시시도' onclick="history.back()">
    		<input type='button' value='홈' onclick="location.href='../index.jsp'">
  		</DIV>
	</c:otherwise>
</c:choose>
  
</body>
</html> 