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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class TrainingSessionsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtKeyword;
	private JTextField txtCity;
	private JTextField txtFrom;
	private JTextField txtUntil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingSessionsFrame frame = new TrainingSessionsFrame();
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
	public TrainingSessionsFrame() {
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
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(30, 136, 750, 534);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
		JLabel lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrainingSessionTitle.setBounds(50, 111, 150, 16);
		contentPane.add(lblTrainingSessionTitle);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCity.setBounds(335, 111, 46, 16);
		contentPane.add(lblCity);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(429, 111, 46, 16);
		contentPane.add(lblDate);
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHour.setBounds(511, 111, 46, 16);
		contentPane.add(lblHour);
		
		JButton btnAddTrainingSession = new JButton("Add training session");
		btnAddTrainingSession.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddTrainingSession.setBounds(925, 100, 200, 50);
		contentPane.add(btnAddTrainingSession);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFilters.setBounds(800, 161, 46, 16);
		contentPane.add(lblFilters);
		
		txtKeyword = new JTextField();
		txtKeyword.setText("Keyword");
		txtKeyword.setBounds(820, 206, 300, 25);
		contentPane.add(txtKeyword);
		txtKeyword.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setText("City");
		txtCity.setBounds(820, 252, 300, 25);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(820, 304, 97, 23);
		contentPane.add(chckbxMonday);
		
		JCheckBox chckbxTeusday = new JCheckBox("Teusday");
		chckbxTeusday.setBounds(977, 304, 97, 23);
		contentPane.add(chckbxTeusday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(820, 340, 97, 23);
		contentPane.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(977, 340, 97, 23);
		contentPane.add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(820, 376, 97, 23);
		contentPane.add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(977, 376, 97, 23);
		contentPane.add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(820, 412, 97, 23);
		contentPane.add(chckbxSunday);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrom.setBounds(820, 452, 46, 14);
		contentPane.add(lblFrom);
		
		txtFrom = new JTextField();
		txtFrom.setBounds(876, 449, 86, 25);
		contentPane.add(txtFrom);
		txtFrom.setColumns(10);
		
		JLabel lblUntil = new JLabel("Until:");
		lblUntil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUntil.setBounds(1003, 454, 46, 14);
		contentPane.add(lblUntil);
		
		txtUntil = new JTextField();
		txtUntil.setBounds(1059, 449, 86, 25);
		contentPane.add(txtUntil);
		txtUntil.setColumns(10);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(800, 186, 450, 484);
		lblBackBorder2.setBorder(border);
		contentPane.add(lblBackBorder2);
	}
}
