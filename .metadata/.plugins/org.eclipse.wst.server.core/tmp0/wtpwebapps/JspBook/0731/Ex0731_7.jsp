<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<% 
		for (int i = 1; i <= 9; i++) {		// 삼각형 모양 만들기 (일반삼각형)
			out.print("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.print("<td>");
				out.print(i + "*" + j + "=" + (i*j));
				out.print("</td>");
			}
			out.print("</tr>");
		}
		%>
	
		<%--
		for (int i = 1; i <= 9; i++) {		// 삼각형 모양 만들기 (역삼각형)
			for (int j = 1; j <= 9; j++) {
				out.println(i + "*" + j + "=" + i*j);
		    } 
		} --%>
	</table>
</body>
</html>