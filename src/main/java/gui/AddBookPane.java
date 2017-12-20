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
import javax.swing.JTextField;
import javax.swing.JButton;

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
	
	/**
	 * Create the panel.
	 */
	
	public AddBookPane() {
		
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
	        
	        lblBookTitle = new JLabel("Book title:");
	        lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblBookTitle.setBounds(133, 182, 109, 34);
	        add(lblBookTitle);
	        
	        lblBookAuthor = new JLabel("Author:");
	        lblBookAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblBookAuthor.setBounds(133, 245, 109, 34);
	        add(lblBookAuthor);
	        
	        txtBookTitle = new JTextField();
	        txtBookTitle.setBounds(252, 184, 133, 34);
	        add(txtBookTitle);
	        txtBookTitle.setColumns(10);
	        
	        txtBookAuthor = new JTextField();
	        txtBookAuthor.setBounds(252, 247, 133, 34);
	        add(txtBookAuthor);
	        txtBookAuthor.setColumns(10);
	        
	        btnAddBookToTrainingSession = new JButton("Add Book");
	        btnAddBookToTrainingSession.setActionCommand("addBookToTrainingsession");
	        btnAddBookToTrainingSession.setBounds(460, 212, 160, 45);
	        add(btnAddBookToTrainingSession);
	}
	
	public void addActionListener(ActionListener listener) {
		btnAddBookToTrainingSession.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
    }
	
	public String getBookTitleTrainingsession() {
        return txtBookTitle.getText();
    }
	
	public String getBookAuthorTrainingsession() {
        return txtBookAuthor.getText();
    }

}
