<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.bbs.*" %> 
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
function read(bbsno){
	//alert(no);
	var url = "read.do";
	url += "?bbsno="+bbsno;
	url += "&col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	location.href=url;
	}
</script>
<script type="text/javascript">
function blist(){
	var url = "list.do";
	url += "?col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	location.href=url;
}
</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<DIV class='title'>수정처리 결과</DIV>
 
<DIV class='content'>
<c:if test="${pflag == true && flag == true }">
	글을 변경했습니다.<br><br>  
    <DIV class='bottom'>
      <input type='button' value='변경 확인' onclick="javascript:read(${dto.bbsno})">
      <input type='button' value='목록' onclick="blist()">
    </DIV>
</c:if>

<c:if test="${pflag == true && flag == false }">
     수정 실패<br>
    <DIV class='bottom'>
      <input type='button' value='다시 시도' onclick="history.back();">       
      <input type='button' value='목록' onclick="blist()">
    </DIV>
</c:if>
<c:if test="${pflag == false }">
 	패스워드가 일치하지 않습니다.<br>
    <DIV class='bottom'>
      <input type='button' value='다시 시도' onclick="history.back();">       
      <input type='button' value='목록' onclick="blist()">
    </DIV>
</c:if>

</DIV>
 
</body>
<!-- *********************************************** -->
</html> 