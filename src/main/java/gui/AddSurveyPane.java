package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import dataAccess.Cache;
import dataAccess.SurveyQuestionAcces;
import models.Address;
import models.SurveyQuestion;
import models.Survey;
import models.SurveyAnswer;
import models.TrainingInfo;
import models.TrainingSession;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class AddSurveyPane extends JPanel {

	private int selectedRow;
	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private JButton btnConfirmSurvey;
	private DefaultTableModel tableQuestionsSurveyModel;
	private DefaultTableModel modelHistoryQuestionsSurvey;
	private JTable tbSurvey;
	private JTable tbAskedQuestions;
	private JScrollPane sclQuestionsSurvey;  
	private JScrollPane sclHistoryQuestions;
	private JButton btnAddQuestion;
	private JButton btnDeleteQuestion;
	private JButton btnUpdateQuestion;
	private JTextField txtAddQuestion;
	private JButton btnBackToNewTrainingsession;
	private ListSelectionModel selectedRowQuestionsSurvey;
	private ListSelectionModel selectedRowHistoryQuestions;
	
	
	
	
	/**
	 * Create the panel.
	 */
	/////////////////////////////////////////////////////////////
	
	
	ConcurrentMap<Integer, SurveyQuestion> listSQuestions =dataAccess.Cache.surveyQuestionCache.asMap();
	
	
	/////////////////////////////////////////////////////////////
	public AddSurveyPane() {
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		;
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
	        jtbTraining = new JButton("Training");
	        jtbTraining.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTraining.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTraining.setBorder(null);
	            }
	        });
	       
	        jtbTraining.setBackground(Color.WHITE);
	        jtbTraining.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTraining.setOpaque(true);
	        jtbTraining.setActionCommand("TrainingMenu");
	        jtbTraining.setBounds(133, 0, 211, 75);
	        add(jtbTraining);
	        
	        jtbTrainingSession = new JButton("Training session");
	        jtbTrainingSession.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingSession.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingSession.setBorder(null);
	            }
	        });
	      
	        jtbTrainingSession.setBackground(Color.WHITE);
	        jtbTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingSession.setOpaque(true);
	        jtbTrainingSession.setActionCommand("TrainingSessionMenu");
	        jtbTrainingSession.setBounds(344, 0, 211, 75);
	        add(jtbTrainingSession);
	        
	        jtbEmployees = new JButton("Employees");
	        jtbEmployees.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbEmployees.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbEmployees.setBorder(null);
	            }
	        });
	       
	        jtbEmployees.setBackground(Color.WHITE);
	        jtbEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbEmployees.setOpaque(true);
	        jtbEmployees.setActionCommand("EmployeesMenu");
	        jtbEmployees.setBounds(555, 0, 212, 75);
	        add(jtbEmployees);
	        
	        jtbStatistics = new JButton("Statistics");
	        jtbStatistics.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbStatistics.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbStatistics.setBorder(null);
	            }
	        });
	        
	        jtbStatistics.setBackground(Color.WHITE);
	        jtbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbStatistics.setOpaque(true);
	        jtbStatistics.setActionCommand("StatisticsMenu");
	        jtbStatistics.setBounds(767, 0, 212, 75);
	        add(jtbStatistics);
	        
	        jtbTrainingRequests = new JButton("Training requests");
	        jtbTrainingRequests.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingRequests.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingRequests.setBorder(null);
	            }
	        });
	        jtbTrainingRequests.setBackground(Color.WHITE);
	        jtbTrainingRequests.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingRequests.setOpaque(true);
	        jtbTrainingRequests.setActionCommand("TrainingRequestsMenu");
	        jtbTrainingRequests.setBounds(979, 0, 211, 75);
	        add(jtbTrainingRequests);
	        
	        JLabel lblNewLabel = new JLabel("logo");
	        lblNewLabel.setBounds(0, 0, 133, 75);
	        lblNewLabel.setOpaque(true);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Profiel");
	        lblNewLabel_1.setBounds(1190, 0, 75, 75);
	        lblNewLabel_1.setOpaque(true);
	        add(lblNewLabel_1);
	        
	        Object [] columnHeaderQuestionsSurvey = {"Questions for the survey"};
	        List<String[]> data1 = new ArrayList<String[]>();	       
			//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);       
	        
	        for (int i =0;i<MainFrame.getSurveyQuestions().size();i++) {

				
				data1.add(new String[] {
						
						MainFrame.getSurveyQuestions().get(i).getQuestion()
						
						
				});
		

			}
			
			tableQuestionsSurveyModel = new DefaultTableModel(data1.toArray(new Object[][] {}), columnHeaderQuestionsSurvey)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbSurvey = new JTable(tableQuestionsSurveyModel);
			tbSurvey.setBackground(Color.red);
			tbSurvey.setForeground(Color.blue);
			tbSurvey.setModel(tableQuestionsSurveyModel);
			tbSurvey.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbSurvey.setRowSelectionAllowed(true);
		    final TableColumnModel columnmodelTraining = tbSurvey.getColumnModel();
		    for (int column = 0; column < tbSurvey.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tbSurvey.getRowCount(); row++) {
		            TableCellRenderer renderer = tbSurvey.getCellRenderer(row, column);
		            Component comp = tbSurvey.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnmodelTraining.getColumn(column).setPreferredWidth(width);
		    }
			
		    sclQuestionsSurvey = new JScrollPane(tbSurvey);
		    sclQuestionsSurvey.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    sclQuestionsSurvey.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    sclQuestionsSurvey.setBounds(488, 176, 403, 505);
			add(sclQuestionsSurvey);
			selectedRowQuestionsSurvey = tbSurvey.getSelectionModel();
			selectedRowQuestionsSurvey.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowQuestionsSurvey.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowQuestionsSurvey.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});
	        
			
			//-------------------------------------------------------------------------------
			
			Object [] columnHeadersHistoryQuestions = {"Previous questions from surveys"};
			List<String[]> data = new ArrayList<String[]>();

			for (Map.Entry<Integer, SurveyQuestion>  entry : listSQuestions.entrySet()) {
				
				data.add(new String[] {
						entry.getValue().getQuestion()
						
						
				});
		

			}
			
			DefaultTableModel modelHistoryQuestionsSurvey = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersHistoryQuestions)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbAskedQuestions = new JTable(modelHistoryQuestionsSurvey);
			tbAskedQuestions.setModel(modelHistoryQuestionsSurvey);
			tbAskedQuestions.setBackground(Color.red);
			tbAskedQuestions.setForeground(Color.blue);
			tbAskedQuestions.setModel(modelHistoryQuestionsSurvey);
			tbAskedQuestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbAskedQuestions.setRowSelectionAllowed(true);
		    final TableColumnModel columnmodelTraining1 = tbAskedQuestions.getColumnModel();
		    for (int column = 0; column < tbAskedQuestions.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tbAskedQuestions.getRowCount(); row++) {
		            TableCellRenderer renderer = tbAskedQuestions.getCellRenderer(row, column);
		            Component comp = tbAskedQuestions.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnmodelTraining1.getColumn(column).setPreferredWidth(width);
		    }
			
		    sclHistoryQuestions = new JScrollPane(tbAskedQuestions);
		    sclHistoryQuestions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    sclHistoryQuestions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    sclHistoryQuestions.setBounds(30, 176, 403, 505);
			add(sclHistoryQuestions);
			selectedRowHistoryQuestions = tbAskedQuestions.getSelectionModel();
			selectedRowHistoryQuestions.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowHistoryQuestions.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowHistoryQuestions.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});
			
			btnConfirmSurvey = new JButton("Confirm survey");
			btnConfirmSurvey.setActionCommand("confirmSurvey");
			btnConfirmSurvey.setBounds(219, 106, 203, 41);			
	        add(btnConfirmSurvey);
	        
	        btnBackToNewTrainingsession = new JButton("Back");
	        btnBackToNewTrainingsession.setActionCommand("backToNewTrainingSession");
	        btnBackToNewTrainingsession.setBounds(30, 106, 123, 41);
	        add(btnBackToNewTrainingsession);
	        
	        btnAddQuestion = new JButton("Add question");
	        btnAddQuestion.setActionCommand("addQuestion");
	        btnAddQuestion.setBounds(987, 350, 203, 41);
	        add(btnAddQuestion);
	        
	        btnDeleteQuestion = new JButton("Delete question");
	        btnDeleteQuestion.setActionCommand("deleteQuestion");
	        btnDeleteQuestion.setBounds(987, 402, 203, 41);
	        add(btnDeleteQuestion);
	        
	        btnUpdateQuestion = new JButton("Update question");
	        btnUpdateQuestion.setActionCommand("updateQuestion");
	        btnUpdateQuestion.setBounds(987, 454, 203, 41);
	        add(btnUpdateQuestion);
	        
	        txtAddQuestion = new JTextField();
	        txtAddQuestion.setBounds(922, 298, 330, 41);
	        add(txtAddQuestion);
	        txtAddQuestion.setColumns(10);
	        
	        JLabel lblAddQuestionExpl = new JLabel("Type your question here");
	        lblAddQuestionExpl.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblAddQuestionExpl.setBounds(922, 263, 235, 24);
	        add(lblAddQuestionExpl);
	        
	}
	
	public void addActionListener(ActionListener listener) {
		btnBackToNewTrainingsession.addActionListener(listener);
		btnConfirmSurvey.addActionListener(listener);
		btnAddQuestion.addActionListener(listener);
		btnDeleteQuestion.addActionListener(listener);
		btnUpdateQuestion.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	public String getAddQuestion() {
	
	return txtAddQuestion.getText();
	}
	public void clear() {
		txtAddQuestion.setText("");
	}
	
}
