<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>    
<%
	Connection conn = null;
	
	try {
		// 이클립스 Establishing SSL connection without server's identity verification is not recommended 오류에 대한 해결로
		// url 뒤에 ?useSSL=false 삽입
		String url = "jdbc:mysql://localhost:3306/assistant?useSSL=false";
		String user = "madang";
		String password = "madang";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException ex) {
		out.println("데이터베이스 연결이 실패했습니다.");
		out.println("SQLException : " + ex.getMessage());
	}
%>