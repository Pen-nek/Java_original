﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %> 
<html>

<head>
	<link rel="stylesheet" href="../resources/css/bootstrap.min.css"/>
	<script type="text/javascript" src="../resources/js/validation.js"></script>
	<title>회원가입</title>
</head>

<body>
	<jsp:include page="menu.jsp" />	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원가입</h1>
		</div>
	</div>
	
	<div class="container">
		<form name="newMember" action="./processAddMember.jsp" class="form-horizontal" method="post"> <%--  enctype="multipart/form-data" --%>
			
			<div class="form-group row">
				<label class="col-sm-2">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="userId" name="userId" class="form-control" >	<%-- 유효성 체크 --%>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="userPw" name="userPw" class="form-control" >	<%-- 유효성 체크 --%>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">이름</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" >	<%-- 유효성 체크 --%>
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">휴대폰번호</label>
				<div class="col-sm-3">
					<input type="text" name="phone" class="form-control" >
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">이메일</label>
				<div class="col-sm-3">
					<input type="text" id="email" name="email" class="form-control" >	
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-3">
					<input type="text" name="gender" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">생년월일</label>
				<div class="col-sm-3">
					<input type="date" name="birthDate" class="form-control" >
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">주소(도, 시)</label>
				<div class="col-sm-3">
					<input type="text" name="addr" class="form-control" >
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">주소(구)</label>
				<div class="col-sm-3">
					<input type="text" name="addr2" class="form-control" >
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">주소(동)</label>
				<div class="col-sm-3">
					<input type="text" name="addr3" class="form-control" >
				</div>
			</div>
			
				<%-- 가입일자 구하기 --%>
			<%!
				Date d = new Date();
				SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
			%>			
			
			<input type="hidden" name="registDate" value="<%=today%>">
			
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="button" class="btn btn-primary" value="등록" onclick="CheckAddMember()">
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>
