<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %> --%>

<script>

</script>
<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">기안문서 조회</h1>
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
								
									<form name="goingDraftReadForm" id="goingDraftReadForm" role="form" method="post">
										<div class="form-group row">
										
											<label class="col-form-label col-sm-1 text-sm-right" style = "font-weight: bold;">기안번호</label>
											<div class="col-sm-2">
												<input type="text" name="d_id" class="form-control" value="${draft.d_id}" readonly>
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
												<input type="datetime" id="d_writeDate" name="d_writeDate" class="form-control" value="${draft.d_writeDate}" readonly>
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
											
											<label class="col-form-label col-sm-5 text-sm-right" style = "font-weight: bold;">최종결재자</label>
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
										
										<input type="hidden" name="finalApprover_id" value="${draft.finalApprover_id}">
										<input type="hidden" name="r_employee" value="${draft.writer_id}">
										
										<div class="col-sm-10 mg-sm-auto" id="btn">
											
											<!-- 접속유저id와 글쓴이/중간결재자/최종결재자 포맷팅. String타입으로 저장 -->
											<!-- 세션값과 파라미터로 가져온 값은 포맷이 다르므로 그냥 값 비교하면 안 됨 -->
											<fmt:formatNumber value="${sessionScope.userId}" type="number" var="userId"/>
											<fmt:formatNumber value="${draft.writer_id}" type="number" var="writer_id"/>
											<fmt:formatNumber value="${draft.midApprover_id}" type="number" var="midApprover_id"/>
											<fmt:formatNumber value="${draft.finalApprover_id}" type="number" var="finalApprover_id"/>
											
											<!-- 작성자일 때 -->
											<c:if test="${userId == writer_id && draft.d_process == '1차진행중'}">
                                    			<button id="btnSave" type="submit" class="btn btn-danger" formaction="/backDraftGo">회수</button>
                               				</c:if>
										
											<!-- 중간결재자일 때 -->
											<c:if test="${userId == midApprover_id}">
												<button id="btnMidOk" type="submit" class="btn btn-success" formaction="/goingDraftMidOk">
													승인
												</button>
												<button id="btnNo" type="button" class="btn btn-danger">
													반려
												</button>
											</c:if>
											
											<!-- 최종결재자일 때 -->
											<c:if test="${userId == finalApprover_id}">
												<button id="btnFinalOk" type="submit" class="btn btn-success" formaction="/goingDraftFinalOk">
													승인
												</button>
												<button id="btnNo" type="button" class="btn btn-danger">
													반려
												</button>
											</c:if>
										
											<button id="btnList" type="button" class="btn btn-primary" 
												onclick="location.href='/goingDraft'">
												목록으로
											</button>
										</div>
									
										
			<!-- 모달 시작 -->
			<div class="modal fade" id="returnModal" tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" style = "font-weight: bold;">반려사유</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body m-3">
							<textarea id="r_content" name="r_content" class="form-control" placeholder="내용을 입력해주세요." rows="5" cols="150"></textarea>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="r_id" value="${draft.d_id}">
							<input type="hidden" name="r_returner" value="${userId}">
							<button type="submit" class="btn btn-success" formaction="/goingDraftNo">확인</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 모달 끝 -->
			
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
	
/* 	document.goingDraftReadForm.date.value.split("T").join(""); */
	
		$(document).ready(function() {
			
			// 모달 띄우기
			$("#btnNo").click(function() {
				
				$("#returnModal").modal("show");
			});
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