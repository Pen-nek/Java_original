package watcha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {

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
	}

}
