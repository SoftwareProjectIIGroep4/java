package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

import javax.swing.JButton;
import javax.swing.JTable;

import gui.EmployeePane;
import models.Address;
import models.Employee;
import models.TrainingInfo;
import models.TrainingSession;
import models.Login;
import models.Survey;
import models.SurveyQuestion;
import models.Teacher;
import models.Token;
import gui.LoginPane;

public class MainFrame extends JFrame {
	private static int keeper;
	private int teacherId=-1;
	private static ArrayList<SurveyQuestion>surveyQuestions = new ArrayList<SurveyQuestion>();
	private Survey survey;

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
        EmployeePane employeePanel = new EmployeePane();
        StatisticsPane statisticsPanel = new StatisticsPane();    
        TrainingrequestPane trainingrequestPanel = new TrainingrequestPane();
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
        getContentPane().add(employeePanel, "employeePanel");
        getContentPane().add(statisticsPanel, "statisticsPanel");
        getContentPane().add(trainingrequestPanel, "trainingrequestPanel");
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
                	Token token= new Token();
                	try {
						 token =Login.authorizeAcces(newLoginPane.getEmail(), newLoginPane.getPassword());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	if (token !=null) {
                	newLoginPane.changeColor();
                    layout.show(getContentPane(), "homePanel");
                    }
                	else {
                		newLoginPane.changeColor();
                        layout.show(getContentPane(), "homePanel");
                	}
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
                	layout.show(getContentPane(), "statisticsPanel");
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
                	layout.show(getContentPane(), "statisticsPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                	layout.show(getContentPane(), "trainingrequestPanel");
                } else if ("goToSelectTraining".equals(command)) {
                	setKeeper(trainingPanel.getTabelID());
                	new SelectTrainingPane();
                	//SelectTrainingPane newSelectTrainingPane = new SelectTrainingPane();
                	//getContentPane().add(newSelectTrainingPane, "SelectTrainingPane");
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
                    	layout.show(getContentPane(), "statisticsPanel");
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
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingrequestPanel");
                    } else if ("backToTrainingSession".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("SaveTrainingSession".equals(command)) {
                    	if(newNewTrianingPane.getTitle().equals("")|| 
                    			newNewTrianingPane.getDescription().equals("")|| 
                    			newNewTrianingPane.getNumberOfDays()==0|| 
                    			newNewTrianingPane.getDescriptionExam().equals("")|| 
                    			newNewTrianingPane.getDescriptionPayement().equals("")||
                    			newNewTrianingPane.getPrice()==0||
                    			teacherId==-1)
                    	{
                    		//open een error message
                    		System.out.println("error message");
             
                    	} else {
                    	TrainingSession tSession=new TrainingSession();
                    	tSession.setTrainingId(getKeeper());
                    	 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy/MM/dd");  
                    	Date date=new Date();						
                    	DateFormat formatter = new SimpleDateFormat("hh:mm a");
                    	try {
							date = formatter1.parse(newNewTrainingSessionPanel.getDate());

							tSession.setStartHour(new java.sql.Time(formatter.parse(newNewTrainingSessionPanel.getStartHour()).getTime()));
							tSession.setEndHour(new java.sql.Time(formatter.parse(newNewTrainingSessionPanel.getEndHour()).getTime()));
                    	} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	tSession.setDate(date);

                    	Address address=new Address();
                    	address.setAdministrativeArea(newNewTrainingSessionPanel.getAdministrativeArea());
                    	address.setLocality(newNewTrainingSessionPanel.getLocality());
                    	address.setPostalCode(Integer.parseInt(newNewTrainingSessionPanel.getPostalCode()));
                    	address.setStreetAddress(newNewTrainingSessionPanel.getStreetAddress());
                    	address.setCountry(newNewTrainingSessionPanel.getCountry());
                    	address.setPremise(newNewTrainingSessionPanel.getPremise());
                    	try {
							address.save();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	
                    	
                    	//save de data voor training session gebruik getters
                    	layout.show(getContentPane(), "trainingSessionPanel");
                    	}
                    } else if ("addTeacher".equals(command)) {
                    	// show addTeacherPane
                    	layout.show(getContentPane(), "addTeacherPanel");
                    } else if ("searchTrainingSession".equals(command)) {
                    	// bevestigen van je trainingdiejezoek bevestigen nog maken, geen layout!
                    	
                    } else if ("addBook".equals(command)) {
                    	// layout.show van je book toevoegen nog maken
                    	layout.show(getContentPane(), "addBookPanel");
                    } else if ("addSurvey".equals(command)) {
                    	surveyQuestions.clear();
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
                	layout.show(getContentPane(), "statisticsPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                	//show trainingRequestMenu
                	layout.show(getContentPane(), "trainingrequestPanel");
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
                    	layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "trainingrequestPanel");
                    } else if ("goToStatisticsFollowedTraining".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "statisticsFollowedTrainingPanel");
                    } else if ("goToStatisticsTrainingParticipation".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "statisticsTrainingParticipationPanel");
                    } else if ("goToStatisticsCertificatesEmployee".equals(command)) {
                    	//show trainingRequestMenu
                    	layout.show(getContentPane(), "statisticsCertificatesEmployeePanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
                        } else if ("BackToTraining".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("SaveTraining".equals(command)) {
                        	//cancel trainingSession
                        	if(newNewTrianingPane.getTitle()==null|| newNewTrianingPane.getDescription()==null|| newNewTrianingPane.getNumberOfDays()==0|| newNewTrianingPane.getDescriptionExam()==null|| newNewTrianingPane.getDescriptionPayement()==null|| newNewTrianingPane.getPrice()==0) {
                        		//open een error message
                        	}
                        	else {
                        	TrainingInfo trainingInfo = new TrainingInfo(newNewTrianingPane.getTitle(), 
                        			newNewTrianingPane.getDescription(), 
                        			newNewTrianingPane.getNumberOfDays(), 
                        			newNewTrianingPane.getDescriptionExam(),
                        			newNewTrianingPane.getDescriptionPayement(),
                        			newNewTrianingPane.getPrice(),
                        			newNewTrianingPane.getSurveyId());
                        	try {
								trainingInfo.save();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        	}
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
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
                        } else if ("addTeacher".equals(command)) {
                        	if (addTeacherPanel.getTeacherLastnameSearch().equals("")||
                        		addTeacherPanel.getTeacherFirstnameSearch().equals("")||	
                        		addTeacherPanel.getTeacherEmailSearch().equals("")||
                        		addTeacherPanel.getTeacherPhonenumberSearch().equals("")) {
                        		System.out.println("testif");
                        		//foutmedling?
                        	}
                        	else {
                        	Teacher teacher = new Teacher();
                        	teacher.setLastName(addTeacherPanel.getTeacherLastnameSearch());
                        	teacher.setFirstName(addTeacherPanel.getTeacherFirstnameSearch());
                        	teacher.setEmail(addTeacherPanel.getTeacherEmailSearch());
                        	teacher.setPhoneNumber(addTeacherPanel.getTeacherPhonenumberSearch());
                        	try {
								teacher.save();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        	teacherId=teacher.getTeacherId();
                        	// button teacher toevoegen en terug naar NewtrainingSessionPane
                        	
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        	}
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
                        	layout.show(getContentPane(), "statisticsPanel");
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
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
                        } else if ("backToNewTrainingSession".equals(command)) {
                        	//Back to newtrainingsessionpanel
                        	layout.show(getContentPane(), "NewTrainingSessionPane");
                        } else if ("addQuestion".equals(command)) {
                        	if (addSurveyPanel.getAddQuestion().equals("")) {
                        		//FOUT?
                        	}
                        	else {
                        		System.out.println(addSurveyPanel.getAddQuestion());
                        		surveyQuestions.add(new SurveyQuestion(addSurveyPanel.getAddQuestion()));
                        		addSurveyPanel.clear();
                        		
                        		//new AddSurveyPane();
                        		
                        	}
                        	//add question to survey
                        	
                        } else if ("deleteQuestion".equals(command)) {
                        	
                        	if (addSurveyPanel.getAddQuestion().equals("")) {
                        		//FOUT?
                        	}
                        	else {
                        		for (int i =0;i<surveyQuestions.size();i++) {
                        			if(surveyQuestions.get(i).getContent().equals(addSurveyPanel.getAddQuestion())) {
                        				surveyQuestions.remove(i);
                        			}
                        		}
                        	}
                        	//delete question from survey
                        	
                        } else if ("updateQuestion".equals(command)) {
                        	if (addSurveyPanel.getAddQuestion().equals("")) {
                        		//FOUT?
                        	}
                        	else {
                        		for (int i =0;i<surveyQuestions.size();i++) {
                        			if(surveyQuestions.get(i).getContent().equals(addSurveyPanel.getAddQuestion())) {
                        				surveyQuestions.set(i, new SurveyQuestion(addSurveyPanel.getAddQuestion()));
                        			}
                        		}
                        	}
                        	
                        }else if ("confirmSurvey".equals(command)) {
                        	survey=new Survey();
                        	survey.setSurveyQuestions(surveyQuestions);
                        	try {
								survey.save();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        	
                        	
                        	
                        	
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("TrainingRequestsMenu".equals(command)) {
                        	//show trainingRequestMenu
                        	layout.show(getContentPane(), "trainingrequestPanel");
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
	public static  ArrayList<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}
	public static int getKeeper() {
		
		return keeper;
	}
	public void setKeeper(int keeper) {
		this.keeper=keeper;
	}
	
}