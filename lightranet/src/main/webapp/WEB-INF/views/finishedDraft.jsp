<%@ page import="java.util.Locale"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">결재완료문서함</h1>
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-body">
											
										<table id="datatables-basic" class="table table-striped" style="width:100%">
											<thead>
												<tr>
													<th>문서번호</th>
													<th>제목</th>
													<th>작성자</th>
													<th>작성일시</th>
													<th>결재완료일시</th>
													<th>진행상태</th>
												</tr>
											</thead>
											
											<c:forEach items="${finishedDraftList}" var="draft">
												<tr>
													<td><c:out value="${draft.d_id}"/></td>
													<td><a href='/finishedDraftRead?d_id=${draft.d_id}'><c:out value="${draft.d_title}"/></a></td>
													<td><c:out value="${draft.writer_name}"/></td>
													<td><c:out value="${draft.d_writeDate}"/></td>
													<td><c:out value="${draft.d_approvedate}"/></td>
													<td><c:out value="${draft.d_process}"/></td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			
			<!-- 모달 추가하기 -->
		<div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">기안 성공</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		             <span aria-hidden="true">&times;</span>
		           </button>
					</div>
					<div class="modal-body m-3">
						<p class="mb-0">기안 작성에 성공하셨습니다.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		<!-- END success modal -->
						
						
			
	<script>
	
		// 모달 띄우기
		$(document).ready(function() {		
			
			var result = '<c:out value="${result}"/>';
			checkModal(result);
			
			history.replaceState({},null,null);
			
			function checkModal(result) {
				
				if (result === '' || history.state) {
					return;
				}
				
				if (result > 0) {
					$(".mb-0").html("기안번호" + result + "번이 등록되었습니다.");
				}
				
				$("#successModal").modal("show");
			}
		});
	
		$(function() {
			// Datatables basic
			$("#datatables-basic").DataTable({
				responsive: true
			});
		});
	</script>

	<%@include file="includes/footer.jsp"%>