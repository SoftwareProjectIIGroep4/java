package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;


public class MainFrame extends JFrame{
	
	// SOURCE: weten hoe GUI centraal zetten op scherm 
	//https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution

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
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
        LoginPane newLoginPane =  new LoginPane();
        HomePane homePanel = new HomePane();
        TrainingPane trainingPanel = new TrainingPane();
        TrainingSessionPane trainingSessionPanel = new TrainingSessionPane();
        NewTrainingSessionPane newNewTrainingSessionPanel = new NewTrainingSessionPane();
        StatisticsPane statisticsPanel = new StatisticsPane();    
        TrainingSessionBookPane newTrainingSessionBookPane = new TrainingSessionBookPane();
        TrainingSessionPoeplePane newTrainingSessionPoeplePane = new TrainingSessionPoeplePane();
        TrainingSessionInfoPane newTrainingSessionInfoPane = new TrainingSessionInfoPane();
        SelectTrainingPane newSelectTrainingPane = new SelectTrainingPane();
        NewTrianingPane newNewTrianingPane = new NewTrianingPane();
        AddTeacherPane addTeacherPanel = new AddTeacherPane(); 
        AddBookPane addBookPanel = new AddBookPane(); 
        AddSurveyPane addSurveyPanel = new AddSurveyPane();
        StatisticsCertificatesEmployeePane statisticsCertificatesEmployeePanel = new StatisticsCertificatesEmployeePane();
        StatisticsFollowedTrainingPane statisticsFollowedTrainingPanel = new StatisticsFollowedTrainingPane();
        StatisticsTrainingParticipationPane statisticsTrainingParticipationPanel = new StatisticsTrainingParticipationPane();

        
        getContentPane().add(newLoginPane, "loginPanel");
        getContentPane().add(homePanel, "homePanel");
        getContentPane().add(trainingPanel, "trainingPanel");
        getContentPane().add(trainingSessionPanel, "trainingSessionPanel");
        getContentPane().add(newNewTrainingSessionPanel, "NewTrainingSessionPane");
        getContentPane().add(statisticsPanel, "statisticsPanel");
        getContentPane().add(newTrainingSessionBookPane, "TrainingSessionBookPane");
        getContentPane().add(newTrainingSessionPoeplePane, "TrainingSessionPoeplePane");
        getContentPane().add(newTrainingSessionInfoPane, "TrainingSessionInfoPane");
        getContentPane().add(newSelectTrainingPane, "SelectTrainingPane");
        getContentPane().add(newNewTrianingPane, "NewTrianingPane");
        getContentPane().add(addTeacherPanel, "addTeacherPanel");
        getContentPane().add(addBookPanel, "addBookPanel");

