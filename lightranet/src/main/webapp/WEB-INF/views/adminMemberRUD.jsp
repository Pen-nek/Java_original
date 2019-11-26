<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Responsive Bootstrap 4 Admin &amp; Dashboard Template">
   <meta name="author" content="Bootlab">

   <title>사원 정보 조회</title>

   <link rel="preconnect" href="//fonts.gstatic.com/" crossorigin>
   <link href="resources/css/classic.css" rel="stylesheet">
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  
<main class="content">
<div class="container-fluid p-0">
	<h1 class="h3 mb-3">사원 정보 조회</h1>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form role="form"  action="/adminMemberRUD" method="post">
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">이름</label>
							<div class="col-sm-2">
								<input type="hidden" class="form-control" value='<c:out value="${adminMember.e_id}"/>' name='e_id' id = 'e_id' readonly="readonly">
								<input type="text" class="form-control" value='<c:out value="${adminMember.e_name}"/>' name='e_name' id = 'e_name'>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">부서</label>
							<div class="col-sm-2">
								<select id="dept_choice" class="form-control" name="dept_id">
									<option selected value="${adminMember.dept_id}">${adminMember.dept_name}</option>
									<c:forEach items="${getDeptList}" var="dept">
										<option value="${dept.dept_id}"><c:out value="${dept.dept_name}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">직급</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" value='<c:out value="${adminMember.e_position}"/>' name='e_position' id = 'e_position'>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">전화번호</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" value='<c:out value="${adminMember.e_phone}"/>' name='e_phone' id = 'e_phone'>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">아이디</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" value='<c:out value="${adminMember.e_loginid}"/>' name='e_loginid' id ='e_loginid'>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">비밀번호</label>
							<div class="col-sm-2">
								<input type="password" class="form-control" value='<c:out value="${adminMember.e_loginpw}"/>' name='e_loginpw' id ='e_loginpw'>
							</div>
						</div>


						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right"
								style="font-weight: bold;">이메일</label>
							<div class="col-sm-2">
								<input type="email" name="e_email" id ="e_email" class="form-control" value='${adminMember.e_email}' required>
							</div>
						</div>

				
						<div class="col-sm-10 mg-sm-auto" id="btn">
							<button type="submit" data-oper = 'modify' class="btn btn-primary">수정</button>&nbsp;&nbsp;&nbsp; <!-- id="memModBtn" -->
							<button type="submit" data-oper = 'remove' class="btn btn-danger pull-right">삭제</button><!-- id="memDelBtn" -->
						</div>
					</form>
						
				</div>
			</div>
		</div>
	</div>
</div>
</main>


<script src="resources/js/app.js"></script>

<script>
		$(function () {
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
			});
		});
		
		$(document).ready(function(){
			
			var formObj = $("form");
			
			$('button').on("click", function(e){
				
				e.preventDefault();
				
				var operation = $(this).data("oper");
				
				console.log(operation);
				
				if(operation === 'remove'){
					formObj.attr("action", "adminMemberRemove");
				}
				formObj.submit();
				alert('처리가 완료되었습니다.');
				self.close();
 				
			});
			
		});
		
</script>
