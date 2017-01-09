<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="model.memo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function mcreate() {
		var url = "create.do";
		location.href = url;
	}

	function mupdate(memono) {
		var url = "update.do";
		url += "?memono=" + memono;
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";
		location.href = url;
	}

	function mdelete(memono) {
		var url = "deleteProc.do";
		url += "?memono=" + memono;
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";
		location.href = url;
	}

	function mlist() {
		var url = "list.do";
		url += "?col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";
		location.href = url;
	}
</script>
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 24px; 
}
</style> 
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
	<div id="w">
		<div class="title"><h3>메모 조회</h3></div>
		<table>
			<tr>
				<th class="table-bordered th">제목</th>
				<td class="table-bordered td">${dto.title }</td>
			</tr>
			<tr>
				<th class="table-bordered th">내용</th>
				<td class="table-bordered td">${dto.content }</td>
			</tr>
			<tr>
				<th class="table-bordered th">조회수</th>
				<td class="table-bordered td">${dto.viewcnt }</td>
			</tr>
			<tr>
				<th class="table-bordered th">등록일</th>
				<td class="table-bordered td">${dto.wdate }</td>
			</tr>
		</table>
		<div class="bottom">
			<input type="button" value="등록" class="button" onclick="mcreate()">
			<input type="button" value="수정" class="button"	onclick="mupdate('${dto.memono}')"> 
			<input type="button" value="삭제" class="button" onclick="mdelete('${dto.memono}')"> 
			<input type="button" value="목록" class="button" onclick="mlist()">
		</div>
	</div>
</body>
</html>

