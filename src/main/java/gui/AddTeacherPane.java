package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

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
	
	/**
	 * Create the panel.
	 */
	public AddTeacherPane() {
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
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
	        
	        JLabel lblNewLabel = new JLabel("logo");
	        lblNewLabel.setBounds(0, 0, 133, 75);
	        lblNewLabel.setOpaque(true);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Profiel");
	        lblNewLabel_1.setBounds(1186, 0, 85, 75);
	        lblNewLabel_1.setOpaque(true);
	        add(lblNewLabel_1);
	        
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
