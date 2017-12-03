package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginFrame {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LoginFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		LoginPanel loginPanel = new LoginPanel();
		frame.getContentPane().add(loginPanel);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
	
	public class LoginPanel extends JPanel {
		
		private JTextField txtPassword;
		private JTextField txtEmail;


		/**
		 * Create the panel.
		 */
		public LoginPanel() {
			
			JButton btnLogin = new JButton("Login");
			btnLogin.setBounds(192, 302, 89, 23);
			
			txtPassword = new JTextField();
			txtPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txtPassword.selectAll();
				}
			});
			txtPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtPassword.selectAll();
				}
			});
			txtPassword.setText("Password");
			txtPassword.setBounds(143, 256, 192, 20);
			txtPassword.setColumns(10);
			
			txtEmail = new JTextField();
			
			txtEmail.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtEmail.selectAll();
				}
			});
		
			txtEmail.setText("Email");
			txtEmail.selectAll();
			txtEmail.setToolTipText("Vuur je email in.");
			txtEmail.setBounds(143, 214, 192, 20);
			txtEmail.setColumns(10);
			
			JLabel lblTest = new JLabel("test");
			lblTest.setForeground(Color.BLACK);
			lblTest.setBounds(140, 154, 195, 33);
			
			this.add(lblTest);
			this.add(txtEmail);
			this.add(txtPassword);
			this.add(btnLogin);
			
			/*btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTest.setText("De email of de wachtwoord is fout");
					lblTest.setForeground(Color.red);
					//frame.dispose();
					//TrainingFrame trainingF = new TrainingFrame();
					//trainingF.setVisible(true);
				}
			});*/

		}
	

	}}

