package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.EmployeeFrame;


public class AddEmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textfieldEmployeeName;
	private JTextField textfieldEmployeeDepartment;
	private JTextField textfieldEmployeeFunction;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeFrame frame = new AddEmployeeFrame();
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
	public AddEmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		// create a line border with the specified color and width
		
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        JLabel lblTraining1 = new JLabel("Training");
        lblTraining1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTraining1.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTraining1.setBorder(null);
            }
        	
			@Override
        	public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingFrame trainingFr = new TrainingFrame();
        		trainingFr.setVisible(true);
        	}
        });
        lblTraining1.setBackground(Color.WHITE);
        lblTraining1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTraining1.setOpaque(true);
        lblTraining1.setBounds(133, 0, 213, 75);
        contentPane.add(lblTraining1);
        
        JLabel lblTrainingSession = new JLabel("Training session");
        lblTrainingSession.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTrainingSession.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTrainingSession.setBorder(null);
            }
        });
        lblTrainingSession.setBackground(Color.WHITE);
        lblTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainingSession.setOpaque(true);
        lblTrainingSession.setBounds(344, 0, 213, 75);
        contentPane.add(lblTrainingSession);
        
        JLabel lblEmployees = new JLabel("Employees");
        lblEmployees.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblEmployees.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblEmployees.setBorder(null);
            }
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
				EmployeeFrame employeeFr = new EmployeeFrame();
				employeeFr.setVisible(true);
        	}
        });
        lblEmployees.setBackground(Color.WHITE);
        lblEmployees.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployees.setOpaque(true);
        lblEmployees.setBounds(555, 0, 213, 75);
        contentPane.add(lblEmployees);
        
        JLabel lblStatistics = new JLabel("Statistics");
        lblStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblStatistics.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblStatistics.setBorder(null);
            }
        });
        lblStatistics.setBackground(Color.WHITE);
        lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatistics.setOpaque(true);
        lblStatistics.setBounds(766, 0, 213, 75);
        contentPane.add(lblStatistics);
        
        JLabel lblTrainingRequests = new JLabel("Training requests");
        lblTrainingRequests.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTrainingRequests.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTrainingRequests.setBorder(null);
            }
        });
        lblTrainingRequests.setBackground(Color.WHITE);
        lblTrainingRequests.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainingRequests.setOpaque(true);
        lblTrainingRequests.setBounds(977, 0, 213, 75);
        contentPane.add(lblTrainingRequests);
        
        JLabel lblNewLabel = new JLabel("logo");
        lblNewLabel.setBounds(0, 0, 133, 75);
        lblNewLabel.setOpaque(true);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Profiel");
        lblNewLabel_1.setBounds(1190, 0, 75, 75);
        lblNewLabel_1.setOpaque(true);
        contentPane.add(lblNewLabel_1);
        
        JButton backButtonEmployee = new JButton("Back");
        backButtonEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		EmployeeFrame employeeFr = new EmployeeFrame();
        		employeeFr.setVisible(true);
        	}
        });
        backButtonEmployee.setBounds(10, 108, 149, 57);
        contentPane.add(backButtonEmployee);
        
        JButton saveButtonEmployee = new JButton("Save");
        saveButtonEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		String name = textfieldEmployeeName.getText().toString();
        		String department = textfieldEmployeeDepartment.getText().toString();
        		String function = textfieldEmployeeFunction.getText().toString();
        		String fullemployee = name+" "+department+" "+function;
        		EmployeeFrame employeeFr = new EmployeeFrame();
        		employeeFr.setVisible(true);
        		
        	}
        });
        saveButtonEmployee.setBounds(191, 108, 149, 57);
        contentPane.add(saveButtonEmployee);
        
        JLabel AddEmployeeBorder = new JLabel("");
        AddEmployeeBorder.setBounds(10, 197, 1150, 456);
        AddEmployeeBorder.setBorder(border1);
        contentPane.add(AddEmployeeBorder);
        
        JLabel labelEmployeeName = new JLabel("Employee name");
        labelEmployeeName.setBounds(26, 221, 133, 25);
        contentPane.add(labelEmployeeName);
        
        textfieldEmployeeName = new JTextField();
        textfieldEmployeeName.setBounds(26, 257, 291, 38);
        contentPane.add(textfieldEmployeeName);
        textfieldEmployeeName.setColumns(10);
        
        JLabel labelEmployeeDepartment = new JLabel("Department");
        labelEmployeeDepartment.setBounds(26, 331, 114, 14);
        contentPane.add(labelEmployeeDepartment);
        
        textfieldEmployeeDepartment = new JTextField();
        textfieldEmployeeDepartment.setBounds(26, 356, 291, 41);
        contentPane.add(textfieldEmployeeDepartment);
        textfieldEmployeeDepartment.setColumns(10);
        
        JLabel labelEmployeeFunction = new JLabel("Function");
        labelEmployeeFunction.setBounds(26, 429, 114, 14);
        contentPane.add(labelEmployeeFunction);
        
        textfieldEmployeeFunction = new JTextField();
        textfieldEmployeeFunction.setBounds(26, 454, 291, 41);
        contentPane.add(textfieldEmployeeFunction);
        textfieldEmployeeFunction.setColumns(10);
        
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                lblNewLabel.setBackground(Color.GREEN);
            }
        });
	}
}