package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
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
import models.Address;
import models.Settings;
import models.TrainingInfo;
import models.TrainingSession;

public class TrainingSessionPane extends JPanel {

	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private JTable tbSession;
	private JTextField txtFromTrainingSession;
	private JTextField txtUntilTrainingSession;
	private JButton btnAddTrainingSession;
	private JButton btnShowTrainingSession;
	private DefaultTableModel modelSession;
	private DefaultTableModel tableModel;
	private String trainingSessionID;
	private String addressID;
	private String trainingID;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	

	


	/*
	 * Create the panel.
	 */
	
	public TrainingSessionPane() {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
		ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
		ConcurrentMap<Integer, Address> ListAdress=dataAccess.Cache.addressCache.asMap();

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
	        jtbSettings.setBounds(1175, 0, 105, 75);
	        add(jtbSettings);
	        
	        jtbTraining = new JButton("Training"); 
	        jtbTraining.setBackground(Color.WHITE);
	        jtbTraining.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTraining.setOpaque(true);
	        jtbTraining.setActionCommand("TrainingMenu");
	        jtbTraining.setBounds(124, 0, 264, 75);
	        add(jtbTraining);
	        
	        jtbTrainingSession = new JButton("Training session");
	        jtbTrainingSession.setBackground(Color.WHITE);
	        jtbTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingSession.setOpaque(true);
	        jtbTrainingSession.setActionCommand("TrainingSessionMenu");
	        jtbTrainingSession.setBounds(387, 0, 264, 75);
	        add(jtbTrainingSession);
	        
	        jtbEmployees = new JButton("Employees");
	        jtbEmployees.setBackground(Color.WHITE);
	        jtbEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbEmployees.setOpaque(true);
	        jtbEmployees.setActionCommand("EmployeesMenu");
	        jtbEmployees.setBounds(650, 0, 264, 75);
	        add(jtbEmployees);
	        
	        jtbStatistics = new JButton("Statistics");
	        jtbStatistics.setBackground(Color.WHITE);
	        jtbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbStatistics.setOpaque(true);
	        jtbStatistics.setActionCommand("StatisticsMenu");
	        jtbStatistics.setBounds(912, 0, 264, 75);
	        add(jtbStatistics);
		
		Object [] columnHeadersSession = {"Training ID","traingsession ID", "Training name","City","Date","Hour"};
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		List<String[]> data = new ArrayList<String[]>();
		
		for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
			data.add(new String[] {
					String.valueOf(entry.getValue().getTrainingId()),
					String.valueOf(entry.getValue().getTrainingSessionId()),
					listTraingInfo.get(entry.getValue().getTrainingId()).getName(), 
					String.valueOf(ListAdress.get(entry.getValue().getAddressId()).getLocality()), 
					entry.getValue().getDate().substring(0, 9) ,
					String.valueOf(entry.getValue().getStartHour()),
					String.valueOf(entry.getValue().getAddressId()),
					String.valueOf(entry.getValue().getTrainingId())
					}
			);
		}
		DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersSession) {


			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbSession = new JTable(tableModel);
		tbSession.setModel(tableModel);
		tbSession.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbSession.setRowSelectionAllowed(true);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelSession = tbSession.getColumnModel();
	    for (int column = 0; column < tbSession.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbSession.getRowCount(); row++) {
	            TableCellRenderer renderer = tbSession.getCellRenderer(row, column);
	            Component comp = tbSession.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelSession.getColumn(column).setPreferredWidth(width);
	    }  
		JScrollPane sclBook = new JScrollPane(tbSession);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(31, 119, 1007, 530);
		add(sclBook);
		ListSelectionModel selectedRowBook = tbSession.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					//doe iets hier
					String[] teStrings=data.get(selectedRow);
					trainingSessionID = teStrings[1];
					addressID = teStrings[6];
					trainingID = teStrings[7];
					//System.out.println(trainingID);
				}
			} 
		});

		btnShowTrainingSession = new JButton("Show training session");
		btnShowTrainingSession.setActionCommand("goToTrainingSessionInfo");
		btnShowTrainingSession.setBounds(1072,138,160,64);
		add(btnShowTrainingSession);
		
		JLabel lblNewLabel_2 = new JLabel("List of trainingssessions");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(31, 86, 278, 28);
		add(lblNewLabel_2);
		
	}
	
	public void addActionListener(ActionListener listener) {
		btnShowTrainingSession.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	
	
	public void addRowToTrainingSessionTable(Object[] row) {
		
		tableModel.addRow(row);
	
	}
	public int getTrainingSessionID() {
		return Integer.parseInt(trainingSessionID);
	}
	public int getAddressID() {
		return Integer.parseInt(addressID);
	}
	public int getTrainingID() {
		return Integer.parseInt(trainingID);
	}
}
