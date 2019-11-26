<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
    // 로그아웃 담당 JSP로 이동
    function logout(){
        location.href="/login/LoginForm";
    }
</script>

</head>

<body>
	<p>성공! ${loginPersonVO.e_name}님 환영합니다.</p>
    <input type="button" value="로그아웃" onclick="logout()">
</body>
</html>