<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Added Member</title>
</head>

<body>

	<h3>가입정보</h3>
	<%
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");
		String addr = request.getParameter("addr");
		String addr2 = request.getParameter("addr2");
		String addr3 = request.getParameter("addr3");
		String registDate = request.getParameter("registDate");
	%>
	<p>아이디 : <%=userId %><br>
	비밀번호 : <%=userPw %><br>
	이름 : <%=name %><br>
	전화번호 : <%=phone %><br>
	이메일 : <%=email %><br>
	성별 : <%=gender %><br>
	생년월일 : <%=birthDate %><br>
	주소 : <%=addr + addr2 + addr3%><br>
	가입일 : <%=registDate %><br>

</body>

</html>