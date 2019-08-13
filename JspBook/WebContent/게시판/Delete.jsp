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
	
	<%
		String b_num = request.getParameter("b_num"); //인터넷상에서 넘어오는 모든 변수는 문자열 타입
		int bi_num = Integer.parseInt(b_num); //정수로 사용하기 위해 형변환
		Connection conn = null; //데이터베이스 연결 객체 선언 (아직 메모리에 없음)
		PreparedStatement pstmt = null; //sql 문장 처리용 객체 선언 (아직 메모리에 없음)
		String sql = ""; // 쿼리작성용 문자열 
		
		try {
			Class.forName("org.sqlite.JDBC"); //forname은 정적변수. 그 안에 드라이버명칭을 써주면 됨. :: JDBC 드라이버 로드
			out.print("드라이버로드OK<br>");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\Desktop\\sqlite3\\mydb.db") ;
			out.print("디비연결OK<br>");
			
			sql = "delete from board where b_num = ?";
			pstmt = conn.prepareStatement(sql); //쿼리실행용 객체 생성
			pstmt.setInt(1, bi_num);
			pstmt.executeUpdate(); //pstmt실행 = 쿼리실행
			response.sendRedirect("./List.jsp");
		}  catch(Exception e) {
			out.print(e.toString() + "DB 에러");
		}
	%>
	 <%
		try {
			pstmt.close();	// 문장 처리 객체 닫기
			conn.close();	// 연결 객체 닫기
		} catch(Exception e) {
			out.print(e.toString()+"DB닫기 에러");
		}
	 %>
	
</body>
</html>