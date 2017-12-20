package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;
import models.Address;
import models.TrainingInfo;
import models.TrainingSession;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class TrainingSessionPane extends JPanel {

	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private JTable tbSession;
<<<<<<< HEAD
	private JTextField txtFromTrainingSession;
	private JTextField txtUntilTrainingSession;
	private JButton btnAddTrainingSession;
	private JButton btnShowTrainingSession;
=======
>>>>>>> refs/remotes/origin/master
	private DefaultTableModel modelSession;
	private DefaultTableModel tableModel;
	private String trainingSessionID;
	

	


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
	        
	        JLabel lblNewLabel = new JLabel("logo");
	        lblNewLabel.setBounds(0, 0, 133, 75);
	        lblNewLabel.setOpaque(true);
	        add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Profiel");
	        lblNewLabel_1.setBounds(1186, 0, 85, 75);
	        lblNewLabel_1.setOpaque(true);
	        add(lblNewLabel_1);
<<<<<<< HEAD
		
		
		Object [] columnHeadersSession = {"Training ID", "Training name","City","Date","Hour"};
=======
				
		Object [] columnHeadersSession = {"Training name","City","Date","Hour"};
>>>>>>> refs/remotes/origin/master
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		List<String[]> data = new ArrayList<String[]>();
		for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
			data.add(new String[] {
					String.valueOf(entry.getValue().getTrainingSessionId()),
					listTraingInfo.get(entry.getValue().getTrainingId()).getName(), 
					String.valueOf(ListAdress.get(entry.getValue().getAddressId()).getLocality()), 
					String.valueOf(entry.getValue().getDate()) ,
					String.valueOf(entry.getValue().getStartHour())}
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
					trainingSessionID = teStrings[0];
					System.out.println(teStrings[0]);
				}
			}
		});
		
		btnShowTrainingSession = new JButton("Show training session");
		btnShowTrainingSession.setActionCommand("goToTrainingSessionInfo");
		btnShowTrainingSession.setBounds(1072,138,160,64);
		add(btnShowTrainingSession);
		
<<<<<<< HEAD
		btnShowTrainingSession = new JButton("Show training session");
		btnShowTrainingSession.setActionCommand("goToTrainingSessionInfo");
		btnShowTrainingSession.setBounds(1000, 138, 160, 64);
		add(btnShowTrainingSession);
		

		//btnShowTrainingSession = new JButton("Show training session");
		//btnShowTrainingSession.setActionCommand("goToTrainingSessionInfo");
		//btnShowTrainingSession.setBounds(1030, 138, 160, 64);
		//add(btnShowTrainingSession);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFilters.setBounds(820, 212, 46, 16);
		add(lblFilters);
		
		/*JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(841, 288, 97, 23);
		add(chckbxMonday);
		
		JCheckBox chckbxTeusday = new JCheckBox("Tuesday");
		chckbxTeusday.setBounds(979, 288, 97, 23);
		add(chckbxTeusday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(841, 314, 97, 23);
		add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(979, 314, 97, 23);
		add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(841, 340, 97, 23);
		add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(979, 340, 97, 23);
		add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(841, 366, 97, 23);
		add(chckbxSunday);*/
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrom.setBounds(841, 421, 46, 14);
		add(lblFrom);
		
		JLabel lblUntil = new JLabel("Until:");
		lblUntil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUntil.setBounds(841, 481, 46, 14);
		add(lblUntil);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(820, 239, 385, 427);
		lblBackBorder2.setBorder(border);
		add(lblBackBorder2);
		
		txtFromTrainingSession = new JTextField();
		txtFromTrainingSession.setBounds(911, 413, 189, 35);
		txtFromTrainingSession.setColumns(10);
		txtFromTrainingSession.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtFromTrainingSession.selectAll();
        	}
		});
		txtFromTrainingSession.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtFromTrainingSession.selectAll();
        	}
        });
        add(txtFromTrainingSession);
		
        txtUntilTrainingSession = new JTextField();
        txtUntilTrainingSession.setBounds(911, 473, 189, 35);
        txtUntilTrainingSession.setColumns(10);
        txtUntilTrainingSession.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtUntilTrainingSession.selectAll();
        	}
		});
        txtUntilTrainingSession.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtUntilTrainingSession.selectAll();
        	}
        });
        add(txtUntilTrainingSession);
=======
		JLabel lblNewLabel_2 = new JLabel("List of training sessions");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(31, 86, 278, 28);
		add(lblNewLabel_2);
>>>>>>> refs/remotes/origin/master
		
	}
	
	public void addActionListener(ActionListener listener) {
<<<<<<< HEAD
		btnAddTrainingSession.addActionListener(listener);
		btnShowTrainingSession.addActionListener(listener);
=======
		btnShowTrainingSession.addActionListener(listener);
>>>>>>> refs/remotes/origin/master
		jtbTraining.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	
	public void addRowToTrainingSessionTable(Object[] row) {
		
		tableModel.addRow(row);
	
	}
	public int getTrainingSessionID() {
		return Integer.parseInt(trainingSessionID);
	}
}
