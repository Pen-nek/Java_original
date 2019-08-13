<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">	<%-- CDN으로 가져온 스타일시트 --%>
</head>
<body>
	<%!
		String greeting = "쇼핑몰 접속을 환영합니다.";
		String tagline = "마켓에 오신 것을 환영합니다!";
	%>
	<nav class="navbar navbar-expand navbar_dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./Ex0731_9.jsp">Home</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				<%=greeting%>
			</h1>
		</div>
	</div>
</body>
</html>