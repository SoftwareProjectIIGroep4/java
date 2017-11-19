package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;


public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameEmployeeSearch;
	private JTextField departmentEmployeeSearch;
	private JTextField functionEmployeeSearch;
	private String fullEmployee;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		// create a line border with the specified color and width
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK,1);
        
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
            public void mouseClicked(MouseEvent e) {
        		dispose();
				StatistiekenFrame statistiekenFr = new StatistiekenFrame();
				statistiekenFr.setVisible(true);
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
        
        JLabel lblEmployeeName = new JLabel("Employee name");
        lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmployeeName.setBounds(31, 115, 152, 14);
        contentPane.add(lblEmployeeName);
        
        JButton addEmployeeButton = new JButton("Add employee");
        addEmployeeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		AddEmployeeFrame addEmployeeFr = new AddEmployeeFrame();
        		addEmployeeFr.setVisible(true);
        	}
        });
        addEmployeeButton.setBounds(977, 115, 187, 68);
        contentPane.add(addEmployeeButton);
        
        JLabel lblNewLabel_2 = new JLabel("SEARCH EMPLOYEE");
        lblNewLabel_2.setBounds(941, 344, 144, 28);
        contentPane.add(lblNewLabel_2);
        
        nameEmployeeSearch = new JTextField();
        nameEmployeeSearch.setBounds(977, 439, 189, 35);
        contentPane.add(nameEmployeeSearch);
        nameEmployeeSearch.setColumns(10);
        
        departmentEmployeeSearch = new JTextField();
        departmentEmployeeSearch.setBounds(975, 516, 189, 35);
        contentPane.add(departmentEmployeeSearch);
        departmentEmployeeSearch.setColumns(10);
        
        functionEmployeeSearch = new JTextField();
        functionEmployeeSearch.setBounds(975, 587, 189, 35);
        contentPane.add(functionEmployeeSearch);
        functionEmployeeSearch.setColumns(10);
        
        JLabel employeeSearchBorder = new JLabel("");
        employeeSearchBorder.setBounds(941, 383, 279, 287);
        employeeSearchBorder.setBorder(border);
        contentPane.add(employeeSearchBorder);
        
        JLabel lblNewLabel_3 = new JLabel("Department");
        lblNewLabel_3.setBounds(332, 117, 100, 12);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Function");
        lblNewLabel_4.setBounds(555, 117, 138, 14);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Name");
        lblNewLabel_5.setBounds(977, 408, 65, 21);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Department");
        lblNewLabel_6.setBounds(977, 485, 100, 14);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblFunction = new JLabel("Function");
        lblFunction.setBounds(977, 562, 100, 14);
        contentPane.add(lblFunction);
        
        JButton btnDeleteEmployee = new JButton("Delete employee");
        btnDeleteEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		DeleteEmployeeFrame deleteEmployeeFr = new DeleteEmployeeFrame();
        		deleteEmployeeFr.setVisible(true);
        	}
        });
        btnDeleteEmployee.setBounds(977, 229, 187, 68);
        contentPane.add(btnDeleteEmployee);
        
       
        
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                lblNewLabel.setBackground(Color.GREEN);
            }
        });
	}
}