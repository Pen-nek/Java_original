<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지전송</title>
<link rel="preconnect" href="//fonts.gstatic.com/">
<link href="resources/css/classic.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
	<main class="content">
	<div class="container-fluid p-0">
		<h1 class="h3 mb-3">쪽지전송</h1>
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-body">
						<form role="form" action="/newNoteForm" method="post">
							<div class="form-group row">
								<input type="hidden" id="userId" name="userId" value="${sessionScope.userId}"><!-- 로그인한 아이디세션 -->
								<label class="col-form-label col-sm-1 text-sm-right"
									style="font-weight: bold;">받는이</label>
								<div class="col-sm-2" style="padding-bottom: 10px;">
									<input type="text" class="form-control" value='${dept_name}'
										readonly="readonly">
								</div>
								<div class="col-sm-2" style="padding-bottom: 10px;">
									<input type="text" class="form-control" value='${e_name}' name="e_name"
										readonly="readonly">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-1 text-sm-right"
									style="font-weight: bold;">내용</label><br>
								<div class="col-sm-5">
									<textarea class="form-control" rows="10" cols="150"
										name="n_content"></textarea>
								</div>
							</div>

							<div class="col-sm-10 mg-sm-auto" id="btn">
								<button id="sendbtn" name="sendbtn" type="submit" class="btn btn-primary">전송</button>
							</div>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	
	<script>
	$(document).ready(function() {
		$("#sendbtn").click(function(){
			alert("답장성공!");
			self.close();
		});
	});
	</script>
</body>
</html>



