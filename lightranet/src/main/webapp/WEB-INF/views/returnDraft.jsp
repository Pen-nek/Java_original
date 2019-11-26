<%@ page import="java.util.Locale"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<%@include file="includes/header.jsp"%>
			<main class="content">
				<div class="container-fluid p-0">
					<h1 class="h3 mb-3">반려기록함</h1>
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-body">
											
										<table id="datatables-basic" class="table table-striped" style="width:100%">
											<thead>
												<tr>
													<th>반려순번</th>
													<th>제목</th>
													<th>반려자</th>
													<th>반려일시</th>
													<th>반려사유</th>
													<th>문서번호</th>
												</tr>
											</thead>
											
											<!-- return과 같은 표현식을 변수명으로 쓰면 안 됨. 오류의 원인 -->
											<c:forEach items="${returnDraftList}" var="back">
												<tr>
													<td><c:out value="${back.r_id}"/></td>
													<td><a href='/returnDraftRead?r_id=${back.r_id}'><c:out value="${back.d_title}"/></a></td>
													<td><c:out value="${back.returner_name}"/></td>
													<td><javatime:format value="${back.r_returndate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
													<td><c:out value="${back.r_content}"/></td>
													<td><c:out value="${back.r_draft}"/></td>
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
			
	<script>
	
		$(function() {
			// Datatables basic
			$("#datatables-basic").DataTable({
				responsive: true
			});
		});
	</script>

	<%@include file="includes/footer.jsp"%>