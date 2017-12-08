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
        
        LoginPane newLoginPane =  new LoginPane();
        HomePane homePanel = new HomePane();
        TrainingPane trainingPanel = new TrainingPane();
        TrainingSessionPane trainingSessionPanel = new TrainingSessionPane();
        NewTrainingSessionPane newNewTrainingSessionPane = new NewTrainingSessionPane();
        EmployeePane employeePanel = new EmployeePane();
        StatistiekenPane statistiekenPanel = new StatistiekenPane();    
        TrainingrequestPane trainingrequestPanel = new TrainingrequestPane();
        TrainingSessionBookPane newTrainingSessionBookPane = new TrainingSessionBookPane();
        TrainingSessionPoeplePane newTrainingSessionPoeplePane = new TrainingSessionPoeplePane();
        TrainingSessionInfoPane newTrainingSessionInfoPane = new TrainingSessionInfoPane();
        SelectTrainingPane newSelectTrainingPane = new SelectTrainingPane();
        NewTrianingPane newNewTrianingPane = new NewTrianingPane();
        
        
        getContentPane().add(newLoginPane, "loginPanel");
        getContentPane().add(homePanel, "homePanel");
        getContentPane().add(trainingPanel, "trainingPanel");
        getContentPane().add(trainingSessionPanel, "trainingSessionPanel");
        getContentPane().add(newNewTrainingSessionPane, "NewTrainingSessionPane");
        getContentPane().add(employeePanel, "employeePanel");
        getContentPane().add(statistiekenPanel, "statistiekenPanel");
        getContentPane().add(trainingrequestPanel, "trainingrequestPanel");
        getContentPane().add(newTrainingSessionBookPane, "TrainingSessionBookPane");
        getContentPane().add(newTrainingSessionPoeplePane, "TrainingSessionPoeplePane");
        getContentPane().add(newTrainingSessionInfoPane, "TrainingSessionInfoPane");
        getContentPane().add(newSelectTrainingPane, "SelectTrainingPane");
        getContentPane().add(newNewTrianingPane, "NewTrianingPane");
       
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
                } else  if ("EmployeesMenu".equals(command)) {
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
                if ("TrainingSessionMenu".equals(command)) {
                    //show trainingSessionPane
                    layout.show(getContentPane(), "trainingSessionPanel");
                } else  if ("EmployeesMenu".equals(command)) {
                    //show employeesPane
                    layout.show(getContentPane(), "employeePanel");
                }else if ("StatisticsMenu".equals(command)) {
                    //show statisticsSessionPane
                    layout.show(getContentPane(), "statistiekenPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                    //show trainingRequestMenu
                    layout.show(getContentPane(), "trainingrequestPanel");
                } else if ("goToSelectTraining".equals(command)) {
                    //show selectTrainingMenu
                    
                }else if ("goToAddTraining".equals(command)) {
                    //show addTrainingMenu
                    
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
                    } else  if ("EmployeesMenu".equals(command)) {
                        //show employeesPane
                        layout.show(getContentPane(), "employeePanel");
                    } else if ("StatisticsMenu".equals(command)) {
                        //show statisticsSessionPane
                        layout.show(getContentPane(), "statistiekenPanel");
                    } else if ("TrainingRequestsMenu".equals(command)) {
                        //show trainingRequestMenu
                        layout.show(getContentPane(), "trainingrequestPanel");
                    }else if ("goToAddTrainingSession".equals(command)) {
                        //show trainingRequestMenu
                        layout.show(getContentPane(), "newTrainingSessionPanel");
                    }
                }
            });
            
            newNewTrainingSessionPane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    System.out.println(command);
                    if ("TrainingMenu".equals(command)) {
                        //show trainingPane
                    } else if ("TrainingSessionMenu".equals(command)) {
                        //show trainingSessionPane
                    } else  if ("EmployeesMenu".equals(command)) {
                        //show employeesPane
                    } else if ("StatisticsMenu".equals(command)) {
                        //show statisticsSessionPane
                    } else if ("TrainingRequestsMenu".equals(command)) {
                        //show trainingRequestMenu
                    } else if ("backToTrainingSession".equals(command)) {
                        //show trainingRequestMenu
                        layout.show(getContentPane(), "trainingSessionPanel");
                    } else if ("SaveTrainingSession".equals(command)) {
                        //save de data voor training session gebruik getters
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
                } else if ("StatisticsMenu".equals(command)) {
                    //show statisticsSessionPane
                    layout.show(getContentPane(), "statistiekenPanel");
                } else if ("TrainingRequestsMenu".equals(command)) {
                    //show trainingRequestMenu
                    layout.show(getContentPane(), "trainingrequestPanel");
                } else if ("addEmployeeToTable".equals(command)) {
                    //show trainingRequestMenu
                    layout.show(getContentPane(), "addEmployeeToTable");
                } else if ("deleteEmployeeToTable".equals(command)) {
                    //show trainingRequestMenu
                    layout.show(getContentPane(), "deleteEmployeeToTable");
                } else if ("updateEmployeeToTable".equals(command)) {
                    //show trainingRequestMenu
                    layout.show(getContentPane(), "updateEmployeeToTable");
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
                    } else  if ("EmployeesMenu".equals(command)) {
                        //show employeesPane
                        layout.show(getContentPane(), "employeePanel");
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
                        } else  if ("EmployeesMenu".equals(command)) {
                            //show employeesPane
                            layout.show(getContentPane(), "employeePanel");
                        } else if ("StatisticsMenu".equals(command)) {
                            //show statisticsSessionPane
                            layout.show(getContentPane(), "statistiekenPanel");
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
                        } else  if ("EmployeesMenu".equals(command)) {
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
                        } else  if ("EmployeesMenu".equals(command)) {
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
                            //show newTrainingSessionPane
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
                        } else if ("TrainingSessionMenu".equals(command)) {
                            //show trainingSessionPane
                        } else if ("EmployeesMenu".equals(command)) {
                            //show employeesPane
                        } else if ("StatisticsMenu".equals(command)) {
                            //show statisticsSessionPane
                        } else if ("TrainingRequestsMenu".equals(command)) {
                            //show trainingRequestPane
                        } else if ("BackToTraining".equals(command)) {
                            //show TrainingSessoinPane
                        } else if ("SaveTraining".equals(command)) {
                            //cancel trainingSession
                        } else if ("AddNewTraining".equals(command)) {
                            //show TrainingSessoinInfoPane
                        }
                        
                    }
                });
        
        layout.show(getContentPane(), "layout");
    }
}
