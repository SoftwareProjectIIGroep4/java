package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class StatisticsFollowedTrainingPane extends JPanel {

	private int selectedRow;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnShowEmployeeFollowedTrainings;
	private JTextField txtEmployeeID;
	private JTable tbFollowedTrainingsEmployee;
	private DefaultTableModel tableFollowedTrainingEmployee;
	private JScrollPane sclFollowedTrainingsEmployee;
	private ListSelectionModel selectedRowFollowedTrainings;
	private JButton btnBackFollowedTrainingStatistics;
	
	/**
	 * Create the panel.
	 */
	public StatisticsFollowedTrainingPane() {
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
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
	        
	        JLabel lblNewLabel = new JLabel("logo");
	        lblNewLabel.setBounds(0, 0, 133, 75);
	        lblNewLabel.setOpaque(true);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Profiel");
	        lblNewLabel_1.setBounds(1186, 0, 85, 75);
	        lblNewLabel_1.setOpaque(true);
	        add(lblNewLabel_1);
	        
	        JLabel lblUitleg = new JLabel("Write employeeID to get information");
	        lblUitleg.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblUitleg.setBounds(44, 222, 260, 33);
	        add(lblUitleg);
	        
	        txtEmployeeID = new JTextField();
	        txtEmployeeID.setBounds(44, 266, 241, 33);
	        add(txtEmployeeID);
	        txtEmployeeID.setColumns(10);
	        
	        Object [] columnheaderEmployeeStatistics = {"First name","Last name","Training name","City","From","Until","Price"};
			//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
			Object[][] data = {
			
					
					
			};
			
			tableFollowedTrainingEmployee = new DefaultTableModel(data, columnheaderEmployeeStatistics)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbFollowedTrainingsEmployee = new JTable(tableFollowedTrainingEmployee);
			tbFollowedTrainingsEmployee.setBackground(Color.red);
			tbFollowedTrainingsEmployee.setForeground(Color.blue);
			tbFollowedTrainingsEmployee.setModel(tableFollowedTrainingEmployee);
			tbFollowedTrainingsEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbFollowedTrainingsEmployee.setRowSelectionAllowed(true);
		    final TableColumnModel columnmodelTraining = tbFollowedTrainingsEmployee.getColumnModel();
		    for (int column = 0; column < tbFollowedTrainingsEmployee.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tbFollowedTrainingsEmployee.getRowCount(); row++) {
		            TableCellRenderer renderer = tbFollowedTrainingsEmployee.getCellRenderer(row, column);
		            Component comp = tbFollowedTrainingsEmployee.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnmodelTraining.getColumn(column).setPreferredWidth(width);
		    }
			
		    sclFollowedTrainingsEmployee = new JScrollPane(tbFollowedTrainingsEmployee);
		    sclFollowedTrainingsEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    sclFollowedTrainingsEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    sclFollowedTrainingsEmployee.setBounds(358, 176, 856, 469);
			add(sclFollowedTrainingsEmployee);
			
			selectedRowFollowedTrainings = tbFollowedTrainingsEmployee.getSelectionModel();
			selectedRowFollowedTrainings.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowFollowedTrainings.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowFollowedTrainings.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});
			
			btnShowEmployeeFollowedTrainings = new JButton("Show information");
			btnShowEmployeeFollowedTrainings.setActionCommand("showFollowedTrainings");
			btnShowEmployeeFollowedTrainings.setBounds(44, 310, 158, 45);
			add(btnShowEmployeeFollowedTrainings);
			
			JLabel lblExplanationOfTable = new JLabel("Employee took part in the following trainings");
			lblExplanationOfTable.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblExplanationOfTable.setBounds(358, 132, 326, 33);
			add(lblExplanationOfTable);
			
			btnBackFollowedTrainingStatistics = new JButton("Back");
			btnBackFollowedTrainingStatistics.setActionCommand("backFollowedToStatistics");
			btnBackFollowedTrainingStatistics.setBounds(44, 131, 144, 45);
			add(btnBackFollowedTrainingStatistics);
			
	}
	
	public void addActionListener(ActionListener listener) {
		btnShowEmployeeFollowedTrainings.addActionListener(listener);
		btnBackFollowedTrainingStatistics.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
    }
	
	public String getEmployeeIDFollowedTraining() {
		return txtEmployeeID.getText();
	}
}
