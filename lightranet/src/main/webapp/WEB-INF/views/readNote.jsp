<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link href="resources/css/classic.css" rel="stylesheet">
<main class="content">
<div class="container-fluid p-0">
	<h1 class="h3 mb-3">쪽지내용</h1>
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<form>
						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right"
								style="font-weight: bold;">보낸이</label>
							<div class="col-sm-1">
								<input type="text" class="form-control"
									value='<c:out value="${note.dept_name} "/>' readonly="readonly"
									style="background: white;">
							</div>
							<div class="col-sm-1">
								<input type="text" class="form-control"
									value='<c:out value="${note.e_name} "/>' readonly="readonly"
									style="background: white;">
							</div>
							<div class="col-sm-1">
								<input type="hidden" class="form-control" value='<c:out value="${note.n_id} "/>' name="n_id">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-sm-1 text-sm-right"
								style="font-weight: bold;">내용</label><br>
							<div class="col-sm-6">
								<input type="text" class="form-control"
									value='<c:out value="${note.n_content} "/>' readonly="readonly"
									style="background: white;">
							</div>
						</div>
						
						<input type="hidden" name="noteId" value="<c:out value='${note.n_id}'/>">

						<div class="col-sm-10 mg-sm-auto" id="btn">
							<button type="button" id="close" class="btn btn-secondary">닫기</button>
							<button type="submit" id="btn1" class="btn btn-primary"
								onclick="window.open('/newNoteForm?e_name=<c:out value="${note.e_name}" />&dept_name=<c:out value="${note.dept_name}"/>','read','width=500 height=500, left=400, top=300');return false">답장</button>
						</div>
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


<script>
      $(function(){
         $("#close").click(function(){
        	
        	//창을 닫는다.
            self.close();
         });

      });
</script>
