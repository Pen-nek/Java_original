package watcha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {

	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest frame = new Guest();
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
	public Guest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Movie Review List");
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		label.setBounds(75, 86, 137, 15);
		contentPane.add(label);
		
		JLabel lblWatchaguest = new JLabel("WATCHA (Guest)");
		lblWatchaguest.setHorizontalAlignment(SwingConstants.CENTER);
		lblWatchaguest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWatchaguest.setBounds(42, 23, 476, 52);
		contentPane.add(lblWatchaguest);
		
		table = new JTable();
		table.setBackground(SystemColor.menu);
		table.setBounds(75, 111, 412, 340);
		contentPane.add(table);
		
		JButton button = new JButton("EXIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login Login = new Login();
				Login.setVisible(true);
			}
		});
		button.setBounds(401, 461, 86, 23);
		contentPane.add(button);
		
		dataLoad();
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
	
	
	
    void dataLoad() {
    	// JTable에 테이블 데이터를 로드
		dbconnect();
		sql = "SELECT reviewid, title, runtime, genre, age, stars, review, username FROM movie, memberlist WHERE movie.userid = memberlist.userid";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(result));	// 질의 결과를 table에 넘겨줌
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }// end of dataLoad()
    
    
    
}//end of guest class
