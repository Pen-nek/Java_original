package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnTest {
	public static Connection getConnection() {		// 커넥션 타입을 돌려주는 겟커넥션 메서드
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		// 1521은 포트번호. oracle이 아닌 다른 sql 툴을 사용하면 바뀔 수 있음. standard는 xe 대신 ocl로. mysql은 jdbc:myslq://localhost/dev(dev는 DB명임)
		String user = "hr";
		String pwd = "hr";
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	// 드라이브 동작 할당받을 때
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("database connected successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}	// 드라이버매니저에 의해 커넥션을 받음
		
		return conn;
	}//end of getConnection
	
	public static void updateList(Connection conn) {
		String sql = null;
		PreparedStatement pstmt = null;
		
		String email = "chungbuk";
		int empid = 100;
		
		sql = "UPDATE employees SET email=? WHERE employee_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, empid);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 데이터가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}// end of updateList()
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		PreparedStatement pstmt;
		ResultSet result;
		String sql;
		
		updateList(conn);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//end of main
}//end of class
