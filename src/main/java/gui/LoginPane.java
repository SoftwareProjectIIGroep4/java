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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginPane extends JPanel {

	private JTextField txtPassword;
	private JTextField txtEmail;
    private JButton btnLogin;
    private JLabel lblMessage;
	
	/**
	 * Create the panel.
	 */
    
	public LoginPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setActionCommand("Login");
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
	
		txtEmail.setText("Email");
		txtEmail.selectAll();
		txtEmail.setToolTipText("Vuur je email in.");
		txtEmail.setBounds(143, 214, 192, 20);
		txtEmail.setColumns(10);
		
		lblMessage = new JLabel("");

		lblMessage.setForeground(Color.BLACK);
		lblMessage.setBounds(140, 154, 195, 33);
		
		this.add(lblMessage);
		this.add(txtEmail);
		this.add(txtPassword);
		this.add(btnLogin);
			
	}
	
	 public void addActionListener(ActionListener listener) {
		 	btnLogin.addActionListener(listener);
	    }
	 void changeColor() {
		 	lblMessage.setText("De email of de wachtwoord is fout");
			lblMessage.setForeground(Color.red);
	 }
	 
	 public String getEmail() {
	        return txtEmail.getText();
	    }
	public String getPassword() {
	        return txtPassword.getText();
	   }
}
