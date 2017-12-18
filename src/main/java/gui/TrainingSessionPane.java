package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class TrainingSessionPane extends JPanel {

	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JTable tbSession;
	private JTextField txtFromTrainingSession;
	private JTextField txtUntilTrainingSession;
	private JButton btnAddTrainingSession;
	private DefaultTableModel modelSession;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public TrainingSessionPane() {
		
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
		
		
		Object [] columnHeadersSession = {"Training name","City","Date","Hour"};
		modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		Object[][] data = {
				//table data schrijven
		};
		tbSession = new JTable(data, columnHeadersSession);
		tableModel = new DefaultTableModel(data, columnHeadersSession) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
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
		sclBook.setBounds(30, 116, 730, 582);
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
				}
			}
		});
		
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 106, 750, 603);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
		
		btnAddTrainingSession = new JButton("Add training session");
		btnAddTrainingSession.setActionCommand("goToAddTrainingSession");
		btnAddTrainingSession.setBounds(820, 138, 160, 64);
		add(btnAddTrainingSession);
		
		btnShowTrainingSession = new JButton("Show training session");
		btnShowTrainingSession.setActionCommand("goToTrainingSessionInfo");
		btnShowTrainingSession.setBounds(1030, 138, 160, 64);
		add(btnShowTrainingSession);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFilters.setBounds(800, 255, 46, 16);
		add(lblFilters);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(820, 304, 97, 23);
		add(chckbxMonday);
		
		JCheckBox chckbxTeusday = new JCheckBox("Tuesday");
		chckbxTeusday.setBounds(977, 304, 97, 23);
		add(chckbxTeusday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(820, 340, 97, 23);
		add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(977, 340, 97, 23);
		add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(820, 376, 97, 23);
		add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(977, 376, 97, 23);
		add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(820, 412, 97, 23);
		add(chckbxSunday);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrom.setBounds(820, 458, 46, 14);
		add(lblFrom);
		
		JLabel lblUntil = new JLabel("Until:");
		lblUntil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUntil.setBounds(820, 511, 46, 14);
		add(lblUntil);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(800, 282, 450, 427);
		lblBackBorder2.setBorder(border);
		add(lblBackBorder2);
		
		txtFromTrainingSession = new JTextField();
		txtFromTrainingSession.setBounds(876, 450, 189, 35);
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
        txtUntilTrainingSession.setBounds(876, 503, 189, 35);
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
		
	}
	
	public void addActionListener(ActionListener listener) {
		btnAddTrainingSession.addActionListener(listener);
		btnShowTrainingSession.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	public String getFromTrainingrequest() {
		return txtFromTrainingSession.getText();
	}
	
	public String getUntilTrainingrequest() {
		return txtUntilTrainingSession.getText();
	}
	
	public void addRowToTrainingSessionTable(Object[] row) {
		
		tableModel.addRow(row);
	
	}
}
