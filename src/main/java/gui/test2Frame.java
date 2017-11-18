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


public class test2Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2Frame frame = new test2Frame();
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
	public test2Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		// create a line border with the specified color and width
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
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setBackground(Color.GREEN);
			}
		});
	}

}
