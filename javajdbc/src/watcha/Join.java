package watcha;

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

public class Join extends JFrame {
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;

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
					Join frame = new Join();
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
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 350, 348, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(63, 93, 57, 15);
		contentPane.add(lblUserId);
		
		JLabel lblJoin = new JLabel("Member Resistration");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJoin.setBounds(36, 29, 254, 34);
		contentPane.add(lblJoin);
		
		JLabel lblUserPw = new JLabel("User PW");
		lblUserPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPw.setBounds(63, 127, 57, 15);
		contentPane.add(lblUserPw);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(136, 90, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(136, 124, 116, 21);
		contentPane.add(txtUserPWD);
		
		
		
		// Join 버튼
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
	      		
	      		String uname = txtUserID.getText();	// 해당 텍스트창에 적힌 글이 uname에 저장됨
	      		String upw = txtUserPWD.getText();
	      		
	      		if (chkDuplicate(uname)) {
	      			JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
	      		}else {
		            sql = "INSERT INTO memberlist VALUES (auto_increment.NEXTVAL, ?, ?)";
		            
		            try {
		            	pstmt = conn.prepareStatement(sql);
		            	pstmt.setString(1, upw);
						pstmt.setString(2, uname);
						
			            int rst = pstmt.executeUpdate();
			            if(rst==1)JOptionPane.showMessageDialog(null, "유저 " + uname + " 가 추가되었습니다.");
			            
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	      		}// end of if-else
			}
		});
		btnNewButton.setBounds(59, 186, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login Login = new Login();
				Login.setVisible(true);
			}
		});
		btnExit.setBounds(168, 186, 97, 23);
		contentPane.add(btnExit);
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
	
	
	
    boolean chkDuplicate(String newName) {
    	boolean exist = false;
    	dbconnect();
    	  
    	sql = "SELECT * FROM memberlist WHERE username=?";
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
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
