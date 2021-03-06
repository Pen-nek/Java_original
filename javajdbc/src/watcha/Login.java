package watcha;

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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	static String uid;
	static String upw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 350, 559, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(219, 106, 131, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserPwd = new JLabel("User PWD");
		lblUserPwd.setBounds(219, 144, 131, 15);
		contentPane.add(lblUserPwd);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(301, 103, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(301, 141, 116, 21);
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
					
					uid = txtUserID.getText();	// 해당 텍스트창에 적힌 글이 uid에 저장됨
		      		upw = txtUserPWD.getText();
					
					sql = "SELECT * FROM memberlist WHERE username=? AND userpwd = ?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					pstmt.setString(2, upw);
					
					result = pstmt.executeQuery();
					
					if(result.next()) {
				         dispose();
				         if(uid.equals("admin") && upw.equals("admin")) { 
				         Admin adminMenu = new Admin();
				         adminMenu.setVisible(true);
				         }
				         else {
				        	dispose();
				            Member membMenu = new Member();
				            membMenu.setVisible(true);
				         }
					} else JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(293, 198, 97, 23);
		contentPane.add(btnLogin);
		
		
		
		// 제목
		
		JLabel lblLogin = new JLabel("WATCHA");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(86, 25, 371, 43);
		contentPane.add(lblLogin);
		
		
		
		// Icon 그림
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("../img/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(30, 94, 142, 128);
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
						Join membJoin = new Join();
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
		btnJoin.setBounds(184, 198, 97, 23);
		contentPane.add(btnJoin);
		
		
		
		// Guest 버튼
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Guest guestMenu = new Guest();
				guestMenu.setVisible(true);
			}
		});
		btnGuest.setBounds(402, 198, 97, 23);
		contentPane.add(btnGuest);
			
	}//end of Login()

	public static String getUid() {
		return uid;
	}

	public static String getUpw() {
		return upw;
	}
	
}//end of class
