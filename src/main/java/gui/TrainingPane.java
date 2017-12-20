package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

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
import javax.swing.table.TableModel;

import com.google.api.client.util.Key;
import com.google.common.cache.Cache;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import models.TrainingInfo;
import models.TrainingSession;
import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;

public class TrainingPane extends JPanel {
	private String fullEmployee;
	private JTable tbTraining;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnSelectTraining;
	private JButton btnAddNewTraining;
	private JLabel lblCityTraining;
	private JLabel lblNewLabel_2;
	
	
	
	/**
	 * Create the panel.
	 */
	public TrainingPane() {
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		HashMap<Integer, TrainingSession> listTrainingssessions= new HashMap<Integer,TrainingSession>();
		try {
			listTrainingssessions=TrainingSessionAccess.getAll();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		HashMap<Integer, TrainingInfo> listTrainings= new HashMap<Integer,TrainingInfo>();
		
		try {
			listTrainings =TrainingInfoAccess.getAll();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	        
	        btnSelectTraining = new JButton("Select Training");
	        btnSelectTraining.setActionCommand("goToSelectTraining");
	        btnSelectTraining.setBounds(1072, 138, 160, 64);
			add(btnSelectTraining);
			
			btnAddNewTraining = new JButton("Add New Training");
			btnAddNewTraining.setActionCommand("goToAddTraining");
			btnAddNewTraining.setBounds(1072, 213, 160, 64);
			add(btnAddNewTraining);
        
        JLabel lblEmployeeExplanation = new JLabel("List of trainings");
        lblEmployeeExplanation.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmployeeExplanation.setBounds(31, 86, 278, 28);
        add(lblEmployeeExplanation);
        
        Object [] columnHeadersSession = {"Training name","City","From","Until","Price"};
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		List<String[]> data1 = new ArrayList<String[]>();
		
		
					for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
						
						try {
							data1.add(new String[] {

									TrainingInfoAccess.get(entry.getValue().getTrainingId()).getName(), String.valueOf(dataAccess.AddressAccess.get(entry.getValue().getAddressId()).getCountry()), String.valueOf(entry.getValue().getStartHour()) ,String.valueOf(entry.getValue().getEndHour()), String.valueOf(TrainingInfoAccess.get(entry.getValue().getTrainingId()).getPrice())}
									
							
							);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		
				}
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel(data1.toArray(new Object[][] {}), columnHeadersSession) {
		



			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		
		};
		tbTraining = new JTable(tableModel);
		tbTraining.setModel(tableModel);
		tbTraining.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTraining.setRowSelectionAllowed(true);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelSession = tbTraining.getColumnModel();
	    for (int column = 0; column < tbTraining.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbTraining.getRowCount(); row++) {
	            TableCellRenderer renderer = tbTraining.getCellRenderer(row, column);
	            Component comp = tbTraining.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelSession.getColumn(column).setPreferredWidth(width);
	    }
	    
	    JScrollPane sclBook = new JScrollPane(tbTraining);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(31, 119, 1007, 530);
		add(sclBook);
		ListSelectionModel selectedRowBook = tbTraining.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});
		
		
				
	}	
	
	public void addActionListener(ActionListener listener) {
		btnSelectTraining.addActionListener(listener);
		btnAddNewTraining.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
    }
	
}
