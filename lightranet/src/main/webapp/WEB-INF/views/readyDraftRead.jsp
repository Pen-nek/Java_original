<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %> --%>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">임시저장 문서</h1>
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
												<input type="text" name="d_id" class="form-control" value="${draft.d_id}" readonly>
											</div>
											
											<label class="col-form-label col-sm-2 text-sm-right" style = "font-weight: bold;">
												작성자
											</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.writer_dept}" readonly>
											</div>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.writer_name}" readonly>
											</div>
										
										</div>
										
										<div class="form-group row">
											
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
											
											<div class = "col-sm-1">
												<label class="custom-control custom-checkbox m-1">
													<span class="custom-control-label text-sm-right">전결</span>
												</label>
												<input type="checkbox" class="custom-control-input">
											</div>
											
										</div>
										
										
										<div class="form-group row">
											
											<label class="col-form-label col-sm-4 text-sm-right" style = "font-weight: bold;">
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
											<button id="btnSave" type="submit" class="btn btn-primary" formaction="/saveReadyDraft">
												임시저장
											</button>
											
											<button id="btnRegist" type="submit" class="btn btn-info" formaction="/registReadyDraft">
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
			
			// 전결 체크박스가 눌리면
			$('#jumpFinal').click(function() {
				
				// 체크되어 있을 때는
				if (document.getElementById('jumpFinal').checked) {
					$("#deptListFinal").hide();
					$("#nameListFinal").hide();
					$("#nameListFinal").val(null);
					$("#jumpFinal").val(true);
				} 
				// 체크 안 돼있을 때는
				else {
					$("#deptListFinal").show();
					$("#nameListFinal").show();
					$("#jumpFinal").val(false);
				}
				
				console.log("전결여부 : " + $('#jumpFinal').val());
				
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
			
		});
		
		
		$(function () {
			
			// Datatables basic
			$("#datatables-basic").DataTable({
				responsive: true
			});
		});
		
	</script>

<%@include file="includes/footer.jsp"%>