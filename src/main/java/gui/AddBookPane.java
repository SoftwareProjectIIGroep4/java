package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

public class AddBookPane extends JPanel {

	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JLabel lblBookTitle;
	private JLabel lblBookAuthor;
	private JTextField txtBookTitle;
	private JTextField txtBookAuthor;
	private JButton btnAddBookToTrainingSession;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	private JButton btnBackToNewTrainingsessio;
	
	/**
	 * Create the panel.
	 */
	
	public AddBookPane() {
		
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
	        jtbSettings.setBounds(1175, 0, 105, 75);
	        add(jtbSettings);
	        
		  btnTraining = new JButton("Training"); 
		  btnTraining.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
		  btnTraining.setBackground(Color.WHITE);
		  btnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		  btnTraining.setOpaque(true);
		  btnTraining.setActionCommand("TrainingMenu");
		  btnTraining.setBounds(124, 0, 264, 75);
	        add(btnTraining);
	        
	        btnTrainingsession = new JButton("Training session");
	        btnTrainingsession.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
	        btnTrainingsession.setBackground(Color.WHITE);
	        btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
	        btnTrainingsession.setOpaque(true);
	        btnTrainingsession.setActionCommand("TrainingSessionMenu");
	        btnTrainingsession.setBounds(387, 0, 264, 75);
	        add(btnTrainingsession);
	        
	        btnEmployees = new JButton("Employees");
	        btnEmployees.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
	        btnEmployees.setBackground(Color.WHITE);
	        btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        btnEmployees.setOpaque(true);
	        btnEmployees.setActionCommand("EmployeesMenu");
	        btnEmployees.setBounds(650, 0, 264, 75);
	        add(btnEmployees);
	        
	        btnStatistics = new JButton("Statistics");
	        btnStatistics.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
	        
	        lblBookTitle = new JLabel("Book title:");
	        lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblBookTitle.setBounds(124, 215, 109, 34);
	        add(lblBookTitle);
	        
	        lblBookAuthor = new JLabel("Author:");
	        lblBookAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblBookAuthor.setBounds(133, 267, 109, 34);
	        add(lblBookAuthor);
	        
	        txtBookTitle = new JTextField();
	        txtBookTitle.setBounds(255, 217, 133, 34);
	        add(txtBookTitle);
	        txtBookTitle.setColumns(10);
	        
	        txtBookAuthor = new JTextField();
	        txtBookAuthor.setBounds(255, 269, 133, 34);
	        add(txtBookAuthor);
	        txtBookAuthor.setColumns(10);
	        
	        btnAddBookToTrainingSession = new JButton("Add Book");
	        btnAddBookToTrainingSession.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
	        btnAddBookToTrainingSession.setActionCommand("addBookToTrainingsession");
	        btnAddBookToTrainingSession.setBounds(459, 240, 160, 45);
	        add(btnAddBookToTrainingSession);
	        
	        btnBackToNewTrainingsessio = new JButton("Back");
	        btnBackToNewTrainingsessio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtBookTitle.setText("");
					txtBookAuthor.setText("");
				}
			});
	        btnBackToNewTrainingsessio.setActionCommand("backToNewTrainingSessio");
	        btnBackToNewTrainingsessio.setBounds(30, 106, 123, 41);
	        add(btnBackToNewTrainingsessio);
	}
	
	public void addActionListener(ActionListener listener) {
		btnAddBookToTrainingSession.addActionListener(listener);
		btnBackToNewTrainingsessio.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	
	public String getBookTitleTrainingsession() {
        return txtBookTitle.getText();
    }
	
	public String getBookAuthorTrainingsession() {
        return txtBookAuthor.getText();
    }
}
