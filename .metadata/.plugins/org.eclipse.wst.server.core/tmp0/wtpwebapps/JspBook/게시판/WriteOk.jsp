<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 예외처리가 필요한 부분이 있는데, 1)네트워크처리 2)파일처리 같은 경우 그리고 3)데이터베이스  예외처리를 강제로 해줘야함.
	//database 연동하는 과정에서는 3개의 중요한 변수가 필요함. 1)Connection 2)Statement 3)ResultSet --%>

	<% 
		request.setCharacterEncoding("UTF-8");	// 폼에서 넘어오는 한글 데이터를 한글로 인코딩
		String b_subject = request.getParameter("b_subject");
		String b_name = request.getParameter("b_name");
		String b_contents = request.getParameter("b_contents");
		
		Connection conn = null;	// 데이터베이스 연결 객체 선언(아직 메모리에 없음)
		Statement stmt = null;	// SQL 문장 처리 객체 선언(아직 메모리에 없음)
		ResultSet rs = null;	// 조회된 테이블 결과 저장 객체(select 실행 시 필요, 그 외는 불필요)
		String sql = "";		// 쿼리 작성용 문자열 
		Calendar cal = Calendar.getInstance();
		
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH);
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int ms = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		String b_date = String.format("%02d-%02d-%02d %02d:%02d:%02d",yy,mm,dd,hh,ms,ss);
		
		try {
			Class.forName("org.sqlite.JDBC");	// JDBC 드라이버 로드
			out.print("드라이버 로드 OK<br>");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\Desktop\\sqlite3\\mydb.db");	// 경로가 정확해야 함
			out.print("DB연결 OK<br>");
			stmt = conn.createStatement();		// 쿼리 실행용 객체 생성
			
			sql = "INSERT INTO board (b_subject, b_name, b_visit, b_date, b_contents)";
			sql += "VALUES ('" + b_subject + "','";		// 변수들은 큰 따옴표 밖에 있음! "VALUES ('" 가 한 묶음. 
			sql += b_name + "', 0, '";
			sql += b_date + "', '";
			sql += b_contents + "')";		// DB에 쓰기 작업. 쪼개서 적은 것임
			
			stmt.executeUpdate(sql);				// 이걸 주석처리 하면 테이블이 업데이트 되지 않음. 테스트 시 주석처리할 것
			response.sendRedirect("List.jsp");		// DB에 쓰기 작업 후 리스트 페이지로 이동
			//out.print(sql + "<br>");
			//out.print("쿼리 실행 OK<br>");
		} catch (Exception e) {
			out.print(e.toString() + "DB 에러");
		}
		try {
			stmt.close();	// 문장 처리 객체 닫기
			conn.close();	// 연결 객체 닫기
		} catch (Exception e) {
			out.print(e.toString() + "DB 닫기 에러");
		}
	%>
</body>
</html>