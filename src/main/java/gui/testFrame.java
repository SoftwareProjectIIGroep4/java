package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class testFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFrame frame = new testFrame();
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
	public testFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTraining = new JButton("Training");

		btnTraining.setBounds(133, 0, 213, 75);
		contentPane.add(btnTraining);
		
		JButton btnTrainingSession = new JButton("Training session");
		btnTrainingSession.setBounds(344, 0, 213, 75);
		contentPane.add(btnTrainingSession);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.setBounds(555, 0, 213, 75);
		contentPane.add(btnEmployees);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(766, 0, 213, 75);
		contentPane.add(btnStatistics);
		
		JButton btnTrainingRequests = new JButton("Training requests");
		btnTrainingRequests.setBounds(977, 0, 213, 75);
		contentPane.add(btnTrainingRequests);
		
		JLabel lblNewLabel = new JLabel("logo");
		
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(0, 0, 133, 75);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Profiel");
		lblNewLabel_1.setBounds(1190, 0, 75, 75);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setBackground(Color.GREEN);
			}
		});
	}
}
