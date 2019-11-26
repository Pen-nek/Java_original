<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">반려 기록</h1>
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<form role="form" method="post">
									
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												반려순번
											</label>
											<div class="col-sm-1">
												<input type="text" name="r_id" class="form-control" value="${back.r_id}" readonly>
											</div>
											
											<label class="col-form-label col-sm-2 text-sm-right" style = "font-weight: bold;">
												작성자
											</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<input type="text" class="form-control" value="${back.writer_dept}" readonly>
											</div>
											<div class = "col-sm-2">
												<input type="text" name="r_employee" class="form-control" value="${back.writer_name}" readonly>
											</div>
											
										</div>
										
										<div class="form-group row">
											
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												작성일시
											</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${back.d_writedate}" readonly>
											</div>
											
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												중간결재자
											</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<input type="text" class="form-control" value="${back.midApprover_dept}" readonly>
											</div>
											
											<div class = "col-sm-2">
												<!-- 반려자 이름과 중결 이름이 같으면 표시되게 -->
												<%-- <c:if test="${back.returner_name}" || "${back.midApprover_name}"> --%>
												<input type="text" class="form-control" value="${back.midApprover_name}" readonly>
											</div>
											
										</div>
										
										
										
										<div class="form-group row">
										
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												반려일시
											</label>
											<div class="col-sm-2">
												<javatime:format value="${back.r_returndate}" pattern="yyyy-MM-dd HH:mm:ss"/>
												<input type="text" class="form-control" value="${back.r_returndate}" readonly>
											</div>
											
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												최종결재자
											</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<input type="text" class="form-control" value="${back.finalApprover_dept}" readonly>
											</div>
											
											<div class = "col-sm-2">
												<input type="text" class="form-control" value="${back.finalApprover_name}" readonly>
											</div>
										</div>
										
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												제목
											</label>
											<div class="col-sm-8">
												<input type="text" name="d_title" value="${back.d_title}" class="form-control" readonly> 
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												내용
											</label><br>
											<div class="col-sm-8">
												<textarea name="d_content" class="form-control" rows="20" cols="150" readonly>${back.d_content}</textarea>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												반려사유
											</label><br>
											<div class="col-sm-8">
												<textarea name="d_content" class="form-control" rows="3" cols="150" readonly>${back.r_content}</textarea>
											</div>
										</div>
										
										<div class="col-sm-10 mg-sm-auto" id="btn">
											<button id="btnList" type="button" class="btn btn-primary" onclick="location.href='/returnDraft'">
												목록으로
											</button>
										</div>
										
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	</div>
	
	
	
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			// 중간결재자 부서 선택 시 DB에서 이름 불러오기
			$('#deptListMid').change(function(){
				
				var data = $(this).val();	// 선택된 부서 이름을 data에 저장한다
				var deptName = {deptName:data};	// deptName을 JSON형태로 만든다
				
				$.ajax({
					type : 'post',
					url : '/ajaxRegistDraft',
					data : deptName,
					datatype : 'json',
					// 전송 성공시 받는 데이터는 data에 저장
					success : function(data){
						
						var html ="<option>이름</option>";
			            for(var i=0; i<data.length; i++){
			                html +="<option value='" +data[i].e_id+ "'>"+data[i].e_name+"</option>";
			            }
			            $("#nameListMid").html(html);
					},
					error:function(){
						alert("ajax 통신 실패");
					}
				});
				
			});
			
			// 최종결재자 부서 선택 시 DB에서 이름 불러오기
			$('#deptListFinal').change(function(){
				
				var data = $(this).val();	// 선택된 부서 이름을 data에 저장한다
				var deptName = {deptName:data};	// deptName을 JSON형태로 만든다
				
				$.ajax({
					type : 'post',
					url : '/ajaxRegistDraft',
					data : deptName,
					datatype : 'json',
					// 전송 성공시 받는 데이터는 data에 저장
					success : function(data){
						var html ="<option>이름</option>";
			            for(var i=0; i<data.length; i++){
			                html +="<option value='" +data[i].e_id+ "'>"+data[i].e_name+"</option>";
			            }
			            $("#nameListFinal").html(html);
					},
					error:function(){
						alert("ajax 통신 실패");
					}
				});
			});
			
/* 			$('#nameListMid').change(function(){
				console.log($("#nameListMid").val());
			});
			
			$('#nameListFinal').change(function(){
				console.log($("#nameListFinal").val());
			}); */
			
		});
		
		
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
		
	</script>

<%@include file="includes/footer.jsp"%>