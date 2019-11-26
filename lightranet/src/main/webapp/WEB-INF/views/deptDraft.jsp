<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<%@include file="includes/header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<h1 class="h3 mb-3">부서완료문서함</h1>
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-body">
						<table id="datatables-basic" class="table table-striped"
							style="width: 100%;">
							<thead>
								<tr>
									<th>문서번호</th>
									<th>제목</th>
									<th>기안자</th>
									<th>기안일시</th>
									<th>결재완료일시</th>
									<th>부서</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${deptdraftlist}" var="draft">
									<tr>
										<td><c:out value="${draft.d_id}" /></td>
										<td><a href='/deptDraftRead?d_id=${draft.d_id}'><c:out value="${draft.d_title}"/></a></td>
										<td><c:out value="${draft.writer_name}" /></td>
										<td><c:out value="${draft.d_writeDate}"/></td>
										<td><c:out value="${draft.d_approvedate}"/></td>
										<td><c:out value="${draft.dept_name}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</main>
<script>
	$(function() {
		// Datatables basic
		$("#datatables-basic").DataTable({
			responsive : true
		});
	});
</script>


<%@include file="includes/footer.jsp"%>
