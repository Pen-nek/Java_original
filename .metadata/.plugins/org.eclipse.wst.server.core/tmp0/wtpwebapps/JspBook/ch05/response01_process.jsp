<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("id");
		String password = request.getParameter("pass");
		
		if (userid.equals("관리자") && password.equals("1234")) {
			// response.sendRedirect("response01_success.jsp");
	%>
			<jsp:forward page="response01_success.jsp"/>	<%-- 이 방식을 사용하면 주소는 process 페이지로 표시됨 --%>
	<%
		} else {
			response.sendRedirect("response01_failed.jsp");
		}
	%>
</body>
</html>