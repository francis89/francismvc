<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.bbs.*,utility.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="util" uri="/ELFunctions" %>
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
.search{
	width: 80%;
	text-align: center;
	margin: 2px auto;
}
</style> 
<script type="text/javascript">
function read(bbsno) {
  var url = "read.do";
  	  url += "?bbsno=" + bbsno;
      url += "&col=${col}";
      url += "&word=${word}";
      url += "&nowPage=${nowPage}";
  
  location.href = url;
}
function down(filename){
	var url = "${pageContext.request.contextPath }/download";
	url += "?dir=/views/bbs/storage";
	url += "&filename="+filename;
	
	location.href = url;
	
}
</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
  
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 <DIV class="container"> 
  <FORM method='post' action="./list.do"> 
	  <SELECT name='col'> <!-- 검색할 컬럼 -->
	    <option value="wname" <c:if test="${col=='wname'}"> selected='selected' </c:if>> 성명</option>
	    <option value="title" <c:if test="${col=='title'}"> selected='selected' </c:if>> 제목</option>
	    <option value="content" <c:if test="${col=='content'}"> selected='selected' </c:if>> 내용</option>
	    <OPTION value='total'>전체출력</OPTION> 
	  </SELECT> 
	  <input type='text' name='word' value='${word }'> <!-- 검색어 -->
	  <input type='submit' value='검색'> 
	  <input type='button' value='등록' onclick="location.href='./create.do'"> 
  </FORM> 
 
 
 

 
 <h2><span class="glyphicon glyphicon-th-list"></span>게시판 목록</h2>
	<TABLE class="table">
   <TR>
    <TH>번호</TH>
    <TH>제목</TH>
    <TH>성명</TH>
    <TH>조회수</TH>
    <TH>등록일</TH>
    <TH>파일명</TH>
    
  </TR>
  
  <c:choose>
  	<c:when test="${fn:length(list) == 0}">
    <TR>
      <TD colspan='8' align='center'>등록된 글이 없습니다.</TD>
    </TR>
  	</c:when>
  	<c:otherwise>
  		<c:forEach items="${list}" var="dto">
  		
  			<TR>
		      <TD>${dto.bbsno }</TD>
		      <TD>
		      	<c:forEach begin="1" end="${dto.indent }">
					&nbsp; &nbsp;
		      	</c:forEach>
		      		<c:if test="${dto.indent > 0 }">
		      		 	<img src="${pageContext.request.contextPath }/images/reply.JPG" style=" width:10px; height:10px;">
		      		</c:if>
		       			<a href="javascript:read('${dto.bbsno }')">${dto.title }</a>
						<c:if test="${util:newImg(fn:substring(dto.wdate, 0, 10)) }">
						   	<img src="${pageContext.request.contextPath }/images/new.gif">
						</c:if>
		      </TD>
		      <TD>${dto.wname }</TD>
		      <TD>${dto.viewcnt }</TD>
		      <TD>${fn:substring(dto.wdate, 0, 10) }</TD>
		      <TD>
		      <c:choose>
		      
		      	<c:when test="${empty dto.filename }">
		      		파일 없음
		      	</c:when>
		      	
		      	<c:otherwise>
		      		<a href="javascript:down('${dto.filename }')">
				  		<span class='glyphicon glyphicon-file'></span>
				  	</a>
		      	</c:otherwise>
		      </c:choose>
		      </TD>
		      
		    </TR>
		  		
		</c:forEach>
			<%--<c:forEach items="${list}" var="dto"> --%>
  	</c:otherwise>
  </c:choose>
 
  
  </TABLE>
  </DIV>
 <DIV class='bottom'>
  	${paging }
    <input type='button' value='등록' onclick="location.href='./create.do'">
    <input type='button' value='이전' onclick="location.href=history.back()">
 </DIV>
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 