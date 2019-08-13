package watcha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Member extends JFrame {
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	String loginID = Login.getUid();

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtPltime;
	private JTextField txtGenre;
	private JTextField txtAge;
	private JTable table;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Member frame = new Member();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 573);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWatcha = new JLabel("WATCHA");
		lblWatcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblWatcha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWatcha.setBounds(248, 10, 352, 52);
		contentPane.add(lblWatcha);
		
		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setBounds(52, 92, 86, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Playtime");
		lblNewLabel.setBounds(52, 122, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Genre");
		lblNewLabel_1.setBounds(52, 154, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age Limit");
		lblNewLabel_2.setBounds(52, 185, 67, 15);
		contentPane.add(lblNewLabel_2);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(140, 92, 116, 21);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtPltime = new JTextField();
		txtPltime.setBounds(140, 123, 116, 21);
		contentPane.add(txtPltime);
		txtPltime.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(140, 154, 116, 21);
		contentPane.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(140, 185, 116, 21);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblStars = new JLabel("Stars");
		lblStars.setBounds(52, 216, 57, 15);
		contentPane.add(lblStars);
		
		JComboBox cbbStars = new JComboBox();
		cbbStars.setModel(new DefaultComboBoxModel(new String[]
				{"Make a Selection", "★", "★★", "★★★", "★★★★", "★★★★★",}));
		cbbStars.setBounds(140, 213, 116, 21);
		contentPane.add(cbbStars);
		
		JLabel lblReview = new JLabel("Content");
		lblReview.setBounds(52, 252, 57, 15);
		contentPane.add(lblReview);
		
		JTextArea txtAreaCon = new JTextArea();
		txtAreaCon.setBackground(SystemColor.control);
		txtAreaCon.setBounds(52, 277, 282, 195);
		contentPane.add(txtAreaCon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 121, 460, 351);
		contentPane.add(scrollPane);
		
		
		
		// 테이블
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dbconnect();
				int row = table.getSelectedRow();	// 테이블에서 선택된 행 추출
				String selected = (table.getModel().getValueAt(row, 0)).toString();	

				sql = "SELECT * FROM movie WHERE reviewid=?";	// reviewid를 이용하여 db를 검색
				
	            try {
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, selected);	// 검색결과를 텍스트필드에 전달
	               result = pstmt.executeQuery();	// 쿼리의 실행 결과가 result에 저장됨
	               
	               while(result.next()) {			// result에 저장된 결과가 남아있는 동안 반복
						String title = result.getString("title");
						String runtime = result.getString("runtime");
						String genre = result.getString("genre");	
						String age = result.getString("age");
						String review = result.getString("review");
						
						txtTitle.setText(title);	// 해당 텍스트창에 title 변수를 넣음
						txtPltime.setText(runtime);
						txtGenre.setText(genre);
						txtAge.setText(age);
						txtAreaCon.setText(review);
	               }//end of while
	               
	            }catch (SQLException e1) {
	               e1.printStackTrace();
	            }
			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.control);
		
		
		
		// Add 버튼
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
	      		
	      		String title = txtTitle.getText();
	      		String runtime = txtPltime.getText();
	      		String genre = txtGenre.getText();	
	      		int age = txtAge.getText();
	      		String stars = (String)cbbStars.getSelectedItem();
	      		String review = txtAreaCon.getText();
	      		
	      		if (chkDuplicate(title)) {
	      			JOptionPane.showMessageDialog(null, "이 영화는 이미 리뷰를 작성하셨습니다.");
	      		}else {
		            sql = "INSERT INTO movie VALUES (auto_increment.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		            
		            try {
		            	pstmt = conn.prepareStatement(sql);
		            	pstmt.setString(1, title);
		            	pstmt.setString(2, runtime);
						pstmt.setString(3, genre);
						pstmt.setInt(3, age);
						pstmt.setString(4, stars);
						pstmt.setString(5, review);
						pstmt.setString(7, loginID);
						
			            int rst = pstmt.executeUpdate();
			            if(rst==1)JOptionPane.showMessageDialog(null, "영화 '" + title + "'의 리뷰가 추가되었습니다.");
			            
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	      		}// end of if-else
	      		dataLoad();
			}
		});
		btnAdd.setBounds(52, 482, 86, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(248, 482, 86, 23);
		contentPane.add(btnDelete);
		
		
		
		// Update 버튼
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dbconnect();
				int row = table.getSelectedRow();	// 테이블에서 선택된 행 추출
				String selected = (table.getModel().getValueAt(row, 0)).toString();	

				sql = "SELECT * FROM movie WHERE reviewid=?";	// reviewid로 movie의 투플을 가져오는 구문
				
	            try {
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, selected);	// 선택된 행의 데이터를 reviewid에 전달
	               result = pstmt.executeQuery();	// 쿼리를 실행하고 결과를 result에 저장
	               
	               while(result.next()) {			// result에 저장된 결과가 남아있는 동안 반복
						String title = result.getString("title");
						String runtime = result.getString("runtime");
						String genre = result.getString("genre");	
						String age = result.getString("age");
						String stars = result.getString("stars");
						String review = result.getString("review");
						String userid = result.getString("userid");
						int reviewid = result.getInt("reviewid");
						
						txtTitle.setText(title);
						txtPltime.setText(runtime);
						txtGenre.setText(genre);
						txtAge.setText(age);
						txtAreaCon.setText(review);
						
						sql = "UPDATE members SET title=?, runtime=?, genre=?, age=?, stars=?, review=?, userid=? WHERE reviewid=?";
			            if(loginID!=userid) {
				            try {
				            	pstmt = conn.prepareStatement(sql);
				            	pstmt.setString(1, title);
								pstmt.setString(2, runtime);
								pstmt.setString(3, genre);
								pstmt.setString(4, age);
								pstmt.setString(5, stars);
								pstmt.setString(6, review);
								pstmt.setString(7, loginID);
								pstmt.setInt(8, reviewid);
					            int rst = pstmt.executeUpdate();	// 쿼리를 업데이트함
					            if(rst==1)JOptionPane.showMessageDialog(null, "영화 '" + title + "의 리뷰가 수정되었습니다.");
					            
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
				            dataLoad();
			            } else {JOptionPane.showMessageDialog(null, "본인이 작성한 리뷰만 수정할 수 있습니다.");}
						
	               }//end of while
	               
	            }catch (SQLException e1) {
	               e1.printStackTrace();
	            }
			}
		});
		btnUpdate.setBounds(150, 482, 86, 23);
		contentPane.add(btnUpdate);
		
		
		
		// Exit 버튼
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login Login = new Login();
				Login.setVisible(true);
			}
		});
		btnExit.setBounds(745, 486, 86, 23);
		contentPane.add(btnExit);
		
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(617, 93, 116, 21);
		contentPane.add(textField_4);
		
		JLabel lblMovieList = new JLabel("Movie Review List");
		lblMovieList.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblMovieList.setBounds(371, 90, 133, 15);
		contentPane.add(lblMovieList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(745, 92, 86, 23);
		contentPane.add(btnSearch);
		
		JLabel lblReview_1 = new JLabel("Movie Review");
		lblReview_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblReview_1.setBounds(52, 57, 133, 15);
		contentPane.add(lblReview_1);
		
		dataLoad();
		
	}//end of Member()
	
	
	
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
	    	  
	    	sql = "SELECT * FROM memberlist WHERE userid=?";
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
			sql = "SELECT reviewid, title, runtime, genre, age, stars, review, username FROM movie, memberlist WHERE movie.userid = memberlist.userid";
			try {
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(result));	// 질의 결과를 table에 넘겨줌
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	    }// end of dataLoad()

	    
}//end of class
