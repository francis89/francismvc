<%@ page contentType="text/html; charset=UTF-8" %> 

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
img{
	width: 200px;
	height: 200px;
}
</style> 
<script type="text/javascript">
function incheck(f){
	if(f.filename.value==""){
		alert("파일을 선택하세요");
		f.filename.focus();
		return false;
	}
}

</script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">사진 수정</DIV>
 
<FORM name='frm' 
	  method='POST' 
	  action='./updateFileProc.do'
	  enctype="multipart/form-data"
	  onsubmit="return incheck(this)"
	  >
	  <input type="hidden" name="no" value="${param.no }">
	  <input type="hidden" name="col" value="${param.col }">
	  <input type="hidden" name="word" value="${param.word }">
	  <input type="hidden" name="nowPage" value="${param.nowPage }">
	  <input type="hidden" name="oldfile" value="${oldfile }">
  <TABLE>
    <TR>
      <TH>원본 파일</TH>
      <TD>
      <img src="${pageContext.request.contextPath }/views/team/storage/${oldfile }" style="width: 500px; height: 450px;"><br>
      	원본 파일명:${oldfile }
      </TD>
    </TR>

    <TR>
      <TH>변경파일</TH>
      <TD><input type="file" name="filename" accept=".gif, .jpg, .png, .GIF, .JPG, .PNG"></TD>
    </TR>

    <TR>
      <TH></TH>
      <TD></TD>
    </TR>
  </TABLE>
  
  <DIV class='bottom'>
    <input type='submit' value='변경'>
    <input type='button' value='취소' onclick="history.back()">
  </DIV>
</FORM>
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html> 