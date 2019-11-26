<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Responsive Bootstrap 4 Admin &amp; Dashboard Template">
   <meta name="author" content="Bootlab">

   <title>Lightranet</title>

   <link rel="preconnect" href="//fonts.gstatic.com/" crossorigin>
   <!-- <link href="css/classic.css" rel="stylesheet"> -->

   <style>
      body {
         opacity: 0;
      }
      .sidebar-item h2, .sidebar-link h4, .sidebar-header h2 { 
         color:white;
      }
      .sidebar-link h3{
         color:white;
         padding:10px 10px;
      }
      /* css에서 html태그의 속성까지 셀렉트하는 방법 */
      input[readonly] {
       	background : white;
      }
   </style>
   
   <script src="/resources/js/settings.js"></script>
   
</head>

<body>
   <div class="wrapper">
      <nav id="sidebar" class="sidebar sidebar-sticky">
         <div class="sidebar-content ">
            <img src="/resources/img/logo.png">
            
            <ul class="sidebar-nav" style="padding-left: 0px;">
               <li class="sidebar-header">
                  <h2>전자결재</h2>
               </li>
            
               <li class="sidebar-item">
                  <a class="sidebar-link" href="/registDraft"><h3>기안하기</h3></a>
               </li>
               
               <li class="sidebar-item">
                  <a href="#dashboards" data-toggle="collapse" class="sidebar-link collapsed">
                     <span class="align-middle"><h3>내문서함</h3></span>
                  </a>
                  
                  <ul id="dashboards" class="sidebar-dropdown list-unstyled collapse show" > <!-- data-parent="#sidebar" -->
                     <li class="sidebar-item"><a class="sidebar-link pl10" 
                        href="/goingDraft"><h4>진행문서함</h4></a></li>
                     <li class="sidebar-item"><a class="sidebar-link pl10" 
                        href="/readyDraft"><h4>임시보관함</h4></a></li>
                     <li class="sidebar-item"><a class="sidebar-link pl10" 
                        href="/returnDraft"><h4>반려기록함</h4></a></li>
                     <li class="sidebar-item"><a class="sidebar-link pl10" 
                        href="/finishedDraft"><h4>결재완료문서함</h4></a></li>
                  </ul>
                  
               </li>
                  
               <li class="sidebar-item">
                  <a href="/deptDraft" class="sidebar-link">
                  <span class="align-middle"><h3>부서완료문서함</h3></span></a>
               </li>
               
               <li class="sidebar-item">
                  <a class="sidebar-link" href="/calendar"><h2>일정</h2></a>
               </li>
               
               <li class="sidebar-item">
               
                  <a href="#ui" data-toggle="collapse" class="sidebar-link collapsed">
                     <!--<i class="align-middle" data-feather="grid"></i>-->
                     <span class="align-middle"><h2>쪽지</h2></span>
                  </a>
                  
                  <ul id="ui" class="sidebar-dropdown list-unstyled collapse " data-parent="#sidebar">
                     <li class="sidebar-item"><a class="sidebar-link pl10" href="/noteForm"><h4>쪽지전송</h4></a></li>
                     <li class="sidebar-item"><a class="sidebar-link pl10" href="/receiveNote"><h4>받은쪽지함</h4></a></li>
                     <li class="sidebar-item"><a class="sidebar-link pl10" href="/sendedNote"><h4>보낸쪽지함</h4></a></li>
                  </ul>
                     
               </li>
               
               <li class="sidebar-item">
                  <c:if test="${sessionScope.userName == 'admin'}">
            	      <a class="sidebar-link" href="/memberList"><h2 style="color: tomato">사원관리</h2></a>
                  </c:if>
                  <c:if test="${sessionScope.userName != 'admin'}">
            	      <a class="sidebar-link" href="/mypage"><h2>마이페이지</h2></a>
                  </c:if>
               </li>
            </ul>
         </div>
      </nav>
                  
      <div class="main">
         <nav class="navbar navbar-expand navbar-light bg-white">
            <a class="sidebar-toggle d-flex mr-2">
               <i class="hamburger align-self-center"></i>
            </a>
            
            <form class="form-inline d-none d-sm-inline-block">
            </form>
   
            <div class="navbar-collapse collapse">
               <ul class="navbar-nav ml-auto">
               		<li class="nav-item dropdown">
						<a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-toggle="dropdown">
			               <i class="align-middle" data-feather="settings"></i>
			             </a>

						<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-toggle="dropdown">
							<!-- 세션에 저장된 값을 jstl로 불러오는 방법 -->
							<span class="text-dark">
								<c:out value="${sessionScope.userName}"/>님 환영합니다.
							</span> 
			            </a>
			             
						<div class="dropdown-menu dropdown-menu-right">
							<a class="dropdown-item" href="/mypage">개인정보 수정</a>
							<a class="dropdown-item" href="/login/logout">로그아웃</a>
						</div>
					</li>
               </ul>
            </div>
         </nav>