<%@ page language="java" contentType="text/html; charset=UTF-8"		
    pageEncoding="UTF-8"%> <%-- 페이지 상의 내용을 인코딩 함 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>	<%-- Form을 통해 넘어오는 값을 인코딩 함. 네트워크를 거치는 과정 중에 인코딩이 풀리기 때문 --%>
	<%
		String subject = request.getParameter("subject");
		String uname = request.getParameter("uname");		// 폼에서 파라미터를 넘겨받음 
		String phone = request.getParameter("phone");
		String region = request.getParameter("region");
		String contents = request.getParameter("contents");
		
		contents = contents.replace("'", "&#39;");		// 특수문자 오류 없게 처리. 보통 이 4개를 처리해줌
		contents = contents.replace("<", "&lt;");
		contents = contents.replace(">", "&gt;");
		contents = contents.replace("\n", "<br>");		// textarea인 contents 내용에 엔터가 들어가면 줄바꿈 되도록 함. 순서가 맨 아래여야 함
		
		out.print("제목 : " + subject + "<br>");
		out.print("이름 : " + uname + "<br>");
		out.print("통신사 : " + phone + "<br>");
		out.print("지역 : " + region + "<br>");
		out.print("내용 : " + contents + "<br>");
		out.print("접속아이피 " + request.getRemoteAddr());
	%>
</body>
</html>