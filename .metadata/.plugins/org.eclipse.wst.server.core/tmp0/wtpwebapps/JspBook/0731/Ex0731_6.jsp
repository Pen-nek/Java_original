<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border-collapse : collapse;}
</style>
</head>
<body>
	<% int count = 0; %>	<%--java+html 방식1 : 디자인이 단순한 경우 적합 --%>
	<table border='1'>	
		<%
			for (int i = 0; i < 3; i++) {
				out.println("<tr>");
				for (int j = 0; j < 4; j++) {
					out.print("<td>");
					out.print("테이블" + ++count);
					out.print("</td>");
				}
				out.println("</tr>");
			}
		%>
	</table>
	<br>
	<%	int count2 = 0; %>	<%--java+html 방식2 : 디자인이 복잡한 경우 적합 --%>
	<table border='1'>
		<% for (int i = 0; i < 3; i++) { %>		<%-- html 문법 구간에서 자바 문법을 보여주기 위해 <%%>기호를 사용 --%>
		<tr>
			<% for (int j = 0; j < 4; j++) { %>
				<td>테이블<%=++count2%></td>
			<% } %>
		</tr>
		<% } %>
	</table>
</body>
</html>