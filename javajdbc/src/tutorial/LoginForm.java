package tutorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 350, 482, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(212, 106, 131, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserPwd = new JLabel("User PWD");
		lblUserPwd.setBounds(212, 144, 131, 15);
		contentPane.add(lblUserPwd);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(294, 103, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(294, 141, 116, 21);
		contentPane.add(txtUserPWD);
		
		
		
		// Login 버튼
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// DB Connection
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				String sql = null;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "madang";
				String pwd = "madang";
				
				try {
					//연결 설정
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pwd);
					
					String uid = txtUserID.getText();	// 해당 텍스트창에 적힌 글이 uid에 저장됨
		      		String upw = txtUserPWD.getText();
					
					sql = "SELECT * FROM members WHERE userid=? AND userpwd = ?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					pstmt.setString(2, upw);
					
					result = pstmt.executeQuery();
					
					if(result.next()) {		// admin에게만 멤버정보 확인 가능하게 만들기
						dispose();
						MemberInfo membInfo = new MemberInfo();
						membInfo.setVisible(true);
					}
					else JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(323, 199, 97, 23);
		contentPane.add(btnLogin);
		
		
		
		// 제목
		
		JLabel lblLoginForm = new JLabel("Welcome to Java DB Class");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginForm.setBounds(49, 26, 371, 43);
		contentPane.add(lblLoginForm);
		
		
		
		// Icon 그림
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(23, 94, 142, 128);
		contentPane.add(label);
		
		
		
		// Join 버튼
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// DB Connection
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				String sql = null;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "madang";
				String pwd = "madang";
				
				try {
					//연결 설정
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pwd);
						// 1. 현재 화면을 닫고
						dispose();
						// 2. 새 화면 생성
						MemberJoin membJoin = new MemberJoin();
						// 3. 새 화면 보이기
						membJoin.setVisible(true);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("드라이버 연결 실패");
					e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println("DB연결 문제");
					e1.printStackTrace();
				}
			}
		});
		btnJoin.setBounds(197, 199, 97, 23);
		contentPane.add(btnJoin);
			
	}//end of LoginForm()
	
}//end of class
