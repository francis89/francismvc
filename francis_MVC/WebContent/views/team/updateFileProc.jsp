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
<script type="text/javascript">
function tread(){
	var url = "read.do"
	url += "?no=${no}";
	url += "&nowPage=${nowPage}";
	url += "&col=${col}";
	url += "&word=${word}";
	
	location.href = url;
}


</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">사진 변경 처리</DIV>
 
<DIV class="content">
<c:choose>
	<c:when test="${flag }">
		사진변경 성공
	</c:when>
	<c:otherwise>
		사진 변경 실패
	</c:otherwise>
</c:choose>

</DIV>
  
  <DIV class='bottom'>
    <input type='button' value='조회' onclick="tread()">
    <input type='button' value='다시시도' onclick="history.back()">
  </DIV>

 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 