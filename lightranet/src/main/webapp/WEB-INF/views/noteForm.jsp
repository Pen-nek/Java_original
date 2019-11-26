<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<main class="content">
<div class="container-fluid p-0">
	<h1 class="h3 mb-3">쪽지전송</h1>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form role="form" action="/noteForm" method="post">
						<div class="form-group row">
						<input type="hidden" id="userId" name="userId" value="${sessionScope.userId}">
							<label class="col-form-label col-sm-1 text-sm-right"
								style="font-weight: bold;">받는이</label>
							<div class="col-sm-2" style="padding-bottom: 10px;">
								<select id="deptList" class="form-control">
									<option selected>부서</option>
									<c:forEach items="${getReceiverDept}" var="dept">
										<option value="${dept.dept_name}"><c:out value="${dept.dept_name}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2" style="padding-bottom: 10px;">
								<select id="nameList" name="n_receiver" class="form-control">
									<option selected>이름</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" 
								style="font-weight: bold;">내용</label><br>
							<div class="col-sm-5">
								<textarea class="form-control" name="n_content" rows="10" cols="150"></textarea>
							</div>
						</div>

						<div class="col-sm-10 mg-sm-auto" id="btn">
							<button type="submit" id="btn1" class="btn btn-primary">전송</button>
						</div>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</main>

<!-- <script src="resources/js/app.js"></script> -->

<script>
	$(document).ready(function(){		
        // 중간결재자 부서 선택 시 DB에서 이름 불러오기
        $('#deptList').change(function(){
           
           var data = $(this).val();   // 선택된 부서 이름을 data에 저장한다
           var deptName = {deptName:data};   // deptName을 JSON형태로 만든다
           
           $.ajax({
              type : 'post',
              url : '/ajaxreceiver',
              data : deptName,
              datatype : 'json',
              // 전송 성공시 받는 데이터는 data에 저장
              success : function(data){
                 
                 var html ="<option>이름</option>";
                    for(var i=0; i<data.length; i++){
                        html +="<option value='" +data[i].e_id+ "'>"+data[i].e_name+"</option>";
                    }
                    $("#nameList").html(html);
              },
              error:function(){
                 alert("ajax 통신 실패");
              }
           });
        });
     // 중간결재자 선택 시 콘솔에 아이디값 받아오나 확인
		$('#nameList').change(function(){
			console.log("받는사람 id : " + $("#nameList").val());
		});
     
		$("#btn1").click(function(){
			alert("쪽지전송 성공!");
			self.close();
		});
	});
</script>

<script>
	$(function() {
		// Datatables basic
		$("#datatables-basic").DataTable({
			responsive : true
		});
	});
</script>


<%@include file="includes/footer.jsp"%>