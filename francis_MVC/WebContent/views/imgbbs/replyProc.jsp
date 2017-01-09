<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.imgbbs.*" %>
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
function ilist() {
  var url = "list.do";
  url += "?col=${col }";
  url += "&word=${word }";
  url += "&nowPage=${nowPage }";
  location.href=url;
}
</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">답변 등록처리</DIV>
 
<DIV class="content">
<c:choose>
	<c:when test="${flag }">
		답변글이 등록되었습니다.
	</c:when>
	<c:otherwise>
		답변글 등록이 실패했습니다.
	</c:otherwise>
</c:choose>

</DIV>
  <DIV class='bottom'>
	<input type="button" value="계속 등록" onclick="location.href='./create.do'">
	<input type="button" value="목록" onclick="ilist()">
  </DIV>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 