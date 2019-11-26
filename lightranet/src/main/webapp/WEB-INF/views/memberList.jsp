<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="includes/header.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<main class="content">
<div class="container-fluid p-0">
	<div class = "container-fluid p-0">
	<h1 class="h3 mb-3">사원 목록 <button id="memRegBtn" type="submit" class="btn btn-success btn-sm pull-right">사원등록</button> </h1>
	</div>
	<div class="row">
		<div class="col-12">
			<div class="card">
			
				<div class="card-body">
				
					<table id="datatables-basic" class="table table-striped"
						style="width: 100%">
						 
						<thead>
							<tr>
								<th>번호</th>
								<th>부서</th>
								<th>직위</th>
								<th>이름</th>
								<th>이메일</th>
								<th>핸드폰 번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${memberList}" var="adminMember">
							<tr>
								
								<td><c:out value="${adminMember.e_id}" /></td>
								<td><c:out value="${adminMember.dept_name}" /></td>
								<td><c:out value="${adminMember.e_position}" /></td>
								<td><a href = '/adminMemberRUD?e_id=<c:out value = "${adminMember.e_id}"/>' onclick="window.open(this.href, '_blank','width=500,height=800,toolbars=no,scrollbars=no'); return false;"><c:out value="${adminMember.e_name}" /></a></td>
								<td><c:out value="${adminMember.e_email}" /></td>
								<td><c:out value="${adminMember.e_phone}" /></td>
								
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
			responsive: true
		});
		
 		$("#memRegBtn").click(function(){
 			/* self.location="/adminMemberAdd"; */
 			
  			var url="/adminMemberAdd"
			window.open(url, "", "location=no, menubar=no, status=0, toolbar=0, width=500, height=600, resizable=yes");
		});
 		
/*  		$("#rud").click(function(){
 			
 			
  			var url="/adminMemberRUD"
			window.open(url, "", "location=no, menubar=no, status=0, toolbar=0, width=500, height=600, resizable=yes");
		}); */
	});
</script>



<%@include file="includes/footer.jsp"%>
