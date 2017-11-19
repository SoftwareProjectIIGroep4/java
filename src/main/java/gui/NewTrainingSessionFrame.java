package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTrainingSessionFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtDate;
	private JTextField txtStartHour;
	private JTextField txtEndHour;
	private JTextField txtAdministrativeArea;
	private JTextField txtLocality;
	private JTextField txtPostalCode;
	private JTextField txtStreetAddress;
	private JTextField txtPremise;
	private JTextField txtCountry;
	private JTextField txtBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTrainingSessionFrame frame = new NewTrainingSessionFrame();
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
	public NewTrainingSessionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblTraining = new JLabel("Training");
		lblTraining.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTraining.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTraining.setBorder(null);
			}
		});
		lblTraining.setBackground(Color.WHITE);
		lblTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraining.setOpaque(true);
		lblTraining.setBounds(133, 0, 213, 75);
		contentPane.add(lblTraining);
		
		JLabel lblTrainingSession = new JLabel("Training session");
		lblTrainingSession.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrainingSession.setBorder(border);
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
				lblEmployees.setBorder(border);
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
				lblStatistics.setBorder(border);
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
				lblTrainingRequests.setBorder(border);
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
		
		JButton btnBack = new JButton("<-  Back");
		
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//TrainingFrame trainingfr = new TrainingFrame();
				//trainingfr.setVisible(true);
			}
		});
		
		btnBack.setBounds(30, 100, 110, 50);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(170, 100, 110, 50);
		contentPane.add(btnSave);
		
		JLabel lblTitle = new JLabel("Session title");
		lblTitle.setBounds(50, 200, 100, 14);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(50, 225, 300, 25);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(50, 271, 46, 14);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(50, 296, 152, 25);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocation.setBounds(50, 413, 100, 14);
		contentPane.add(lblLocation);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(750, 186, 500, 484);
		lblBackBorder2.setBorder(border);
		contentPane.add(lblBackBorder2);
		
		JLabel lblStartHour = new JLabel("Start hour");
		lblStartHour.setBounds(50, 342, 100, 14);
		contentPane.add(lblStartHour);
		
		txtStartHour = new JTextField();
		txtStartHour.setBounds(50, 367, 86, 25);
		contentPane.add(txtStartHour);
		txtStartHour.setColumns(10);
		
		JLabel lblEndHour = new JLabel("End hour");
		lblEndHour.setBounds(425, 342, 46, 14);
		contentPane.add(lblEndHour);
		
		txtEndHour = new JTextField();
		txtEndHour.setBounds(425, 367, 86, 25);
		contentPane.add(txtEndHour);
		txtEndHour.setColumns(10);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(30, 186, 700, 484);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
		JLabel lblAdministrativeArea = new JLabel("Administrative area");
		lblAdministrativeArea.setBounds(50, 448, 100, 14);
		contentPane.add(lblAdministrativeArea);
		
		txtAdministrativeArea = new JTextField();
		txtAdministrativeArea.setBounds(50, 473, 200, 25);
		contentPane.add(txtAdministrativeArea);
		txtAdministrativeArea.setColumns(10);
		
		JLabel lblLocality = new JLabel("Locality");
		lblLocality.setBounds(50, 519, 46, 14);
		contentPane.add(lblLocality);
		
		txtLocality = new JTextField();
		txtLocality.setBounds(50, 544, 200, 25);
		contentPane.add(txtLocality);
		txtLocality.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setBounds(50, 590, 100, 14);
		contentPane.add(lblPostalCode);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setBounds(50, 615, 200, 25);
		contentPane.add(txtPostalCode);
		txtPostalCode.setColumns(10);
		
		JLabel lblStreetAddress = new JLabel("Street address");
		lblStreetAddress.setBounds(425, 448, 100, 14);
		contentPane.add(lblStreetAddress);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setBounds(425, 475, 200, 25);
		contentPane.add(txtStreetAddress);
		txtStreetAddress.setColumns(10);
		
		JLabel lblPremise = new JLabel("Premise");
		lblPremise.setBounds(425, 519, 46, 14);
		contentPane.add(lblPremise);
		
		txtPremise = new JTextField();
		txtPremise.setBounds(425, 546, 200, 25);
		contentPane.add(txtPremise);
		txtPremise.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(425, 590, 46, 14);
		contentPane.add(lblCountry);
		
		txtCountry = new JTextField();
		txtCountry.setBounds(425, 617, 200, 25);
		contentPane.add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblResaerchForBooks = new JLabel("Resaerch for books");
		lblResaerchForBooks.setBounds(766, 200, 150, 14);
		contentPane.add(lblResaerchForBooks);
		
		txtBook = new JTextField();
		txtBook.setBounds(766, 227, 300, 25);
		contentPane.add(txtBook);
		txtBook.setColumns(10);
		
	}

}
