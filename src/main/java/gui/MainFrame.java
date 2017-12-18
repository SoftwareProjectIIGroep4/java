package gui;
 
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
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

import gui.EmployeePane;
import models.Employee;




public class MainFrame extends JFrame{

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
		
        LoginPane newLoginPane =  new LoginPane();
        HomePane homePanel = new HomePane();
        TrainingPane trainingPanel = new TrainingPane();
        TrainingSessionPane trainingSessionPanel = new TrainingSessionPane();
        NewTrainingSessionPane newNewTrainingSessionPanel = new NewTrainingSessionPane();
        //EmployeePane employeePanel = new EmployeePane();
        ExtraInfoEmployee employeePanel = new ExtraInfoEmployee();
        StatistiekenPane statistiekenPanel = new StatistiekenPane();    
        TrainingrequestPane trainingrequestPanel = new TrainingrequestPane();
        TrainingSessionBookPane newTrainingSessionBookPane = new TrainingSessionBookPane();
        TrainingSessionPoeplePane newTrainingSessionPoeplePane = new TrainingSessionPoeplePane();
        TrainingSessionInfoPane newTrainingSessionInfoPane = new TrainingSessionInfoPane();
        SelectTrainingPane newSelectTrainingPane = new SelectTrainingPane();
        NewTrianingPane newNewTrianingPane = new NewTrianingPane();
        AddTeacherPane addTeacherPanel = new AddTeacherPane(); 
        AddBookPane addBookPanel = new AddBookPane(); 
        AddSurveyPane addSurveyPanel = new AddSurveyPane(); 
        
        getContentPane().add(newLoginPane, "loginPanel");
        getContentPane().add(homePanel, "homePanel");
        getContentPane().add(trainingPanel, "trainingPanel");
        getContentPane().add(trainingSessionPanel, "trainingSessionPanel");
        getContentPane().add(newNewTrainingSessionPanel, "NewTrainingSessionPane");
        getContentPane().add(employeePanel, "employeePanel");
        getContentPane().add(statistiekenPanel, "statistiekenPanel");
        getContentPane().add(trainingrequestPanel, "trainingrequestPanel");
        getContentPane().add(newTrainingSessionBookPane, "TrainingSessionBookPane");
        getContentPane().add(newTrainingSessionPoeplePane, "TrainingSessionPoeplePane");
        getContentPane().add(newTrainingSessionInfoPane, "TrainingSessionInfoPane");
        getContentPane().add(newSelectTrainingPane, "SelectTrainingPane");
        getContentPane().add(newNewTrianingPane, "NewTrianingPane");
        getContentPane().add(addTeacherPanel, "addTeacherPanel");
        getContentPane().add(addBookPanel, "addBookPanel");
        getContentPane().add(addSurveyPanel, "addSurveyPanel");

       
        newLoginPane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                System.out.println(command);
                if ("Login".equals(command)) {
                	newLoginPane.changeColor();
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
                	layout.show(getContentPane(), "employeePanel");
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                	layout.show(getContentPane(), "statistiekenPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                	layout.show(getContentPane(), "trainingrequestPanel");
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
                	layout.show(getContentPane(), "employeePanel");
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                	layout.show(getContentPane(), "statistiekenPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                	layout.show(getContentPane(), "trainingrequestPanel");
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
                    	layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statistiekenPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingrequestPanel");
                    } else if ("goToAddTrainingSession".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "NewTrainingSessionPane");
                    } else if ("goToTrainingSessionInfo".equals(command)) {
                        //show trainingRequestMenu
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
                    	layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statistiekenPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingrequestPanel");
                    } else if ("backToTrainingSession".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("SaveTrainingSession".equals(command)) {
                    	//save de data voor training session gebruik getters
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("addTeacher".equals(command)) {
                    	// show addTeacherPane
                    	layout.show(getContentPane(), "addTeacherPanel");
                    } else if ("searchTrainingSession".equals(command)) {
                    	// bevestigen van je trainingdiejezoek bevestigen nog maken, geen layout!
                    	layout.show(getContentPane(), "addTeacherPanel");
                    } else if ("addBook".equals(command)) {
                    	// layout.show van je book toevoegen nog maken
                    	layout.show(getContentPane(), "addBookPanel");
                    } else if ("addSurvey".equals(command)) {
                    	// layout.show van je survey toevoegen nog maken
                    	layout.show(getContentPane(), "addSurveyPanel");
                    }                   
                }
            });
        
        	employeePanel.addActionListener(new ActionListener() {
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
                	layout.show(getContentPane(), "employeePanel");
                } else if ("StatisticsMenu".equals(command)) {
                	//show statisticsSessionPane
                	layout.show(getContentPane(), "statistiekenPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                	layout.show(getContentPane(), "trainingrequestPanel");
                } 
            }
        });
        	
        		statistiekenPanel.addActionListener(new ActionListener() {
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
                    	layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statistiekenPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingrequestPanel");
                    } else if ("goToTrainingStatistics".equals(command)) {
                    	//show trainingRequestMenu
                
                    } else if ("goToEmployeeStatistics".equals(command)) {
                    	//show trainingRequestMenu
                
                    } 
                }
            });
        		
        		trainingrequestPanel.addActionListener(new ActionListener() {
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
                        } else if ("BackToTraining".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("SaveTraining".equals(command)) {
                        	//cancel trainingSession
                        	
                        } else if ("AddNewTraining".equals(command)) {
                        	//show TrainingSessoinInfoPane
                        	
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statistiekenPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
                        } else if ("backToNewTrainingSession".equals(command)) {
                        	//Back to newtrainingsessionpanel
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        } else if ("addQuestion".equals(command)) {
                        	//add question to survey
                        	
                        } else if ("deleteQuestion".equals(command)) {
                        	//delete question from survey
                        	
                        } else if ("updateQuestion".equals(command)) {
                        	//update question from survey
                        	
                        }else if ("btnConfirmSurvey".equals(command)) {
                        	//Confirm the survey
                        	
                        }
                    }
                });
        
        layout.show(getContentPane(), "layout");
	}
}