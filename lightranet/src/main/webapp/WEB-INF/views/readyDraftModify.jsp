<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %> --%>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">임시저장 수정</h1>
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<form role="form" method="post">
									
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												기안번호
											</label>
											<div class="col-sm-1">
												<input type="text" class="form-control" value="${draft.d_id}" readonly>
											</div>
											
											
											
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												기안일시
											</label>
											<div class="col-sm-2">
												<!-- java 원하는 포맷으로 오늘 날짜 불러오기 -->
												<%
													java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
													String today = formatter.format(new java.util.Date());
												%>
												<input type="text" class="form-control" value="<%=today%>" readonly>
											</div>
											
											
											
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												작성자
											</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.writer_name}" readonly>
											</div>
										</div>
										
										
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												중간결재자
											</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<select id="deptListMid" class="form-control" >
													<option selected>${draft.midApprover_dept}</option>
													<c:forEach items="${getDeptList}" var="dept">
														<option><c:out value="${dept.dept_name}"/></option>
													</c:forEach>
												</select>
											</div>
											
											<div class = "col-sm-2">
												<select id="nameListMid" name="d_midApprover" class="form-control">
													<option value="${draft.midApprover_id}" selected>${draft.midApprover_name}</option>
												</select>
											</div>
											현재 중간결재자 id값 : <c:out value="${draft.d_midApprover}"/>
											<div class = "col-sm-3">
												<label class="custom-control custom-checkbox m-1">
													<span class="custom-control-label text-sm-right">전결</span>
												</label>
												<input type="checkbox" class="custom-control-input">
											</div>
										</div>
										
										
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												최종결재자
											</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<select id="deptListFinal" class="form-control" >
													<option selected>${draft.finalApprover_dept}</option>
													<c:forEach items="${getDeptList}" var="dept">
														<option><c:out value="${dept.dept_name}"/></option>
													</c:forEach>
												</select>
											</div>
											
											<div class = "col-sm-2">
												<select id="nameListFinal" name="d_finalApprover" class="form-control">
													<option value="${draft.finalApprover_id}" selected>${draft.finalApprover_name}</option>
												</select>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												제목
											</label>
											<div class="col-sm-8">
												<input type="text" name="d_title" value="${draft.d_title}" class="form-control"> 
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">
												내용
											</label><br>
											<div class="col-sm-8">
												<textarea name="d_content" class="form-control" rows="20" cols="150">${draft.d_content}</textarea>
											</div>
										</div>
										
										<div class="col-sm-10 mg-sm-auto" id="btn">
											<button id="btnSave" type="submit" class="btn btn-primary" formaction="/readyDraft">
												임시저장
											</button>
											
											<button id="btnRegist" type="submit" class="btn btn-info" formaction="/readyDraftRead">
												기안하기
											</button>
											
											<button id="btnList" type="button" class="btn btn-primary" onclick="location.href='/readyDraft'">
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
	


	<!-- 없어야 메뉴가 여닫힘 -->
	<!-- <script src="../../resources/js/app.js"></script>	 -->
	
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
			
 			$('#nameListMid').change(function(){
				console.log("선택 후 중간결재자 id 값" + $("#nameListMid").val());
				
			});
			
			$('#nameListFinal').change(function(){
				console.log($("#nameListFinal").val());
			});
			
		});
		
		
		$(function () {
			
			// 임시보관 버튼 기능
			$("#btnSave").click(function() {
				location.href = '/goingDraft';
			});
			
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