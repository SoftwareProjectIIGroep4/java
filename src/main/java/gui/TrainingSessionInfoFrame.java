package gui;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class TrainingSessionInfoFrame extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingSessionInfoFrame frame = new TrainingSessionInfoFrame();
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
	public TrainingSessionInfoFrame() {
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
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionsFrame newFrame = new TrainingSessionsFrame();
				newFrame.setVisible(true);
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
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TrainingSessionsFrame newFrame = new TrainingSessionsFrame();
				newFrame.setVisible(true);
			}
		});
		
		
		btnBack.setBounds(30, 100, 110, 50);
		contentPane.add(btnBack);
		
		JLabel lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		contentPane.add(lblTrainingSessionTitle);
		
		JButton btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		contentPane.add(btnCancelTrainingSession);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBackground(SystemColor.control);
		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblInfo.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionInfoFrame newFrame = new TrainingSessionInfoFrame();
				newFrame.setVisible(true);
			}
		});
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setOpaque(true);
		lblInfo.setBounds(450, 165, 100, 50);
		contentPane.add(lblInfo);
		
		JLabel lblEnlistedPeople = new JLabel("Enlisted people");
		lblEnlistedPeople.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblEnlistedPeople.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEnlistedPeople.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionPoepleFrame newFrame = new TrainingSessionPoepleFrame();
				newFrame.setVisible(true);
		}});
		lblEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnlistedPeople.setOpaque(true);
		lblEnlistedPeople.setBounds(550, 165, 200, 50);
		contentPane.add(lblEnlistedPeople);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBooks.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBooks.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionBookFrame newFrame = new TrainingSessionBookFrame();
				newFrame.setVisible(true);
			}
		});
		lblBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBooks.setBounds(750, 165, 100, 50);
		lblBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooks.setOpaque(true);
		contentPane.add(lblBooks);
		
		JLabel lblGeneralInfo = new JLabel("General info");
		lblGeneralInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGeneralInfo.setBounds(30, 230, 150, 20);
		contentPane.add(lblGeneralInfo);
		
		JTextArea txtGeneralInfo = new JTextArea();
		txtGeneralInfo.setBounds(30, 264, 390, 400);
		contentPane.add(txtGeneralInfo);
		
		JLabel lblExamInfo = new JLabel("Exam info");
		lblExamInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExamInfo.setBounds(435, 230, 150, 20);
		contentPane.add(lblExamInfo);
		
		JTextArea txtExamInfo = new JTextArea();
		txtExamInfo.setBounds(435, 264, 390, 400);
		contentPane.add(txtExamInfo);
		
		JLabel lblPaymentInfo = new JLabel("Payment info");
		lblPaymentInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentInfo.setBounds(840, 233, 100, 14);
		contentPane.add(lblPaymentInfo);
		
		JTextArea txtPaymentInfo = new JTextArea();
		txtPaymentInfo.setBounds(840, 264, 390, 400);
		contentPane.add(txtPaymentInfo);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 220, 1220, 450);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
	}
}
