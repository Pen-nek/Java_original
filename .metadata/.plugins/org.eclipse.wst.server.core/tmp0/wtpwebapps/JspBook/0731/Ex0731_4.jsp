<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		int count = 0;		// 전역변수는 페이지가 리로드 돼도 초기화되지 않고 메모리에 남아있음
	%>
	<%
		out.print(++count);
	%> --%>
	<%
		for (int i=0; i<11; i++) {
			if (i % 2 == 0)
			out.println(i + "<br>");	
		}
	%>
</body>
</html>