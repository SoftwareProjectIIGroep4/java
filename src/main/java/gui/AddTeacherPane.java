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

	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
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
	        
	        jtbTraining = new JButton("Training");
	        jtbTraining.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTraining.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTraining.setBorder(null);
	            }
	        });
	        jtbTraining.setBackground(Color.WHITE);
	        jtbTraining.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTraining.setOpaque(true);
	        jtbTraining.setActionCommand("TrainingMenu");
	        jtbTraining.setBounds(133, 0, 211, 75);
	        add(jtbTraining);
	        
	        jtbTrainingSession = new JButton("Training session");
	        jtbTrainingSession.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingSession.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingSession.setBorder(null);
	            }
	        });
	        jtbTrainingSession.setBackground(Color.WHITE);
	        jtbTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingSession.setOpaque(true);
	        jtbTrainingSession.setActionCommand("TrainingSessionMenu");
	        jtbTrainingSession.setBounds(344, 0, 211, 75);
	        add(jtbTrainingSession);
	        
	        jtbEmployees = new JButton("Employees");
	        jtbEmployees.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbEmployees.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbEmployees.setBorder(null);
	            }
	        });
	        jtbEmployees.setBackground(Color.WHITE);
	        jtbEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbEmployees.setOpaque(true);
	        jtbEmployees.setActionCommand("EmployeesMenu");
	        jtbEmployees.setBounds(555, 0, 212, 75);
	        add(jtbEmployees);
	        
	        jtbStatistics = new JButton("Statistics");
	        jtbStatistics.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbStatistics.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbStatistics.setBorder(null);
	            }
	        });
	        jtbStatistics.setBackground(Color.WHITE);
	        jtbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbStatistics.setOpaque(true);
	        jtbStatistics.setActionCommand("StatisticsMenu");
	        jtbStatistics.setBounds(767, 0, 212, 75);
	        add(jtbStatistics);
	        
	        jtbTrainingRequests = new JButton("Training requests");
	        jtbTrainingRequests.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingRequests.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingRequests.setBorder(null);
	            }
	        });
	        jtbTrainingRequests.setBackground(Color.WHITE);
	        jtbTrainingRequests.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingRequests.setOpaque(true);
	        jtbTrainingRequests.setActionCommand("TrainingRequestsMenu");
	        jtbTrainingRequests.setBounds(979, 0, 211, 75);
	        add(jtbTrainingRequests);
	        
	        JLabel lblNewLabel = new JLabel("logo");
	        lblNewLabel.setBounds(0, 0, 133, 75);
	        lblNewLabel.setOpaque(true);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Profiel");
	        lblNewLabel_1.setBounds(1190, 0, 75, 75);
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
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
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
