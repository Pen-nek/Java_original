<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %> --%>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">부서문서 조회</h1>
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<form role="form" action="/deptDraftRead" method="get">
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">기안번호</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.d_id}" readonly>
											</div>
											
											<label class="col-form-label col-sm-2 text-sm-right" style = "font-weight: bold;">작성자</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.writer_dept}" readonly>
											</div>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.writer_name}" readonly>
											</div>
											
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">기안일시</label>
											<div class="col-sm-2">
												<!-- 날짜와 시간 사이 T 없애야 함 -->
												<input type="text" class="form-control" value="${draft.d_writeDate}"
												pattern="yyyy-MM-dd HH:mm:ss" readonly>
											</div>
											
											<label class="col-form-label col-sm-2 text-sm-right" style = "font-weight: bold;">중간결재자</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<input type="text" class="form-control" value="${draft.midApprover_dept}" readonly>
											</div>
											
											<div class = "col-sm-2">
												<input type="text" class="form-control" value="${draft.midApprover_name}" readonly>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">결재완료일시</label>
											<div class="col-sm-2">
												<input type="text" class="form-control" value="${draft.d_approvedate}" readonly>
											</div>
											
											<label class="col-form-label col-sm-2 text-sm-right" style = "font-weight: bold;">최종결재자</label>
											<div class = "col-sm-2" style = "padding-bottom: 10px;"> 
												<input type="text" class="form-control" value="${draft.finalApprover_dept}" readonly>
											</div>
											
											<div class = "col-sm-2">
												<input type="text" class="form-control" value="${draft.finalApprover_name}" readonly>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">제목</label>
											<div class="col-sm-8">
												<input type="text" value="${draft.d_title}" class="form-control" readonly> 
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">내용</label><br>
											<div class="col-sm-8">
												<textarea class="form-control" rows="20" cols="150" readonly>${draft.d_content}</textarea>
											</div>
										</div>
										
										<div class="col-sm-10 mg-sm-auto" id="btn">
											<button id="btnList" type="button" class="btn btn-primary" onclick="location.href='/deptDraft'">
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