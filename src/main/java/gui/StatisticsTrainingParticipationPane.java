package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
import dataAccess.StatisticsAccess;
import models.EmpHighTrainingCount;
import models.Settings;

public class StatisticsTrainingParticipationPane extends JPanel {

	private int selectedRow;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnShowMaxParticipationTraining;
	private JTextField txtYear;
	private JTable tbEmployeeParticipationTrainings;
	private DefaultTableModel tablePartEmployeeTraining;
	private DefaultTableModel modelPartEmployees;
	private JScrollPane sclPartEmployeeTrainings;
	private ListSelectionModel selectedRowPartEmployeeTraining;
	private JButton btnParticipationBackStatistics;
	private JLabel lblFirstName;
	private JLabel lblLastname;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	
	
	/**
	 * Create the panel.
	 */
	
	private List<String[]> employeeData = null;
	
	public StatisticsTrainingParticipationPane() {
		
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
		  btnTraining.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtYear.setText("");
					modelPartEmployees.getDataVector().removeAllElements();
					modelPartEmployees.fireTableDataChanged();
				}
			});
		  btnTraining.setBackground(Color.WHITE);
		  btnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		  btnTraining.setOpaque(true);
		  btnTraining.setActionCommand("TrainingMenu");
		  btnTraining.setBounds(124, 0, 264, 75);
	      add(btnTraining);
	        
	        btnTrainingsession = new JButton("Training session");
	        btnTrainingsession.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtYear.setText("");
					modelPartEmployees.getDataVector().removeAllElements();
					modelPartEmployees.fireTableDataChanged();
				}
			});
	        btnTrainingsession.setBackground(Color.WHITE);
	        btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
	        btnTrainingsession.setOpaque(true);
	        btnTrainingsession.setActionCommand("TrainingSessionMenu");
	        btnTrainingsession.setBounds(387, 0, 264, 75);
	        add(btnTrainingsession);
	        
	        btnEmployees = new JButton("Employees");
	        btnEmployees.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtYear.setText("");
					modelPartEmployees.getDataVector().removeAllElements();
					modelPartEmployees.fireTableDataChanged();
				}
			});
	        btnEmployees.setBackground(Color.WHITE);
	        btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        btnEmployees.setOpaque(true);
	        btnEmployees.setActionCommand("EmployeesMenu");
	        btnEmployees.setBounds(650, 0, 264, 75);
	        add(btnEmployees);
	        
	        btnStatistics = new JButton("Statistics");
	        btnStatistics.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtYear.setText("");
					modelPartEmployees.getDataVector().removeAllElements();
					modelPartEmployees.fireTableDataChanged();
				}
			});
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
	        
	        JLabel lblUitlegPart = new JLabel("Write year to retrieve data");
	        lblUitlegPart.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblUitlegPart.setBounds(44, 222, 260, 33);
	        add(lblUitlegPart);
	        
	        lblFirstName = new JLabel("");
			lblFirstName.setBounds(74, 404, 149, 40);
			add(lblFirstName);
			
			lblLastname = new JLabel("");
			lblLastname.setBounds(74, 455, 114, 63);
			add(lblLastname);
			
	        txtYear = new JTextField();
	        txtYear.setBounds(44, 266, 126, 33);
	        add(txtYear);
	        txtYear.setColumns(10);
	        
	        Object [] columnheaderEmployeeStatistics = {"EmployeeID","First Name","Last Name","Number of participations"};
			//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
			Object[][] data = {
			};

			tablePartEmployeeTraining  = new DefaultTableModel(data, columnheaderEmployeeStatistics)
			{
				@Override
				public boolean isCellEditable(int row, int column) {
					//all cells false
					return false;
				}
			};
			tbEmployeeParticipationTrainings = new JTable(tablePartEmployeeTraining );
			tbEmployeeParticipationTrainings.setModel(tablePartEmployeeTraining );
			tbEmployeeParticipationTrainings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbEmployeeParticipationTrainings.setRowSelectionAllowed(true);
			final TableColumnModel columnmodelTraining = tbEmployeeParticipationTrainings .getColumnModel();
			for (int column = 0; column < tbEmployeeParticipationTrainings .getColumnCount(); column++) {
				int width = 15; // Min width
				for (int row = 0; row < tbEmployeeParticipationTrainings .getRowCount(); row++) {
					TableCellRenderer renderer = tbEmployeeParticipationTrainings .getCellRenderer(row, column);
					Component comp = tbEmployeeParticipationTrainings .prepareRenderer(renderer, row, column);
					width = Math.max(comp.getPreferredSize().width +1 , width);
				}
				if(width > 300)
					width=300;
				columnmodelTraining.getColumn(column).setPreferredWidth(width);
			}

			sclPartEmployeeTrainings = new JScrollPane(tbEmployeeParticipationTrainings );
			sclPartEmployeeTrainings.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			sclPartEmployeeTrainings.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			sclPartEmployeeTrainings.setBounds(358, 176, 856, 469);
			add(sclPartEmployeeTrainings);

			selectedRowPartEmployeeTraining = tbEmployeeParticipationTrainings .getSelectionModel();
			selectedRowPartEmployeeTraining.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowPartEmployeeTraining.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowPartEmployeeTraining.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});



			btnShowMaxParticipationTraining  = new JButton("Show information");
			btnShowMaxParticipationTraining .addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int count = Integer.parseInt(txtYear.getText());
					
					List<EmpHighTrainingCount> listTrainingCount = new ArrayList<EmpHighTrainingCount>();
					
					try {
						
						listTrainingCount = StatisticsAccess.getHighestTrainingCount(count);
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					List<String[]> employeeData = new ArrayList<String[]>();
					
					for(int i = 0; i < listTrainingCount.size(); i++) {
						
							employeeData.add(new String[] {
													
									String.valueOf(listTrainingCount.get(i).getEmployee().getEmployeeID()),
									listTrainingCount.get(i).getEmployee().getFirstName(),
									listTrainingCount.get(i).getEmployee().getLastName(),
									String.valueOf(listTrainingCount.get(i).getCount())
								
							});		  
					}	
				
				

					if (listTrainingCount.isEmpty()) {
						employeeData.add(new String[] {
								"No Training Followed Yet"	
						});
					}

					modelPartEmployees = new DefaultTableModel(employeeData.toArray(new Object[][] {}), columnheaderEmployeeStatistics) {
						@Override
						public boolean isCellEditable(int row, int column) {
							//all cells false
							return false;
						}
					};
					tbEmployeeParticipationTrainings.setModel(modelPartEmployees);
					tbEmployeeParticipationTrainings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tbEmployeeParticipationTrainings.setRowSelectionAllowed(true);

					final TableColumnModel columnmodelTraining = tbEmployeeParticipationTrainings.getColumnModel();
					for (int column = 0; column < tbEmployeeParticipationTrainings.getColumnCount(); column++) {
						int width = 15; // Min width
						for (int row = 0; row < tbEmployeeParticipationTrainings.getRowCount(); row++) {
							TableCellRenderer renderer = tbEmployeeParticipationTrainings.getCellRenderer(row, column);
							Component comp = tbEmployeeParticipationTrainings.prepareRenderer(renderer, row, column);
							width = Math.max(comp.getPreferredSize().width +1 , width);
						}
						if(width > 300)
							width=300;
						columnmodelTraining.getColumn(column).setPreferredWidth(width);
					}

				}
			});
		
			btnShowMaxParticipationTraining.setBounds(44, 310, 158, 45);
			add(btnShowMaxParticipationTraining);
			
			JLabel lblExplanationOfTablePart = new JLabel("Training participations of employee");
			lblExplanationOfTablePart.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblExplanationOfTablePart.setBounds(358, 132, 326, 33);
			add(lblExplanationOfTablePart);
			
			btnParticipationBackStatistics = new JButton("Back");
			btnParticipationBackStatistics.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtYear.setText("");
					modelPartEmployees.getDataVector().removeAllElements();
					modelPartEmployees.fireTableDataChanged();
				}
			});
			btnParticipationBackStatistics.setActionCommand("backPartToStatistics");
			btnParticipationBackStatistics.setBounds(44, 131, 144, 45);
			add(btnParticipationBackStatistics);
			
			
	}
			
		public void addActionListener(ActionListener listener) {
		btnShowMaxParticipationTraining.addActionListener(listener);
		btnParticipationBackStatistics.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	
}			

