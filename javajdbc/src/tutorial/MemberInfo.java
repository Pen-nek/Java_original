package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberInfo extends JFrame {
   Connection conn;
   PreparedStatement pstmt;
   String sql;
   ResultSet result;
   
   private JPanel contentPane;
   private JTextField txtUserID;
   private JTextField txtUserPWD;
   private JTextField txtPhn;
   private JTextField txtAdrs;
   private JTable table;

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
   public MemberInfo() {
      setTitle("Member Information Form");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(600, 350, 882, 531);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Member Information Form");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
      lblNewLabel.setBounds(286, 27, 327, 41);
      contentPane.add(lblNewLabel);
      
      txtUserID = new JTextField();
      txtUserID.setBounds(140, 110, 116, 21);
      contentPane.add(txtUserID);
      txtUserID.setColumns(10);
      
      txtUserPWD = new JTextField();
      txtUserPWD.setBounds(140, 141, 116, 21);
      contentPane.add(txtUserPWD);
      txtUserPWD.setColumns(10);
      
      JLabel lblNewLabel_1 = new JLabel("User ID");
      lblNewLabel_1.setBounds(32, 113, 78, 15);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("User PW");
      lblNewLabel_2.setBounds(32, 144, 96, 15);
      contentPane.add(lblNewLabel_2);
      
      
      
      
      // Search 버튼
      JButton btnNewButton = new JButton("Search");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbconnect();
            String uid = txtUserID.getText();
            sql = "SELECT * FROM members WHERE userid=?";
            try {
               pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, uid);
               
               result = pstmt.executeQuery();	// 쿼리의 실행 결과가 result에 저장됨
               
               while(result.next()) {	// 쿼리 내용이 있는 동안 반복
                  String vuid = result.getString("userid");		// 실행 결과 중 userid를 가져와서 vuid 변수에 저장
                  String vupwd = result.getString("userpwd");
                  String phn = result.getString("phone");
                  String adrs = result.getString("address");
                  txtUserID.setText(vuid);	// 해당 텍스트창에 vuid 변수를 넣음
                  txtUserPWD.setText(vupwd);
                  txtPhn.setText(phn);
                  txtAdrs.setText(adrs);
               }//end of while
               
            }catch (SQLException e1) {
               e1.printStackTrace();
            }
               
         }
      });
      btnNewButton.setBounds(23, 439, 97, 23);
      contentPane.add(btnNewButton);
      
      
      
      // Add 버튼
      JButton btnNewButton_1 = new JButton("Add");
      btnNewButton_1.addActionListener(new ActionListener() {
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
      		dataLoad();
      	}
      });
      btnNewButton_1.setBounds(143, 439, 97, 23);
      contentPane.add(btnNewButton_1);
      
      
      
      // Update 버튼
      
      JButton btnNewButton_2 = new JButton("Update");
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dbconnect();
      		String uid = txtUserID.getText();
      		String upwd = txtUserPWD.getText();
      		String uphn = txtPhn.getText();
      		String uadrs = txtAdrs.getText();
            sql = "UPDATE members SET userpwd=?, phone=?, address=? WHERE userid = ?";
            
            try {
            	pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, upwd);	// 쿼리의 1번째 ?를 upwd로 바꿈
				pstmt.setString(2, uphn);
				pstmt.setString(3, uadrs);
				pstmt.setString(4, uid);
	            int rst = pstmt.executeUpdate();	// 쿼리를 업데이트함
	            if(rst==1)JOptionPane.showMessageDialog(null, "레코드 1개를 업데이트하였습니다.");
	            
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            dataLoad();
      	}
      });
      btnNewButton_2.setBounds(263, 439, 97, 23);
      contentPane.add(btnNewButton_2);
      
      
      
      // Delete 버튼
      JButton btnNewButton_3 = new JButton("Delete");
      btnNewButton_3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		dbconnect();
      		String uid = txtUserID.getText();
            sql = "DELETE FROM members WHERE userid=?";
            
            try {
            	pstmt = conn.prepareStatement(sql);
            	pstmt.setString(1, uid);
				
	            int rst = pstmt.executeUpdate();
	            if(rst==1)JOptionPane.showMessageDialog(null, "유저 " + uid + "의 내용을 삭제하였습니다.");
	            
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            dataLoad();
      	}
      });
      btnNewButton_3.setBounds(383, 439, 97, 23);
      contentPane.add(btnNewButton_3);
      
      
      
      // Exit 버튼
      JButton btnNewButton_4 = new JButton("Exit");
      btnNewButton_4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // System.exit(0);		// 무조건 프로그램 종료 시 0
        	// 1. 현재 화면을 닫고
			dispose();
			// 2. 새 화면 생성
			LoginForm loginForm = new LoginForm();
			// 3. 새 화면 보이기
			loginForm.setVisible(true);
         }
      });
      btnNewButton_4.setBounds(623, 439, 97, 23);
      contentPane.add(btnNewButton_4);
      
      
      
      // Reset 버튼
      JButton btnReset = new JButton("Reset");
      btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText("");
				txtUserPWD.setText("");
				txtPhn.setText("");
				txtAdrs.setText("");
			}
		});
		btnReset.setBounds(503, 439, 97, 23);
		contentPane.add(btnReset);
		
		txtPhn = new JTextField();
		txtPhn.setColumns(10);
		txtPhn.setBounds(140, 172, 116, 21);
		contentPane.add(txtPhn);
		
		txtAdrs = new JTextField();
		txtAdrs.setColumns(10);
		txtAdrs.setBounds(140, 203, 116, 21);
		contentPane.add(txtAdrs);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(32, 175, 96, 15);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 206, 57, 15);
		contentPane.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 110, 469, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dbconnect();
				// 테이블을 클릭했을 때, 행을 추출하고 
				// 추출된 행의 각 컬럼을 왼쪽에 있는 각각의 텍스트필드에 전달한다.
				int row = table.getSelectedRow();	// 테이블에서 선택된 행 추출
				String uid = (table.getModel().getValueAt(row, 0)).toString();	//toString() : getValueAt()이 Object형이기 때문에 String으로 바꿔줌

				// uid를 이용하여 db를 검색하고 검색결과를 텍스트필드에 전달
				sql = "SELECT * FROM members WHERE userid=?";
	            try {
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, uid);
	               
	               result = pstmt.executeQuery();	// 쿼리의 실행 결과가 result에 저장됨
	               
	               while(result.next()) {	// 쿼리 내용이 있는 동안 반복
	                  String vuid = result.getString("userid");		// 실행 결과 중 userid를 가져와서 vuid 변수에 저장
	                  String vupwd = result.getString("userpwd");
	                  String phn = result.getString("phone");
	                  String adrs = result.getString("address");
	                  txtUserID.setText(vuid);	// 해당 텍스트창에 vuid 변수를 넣음
	                  txtUserPWD.setText(vupwd);
	                  txtPhn.setText(phn);
	                  txtAdrs.setText(adrs);
	               }//end of while
	               
	            }catch (SQLException e1) {
	               e1.printStackTrace();
	            }
				
			
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		// Data Load 버튼
		JButton btnDataLoad = new JButton("Data Load");
		btnDataLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataLoad();
			}
		});
		btnDataLoad.setBounds(743, 439, 97, 23);
		contentPane.add(btnDataLoad);
		
		dataLoad();
   }// end of MemberInfo();
   
   
   
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
    
    void closeAll() {
    	if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
    
    void dataLoad() {
    	// JTable에 테이블 데이터를 로드
		dbconnect();
		sql = "SELECT * FROM members";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(result));	// 질의 결과를 table에 넘겨줌
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }// end of dataLoad()
}// end of class