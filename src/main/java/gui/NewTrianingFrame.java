package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTrianingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtNumberOfDays;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTrianingFrame frame = new NewTrianingFrame();
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
	public NewTrianingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
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
		lblTraining.setBounds(133, 0, 211, 75);
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
		lblTrainingSession.setBounds(344, 0, 211, 75);
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
		lblEmployees.setBounds(555, 0, 212, 75);
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
		lblStatistics.setBounds(767, 0, 212, 75);
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
		lblTrainingRequests.setBounds(979, 0, 211, 75);
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
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrainingFrame trainingfr = new TrainingFrame();
				trainingfr.setVisible(true);
			}
		});
		btnBack.setBounds(30, 100, 110, 50);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(170, 100, 110, 50);
		contentPane.add(btnSave);
		
		JButton btnAddNewTraining = new JButton("Add new training");
		btnAddNewTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EditTrainingFrame editTrainingfr = new EditTrainingFrame();
				editTrainingfr.setVisible(true);
			}
		});
		btnAddNewTraining.setBounds(310, 100, 140, 50);
		contentPane.add(btnAddNewTraining);
		
		JLabel lblAddNewTraining = new JLabel("Add new training");
		lblAddNewTraining.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddNewTraining.setBounds(40, 161, 140, 14);
		contentPane.add(lblAddNewTraining);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(50, 200, 46, 14);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(50, 225, 300, 25);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(50, 271, 60, 14);
		contentPane.add(lblDescription);
		
		JEditorPane epDescription = new JEditorPane();
		epDescription.setBounds(50, 296, 500, 180);
		epDescription.setBorder(border1);
		contentPane.add(epDescription);
		
		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setForeground(Color.BLACK);
		lblNumberOfDays.setBounds(50, 497, 100, 14);
		contentPane.add(lblNumberOfDays);
		
		txtNumberOfDays = new JTextField();
		txtNumberOfDays.setBounds(50, 522, 86, 20);
		contentPane.add(txtNumberOfDays);
		txtNumberOfDays.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(50, 563, 46, 14);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(50, 588, 86, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblDescriptionExam = new JLabel("Description exam");
		lblDescriptionExam.setBounds(660, 200, 100, 14);
		contentPane.add(lblDescriptionExam);
		
		JEditorPane epDescriptionExam = new JEditorPane();
		epDescriptionExam.setBounds(660, 225, 500, 180);
		epDescriptionExam.setBorder(border1);
		contentPane.add(epDescriptionExam);
		
		JLabel lblDescriptionPayement = new JLabel("Description payement");
		lblDescriptionPayement.setBounds(660, 426, 150, 14);
		contentPane.add(lblDescriptionPayement);
		
		JEditorPane epDescriptionPayement = new JEditorPane();
		epDescriptionPayement.setBounds(660, 451, 500, 180);
		epDescriptionPayement.setBorder(border1);
		contentPane.add(epDescriptionPayement);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(30, 186, 1224, 484);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setBackground(Color.GREEN);
			}
		});
	}
}
