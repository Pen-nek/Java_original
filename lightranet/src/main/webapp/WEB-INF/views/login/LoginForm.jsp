<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="ko">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Responsive Bootstrap 4 Admin &amp; Dashboard Template">
	<meta name="author" content="Bootlab">
	
	<title>Lightranet</title>
	
	<link rel="preconnect" href="//fonts.gstatic.com/" crossorigin>
	<link href="/resources/css/classic.css" rel="stylesheet">
	
	<script src="/resources/js/settings.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript">
	
	   $(function(){
	      if("${msg}"){
	         alert("${msg}");
	         location.href = "/login/LoginForm"; // main 페이지로 수정해주면 됨. 
	      }
	   });
	   
	   function login(){
	      $("#loginForm").attr("method","POST");
	      $("#loginForm").attr("action","/login/LoginCheck");
	      $("#loginForm").submit();
	   }
	</script>
</head>

<body>
   <main class="main d-flex w-100">
      <div class="container d-flex flex-column">
         <div class="row h-100">
            <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
               <div class="d-table-cell align-middle">
                  <div class="text-center mt-4">
                     <p class="lead">
                        <img src="/resources/img/logo-1.png">
                     </p>
                  </div>
                  <div class="card">
                     <div class="card-body">
                        <div class="m-sm-4">
                           <form name="loginForm" id="loginForm">
                              <div class="form-group">
                                 <label>아이디</label>
                                 <input class="form-control form-control-lg" type="text" name='loginId' id='loginId' placeholder="Enter your ID"
                                 	value="grim">
                              </div>
                              <div class="form-group">
                                 <label>비밀번호</label>
                                 <input class="form-control form-control-lg" type='password' name='loginPw' id='loginPw' placeholder="Enter your password"
                                 	value="1234">
                              </div>
                              <div class="text-center mt-3">
                                 <button type="submit" class="btn btn-lg btn-primary" onclick="login();">로그인</button>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>

               </div>
            </div>
         </div>
      </div>
   </main>

   <!-- <script src="js/app.js"></script> -->

</body>

</html>