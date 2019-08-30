package components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class LabelEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
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
	public LabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(UIManager.getColor("EditorPane.selectionBackground"), 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("This is Title....");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setForeground(new Color(0, 0, 139));
		lblTitle.setBounds(58, 46, 133, 22);
		contentPane.add(lblTitle);
		
		JLabel label = new JLabel("Java DB Class");
		label.setBounds(58, 78, 133, 22);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	// 마우스 클릭 시 이벤트 발생시키는 메서드
				lblTitle.setForeground(new Color(0,0,255));
			}
		});
		
		btnNewButton.setBounds(58, 188, 97, 23);
		contentPane.add(btnNewButton);
	}
}
