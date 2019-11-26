<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="includes/header.jsp"%>
	
	<main class="content">
		<div class="container-fluid p-0">
			<h1 class="h3 mb-3" style="font-weight: bold;">마이페이지</h1>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<form role="form" action="/emp_modify" method="post">
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">이름</label>
									<div class="col-sm-3">
										<input type="text" class="form-control"
											value='${employee.e_name}'
											readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">부서</label>
									<div class="col-sm-3">
										<input type="text" class="form-control"
											value='${employee.dept_name}'
											readonly="readonly">
									</div>
								</div>
		
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">직급</label>
									<div class="col-sm-3">
										<input type="text" class="form-control"
											value='${employee.e_position}'
											readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">전화번호</label>
									<div class="col-sm-3">
										<input type="text" name="e_phone" class="form-control"
											value='${employee.e_phone}'
											style="background: white;">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">아이디</label>
									<div class="col-sm-3">
										<input type="text" class="form-control"
											value='${employee.e_loginid}'
											readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">비밀번호</label>
									<div class="col-sm-3">
										<input type="password" name="e_loginpw"
											class="form-control" required>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-form-label col-sm-2 text-sm-right"
										style="font-weight: bold;">이메일</label>
									<div class="col-sm-3">
										<input type="email" name="e_email" class="form-control"
											value='${employee.e_email}'>
									</div>
								</div>
		
								<input type="hidden" name="e_id" value="${sessionScope.userId}">
		
								<div class="col-sm-10 mg-sm-auto" id="btn">
									<button type="submit" class="btn btn-primary">수정</button>
								</div>
		
							</form>
		
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
<!-- 	<script src="resources/js/app.js"></script> -->
	
	<script type="text/javascript">
	
		$(function () {
			
			// Datatables basic
			$("#datatables-basic").DataTable({
				responsive: true
			});
		});
		

		$(document).ready(function() {
			
		    $("#fileInput").on('change',
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
		});
		
	</script>

	<%@include file="includes/footer.jsp"%>