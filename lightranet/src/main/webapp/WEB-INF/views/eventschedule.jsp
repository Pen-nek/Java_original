<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

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

<title>일정관리 수정</title>

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


<script type="text/javascript">
/* String a = "yyyy-MM-ddThh:mm:ss"; */
/*    $(document).ready(
         function() {

            $("#fileInput").on(
                  'change',
                  function() { // 값이 변경되면
                     if (window.FileReader) { // modern browser
                        var filename = $(this)[0].files[0].name;
                     } else { // old IE
                        var filename = $(this).val().split('/').pop()
                              .split('\\').pop(); // 파일명만 추출
                     }
                     // 추출한 파일명 삽입
                     $("#userfile").val(filename);
                  });
         }); */
</script>
${msg}
	<main class="content">
		<div class="container-fluid p-0">
			<h1 class="h3 mb-3">일정 수정</h1>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							
							<form name="updateForm" id="updateForm" role="form" action="/eventschedule?c_id=<c:out value="${calendar.c_id}"/>" method="post">
							<input type="hidden" name="flag" id="flag" />
								
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right" 
										style="font-weight: bold;">시작일자</label>
									<div class="col-sm-2">
										<%-- <fmt:parseDate value="${calendar.c_start}" var="parseStartDate" pattern="yyyy-MM-dd'T'HH:mm" scope="page"/> --%>
										<%-- ${parseStartDate} --%>
										<%--
										https://esckey.tistory.com/68
										https://maxim365.tistory.com/194
										 --%>
										
										 <%-- <input type="datetime" name="c_start" class="form-control  datetime-local" value="${calendar.c_start}"> --%>
										<input type="datetime-local" name="c_start" class="form-control datetime_local" value="${calendar.c_start}">
								<%-- 	 	${startDate} 
										test : ${calendar.c_start}  --%>
									</div>
									
									
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">종료일자</label>
									<div class="col-sm-2">
										<input type="datetime-local" name="c_finish" class="form-control  datetime-local" value="${calendar.c_finish}">
										
									</div>
								</div>
	
								<div class="form-group row">
									<label class="col-form-label col-sm-1 text-sm-right"
										style="font-weight: bold;">종류</label>
									<div class="col-sm-6" style="padding-bottom: 10px;">
										<select id="inputState" name="c_category" class="form-control">
											<option selected>${calendar.c_category}</option>
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
											cols="50">${calendar.c_content}</textarea>
									</div>
								</div>
	
								<div class="col-sm-10 mg-sm-auto" id="btn">
									<button onclick="btn1_click();" id="btn1" class="btn btn-primary">수정</button><!-- type="submit" -->
									<button onclick="btn2_click();" id="btn2" class="btn btn-danger">삭제</button>
									<button id="btn3" type="submit" class="btn btn-primary" style="margin-left: 80px;">목록으로</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<script type="text/javascript">
	
		//수정 화면 클릭 후 
		function btn1_click() {
			$("#flag").val("U");
			$("#updateForm").action("/eventschedule");
			$("#updateForm").submit();
			
		}
		function btn2_click() {
			$("#flag").val("D");
			$("#updateForm").action("/eventschedule");
			$("#updateForm").submit();
		}
			
		$(function (){ // 화면 로드되면서 실행
			if("${msg}"){
				alert("${msg}");
				opener.fn_refresh();
				window.close();
			}
			/*
			// Datatables basic
			$("#datatables-basic").DataTable({
				responsive: true
			});
			// Datatables with Buttons
			var datatablesButtons = $("#datatables-buttons").DataTable({
				responsive: true,
				lengthChange: !1,
				buttons: ["copy", "print"]
			});
			datatablesButtons.buttons().container().appendTo("#datatables-buttons_wrapper .col-md-6:eq(0)");
			// Datatables with Multiselect
			var datatablesMulti = $("#datatables-basic").DataTable({
				responsive: true,
				select: {
					style: "multi"
				}
			}); */
		});
		 	
	</script>
	
	<%@include file="includes/footer.jsp"%>