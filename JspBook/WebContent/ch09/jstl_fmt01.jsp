<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>internalization</title>
</head>

<body>
	<p>----------한국어 로케일------------
		<fmt:setLocale value="ko" />	<!-- 한글을 사용하겠다 -->
		<fmt:setBundle basename="bundle.myBundle" var="resourceBundle" />	<!-- basename : 프로퍼티 파일 주소. src폴더에서 시작함 / var : 프로퍼티 이름 지정 -- -->
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" />
	<p> <fmt:message key="username" var="userMsg" bundle="${resourceBundle}" />	<!-- var : 불러온 내용을 저장 -->
	이름 : ${userMsg}
	
	<p>----------영어 로케일------------
		<fmt:setLocale value="en" />	<!-- 영문을 사용하겠다 -->
		<fmt:setBundle basename="bundle.myBundle" var="resourceBundle" />
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" />
	<p> 이름 : <fmt:message key="username" bundle="${resourceBundle}" />
	
	<p>----------일본어 로케일------------
		<fmt:setLocale value="ja" />	<!-- 일본어를 사용하겠다 -->
		<fmt:setBundle basename="bundle.myBundle" var="resourceBundle" />
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" />
	<p> 이름 : <fmt:message key="username" bundle="${resourceBundle}" />
	
	<p>----------중국 간체 로케일------------
		<fmt:setLocale value="zh" />	<!-- 중국 간체를 사용하겠다 -->
		<fmt:setBundle basename="bundle.myBundle" var="resourceBundle" />
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" />
	<p> 이름 : <fmt:message key="username" bundle="${resourceBundle}" />
</body>

</html>