package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dataAccess.Cache;
import models.Settings;

public class NewTrianingPane extends JPanel {
	
	private JTextField txtTitle;
	private JTextField txtNumberOfDays;
	private JTextField txtPrice;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnBack;
	private JButton btnSave;
	private JEditorPane epDescriptionExam;
	private JEditorPane epDescriptionPayement;
	private JEditorPane epDescription;
	private JLabel lblAddNewTraining;
	private JScrollPane sclDescription;
	private JScrollPane sclDescriptionExam;
	private JScrollPane sclDescriptionPayement;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	
	/**
	 * Create the panel.
	 */
	public NewTrianingPane() {
		
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
					txtTitle.setText("");
					txtNumberOfDays.setText("");
					txtPrice.setText("");
					epDescription.setText("");
					epDescriptionExam.setText("");
					epDescriptionPayement.setText("");
					
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
					txtTitle.setText("");
					txtNumberOfDays.setText("");
					txtPrice.setText("");
					epDescription.setText("");
					epDescriptionExam.setText("");
					epDescriptionPayement.setText("");
					
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
					txtTitle.setText("");
					txtNumberOfDays.setText("");
					txtPrice.setText("");
					epDescription.setText("");
					epDescriptionExam.setText("");
					epDescriptionPayement.setText("");
					
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
					txtTitle.setText("");
					txtNumberOfDays.setText("");
					txtPrice.setText("");
					epDescription.setText("");
					epDescriptionExam.setText("");
					epDescriptionPayement.setText("");
					
				}
			});
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTitle.setText("");
				txtNumberOfDays.setText("");
				txtPrice.setText("");
				epDescription.setText("");
				epDescriptionExam.setText("");
				epDescriptionPayement.setText("");
				
			}
		});
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTraining");
		add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTitle.setText("");
				txtNumberOfDays.setText("");
				txtPrice.setText("");
				epDescription.setText("");
				epDescriptionExam.setText("");
				epDescriptionPayement.setText("");
				
			}
		});
		btnSave.setBounds(170, 100, 110, 50);
		btnSave.setActionCommand("SaveTraining");
		add(btnSave);
		
		
		lblAddNewTraining = new JLabel("Add new training");
		lblAddNewTraining.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddNewTraining.setBounds(40, 161, 140, 14);
		add(lblAddNewTraining);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(50, 200, 46, 14);
		add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(50, 225, 300, 25);
		add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(50, 271, 100, 14);
		add(lblDescription);
		
		epDescription = new JEditorPane();
		//epDescription.setBounds(50, 296, 500, 180);
		epDescription.setBorder(border);
		//add(epDescription);
		sclDescription = new JScrollPane(epDescription);
		sclDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclDescription.setBounds(50, 296, 500, 180);
		add(sclDescription);
		
		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setForeground(Color.BLACK);
		lblNumberOfDays.setBounds(50, 497, 100, 14);
		add(lblNumberOfDays);
		
		txtNumberOfDays = new JTextField();
		txtNumberOfDays.setBounds(50, 522, 86, 20);
		add(txtNumberOfDays);
		txtNumberOfDays.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(50, 563, 46, 14);
		add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(50, 588, 86, 20);
		add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblDescriptionExam = new JLabel("Description exam");
		lblDescriptionExam.setBounds(660, 200, 100, 14);
		add(lblDescriptionExam);
		
		epDescriptionExam = new JEditorPane();
		epDescriptionExam.setBorder(border);
		sclDescriptionExam = new JScrollPane(epDescriptionExam);
		sclDescriptionExam.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionExam.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionExam.setBounds(660, 225, 500, 180);
		add(sclDescriptionExam);
		
		JLabel lblDescriptionPayement = new JLabel("Description payement");
		lblDescriptionPayement.setBounds(660, 426, 150, 14);
		add(lblDescriptionPayement);
		
		epDescriptionPayement = new JEditorPane();
		epDescriptionPayement.setBorder(border);
		sclDescriptionPayement = new JScrollPane(epDescriptionPayement);
		sclDescriptionPayement.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionPayement.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionPayement.setBounds(660, 451, 500, 180);
		add(sclDescriptionPayement);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(30, 186, 1224, 484);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
		
	}
	
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	public String getTitle() {
		
        return txtTitle.getText();
    }
	public void setTitle(String text) {
		txtTitle.setText(text);
    }
	public int getNumberOfDays() {
        return Integer.parseInt(txtNumberOfDays.getText());
    }
	public void setNumberOfDays(String text) {
		txtNumberOfDays.setText(text);
    }
	public float getPrice() {
        return Float.valueOf(txtPrice.getText());
    }
	public void setPrice(String text) {
		txtPrice.setText(text);
    }
	
	public String getDescriptionExam() {
        return epDescriptionExam.getText();
    }
	public void setDescriptionExam(String text) {
		epDescriptionExam.setText(text);
    }
	public String getDescriptionPayement() {
        return epDescriptionPayement.getText();
    }
	public void setDescriptionPayement(String text) {
		epDescriptionPayement.setText(text);
    }
	public String getDescription() {
        return epDescription.getText();
    }
	public void setDescription(String text) {
		epDescription.setText(text);
    }

	public int getSurveyId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
