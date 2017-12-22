package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dataAccess.Cache;
import models.Settings;

public class StatisticsPane extends JPanel {

	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JLabel lblNewLabel_2;
	private JButton btnParticipationTrainingsEmployeeStatistics;
	private JButton btnParticipationMaxEmployeeStatistics;
	private JButton btnCertEmployeeStatistics;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	
	/**
	 * Create the panel.
	 */
	public StatisticsPane() {
		
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
        
        lblNewLabel_2 = new JLabel("Choose an option to consult statistics");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(492, 103, 296, 35);
        add(lblNewLabel_2);
        
        btnParticipationTrainingsEmployeeStatistics = new JButton("Trainings the employee took part of");
        btnParticipationTrainingsEmployeeStatistics.setActionCommand("goToStatisticsFollowedTraining");
        btnParticipationTrainingsEmployeeStatistics.setBounds(461, 165, 327, 46);
        add(btnParticipationTrainingsEmployeeStatistics);
        
        btnParticipationMaxEmployeeStatistics = new JButton("Which employee participated to the most trainings");
        btnParticipationMaxEmployeeStatistics.setActionCommand("goToStatisticsTrainingParticipation");
        btnParticipationMaxEmployeeStatistics.setBounds(461, 235, 327, 46);
        add(btnParticipationMaxEmployeeStatistics);
        
        btnCertEmployeeStatistics = new JButton("Which certificates does an employee have");
        btnCertEmployeeStatistics.setActionCommand("goToStatisticsCertificatesEmployee");
        btnCertEmployeeStatistics.setBounds(461, 304, 327, 46);
        add(btnCertEmployeeStatistics);
        
	}
	
	public void addActionListener(ActionListener listener) {
		btnParticipationTrainingsEmployeeStatistics.addActionListener(listener);
		btnParticipationMaxEmployeeStatistics.addActionListener(listener);
		btnCertEmployeeStatistics.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
}
