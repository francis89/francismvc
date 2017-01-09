<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.bbs.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html> 
<html> 
<head> 
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!--     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<script type="text/javascript">
	function bcreate(){
		var url = "create.do";
		location.href=url;
	}
	
	function bupdate(){
		var url = "update.do";
		url += "?bbsno=${bbsno}";
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		location.href=url;
	}
	
	function bdelete(){
		var url = "delete.do";
		url += "?bbsno=${bbsno}";
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		url += "&oldfile=${dto.filename}";
		location.href=url;
	}
	function breply(){
		var url = "reply.do";
		url += "?bbsno=${bbsno}";
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		location.href=url;
	}
	
	function blist(){
		var url = "list.do";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		location.href=url;
	}
	
	function down(filename){
		var url = "${pageContext.request.contextPath }/download";
		url += "?dir=/views/bbs/storage";
		url += "&filename="+filename;
		
		location.href = url;
		
	}
</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">조회</DIV>
 
  <TABLE style=" width: 60%; padding: 20px;">
  <TR>
    <TH>제목</TH>
    <TD>${dto.title }</TD>
  </TR>
  <TR>
    <TH>내용</TH>
    <TD>${content }</TD>
  </TR>
  <TR>
    <TH>성명</TH>
    <TD>${dto.wname }</TD>
  </TR>
  
  <TR>
    <TH>조회수</TH>
    <TD>${dto.viewcnt }</TD>
  </TR>
  <TR>
    <TH>등록일</TH>
    <TD>${fn:substring(dto.wdate, 0, 10) }</TD>
  </TR>
  <TR>
    <TH>파일</TH>
    <TD>
    <c:choose>
    	<c:when test="${empty dto.filename }">
    		파일 없음
    	</c:when>
    	<c:otherwise>
    		${dto.filename }(${dto.filesize/1024 }KB)
  	  		<a href="javascript:down('${dto.filename }')">
		  	<span class='glyphicon glyphicon-file'></span>
		  	</a>
    	</c:otherwise>
    </c:choose>
    </TD>
  </TR>
  
</TABLE>
  
  <div class="bottom">
<input type="button" value="등록" onclick="bcreate()">
<input type="button" value="목록" onclick="blist()">
<input type="button" value="수정" onclick="bupdate()">
<input type="button" value="삭제" onclick="bdelete()">
<input type="button" value="답변" onclick="breply()">
</div>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 