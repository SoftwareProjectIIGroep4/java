package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class AddSurveyPane extends JPanel {

	private int selectedRow;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JButton btnConfirmSurvey;
	private DefaultTableModel modelSurvey;
	private DefaultTableModel tableModel;
	private JTable tbSurvey;
	private JButton btnAddQuestion;
	private JButton btnDeleteQuestion;
	private JButton btnUpdateQuestion;
	private JTextField txtAddQuestion;
	private JButton btnBackToNewTrainingsession;
	
	/**
	 * Create the panel.
	 */
	public AddSurveyPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
	        jtbTraining = new JToggleButton("Training");
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
	        
	        jtbTrainingSession = new JToggleButton("Training session");
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
	        
	        jtbEmployees = new JToggleButton("Employees");
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
	        
	        jtbStatistics = new JToggleButton("Statistics");
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
	        
	        jtbTrainingRequests = new JToggleButton("Training requests");
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
	        
	        Object [] columnHeadersEmployees = {"Questions"};
			Object[][] data = {
			
					
					
			};
			
			tableModel = new DefaultTableModel(data, columnHeadersEmployees)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbSurvey = new JTable(tableModel);
			tbSurvey.setBackground(Color.red);
			tbSurvey.setForeground(Color.blue);
			tbSurvey.setModel(tableModel);
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
			
		    JScrollPane sclEmployee = new JScrollPane(tbSurvey);
		    sclEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    sclEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    sclEmployee.setBounds(30, 173, 789, 527);
			add(sclEmployee);
			ListSelectionModel selectedRowEmployees = tbSurvey.getSelectionModel();
			selectedRowEmployees.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowEmployees.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowEmployees.getMinSelectionIndex();
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
	        btnAddQuestion.setBounds(942, 350, 203, 41);
	        add(btnAddQuestion);
	        
	        btnDeleteQuestion = new JButton("Delete question");
	        btnDeleteQuestion.setActionCommand("deleteQuestion");
	        btnDeleteQuestion.setBounds(942, 402, 203, 41);
	        add(btnDeleteQuestion);
	        
	        btnUpdateQuestion = new JButton("Update question");
	        btnUpdateQuestion.setActionCommand("updateQuestion");
	        btnUpdateQuestion.setBounds(942, 454, 203, 41);
	        add(btnUpdateQuestion);
	        
	        txtAddQuestion = new JTextField();
	        txtAddQuestion.setBounds(876, 298, 330, 41);
	        add(txtAddQuestion);
	        txtAddQuestion.setColumns(10);
	        
	        JLabel lblAddQuestionExpl = new JLabel("Type your question here");
	        lblAddQuestionExpl.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblAddQuestionExpl.setBounds(876, 263, 235, 24);
	        add(lblAddQuestionExpl);
	        
	        tbSurvey.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	
	        	int i = tbSurvey.getSelectedRow();
	        		
	        }
	     });
	        
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
}
