package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
import models.Settings;
import models.SurveyQuestion;

public class AddSurveyPane extends JPanel {

	private int selectedRow;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnConfirmSurvey;
	private DefaultTableModel tableQuestionsSurveyModel;
	private DefaultTableModel modelHistoryQuestionsSurvey;
	private JTable tbSurvey;
	private JTable tbAskedQuestions;
	private JScrollPane sclQuestionsSurvey;  
	private JScrollPane sclHistoryQuestions;
	private JButton btnAddQuestion;
	private JTextField txtAddQuestion;
	private JButton btnBackToNewTrainingsession;
	private ListSelectionModel selectedRowQuestionsSurvey;
	private ListSelectionModel selectedRowHistoryQuestions;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	
	public DefaultTableModel gettableQuestionsSurveyModel() {
		 return this.tableQuestionsSurveyModel;
	 }
	
	
	
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
		  
		  	try {
				settings = Cache.settingsCache.get(1);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        companyName = new JLabel(settings.getCompanyName()); //uit cache halen f
	        companyName.setBounds(10, 0, 110, 75);
	        companyName.setOpaque(true);
	        add(companyName);
		  
		  	jtbSettings = new JButton("Settings");
		  	jtbSettings.setBackground(Color.WHITE);
		  	jtbSettings.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbSettings.setOpaque(true);
	        jtbSettings.setActionCommand("SettingsMenu");
	        jtbSettings.setBounds(1190, 12, 70, 50);
	        add(jtbSettings);
	        
		  btnTraining = new JButton("Training"); 
		  btnTraining.setBackground(Color.WHITE);
		  btnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		  btnTraining.setOpaque(true);
		  btnTraining.setActionCommand("TrainingMenu");
		  btnTraining.setBounds(124, 0, 264, 75);
	        add(btnTraining);
	        
	        btnTrainingsession = new JButton("Training session");
	        btnTrainingsession.setBackground(Color.WHITE);
	        btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
	        btnTrainingsession.setOpaque(true);
	        btnTrainingsession.setActionCommand("TrainingSessionMenu");
	        btnTrainingsession.setBounds(387, 0, 264, 75);
	        add(btnTrainingsession);
	        
	        btnEmployees = new JButton("Employees");
	        btnEmployees.setBackground(Color.WHITE);
	        btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        btnEmployees.setOpaque(true);
	        btnEmployees.setActionCommand("EmployeesMenu");
	        btnEmployees.setBounds(650, 0, 264, 75);
	        add(btnEmployees);
	        
	        btnStatistics = new JButton("Statistics");
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
	        
	        Object [] columnHeaderQuestionsSurvey = {"Questions for the survey"};
	        List<String[]> data1 = new ArrayList<String[]>();	       
			//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);       
	        

				
				data1.add(new String[] {
						
						
				});
		

			
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
						int selectedRow = tbSurvey.getSelectedRow();
						int selectedColumn= tbSurvey.getSelectedColumn();
						
						//tableQuestionsSurveyModel.removeRow(selectedRow);
						
					}
				}

			});
			tbSurvey.addMouseListener(new MouseAdapter(){
			     public void mouseClicked(MouseEvent e){
			      if (e.getClickCount() == 2){
			    	  int selectedRow = tbSurvey.getSelectedRow();
			    	  tableQuestionsSurveyModel.removeRow(selectedRow);
			         }
			      }
			     } );
	        
			
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
						int selectedRow = tbAskedQuestions.getSelectedRow();
						int selectedColumn= tbAskedQuestions.getSelectedColumn();
						
						Object object=GetData(tbAskedQuestions, selectedRow, selectedColumn);
						txtAddQuestion.setText(object.toString());
						
						
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
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	
	public String getAddQuestion() {
	
	return txtAddQuestion.getText();
	}
	public void clear() {
		txtAddQuestion.setText("");
	}
	
	
	public Object GetData(JTable table, int row_index, int col_index){
		  return table.getModel().getValueAt(row_index, col_index);
		  }  
	public void mouseClicked(MouseEvent e,int selected) {
		  if (e.getClickCount() >= 2) {
			  tableQuestionsSurveyModel.removeRow(selected);
		  }
		}
	
	
}
