<%@ page contentType="text/html; charset=UTF-8"%>
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
	<div id="w">
	<div class="title"><h3>메모 등록 결과</h3></div>
	<div class="content">
	<c:choose>
		<c:when test="${flag}">
			메모를 등록 했습니다
		</c:when>
		<c:otherwise>
			메모 등록이 실패했습니다.
		</c:otherwise>
	</c:choose>
		<div class="bottom">
		<input type="button" value="계속 등록" class="button" onclick="location.href='./create.do'">
		<input type="button" value="목록" class="button" onclick="location.href='./list.do'">
		</div>
	</div>
	</div>
</body>
</html>
