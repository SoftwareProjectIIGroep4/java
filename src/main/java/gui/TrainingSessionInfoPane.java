package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TrainingSessionInfoPane extends JPanel {
	
	private JButton btnBack;
	private JTextArea txtGeneralInfo;
	private JTextArea txtExamInfo;
	private JTextArea txtPaymentInfo;
	private JButton btnCancelTrainingSession;
	private JLabel lblTrainingSessionTitle;
	private JButton jtbInfo;
	private JButton jtbEnlistedPeople;
	private JButton jtbBooks;
	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;

	/**
	 * Create the panel.
	 */
	public TrainingSessionInfoPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		jtbTraining = new JButton("Training");
		/*jtbTraining.addMouseListener(new MouseAdapter() {
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
		/*jtbTrainingSession.addMouseListener(new MouseAdapter() {
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
		/*jtbEmployees.addMouseListener(new MouseAdapter() {
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
		/*jtbStatistics.addMouseListener(new MouseAdapter() {
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
		/*jtbTrainingRequests.addMouseListener(new MouseAdapter() {
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
		
		btnBack = new JButton("<-  Back");
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTrainingSessoin");
		add(btnBack);
		
		lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		add(lblTrainingSessionTitle);
		
		btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		btnCancelTrainingSession.setActionCommand("CancelTrainingSession");
		add(btnCancelTrainingSession);
		
		jtbInfo = new JButton("Info");
		//jtbInfo.setBackground(SystemColor.control);
		/*jtbInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbInfo.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbInfo.setBackground(SystemColor.control);
			}
		});*/
		jtbInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbInfo.setHorizontalAlignment(SwingConstants.CENTER);
		jtbInfo.setOpaque(true);
		jtbInfo.setBounds(450, 165, 100, 50);
		jtbInfo.setActionCommand("Info");
		add(jtbInfo);
		
		jtbEnlistedPeople = new JButton("Enlisted people");
		/*jtbEnlistedPeople.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbEnlistedPeople.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbEnlistedPeople.setBackground(SystemColor.control);
			}
			});*/
		jtbEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		jtbEnlistedPeople.setOpaque(true);
		jtbEnlistedPeople.setBounds(550, 165, 200, 50);
		jtbEnlistedPeople.setActionCommand("EnlistedPeople");
		add(jtbEnlistedPeople);
		
		jtbBooks = new JButton("Books");
		/*jtbBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbBooks.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbBooks.setBackground(SystemColor.control);
			}
		});*/
		jtbBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbBooks.setBounds(750, 165, 100, 50);
		jtbBooks.setHorizontalAlignment(SwingConstants.CENTER);
		jtbBooks.setOpaque(true);
		jtbBooks.setActionCommand("Books");
		add(jtbBooks);
		
		JLabel lblGeneralInfo = new JLabel("General info");
		lblGeneralInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGeneralInfo.setBounds(30, 230, 150, 20);
		add(lblGeneralInfo);
		
		txtGeneralInfo = new JTextArea();
		txtGeneralInfo.setEditable(false);
		txtGeneralInfo.setBounds(30, 264, 390, 400);
		add(txtGeneralInfo);
		
		JLabel lblExamInfo = new JLabel("Exam info");
		lblExamInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExamInfo.setBounds(435, 230, 150, 20);
		add(lblExamInfo);
		
		txtExamInfo = new JTextArea();
		txtExamInfo.setEditable(false);
		txtExamInfo.setBounds(435, 264, 390, 400);
		add(txtExamInfo);
		
		JLabel lblPaymentInfo = new JLabel("Payment info");
		lblPaymentInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentInfo.setBounds(840, 233, 100, 14);
		add(lblPaymentInfo);
		
		txtPaymentInfo = new JTextArea();
		txtPaymentInfo.setEditable(false);
		txtPaymentInfo.setBounds(840, 264, 390, 400);
		add(txtPaymentInfo);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 220, 1220, 450);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
	}
	
	public void addActionListener(ActionListener listener) {
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
		jtbInfo.addActionListener(listener);
		jtbEnlistedPeople.addActionListener(listener);
		jtbBooks.addActionListener(listener);
		btnBack.addActionListener(listener);
		btnCancelTrainingSession.addActionListener(listener);
    }
	
	public String getGeneralInfo() {
        return txtGeneralInfo.getText();
    }
	public void setGeneralInfo(String text) {
        txtGeneralInfo.setText(text);
    }
	public String getExamInfo() {
        return txtExamInfo.getText();
    }
	public void setExamInfo(String text) {
		txtExamInfo.setText(text);
    }
	public String getPaymentInfo() {
        return txtPaymentInfo.getText();
    }
	public void setPaymentInfo(String text) {
		txtPaymentInfo.setText(text);
    }
}
