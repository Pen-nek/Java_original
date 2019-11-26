<%@ page import="java.util.Locale"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">임시보관함</h1>
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
													<th>진행상태</th>
												</tr>
											</thead>
											
											<c:forEach items="${readyDraftList}" var="draft">
												<tr>
													<td><c:out value="${draft.d_id}"/></td>
													<td><a href='/readyDraftRead?d_id=${draft.d_id}'><c:out value="${draft.d_title}"/></a></td>
													<td><c:out value="${draft.writer_name}"/></td>
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
			
	<!-- 모달 시작 -->
	<div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">성공</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	             <span aria-hidden="true">&times;</span>
	           </button>
				</div>
				<div class="modal-body m-3">
					<p class="mb-0">내용 없음</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 모달 끝 -->
			
<script>
	
	// 모달 띄우기
	$(document).ready(function() {		
		
		// 이전창에서 결과값 받기
		var result = '<c:out value="${result}"/>';
		
		// 결과 넣어 메서드 돌리기
		checkModal(result);
		
		// 히스토리 생성
		history.replaceState({},null,null);
		
		function checkModal(result) {
			
			// 결과값이 없거나 히스토리가 있을 때는 넘어가기
			if (result === '' || history.state) {
				return;
			}
			
			// 결과가 있으면 값에 따라 모달창 내용 바꾸기
			switch (result) {
			
			case 'saveDraftSuccess' :
				$(".modal-body").html("임시저장에 성공하였습니다.");
				break;
				
			case 'modSaveDraftSuccess' :
				$(".modal-body").html("임시저장된 기안을 수정하였습니다.");
				break;
				
			}
			
			// 모달창 띄우기
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