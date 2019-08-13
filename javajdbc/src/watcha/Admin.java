package watcha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_4;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWahtcha = new JLabel("WATCHA (Admin)");
		lblWahtcha.setHorizontalAlignment(SwingConstants.CENTER);
		lblWahtcha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWahtcha.setBounds(229, 10, 476, 52);
		contentPane.add(lblWahtcha);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBounds(487, 121, 412, 340);
		contentPane.add(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(41, 471, 86, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(237, 471, 86, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login Login = new Login();
				Login.setVisible(true);
			}
		});
		btnExit.setBounds(813, 471, 86, 23);
		contentPane.add(btnExit);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(139, 471, 86, 23);
		contentPane.add(btnUpdate);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(684, 95, 116, 21);
		contentPane.add(textField_4);
		
		JLabel lblMovieList = new JLabel("Movie Review List");
		lblMovieList.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblMovieList.setBounds(487, 96, 137, 15);
		contentPane.add(lblMovieList);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(812, 94, 86, 23);
		contentPane.add(btnSearch);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.menu);
		table_1.setBounds(39, 121, 412, 340);
		contentPane.add(table_1);
		
		JLabel lblMemberList = new JLabel("Member List");
		lblMemberList.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblMemberList.setBounds(41, 95, 107, 15);
		contentPane.add(lblMemberList);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(237, 94, 116, 21);
		contentPane.add(textField);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(365, 93, 86, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("ADD");
		button_1.setBounds(487, 471, 86, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.setBounds(585, 471, 86, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("DELETE");
		button_3.setBounds(683, 471, 86, 23);
		contentPane.add(button_3);
	}
}
