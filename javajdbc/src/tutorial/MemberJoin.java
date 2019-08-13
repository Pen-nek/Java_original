package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MemberJoin extends JFrame {
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtPhn;
	private JTextField txtAdrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberJoin frame = new MemberJoin();
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
	public MemberJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 350, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(119, 65, 57, 15);
		contentPane.add(lblUserId);
		
		JLabel lblMemberJoin = new JLabel("Member Resistration");
		lblMemberJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberJoin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMemberJoin.setBounds(85, 10, 254, 34);
		contentPane.add(lblMemberJoin);
		
		JLabel lblUserPw = new JLabel("User PW");
		lblUserPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPw.setBounds(119, 99, 57, 15);
		contentPane.add(lblUserPw);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setBounds(75, 134, 101, 15);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(119, 168, 57, 15);
		contentPane.add(lblNewLabel);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(192, 62, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(192, 96, 116, 21);
		contentPane.add(txtUserPWD);
		
		txtPhn = new JTextField();
		txtPhn.setColumns(10);
		txtPhn.setBounds(192, 131, 116, 21);
		contentPane.add(txtPhn);
		
		txtAdrs = new JTextField();
		txtAdrs.setColumns(10);
		txtAdrs.setBounds(192, 165, 116, 21);
		contentPane.add(txtAdrs);
		
		
		
		// Join버튼
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
	      		
	      		String uid = txtUserID.getText();	// 해당 텍스트창에 적힌 글이 uid에 저장됨
	      		String upw = txtUserPWD.getText();
	      		String phn = txtPhn.getText();	
	      		String adrs = txtAdrs.getText();
	      		
	      		if (chkDuplicate(uid)) {
	      			JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
	      		}else {
		            sql = "INSERT INTO members VALUES (?, ?, ?, ?)";
		            
		            try {
		            	pstmt = conn.prepareStatement(sql);
		            	pstmt.setString(1, uid);
						pstmt.setString(2, upw);
						pstmt.setString(3, phn);
						pstmt.setString(4, adrs);
						
			            int rst = pstmt.executeUpdate();
			            if(rst==1)JOptionPane.showMessageDialog(null, "유저 " + uid + " 가 추가되었습니다.");
			            
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	      		}// end of if-else
			}
		});
		btnNewButton.setBounds(35, 210, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginForm loginForm = new LoginForm();
				loginForm.setVisible(true);
			}
		});
		btnExit.setBounds(299, 210, 97, 23);
		contentPane.add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText("");
				txtUserPWD.setText("");
				txtPhn.setText("");
				txtAdrs.setText("");
			}
		});
		btnReset.setBounds(167, 210, 97, 23);
		contentPane.add(btnReset);
	}
	
	
	
	void dbconnect() {
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
        } catch (ClassNotFoundException e) {
           System.out.println("드라이버 로드 실패");
           e.printStackTrace();
        } catch (SQLException e) {
           System.out.println("DB연결 문제");
           e.printStackTrace();
        }      
     }// end of dbconnect()
	
	
	
    boolean chkDuplicate(String newid) {
    	boolean exist = false;
    	dbconnect();
    	  
    	sql = "SELECT * FROM members WHERE userid=?";
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newid);
	        result = pstmt.executeQuery();	// 쿼리의 실행 결과가 result에 저장됨
	        if(result.next())	// 만약 뭔가를 가리킨다면(결과로 뭔가가 하나라도 나온다면)
	        	exist = true;
	        else exist = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return exist;
      }// end of chkDuplicate()

}
