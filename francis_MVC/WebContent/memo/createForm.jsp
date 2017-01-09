<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssi.jsp" %>
<% request.setCharacterEncoding("utf-8"); %> 

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

<script type="text/javascript">
function input(frm){
	if(frm.title.value==""){
		alert("제목 넣어라");
		frm.title.focus();
		return false;
	}
	if(frm.content.value==""){
		alert("내용 넣어라");
		frm.content.focus();
		return false;
	}
	
}

</script>
<link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<body> 
<form name="frm" method="POST" action="./createProc.jsp"
onsubmit="return input(this)" >
<table class="table">
<tr>
	<td>
	<input type='text' name='title' size='40' placeholder="제목">
	</td>
</tr>
<tr>
	<td>
	<textarea name='content' rows='2' cols='40' placeholder="내용"></textarea>
	<br>
	<input type="submit" value='전송' >
	</td>
</tr>

</table>


</form>
</body> 
</html> 