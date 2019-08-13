<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>	<%-- 패키지 import 방법 --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--@ include file="footer.jsp" // 삽입하는 형태. 디자인을 그냥 JSP파일로 옮길 때 사용 --%>
	<jsp:include page="footer.jsp"/>	<%-- 매크로를 이용해서 실행하는 형태, 클래스나 메서드 호출 사용 시 사용 --%>
	<%= new Date()%><br>   
	<%
		Date date =new Date();
		out.print(date +"<br>");
		out.print(date +"<br>");
		out.print(date +"<br>");
		out.print("<br><br>-------------------------------------"+"<br><br>");
		int hour = date.getHours();
		out.print(hour+"<br>");
	%>
	
	<% 
		Calendar cal = Calendar.getInstance();
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH);
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int ms = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		String date2 = yy + " : " + mm + " : " +  dd + " : " +  hh +" : " +  ms +" : " +  ss;
		out.print(date2 + "<br>");
		out.print("<br><br>-------------------------------------"+"<br><br>");
		String date3="";
		date3.format("%02d-%02d-%02d %02d:%02d:%02d",yy,mm,dd,hh,ms,ss); // 02d 는 두자리수로 나타내는 것
		out.print(date3+"<br>");
	%>
	<%@ include file="footer.jsp" %>
</body>
</html>