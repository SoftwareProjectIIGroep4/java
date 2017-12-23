package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;


public class LoginPane extends JPanel {

	private JPasswordField  txtPassword;
	private JTextField txtEmail;
    private JButton btnLogin;
    private JLabel lblMessage;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JLabel lblNewLabel;
	
	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setActionCommand("Login");
		btnLogin.setBounds(549, 381, 149, 50);
		
		txtPassword = new JPasswordField ();
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
		txtPassword.setBounds(526, 338, 192, 20);
		txtPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPassword.selectAll();
			}
		});
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtEmail.selectAll();
			}
		});
	
		txtEmail.selectAll();
		txtEmail.setBounds(526, 249, 192, 20);
		txtEmail.setColumns(10);
		
		lblMessage = new JLabel("");

		lblMessage.setForeground(Color.BLACK);
		lblMessage.setBounds(140, 154, 195, 33);
		
		this.add(lblMessage);
		this.add(txtEmail);
		this.add(txtPassword);
		this.add(btnLogin);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(526, 316, 96, 20);
		add(lblPassword);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(526, 223, 96, 20);
		add(lblUsername);
		
		lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(569, 137, 129, 50);
		add(lblNewLabel);
			
	}
	
	 public void addActionListener(ActionListener listener) {
		 	btnLogin.addActionListener(listener);
	    }
	 
	 
	 public String getEmail() {
	        return txtEmail.getText();
	    }
	 public String getPassword() {
	        return txtPassword.getText();
	   }
}
