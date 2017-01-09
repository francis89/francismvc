<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.img {
	width: 100%;
	height: 55%;
}

li#admin {
	float: right;
	padding-right: 30px;
}

body {
	background-color: black;
}
</style>
</head>
<body>
	<!-- 상단 메뉴 -->
	<div style="background-color: white;">
		<table style="width: 100%">
			<tr>
				<td><img class="img"
					src="${pageContext.request.contextPath }/menu/images/marvel_1.jpg">
				</td>
			</tr>
		</table>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/index.jsp">Home</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<c:choose>
							<c:when test="${empty sessionScope.id }">
								<li><a
									href="${pageContext.request.contextPath }/member/agreement.jsp">회원가입</a></li>
							</c:when>
							<c:when
								test="${not empty sessionScope.id && sessionScope.grade == 'H' }">
								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> 정보확인 <span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<li><a
											href="${pageContext.request.contextPath }/member/read.do">나의정보</a></li>
										<li><a
											href="${pageContext.request.contextPath }/member/update.do">회원수정</a></li>
										<li><a
											href="${pageContext.request.contextPath }/member/delete.do">회원탈퇴</a></li>
										<li><a
											href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></li>
									</ul></li>

							</c:when>
						</c:choose>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 게시판 <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a
									href="${pageContext.request.contextPath }/bbs/list.do">게시판목록</a></li>
								<li><a
									href="${pageContext.request.contextPath }/bbs/create.do">게시판생성</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 이미지게시판 <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a
									href="${pageContext.request.contextPath }/imgbbs/list.do">이미지
										목록</a></li>
								<li><a
									href="${pageContext.request.contextPath }/imgbbs/create.do">이미지
										등록</a></li>
							</ul></li>

						<li><a
							href="${pageContext.request.contextPath }/memo/list.do">방명록</a></li>

						<c:if
							test="${not empty sessionScope.id && sessionScope.grade=='A' }">
							<li><a
								href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></li>
							<li id="admin"><a
								href="${pageContext.request.contextPath }/admin/list.do">회원목록</a></li>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a
							href="${pageContext.request.contextPath }/member/login.do"> <span
								class="glyphicon glyphicon-log-in"></span> Login
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- 상단 메뉴 끝 -->



	<!-- 내용 시작 -->
	<div style="width: 100%; padding-top: 10px;">
		<div class="container-fluid text-center"
			style="background-color: #8B8A8A;">
			<div class="row content">
				<div class="col-sm-2 sidenav">
					<p>
						<a href="#">Link</a>
					</p>
					<p>
						<a href="#">Link</a>
					</p>
					<p>
						<a href="#">Link</a>
					</p>
				</div>
				<div class="col-sm-8 text-left">