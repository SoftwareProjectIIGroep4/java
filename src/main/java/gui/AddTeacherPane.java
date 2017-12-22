package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dataAccess.Cache;
import models.Settings;

public class AddTeacherPane extends JPanel {

	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JTextField txtTeacherFirstName;
	private JTextField txtTeacherLastName;
	private JTextField txtTeacherEmail;
	private JTextField txtTeacherPhoneNumber;
	private JButton btnSubmitAddTeacher;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	
	/**
	 * Create the panel.
	 */
	public AddTeacherPane() {
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		  
		  	try {
				settings = Cache.settingsCache.get(1);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        companyName = new JLabel(settings.getCompanyName()); //uit cache halen f
	        companyName.setBounds(10, 0, 110, 75);
	        companyName.setOpaque(true);
	        add(companyName);
		  
		  	jtbSettings = new JButton("Settings");
		  	jtbSettings.setBackground(Color.WHITE);
		  	jtbSettings.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbSettings.setOpaque(true);
	        jtbSettings.setActionCommand("SettingsMenu");
	        jtbSettings.setBounds(1190, 12, 70, 50);
	        add(jtbSettings);
	        
		  btnTraining = new JButton("Training"); 
		  btnTraining.setBackground(Color.WHITE);
		  btnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		  btnTraining.setOpaque(true);
		  btnTraining.setActionCommand("TrainingMenu");
		  btnTraining.setBounds(124, 0, 264, 75);
	        add(btnTraining);
	        
	        btnTrainingsession = new JButton("Training session");
	        btnTrainingsession.setBackground(Color.WHITE);
	        btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
	        btnTrainingsession.setOpaque(true);
	        btnTrainingsession.setActionCommand("TrainingSessionMenu");
	        btnTrainingsession.setBounds(387, 0, 264, 75);
	        add(btnTrainingsession);
	        
	        btnEmployees = new JButton("Employees");
	        btnEmployees.setBackground(Color.WHITE);
	        btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        btnEmployees.setOpaque(true);
	        btnEmployees.setActionCommand("EmployeesMenu");
	        btnEmployees.setBounds(650, 0, 264, 75);
	        add(btnEmployees);
	        
	        btnStatistics = new JButton("Statistics");
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
	        
	        JLabel lblTeacherFirstName = new JLabel("First name:");
	        lblTeacherFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblTeacherFirstName.setBounds(100, 179, 94, 36);
	        add(lblTeacherFirstName);
	        
	        JLabel lblTeacherLastName = new JLabel("Last name:");
	        lblTeacherLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblTeacherLastName.setBounds(100, 247, 94, 36);
	        add(lblTeacherLastName);
	        
	        JLabel lblTeacherEmail = new JLabel("E-MAIL:");
	        lblTeacherEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblTeacherEmail.setBounds(100, 321, 94, 36);
	        add(lblTeacherEmail);
	        
	        JLabel lblPhoneNumber = new JLabel("Phone number:");
	        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblPhoneNumber.setBounds(100, 383, 109, 36);
	        add(lblPhoneNumber);
	         
	        txtTeacherFirstName = new JTextField();
	        txtTeacherFirstName.setBounds(221, 186, 157, 36);
	        add(txtTeacherFirstName);
	        txtTeacherFirstName.setColumns(10);
	        
	        txtTeacherLastName = new JTextField();
	        txtTeacherLastName.setBounds(221, 249, 157, 36);
	        add(txtTeacherLastName);
	        txtTeacherLastName.setColumns(10);
	        
	        txtTeacherEmail = new JTextField();
	        txtTeacherEmail.setBounds(221, 323, 157, 36);
	        add(txtTeacherEmail);
	        txtTeacherEmail.setColumns(10);
	        
	        txtTeacherPhoneNumber = new JTextField();
	        txtTeacherPhoneNumber.setBounds(221, 385, 157, 36);
	        add(txtTeacherPhoneNumber);
	        txtTeacherPhoneNumber.setColumns(10);
	        
	        btnSubmitAddTeacher = new JButton("Add teacher");
	        btnSubmitAddTeacher.setActionCommand("addTeacher");
	        btnSubmitAddTeacher.setBounds(504, 281, 123, 51);
	        add(btnSubmitAddTeacher);
	}
	
	public void addActionListener(ActionListener listener) {
		btnSubmitAddTeacher.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	public String getTeacherFirstnameSearch() {
        return txtTeacherFirstName.getText();
    }
	
	public String getTeacherLastnameSearch() {
        return txtTeacherLastName.getText();
    }
	
	public String getTeacherEmailSearch() {
        return txtTeacherEmail.getText();
    }
	
	public String getTeacherPhonenumberSearch() {
        return txtTeacherPhoneNumber.getText();
    }
}
