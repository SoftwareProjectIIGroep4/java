package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JButton;

public class StatistiekenPane extends JPanel {

	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private JButton btnTrainingStatistics;
	private JButton btnEmployeeStatistics;
	
	/**
	 * Create the panel.
	 */
	public StatistiekenPane() {
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);


		jtbTraining = new JButton("Training");
       /* jtbTraining.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jtbTraining.setBorder(border);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jtbTraining.setBorder(null);
            }
        });*/
        jtbTraining.setBackground(Color.WHITE);
        jtbTraining.setHorizontalAlignment(SwingConstants.CENTER);
        jtbTraining.setOpaque(true);
        jtbTraining.setActionCommand("TrainingMenu");
        jtbTraining.setBounds(133, 0, 211, 75);
        add(jtbTraining);
        
        jtbTrainingSession = new JButton("Training session");
       /* jtbTrainingSession.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jtbTrainingSession.setBorder(border);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jtbTrainingSession.setBorder(null);
            }
        });*/
        jtbTrainingSession.setBackground(Color.WHITE);
        jtbTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
        jtbTrainingSession.setOpaque(true);
        jtbTrainingSession.setActionCommand("TrainingSessionMenu");
        jtbTrainingSession.setBounds(344, 0, 211, 75);
        add(jtbTrainingSession);
        
        jtbEmployees = new JButton("Employees");
       /* jtbEmployees.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jtbEmployees.setBorder(border);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jtbEmployees.setBorder(null);
            }
        });*/
        jtbEmployees.setBackground(Color.WHITE);
        jtbEmployees.setHorizontalAlignment(SwingConstants.CENTER);
        jtbEmployees.setOpaque(true);
        jtbEmployees.setActionCommand("EmployeesMenu");
        jtbEmployees.setBounds(555, 0, 212, 75);
        add(jtbEmployees);
        
        jtbStatistics = new JButton("Statistics");
       /* jtbStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jtbStatistics.setBorder(border);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jtbStatistics.setBorder(null);
            }
        });*/
        jtbStatistics.setBackground(Color.WHITE);
        jtbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        jtbStatistics.setOpaque(true);
        jtbStatistics.setActionCommand("StatisticsMenu");
        jtbStatistics.setBounds(767, 0, 212, 75);
        add(jtbStatistics);
        
        jtbTrainingRequests = new JButton("Training requests");
      /*  jtbTrainingRequests.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jtbTrainingRequests.setBorder(border);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jtbTrainingRequests.setBorder(null);
            }
        });*/
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
        
        JLabel lblNewLabel_2 = new JLabel("Choose the category of which you want to see the statistics");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(442, 142, 422, 38);
        add(lblNewLabel_2);
        
        btnTrainingStatistics = new JButton("Training");
        btnTrainingStatistics.setActionCommand("goToTrainingStatistics");
        btnTrainingStatistics.setBounds(555, 214, 177, 38);
        add(btnTrainingStatistics);
        
        btnEmployeeStatistics = new JButton("Employees");
        btnEmployeeStatistics.setActionCommand("goToEmployeeStatistics");
        btnEmployeeStatistics.setBounds(555, 286, 177, 38);
        add(btnEmployeeStatistics);
        
	}
	
	public void addActionListener(ActionListener listener) {
		btnEmployeeStatistics.addActionListener(listener);
		btnTrainingStatistics.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
}
