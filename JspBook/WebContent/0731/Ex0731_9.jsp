<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	@import url('https://fonts.googleapis.com/css?family=Song+Myung&display=swap');		<%-- CDN으로 가져온 스타일시트 --%>
	h1, h2 {font-family: 'Song Myung', serif;}
</style>
<body>
	<%!
		String greeting = "쇼핑몰 접속을 환영합니다.";
		String tagline = "마켓에 오신 것을 환영합니다!";
	%>
	<h1><%=greeting%></h1>
	<h2><%=tagline%></h2>
	
	<% 
	java.util.Date d = new java.util.Date();	// 클래스형은 이렇게 쓰는 것도 가능하다!!
	out.print(d);
	%>
</body>
</html>