<%@ page import="org.apache.commons.fileupload.FileItem"%>
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
function blist(){
	var url = "list.do";
	
	location.href=url;
}



</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<div class="title">처리결과</div>
 
<DIV class="content">
<c:choose>
	<c:when test="${flag }">
		게시물 등록 성공했습니다
	</c:when>
	<c:otherwise>
		게시물 등록에 실패했습니다.
	</c:otherwise>
</c:choose>

</DIV>
 
<DIV class='bottom'>
  <input type='button' value='계속 등록' onclick="location.href='${pageContext.request.contextPath}/bbs/create.do'">
  <input type='button' value='목록' onclick="blist()">
 
</DIV>
 

<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 