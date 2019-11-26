<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="dbconn.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String group = request.getParameter("group");
	String phone = request.getParameter("phone");
	String memo = request.getParameter("memo");
	
	PreparedStatement pstmt = null;
	
	String sql = "insert into contact(c_name, c_group, c_phone, c_memo, c_callcnt) values(?, ?, ?, ?, 0)";
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, name);
	pstmt.setString(2, group);
	pstmt.setString(3, phone);
	pstmt.setString(4, memo);
	pstmt.executeUpdate();
	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();

	response.sendRedirect("contact.jsp");
%>

</body>
</html>