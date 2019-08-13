<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! // int count = 0;	 전역변수 %>
<body>
<%
	for(int i=0; i<5; i++) {
		out.print("<h1>JSP Test</h1>");		//JSP에서는 자바와 달리 앞에 System을 사용하지 않음
	}
%>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<%
	// out.println(++count);
	out.print(myMethod(0));
	out.println("<h3>JSP</h3>");		// html 문법은 ""사이에 넣어줌
%>
<%!
	public int myMethod(int count) {
		return ++count;
	}
%>
</body>
</html>