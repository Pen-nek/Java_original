<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Responsive Bootstrap 4 Admin &amp; Dashboard Template">
<meta name="author" content="Bootlab">

<title>일정관리 추가</title>

<link rel="preconnect" href="//fonts.gstatic.com/" crossorigin>
<link href="resources/css/classic.css" rel="stylesheet">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>  
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
<script src="resources/js/app.js"></script>
<script src="/resources/js/settings.js"></script>

<style>
	body {
		opacity: 0;
	}
	
	#btn2 {
		margin-left: 20px;
	}
</style>

</head>

<body>
	<main class="content">
		<div class="container-fluid p-0">
			<h1 class="h3 mb-3">일정 추가</h1>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
                                 
								<form role="form" action="/addschedule" method="post">
								
								
								
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right" 
										style="font-weight: bold;">시작일자</label>
									<div class="col-sm-2">
										<input type="datetime-local" id="c_start" name="c_start" class="form-control">
									</div>
									
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">종료일자</label>
									<div class="col-sm-2">
										<input type="datetime-local" id="c_finish" name="c_finish" class="form-control">
									</div>
								</div>
	
								<div class="form-group row">
									<label class="col-form-label col-sm-1 text-sm-right"
										style="font-weight: bold;">종류</label>
									<div class="col-sm-6" style="padding-bottom: 10px;">
										<select id="inputState" name="c_category" class="form-control">
											<option selected>--선택--</option>
											<option>프로젝트</option>
											<option>휴가</option>
											<option>결재 관련</option>
											<option>세액 신고</option>
										</select>
									</div>
								</div>
	
								<div class="form-group row">
									<label class="col-form-label col-sm-1 text-sm-right"
										style="font-weight: bold;">내용</label><br>
									<div class="col-sm-6">
										<textarea class="form-control" name="c_content" placeholder="Textarea" rows="15"
											cols="50"></textarea>
									</div>
								</div>
	
								<div class="col-sm-10 mg-sm-auto" id="btn">
									<button onclick="btn1_click();" id="btn1" type="submit" class="btn btn-primary">등록</button>
									<button id="btn2" type="reset" class="btn btn-primary">Reset</button>
									<button id="btn3" type="submit" class="btn btn-primary" style="margin-left: 80px;">목록으로</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script>

	//등록 화면 클릭 후 
/* 	function btn1_click() {
		$("#updateForm").action("/eventschedule");
		$("#updateForm").submit();
	} */

			
	$(function (){ // 화면 로드되면서 실행
		if("${msg}"){
			alert("${msg}");
			opener.fn_refresh();
			window.close();
		}
	});
	</script>
	
	<%@include file="includes/footer.jsp"%>