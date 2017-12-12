package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import models.TrainingInfo;

public class NewTrianingPane extends JPanel {
	
	private JTextField txtTitle;
	private JTextField txtNumberOfDays;
	private JTextField txtPrice;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JButton btnBack;
	private JButton btnSave;
	private JButton btnAddNewTraining;
	private JEditorPane epDescriptionExam;
	private JEditorPane epDescriptionPayement;
	private JEditorPane epDescription;
	private JLabel lblAddNewTraining;
	private JScrollPane sclDescription;
	private JScrollPane sclDescriptionExam;
	private JScrollPane sclDescriptionPayement;
	private JButton btnSelectSurvey;
	
	/**
	 * Create the panel.
	 */
	public NewTrianingPane() {
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		jtbTraining = new JToggleButton("Training");
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
		
		jtbTrainingSession = new JToggleButton("Training session");
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
		
		jtbEmployees = new JToggleButton("Employees");
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
		
		jtbStatistics = new JToggleButton("Statistics");
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
		
		jtbTrainingRequests = new JToggleButton("Training requests");
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
		
		btnBack = new JButton("<-  Back");
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTraining");
		add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(170, 100, 110, 50);
		btnSave.setActionCommand("SaveTraining");
		add(btnSave);
		
		btnAddNewTraining = new JButton("Add new training");
		btnAddNewTraining.setBounds(310, 100, 140, 50);
		btnAddNewTraining.setActionCommand("AddNewTraining");
		add(btnAddNewTraining);
		
		btnSelectSurvey = new JButton("Select Survey");
		btnSelectSurvey.setActionCommand("selectSurvey");
		btnSelectSurvey.setBounds(438, 225, 117, 29);
		add(btnSelectSurvey);
		
		
		lblAddNewTraining = new JLabel("Add new training");
		lblAddNewTraining.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		epDescription.setBorder(border1);
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
		epDescriptionExam.setBorder(border1);
		sclDescriptionExam = new JScrollPane(epDescriptionExam);
		sclDescriptionExam.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionExam.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclDescriptionExam.setBounds(660, 225, 500, 180);
		add(sclDescriptionExam);
		
		JLabel lblDescriptionPayement = new JLabel("Description payement");
		lblDescriptionPayement.setBounds(660, 426, 150, 14);
		add(lblDescriptionPayement);
		
		epDescriptionPayement = new JEditorPane();
		epDescriptionPayement.setBorder(border1);
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
		btnAddNewTraining.addActionListener(listener);
		btnSelectSurvey.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
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

}
