package others;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class GuiTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTest frame = new GuiTest();
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
	public GuiTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblBlahBlah = new JLabel("blah blah");
		contentPane.add(lblBlahBlah, BorderLayout.NORTH);
		
		JButton btnButton = new JButton("button1");
		contentPane.add(btnButton, BorderLayout.CENTER);
		
		JCheckBox chckbxCheckBox = new JCheckBox("check box");
		chckbxCheckBox.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(chckbxCheckBox, BorderLayout.EAST);
	}

}
