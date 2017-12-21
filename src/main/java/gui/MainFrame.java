package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;


import dataAccess.GoogleBooksAPI;
import dataAccess.SurveyQuestionAcces;
import dataAccess.TrainingInfoAccess;
//import gui.EmployeePane;
import models.Address;
import models.Book;
import models.TrainingInfo;
import models.TrainingSession;
import models.Login;
import models.Survey;
import models.SurveyQuestion;
import models.Teacher;
import models.Token;
import models.TrainingBooks;
import gui.LoginPane;

public class MainFrame extends JFrame {
	
	private static int keeper;
	private int teacherId=-1;
	private static ArrayList<SurveyQuestion>surveyQuestions = new ArrayList<SurveyQuestion>();
	private int surveyId=-1;
	private int bookId=-1;
	private int trainingId=-1;
	private Book book ;
	private TrainingBooks trainingBooks;
		
	

	
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
        ExtraInfoEmployee employeePanel = new ExtraInfoEmployee();

       // StatistiekenPane statistiekenPanel = new StatistiekenPane();    

        //TrainingrequestPane trainingrequestPanel = new TrainingrequestPane();
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
        getContentPane().add(employeePanel, "employeePanel");
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
                } else if ("goToAddTrainingSession".equals(command)) {
                	//show training Menu
                	layout.show(getContentPane(), "NewTrainingSessionPane");
                } else if ("goToTrainingSessionInfo".equals(command)) {
                    //show trainingsessioninfopane
                    layout.show(getContentPane(), "TrainingSessionInfoPane");
                }
                
            }
        });
       
        
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
                } else if ("goToSelectTraining".equals(command)) {
                	setKeeper(trainingPanel.getTabelID());
                	trainingId=keeper;
                	
                	ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
                	for (Map.Entry<Integer, TrainingInfo>  entry : listTraingInfo.entrySet()) {
            			if (entry.getValue().getTrainingId()==MainFrame.getKeeper()) {
            				newSelectTrainingPane.getTableModel().addRow(new Object[]{entry.getValue().getName(),
            						String.valueOf(entry.getValue().getNumberOfDays()),
            						String.valueOf(entry.getValue().getPrice())});
            			
            			
            					
            		
            			}
            		}
                	
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
                    	layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                    	//show statisticsSessionPane
                    	layout.show(getContentPane(), "statisticsPanel");
                    } else if ("backToTrainingSession".equals(command)) {
                    	//show TrainingPane
                    	layout.show(getContentPane(), "trainingPanel");
                    } else if ("SaveTrainingSession".equals(command)) {
                    	if(newNewTrainingSessionPanel.getTitle().equals("")|| 
                    			newNewTrainingSessionPanel.getDate()==null|| 
                    			newNewTrainingSessionPanel.getStartHour()==null|| 
                    			newNewTrainingSessionPanel.getEndHour()==null||
                    			newNewTrainingSessionPanel.getAdministrativeArea().equals("")||
                    			newNewTrainingSessionPanel.getLocality().equals("")||
                    			newNewTrainingSessionPanel.getPostalCode().equals("")||
                    			newNewTrainingSessionPanel.getStreetAddress().equals("")||
                    			newNewTrainingSessionPanel.getCountry().equals("")||
                    			newNewTrainingSessionPanel.getPremise().equals("")||
                    		    teacherId==-1||
                    			surveyId==-1||
                    			trainingId==-1
                    			)
                    		
                    	{
                    		

                    		
             
                    	} else {
                    	TrainingSession tSession=new TrainingSession();
                    	tSession.setTrainingId(getKeeper());
         
                    	 
                    							
                    	
                    	
                    	tSession.setDate(newNewTrainingSessionPanel.getDate().toString());
                    	
                    	
                    	tSession.setStartHour(newNewTrainingSessionPanel.getStartHour());
                    	tSession.setEndHour(newNewTrainingSessionPanel.getEndHour());
						
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
                    	tSession.setAddressId(address.getAddressId());
                    	System.out.println("teacherid::"+teacherId);
                    	tSession.setTeacherId(teacherId);
                    	tSession.setSurveyId(surveyId);
                    	try {
							tSession.save();
						} catch (URISyntaxException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	surveyId=-1;
                    	teacherId=-1;
                    	bookId=-1;
                    	
                    	
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
                    	layout.show(getContentPane(), "employeePanel");
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
                        	layout.show(getContentPane(), "employeePanel");
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
                        	layout.show(getContentPane(), "employeePanel");
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
                        	layout.show(getContentPane(), "employeePanel");
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
                        if ("BackToTrainingPane".equals(command)) {
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
                        } else if ("BackToTraining".equals(command)) {
                        	//show TrainingSessoinPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("SaveTraining".equals(command)) {
                        	//cancel trainingSession
                        	if(newNewTrianingPane.getTitle().equals("")|| 
                        	newNewTrianingPane.getDescription().equals("")|| 
                        	newNewTrianingPane.getNumberOfDays()==0|| 
                        	newNewTrianingPane.getDescriptionExam().equals("")|| 
                        	newNewTrianingPane.getDescriptionPayement().equals("")|| 
                        	newNewTrianingPane.getPrice()==0) {
                        		
                        		
                        		
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
                        	layout.show(getContentPane(), "trainingPanel");

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
                        } else if ("addTeacher".equals(command)) {
                        	if (addTeacherPanel.getTeacherLastnameSearch().equals("")||
                        		addTeacherPanel.getTeacherFirstnameSearch().equals("")||	
                        		addTeacherPanel.getTeacherEmailSearch().equals("")||
                        		addTeacherPanel.getTeacherPhonenumberSearch().equals("")) {
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
                        	book=null;
                        	trainingBooks=null;
                        	//show trainingPane
                        	layout.show(getContentPane(), "trainingPanel");
                        } else if ("TrainingSessionMenu".equals(command)) {
                        	book=null;
                        	trainingBooks=null;
                        	//show trainingSessionPane
                        	layout.show(getContentPane(), "trainingSessionPanel");
                        } else	if ("EmployeesMenu".equals(command)) {
                        	book=null;
                        	trainingBooks=null;
                        	//show employeesPane
                        	layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                        	book=null;
                        	trainingBooks=null;
                        	//show statisticsSessionPane
                        	layout.show(getContentPane(), "statisticsPanel");
                        } else if ("addBookToTrainingsession".equals(command)) {
                        	JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
                		    try {
                	
                		      String prefix = null;
                		      String query = addBookPanel.getBookTitleTrainingsession()+"--"+addBookPanel.getBookAuthorTrainingsession();
                		      ArrayList<String> args=new ArrayList<String>();
                		      for (String arg : args) {
                		        if ("--author".equals(arg)) {
                		          prefix = "inauthor:";
                		        } else if ("--isbn".equals(arg)) {
                		          prefix = "isbn:";
                		        } else if ("--title".equals(arg)) {
                		          prefix = "intitle:";
                		        } else if (arg.startsWith("--")) {
                		          System.err.println("Unknown argument: " + arg);
                		          System.exit(1);
                		        } else {
                		          query = arg;
                		        }
                		      }
                		      if (prefix != null) {
                		        query = prefix + query;
                		      }
                		      try {
                		    	  ArrayList<Book> testBooks = new ArrayList<>();
                		    	  testBooks= GoogleBooksAPI.queryGoogleBooks(jsonFactory, query);
                		    	   book = testBooks.get(0);
                		    	 
                		    	  book.save();
                		    	  trainingBooks=new TrainingBooks(trainingId, book.getIsbn());
                		    	  trainingBooks.save();
                		        // Succes
                		      } catch (IOException e1) {
                		        System.err.println(e1.getMessage());
                		      }
                		    } catch (Throwable t) {
                		      t.printStackTrace();
                		    }
                		    
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
                        		
                        		addSurveyPanel.gettableQuestionsSurveyModel().addRow(new Object[]{addSurveyPanel.getAddQuestion()});
                        		new AddSurveyPane();
                        		
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
                        		addSurveyPanel.gettableQuestionsSurveyModel().removeRow(1);
                        		if (addSurveyPanel.gettableQuestionsSurveyModel().getRowCount() > 0) {
                                    for (int i = addSurveyPanel.gettableQuestionsSurveyModel().getRowCount() - 1; i > -1; i--) {
                                    	if (addSurveyPanel.gettableQuestionsSurveyModel().getValueAt(i, 0)==addSurveyPanel.getAddQuestion()) {
                                    	addSurveyPanel.gettableQuestionsSurveyModel().removeRow(i);
                                    	}
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
                        	Survey survey=new Survey();                       
                        	try {
								survey.save();
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        	for (int i=0;i<surveyQuestions.size();i++) {
                        		surveyQuestions.get(i).setSurveyID(survey.getSurveyID());
                        		try {
									surveyQuestions.get(i).save();
								} catch (URISyntaxException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                        	}
                        	surveyId=survey.getSurveyID();
                        	surveyQuestions.clear();
                        	

                        	
                        	
                        	
                        	
                        	
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
	private  java.sql.Date convertUtilToSql(java.util.Date uDate) {
		
		       java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		
		       return sDate;
		
		    }

	
}