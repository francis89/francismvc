<%@ page contentType="text/html; charset=UTF-8" %> 
<% 
	String root = request.getContextPath();
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
<link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">탈퇴처리</DIV>

	<DIV class="content">
		<% 
			if(flag){
				out.print("탈퇴 처리 되었습니다<br>자동 로그아웃됩니다.");
			}else{
				out.print("탈퇴 처리 실패<br>다시 시도 하세요");
			}
		
		
		%>
	</DIV>
 

<DIV class='bottom'>
    <input type='button' value='홈' onclick="location.href='<%=root%>/index.jsp'">
    <input type='button' value='다시시도' onclick="history.back()">
</DIV>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 