package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        final CardLayout layout = new CardLayout();
        getContentPane().setLayout(layout);
		
        
        loginPane lp =  new loginPane();
        NewTrainingSessionPane newTrainingSessionPane = new NewTrainingSessionPane();
        TrainingSessionBookPane newTrainingSessionBookPane = new TrainingSessionBookPane();
        TrainingSessionPoeplePane newTrainingSessionPoeplePane = new TrainingSessionPoeplePane();
        TrainingSessionInfoPane newTrainingSessionInfoPane = new TrainingSessionInfoPane();
        SelectTrainingPane newSelectTrainingPane = new SelectTrainingPane();
        
        
        getContentPane().add(lp, "loginPanel");
        getContentPane().add(newTrainingSessionPane, "newTrainingSessionPane");
        getContentPane().add(newTrainingSessionBookPane, "TrainingSessionBookPane");
        getContentPane().add(newTrainingSessionPoeplePane, "TrainingSessionPoeplePane");
        getContentPane().add(newTrainingSessionInfoPane, "TrainingSessionInfoPane");
        getContentPane().add(newSelectTrainingPane, "SelectTrainingPane");
       
        
        lp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("Login".equals(command)) {
                	lp.changeColor();
                    layout.show(lp, "newLogin");
                } else if ("manager".equals(command)) {
                    //layout.show(getContentPane(), "managerLogin");
                }
            }
        });
        
        newTrainingSessionPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                } else	if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                } else if ("backToTrainingSession".equals(command)) {
                	//show trainingRequestMenu
                } else if ("SaveTrainingSession".equals(command)) {
                	//save de data voor training session gebruik getters
                }
            }
        });
        
        newTrainingSessionBookPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                } else	if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestPane
                } else if ("BackToTrainingSessoin".equals(command)) {
                	//show TrainingSessoinPane
                } else if ("CancelTrainingSession".equals(command)) {
                	//cancel trainingSession
                } else if ("Info".equals(command)) {
                	//show TrainingSessoinInfoPane
                } else if ("EnlistedPeople".equals(command)) {
                	//show TrainingSessoinEnlistedPeoplePane
                } else if ("Books".equals(command)) {
                 	//show TrainingSessoinBooksPane
                }
                
            }
        });
        
        newTrainingSessionPoeplePane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                } else	if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestPane
                } else if ("BackToTrainingSessoin".equals(command)) {
                	//show TrainingSessoinPane
                } else if ("CancelTrainingSession".equals(command)) {
                	//cancel trainingSession
                } else if ("Info".equals(command)) {
                	//show TrainingSessoinInfoPane
                } else if ("EnlistedPeople".equals(command)) {
                	//show TrainingSessoinEnlistedPeoplePane
                } else if ("Books".equals(command)) {
                 	//show TrainingSessoinBooksPane
                }
                
            }
        });
        
        newTrainingSessionInfoPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                } else if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestPane
                } else if ("BackToTrainingSessoin".equals(command)) {
                	//show TrainingSessoinPane
                } else if ("CancelTrainingSession".equals(command)) {
                	//cancel trainingSession
                } else if ("Info".equals(command)) {
                	//show TrainingSessoinInfoPane
                } else if ("EnlistedPeople".equals(command)) {
                	//show TrainingSessoinEnlistedPeoplePane
                } else if ("Books".equals(command)) {
                 	//show TrainingSessoinBooksPane
                }
                
            }
        });
        
        newSelectTrainingPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("Cancel".equals(command)) {
                	//show trainingSessionPane
                } else if ("MakeTrainingSession".equals(command)) {
                	//show newtrainingSessionPane
                }
                
            }
        });
        
    
        layout.show(getContentPane(), "layout");
	}
}
