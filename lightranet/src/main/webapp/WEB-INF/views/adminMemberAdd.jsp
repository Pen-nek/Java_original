<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Responsive Bootstrap 4 Admin &amp; Dashboard Template">
   <meta name="author" content="Bootlab">

   <title>사원 등록</title>

   <link rel="preconnect" href="//fonts.gstatic.com/" crossorigin>
   <link href="resources/css/classic.css" rel="stylesheet">
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>   

<body>
<main class="content">
<div class="container-fluid p-0">
	<h1 class="h3 mb-3">사원 등록</h1>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form role="form"  name="memAddForm"  action="/adminMemberAdd" method="post" ><!-- enctype="multipart/form-data"  -->
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">이름</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" name='e_name' id = 'e_name'>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right"
								style="font-weight: bold;">부서</label>
							<div class="col-sm-2">
								<select id="dept_choice" class="form-control" name="dept_id" id ="dept_id" >
									<option>부서 선택</option>
									<c:forEach var="dept" items="${getDeptList}">
										<option value="${dept.dept_id}"> ${dept.dept_name} </option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">직급</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" name='e_position' id = 'e_position'>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">전화번호</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" name='e_phone' id = 'e_phone'>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">아이디</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" name='e_loginid' id ='e_loginid' >
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">비밀번호</label>
							<div class="col-sm-2">
								<input type="password" class="form-control" name='e_loginpw' id ='e_loginpw' >
							</div>
						</div>
						
						<!-- 이메일 형식을 지키지 않으면 경고창이 떠야 함 -->
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right" style="font-weight: bold;">이메일</label>
							<div class="col-sm-2">
								<input type="email" name="e_email" id ="e_email" class="form-control" required>
							</div>
						</div>

						<div class="col-sm-10 mg-sm-auto" id="btn">
							<input type="button" class="btn btn-primary" onclick="check()" value = "등록">&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-primary pull-right">다시 작성 </button>&nbsp;&nbsp;&nbsp;
							<button type="reset" id = "close" class="btn btn-secondary">닫기 </button>
						</div>
					
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>
</main>


<script src="resources/js/app.js"></script>

<script>

	$(function(){
		
		$("#close").click(function(){
			self.close();
		});

	});
	
	function check(){

        var form = document.memAddForm;
      
       if(form.e_name.value == ""){
          alert("이름을 입력해주세요");
          form.e_name.focus();
          return false;
       } else if (form.dept_id.value == "부서 선택"){
          alert("부서를 선택해주세요");
          form.dept_id.focus();
          return false;
       } else if (form.e_position.value == ""){
          alert("직급을 입력해주세요");
          form.e_position.focus();
          return false;
       } else if (form.e_loginid.value == ""){
          alert("아이디 입력해주세요");
          form.e_loginid.focus();
          return false;
       } else if (form.e_loginpw.value == ""){
          alert("비밀번호 입력해주세요");
          form.e_loginpw.focus();
          return false;
       }
       
        form.submit();
        alert("사원 등록이 완료되었습니다.");
        window.close();   
       
    }


	
	

	
	

	
</script>

</body>
</html>
