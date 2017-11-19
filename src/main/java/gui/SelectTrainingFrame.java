package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class SelectTrainingFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTrainingFrame frame = new SelectTrainingFrame();
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
	public SelectTrainingFrame() {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectTraining = new JLabel("Select Training");
		lblSelectTraining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectTraining.setBounds(10, 11, 250, 25);
		contentPane.add(lblSelectTraining);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 638, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnMakeTrainingSession = new JButton("Make training session");
		btnMakeTrainingSession.setBounds(410, 638, 150, 23);
		contentPane.add(btnMakeTrainingSession);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(10, 47, 550, 580);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
	}
}
