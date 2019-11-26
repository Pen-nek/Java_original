<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<%@include file="includes/header.jsp"%>

<main class="content">
<div class="container-fluid p-0">
	<h1 class="h3 mb-3">받은 쪽지함</h1>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
				<input type="hidden" id="userId" name="userId" value="${sessionScope.userId}">
					<table id="datatables-basic" class="table table-striped"
						style="width: 100%;">
						<thead>
							<tr>
								<th>부서</th>
								<th>보낸사람</th>
								<th>내용</th>
								<th>받은날짜</th>
								<th>수신여부</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="note">
								<tr>
									<td><c:out value="${note.dept_name }" /></td>
									<td><c:out value="${note.e_name }" /></td>
									<td><a href=# id="read" onclick="window.open('/readReceiveNote?n_id=<c:out value="${note.n_id} "/>','read','width=500 height=600, left=400, top=300');return false"><c:out value="${note.n_content }" /></a></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${note.n_sendtime }"/></td>
									<%-- <td><c:out value="${note.n_sendtime }" /></td> --%>
									<c:choose>
										<c:when test="${note.n_checked == 'true'}">
											<td>읽음</td>
										</c:when>
										<c:when test="${note.n_checked == 'false'}">
											<td>읽지 않음</td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
