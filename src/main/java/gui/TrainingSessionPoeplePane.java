package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import dataAccess.EmployeeAccess;
import models.Employee;
import models.Settings;
import models.TrainingInfo;
import models.TrainingSession;

public class TrainingSessionPoeplePane extends JPanel {
	private int selectedRow;
	private JButton btnBack;
	private JTable tbEmployee;
	private JButton btnCancelTrainingSession;
	private JLabel lblTrainingSessionTitle;
	private JButton btnInfo;
	private JButton btnEnlistedPeople;
	private JButton btnBooks;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnMaps;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	

	public TrainingSessionPoeplePane() {
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
							
		ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
		ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
		 try {
			 HashMap<Integer, Employee> ListEmployee=EmployeeAccess.getBySession(0);
  } catch (Exception exp) {
  	 System.out.println("nope");
       exp.printStackTrace();
       
   }
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTrainingSessoin");
		add(btnBack);
		
		lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		add(lblTrainingSessionTitle);
		
		btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		btnCancelTrainingSession.setActionCommand("CancelTrainingSession");
		add(btnCancelTrainingSession);
		
		btnInfo = new JButton("Info");
		btnInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInfo.setHorizontalAlignment(SwingConstants.CENTER);
		btnInfo.setOpaque(true);
		btnInfo.setBounds(440, 165, 100, 50);
		btnInfo.setActionCommand("Info");
		add(btnInfo);
		
		btnEnlistedPeople = new JButton("Enlisted people");
		btnEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		btnEnlistedPeople.setOpaque(true);
		btnEnlistedPeople.setBounds(540, 165, 200, 50);
		btnEnlistedPeople.setActionCommand("EnlistedPeople");
		add(btnEnlistedPeople);
		
		btnBooks = new JButton("Books");
		btnBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBooks.setBounds(740, 165, 100, 50);
		btnBooks.setHorizontalAlignment(SwingConstants.CENTER);
		btnBooks.setOpaque(true);
		btnBooks.setActionCommand("Books");
		add(btnBooks);
		
		btnMaps = new JButton("Map");
		btnMaps.setOpaque(true);
		btnMaps.setHorizontalAlignment(SwingConstants.CENTER);
		btnMaps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMaps.setActionCommand("Map");
		btnMaps.setBounds(840, 165, 100, 50);
		add(btnMaps);
		
		Object [] columnHeadersEmployee = {"Employee ID","Employee name","Department","Function","Status"};
		DefaultTableModel modelEmployee = new DefaultTableModel();
		modelEmployee.setColumnIdentifiers(columnHeadersEmployee);
		List<String[]> data = new ArrayList<String[]>();
		
			data.add(new String[] {
					//String.valueOf(entry.getValue().getTrainingSessionId()),
					//String.valueOf(entry.getValue().getEmployeeID()),
					//entry.getValue().getFirstName()
					//listTraingInfo.get(entry.getValue().getTrainingId()).getName(), 
					//String.valueOf(ListAdress.get(entry.getValue().getAddressId()).getLocality()), 
					//String.valueOf(entry.getValue().getDate()) ,
					//String.valueOf(entry.getValue().getStartHour())
					}
			);
	
		DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersEmployee) {


			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbEmployee = new JTable(tableModel);
		tbEmployee.setModel(tableModel);
		tbEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//tbEmployee.setEnabled(false);
		tbEmployee.setRowSelectionAllowed(true);
		//tbEmployee.setModel(modelBook);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelBook = tbEmployee.getColumnModel();
	    for (int column = 0; column < tbEmployee.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbEmployee.getRowCount(); row++) {
	            TableCellRenderer renderer = tbEmployee.getCellRenderer(row, column);
	            Component comp = tbEmployee.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelBook.getColumn(column).setPreferredWidth(width);
	    }
		
	    
		JScrollPane sclBook = new JScrollPane(tbEmployee);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 230, 1218, 430);
		add(sclBook);
		ListSelectionModel selectedRowBook = tbEmployee.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowBook.getMinSelectionIndex();
					//lblTrainingSessionTitle.setText(String.valueOf(selectedRow));
				}
			}
		});
		
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 220, 1237, 450);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
	}
	
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnCancelTrainingSession.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		btnInfo.addActionListener(listener);
		btnEnlistedPeople.addActionListener(listener);
		btnBooks.addActionListener(listener);
		btnMaps.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	
	public void setListEmployee(int id) {
		try {
			Object [] columnHeadersEmployee = {"Employee ID","Employee name","Titel"};
			 HashMap<Integer, Employee> ListEmployee = EmployeeAccess.getBySession(id);
			 List<String[]> data = new ArrayList<String[]>();
				for (Integer  entry : ListEmployee.keySet()) {
					data.add(new String[] {
							String.valueOf(ListEmployee.get(entry).getEmployeeID()),
							ListEmployee.get(entry).getTitleOfCourtesy()+ " " +ListEmployee.get(entry).getFirstName() + " " + ListEmployee.get(entry).getLastName(),
							ListEmployee.get(entry).getTitle()
							}
					);
				}
				DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersEmployee) {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				tbEmployee.setModel(tableModel);
 } catch (Exception exp) {
 	 System.out.println("nope");
      exp.printStackTrace();
      
  }
	}
	
	public void setBtnCancelTrainingSession(int id) {	
		TrainingSession session = null;
        try {
			session = Cache.trainingSessionCache.get(id);
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		if(session.isCancelled() == true) {
			System.out.println("true");
			btnCancelTrainingSession.setText("Uncancel training session");
		} else {
			System.out.println("false");
			btnCancelTrainingSession.setText("Cancel training session");
		}
	}
	
	public void updateCancelTrainingSession(int id) {	
		TrainingSession session = null;
        try {
			session = Cache.trainingSessionCache.get(id);
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		if(session.isCancelled() == true) {
			System.out.println("true");
			btnCancelTrainingSession.setText("Uncancel training session");
			session.setCanceled(false);
			try {
				session.save();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			System.out.println("false");
			btnCancelTrainingSession.setText("Cancel training session");
			session.setCanceled(true);
			try {
				session.save();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}