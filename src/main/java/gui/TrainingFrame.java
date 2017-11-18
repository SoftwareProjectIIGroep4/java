package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

public class TrainingFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingFrame frame = new TrainingFrame();
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
	public TrainingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnTraining = new JMenu("Training");
		menuBar_1.add(mnTraining);
		
		JMenu mnTrainingSessions = new JMenu("Training Sessions");
		menuBar_1.add(mnTrainingSessions);
		
		JMenu mnEmployees = new JMenu("Employees");
		menuBar_1.add(mnEmployees);
		
		JMenu mnStatistics = new JMenu("Statistics");
		menuBar_1.add(mnStatistics);
		
		JMenu mnTrainingRequests = new JMenu("Training Requests");
		menuBar_1.add(mnTrainingRequests);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
