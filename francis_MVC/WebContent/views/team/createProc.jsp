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
  font-size: 24px; 
} 
</style> 
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body>
<div class="content">
<c:choose>
	<c:when test="${flag }">
		팀 정보 등록 성공
	</c:when>
	<c:otherwise>
		팀 정보 등록 실패
	</c:otherwise>
</c:choose>

<br>
</div>
<div class="bottom">
<input type='button' value='계속 등록' onclick="location.href='./create.do'">
<input type='button' value='목록' onclick="location.href='./list.do'">
</div>
</body> 
</html> 


