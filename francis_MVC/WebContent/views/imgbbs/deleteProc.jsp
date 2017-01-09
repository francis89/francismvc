<%@ page contentType="text/html; charset=UTF-8" %> 
<% 
	String root = request.getContextPath();
	String col = request.getParameter("col");
	String word = request.getParameter("word");
	String nowPage = request.getParameter("nowPage");
	
	boolean pflag = (boolean)request.getAttribute("pflag");
	boolean flag = (boolean)request.getAttribute("flag");
%>
 
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
function ilist(){
	var url = "<%=root%>/imgbbs/list.do";
	url += "?col=<%=col%>";
	url += "&word=<%=word%>";
	url += "&nowPage=<%=nowPage%>";
	location.href=url;
}
</script> 
<link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">삭제처리</DIV>

<div class="content">
<%
	if(pflag==false){
		out.print("패스워드 불일치");}
	else if(flag){
		out.print("글을 삭제하였습니다.");}
	else{
		out.print("글삭제를 실패했습니다.");}

%>
</div>
 

  <%if(pflag==false){%>
  <DIV class='bottom'>
    <input type='button' value='다시시도'onclick="history.back()">
    <input type='button' value='목록' onclick="ilist()">
  </DIV>
  

 
  <%}else{%>
  <DIV class='bottom'>
    <input type='submit' value='다시등록'onclick="location='./create.do'">
    <input type='button' value='목록' onclick="ilist()">
  </DIV>
 <%} %>
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 