        getContentPane().add(addSurveyPanel, "addSurveyPanel");
        getContentPane().add(statisticsCertificatesEmployeePanel, "statisticsCertificatesEmployeePanel");
        getContentPane().add(statisticsFollowedTrainingPanel, "statisticsFollowedTrainingPanel");
        getContentPane().add(statisticsTrainingParticipationPanel, "statisticsTrainingParticipationPanel");

       
        newLoginPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("Login".equals(command)) {
                    layout.show(getContentPane(), "homePanel");
                }
            }
        });
        
        	homePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                	layout.show(getContentPane(), "trainingPanel");
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                	layout.show(getContentPane(), "trainingSessionPanel");
                } else	if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                	
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                	layout.show(getContentPane(), "statisticsPanel");
                }
            }
        });
        
        	trainingPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("TrainingMenu".equals(command)) {
                	//show trainingPane
                	layout.show(getContentPane(), "trainingPanel");
                } else if ("TrainingSessionMenu".equals(command)) {
                	//show trainingSessionPane
                	layout.show(getContentPane(), "trainingSessionPanel");
                } else	if ("EmployeesMenu".equals(command)) {
                	//show employeesPane
                	
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                	layout.show(getContentPane(), "statisticsPanel");
                } else if ("goToSelectTraining".equals(command)) {
                	//show selectTrainingMenu
                	layout.show(getContentPane(), "SelectTrainingPane");
                }else if ("goToAddTraining".equals(command)) {
                	//show addTrainingMenu
                	layout.show(getContentPane(), "NewTrianingPane");
                }
                	
            }
        });
        
        	trainingSessionPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    System.out.println(command);
                    if ("TrainingMenu".equals(command)) {
                    	//show trainingPane
                    	layout.show(getContentPane(), "trainingPanel");
                    } else if ("TrainingSessionMenu".equals(command)) {
                    	//show trainingSessionPane
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else	if ("EmployeesMenu".equals(command)) {
                    	//show employeesPane
                    	
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("goToAddTrainingSession".equals(command)) {
                    	//show training Menu
                    	layout.show(getContentPane(), "NewTrainingSessionPane");
                    } else if ("goToTrainingSessionInfo".equals(command)) {
                        //show trainingsessioninfopane
                        layout.show(getContentPane(), "TrainingSessionInfoPane");
                    }
                }
            });
        	
        	newNewTrainingSessionPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    System.out.println(command);
                    if ("TrainingMenu".equals(command)) {
                    	//show trainingPane
                    	layout.show(getContentPane(), "trainingPanel");
                    } else if ("TrainingSessionMenu".equals(command)) {
                    	//show trainingSessionPane
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else	if ("EmployeesMenu".equals(command)) {
                    	//show employeesPane
                    	
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("backToTrainingSession".equals(command)) {
                    	//show trainingsessionPane
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("SaveTrainingSession".equals(command)) {
                    	//save de data voor training session gebruik getters
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("addTeacher".equals(command)) {
                    	// show addTeacherPane
                    	layout.show(getContentPane(), "addTeacherPanel");
                    } else if ("searchTrainingSession".equals(command)) {
                    	// bevestigen van je trainingdiejezoek bevestigen nog maken, geen layout!
                    	
                    } else if ("addBook".equals(command)) {
                    	// layout.show van je book toevoegen nog maken
                    	layout.show(getContentPane(), "addBookPanel");
                    } else if ("addSurvey".equals(command)) {
                    	// layout.show van je survey toevoegen nog maken
                    	layout.show(getContentPane(), "addSurveyPanel");
                    }                   
                }
            });
        	
        		statisticsPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    System.out.println(command);
                    if ("TrainingMenu".equals(command)) {
                    	//show trainingPane
                    	layout.show(getContentPane(), "trainingPanel");
                    } else if ("TrainingSessionMenu".equals(command)) {
                    	//show trainingSessionPane
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else	if ("EmployeesMenu".equals(command)) {
                    	//show employeesPane
                    	
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("goToStatisticsFollowedTraining".equals(command)) {
                    	//show StatisticsFollowedPane
                    	layout.show(getContentPane(), "statisticsFollowedTrainingPanel");
                    } else if ("goToStatisticsTrainingParticipation".equals(command)) {
                    	//show StatisticsParticipatedPane
                    	layout.show(getContentPane(), "statisticsTrainingParticipationPanel");
                    } else if ("goToStatisticsCertificatesEmployee".equals(command)) {
                    	//show StatisticsCertPane
                    	layout.show(getContentPane(), "statisticsCertificatesEmployeePanel");
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
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("BackToTrainingSessoin".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else if ("CancelTrainingSession".equals(command)) {
                        	//cancel trainingSession
                        	
                        } else if ("Info".equals(command)) {
                            //show TrainingSessoinInfoPane
                            layout.show(getContentPane(), "TrainingSessionInfoPane");
                        } else if ("EnlistedPeople".equals(command)) {
                            //show TrainingSessoinEnlistedPeoplePane
                            layout.show(getContentPane(), "TrainingSessionPoeplePane");
                        } else if ("Books".equals(command)) {
                            //show TrainingSessoinBooksPane
                            layout.show(getContentPane(), "TrainingSessionBookPane");
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
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("BackToTrainingSessoin".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingSessionPanel");

                        } else if ("CancelTrainingSession".equals(command)) {
                        	//cancel trainingSession
                        	
                        } else if ("Info".equals(command)) {
                            //show TrainingSessoinInfoPane
                            layout.show(getContentPane(), "TrainingSessionInfoPane");
                        } else if ("EnlistedPeople".equals(command)) {
                            //show TrainingSessoinEnlistedPeoplePane
                            layout.show(getContentPane(), "TrainingSessionPoeplePane");
                        } else if ("Books".equals(command)) {
                            //show TrainingSessoinBooksPane
                            layout.show(getContentPane(), "TrainingSessionBookPane");
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
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("BackToTrainingSessoin".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingSessionPanel");

                        } else if ("CancelTrainingSession".equals(command)) {
                        	//cancel trainingSession
                        	
                        } else if ("Info".equals(command)) {
                            //show TrainingSessoinInfoPane
                            layout.show(getContentPane(), "TrainingSessionInfoPane");
                        } else if ("EnlistedPeople".equals(command)) {
                            //show TrainingSessoinEnlistedPeoplePane
                            layout.show(getContentPane(), "TrainingSessionPoeplePane");
                        } else if ("Books".equals(command)) {
                            //show TrainingSessoinBooksPane
                            layout.show(getContentPane(), "TrainingSessionBookPane");
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
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("MakeTrainingSession".equals(command)) {
                        	//show newTrainingSessionPane
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        }
                        
                    } 
                });
        		
        		
        		newNewTrianingPane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("BackToTraining".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("SaveTraining".equals(command)) {
                        	//cancel trainingSession
                        	layout.show(getContentPane(), "trainingPanel");
                        }
                        else if ("selectSurvey".equals(command)) {
                        //save de data voor training session gebruik getters
                        //	naar de pane van Survey gaan.
                        //	layout.show(getContentPane(), "trainingSessionPanel");
                        }
                        
                    }
                });
        		
        		addTeacherPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("addTeacher".equals(command)) {
                        	// button teacher toevoegen en terug naar NewtrainingSessionPane
                        	
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        } 
                    }
                });
        		
        		addBookPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("addBookToTrainingsession".equals(command)) {
                        	// voeg boek bij trainingsession + show trainingsessionpane
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        } 
                    }
                });
        		
        		
        		addSurveyPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("backToNewTrainingSession".equals(command)) {
                        	//Back to newtrainingsessionpanel
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        } else if ("addQuestion".equals(command)) {
                        	//add question to survey
                        	
                        } else if ("deleteQuestion".equals(command)) {
                        	//delete question from survey
                        	
                        } else if ("updateQuestion".equals(command)) {
                        	//update question from survey
                        	
                        }else if ("confirmSurvey".equals(command)) {
                        	//Confirm the survey and go back to newtrainingsessionpane
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        }
                    }
                });
        		
        		statisticsCertificatesEmployeePanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("showcertTrainingsEmployee".equals(command)) {
                        	// laad data van employee certificates op JTable
                        	
                        } else if ("backCertToStatistics".equals(command)) {
                        	// Terug naar statistiekenpanel
                        	layout.show(getContentPane(), "statisticsPanel");
                        } 
                        
                    }
                });
        		
        		statisticsFollowedTrainingPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("showFollowedTrainings".equals(command)) {
                        	// laad data van employee gevolgde trainingen op JTable
                        	
                        } else if ("backFollowedToStatistics".equals(command)) {
                        	// Terug naar statistiekenpanel
                        	layout.show(getContentPane(), "statisticsPanel");
                        } 
                        
                    }
                });
        		
        		statisticsTrainingParticipationPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        System.out.println(command);
                        if ("TrainingMenu".equals(command)) {
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	//show employeesPane
                        	
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("showParticipationTrainingsEmployee".equals(command)) {
                        	// laad data van employee die de meeste trainingen gevolgd heeft volgens jaar op JTable
                        	
                        } else if ("backPartToStatistics".equals(command)) {
                        	// Terug naar statistiekenpanel
                        	layout.show(getContentPane(), "statisticsPanel");
                        } 
                        
                    }
                });
        		
        		
        
        layout.show(getContentPane(), "layout");
	}
}