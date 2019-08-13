package components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class TextInputEx extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextInputEx frame = new TextInputEx();
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
	public TextInputEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);	// (x, y, n, m) : x와 y는 실행 시 창이 뜨는 좌표, n과 m은 실행되는 창 크기
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(91, 62, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblContents = new JLabel("Contents");
		lblContents.setBounds(91, 107, 57, 15);
		contentPane.add(lblContents);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(91, 304, 57, 15);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setText("input your name");
		txtName.setToolTipText("this is tooltip...");
		txtName.setBounds(179, 59, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(179, 103, 209, 172);
		contentPane.add(textArea);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(179, 301, 116, 21);
		contentPane.add(txtPwd);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(179, 349, 97, 23);
		contentPane.add(btnStore);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				textArea.setText("");
				txtPwd.setText("");
			}
		});
		btnReset.setBounds(298, 349, 97, 23);
		contentPane.add(btnReset);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(421, 103, 135, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JCheckBox chkCpp = new JCheckBox("C++");
		chkCpp.setBounds(421, 149, 115, 23);
		contentPane.add(chkCpp);
		
		JCheckBox chkJava = new JCheckBox("Java");
		chkJava.setBounds(540, 149, 115, 23);
		contentPane.add(chkJava);
		
		ButtonGroup grp = new ButtonGroup();
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setBounds(421, 194, 121, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setBounds(540, 194, 121, 23);
		contentPane.add(rdoFemale);
		
		grp.add(rdoMale);
		grp.add(rdoFemale);
		
		String[] pet = {"Make selection", "Cat", "Dog", "Rabbit", "Pig"};
		
		JList list = new JList(pet);
		list.setBounds(400, 240, 100, 100);
		contentPane.add(list);
		
		JComboBox combo = new JComboBox(pet);	// 드롭다운 리스트
		combo.setBounds(550, 240, 150, 30);
		contentPane.add(combo);
		
	}
}
