package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

public class TrainingSessionBookPane extends JPanel {
	private int selectedRow;
	private JTextField txtSearch;
	private JTable tbBook;	
	private JButton btnBack;
	private JLabel lblTrainingSessionTitle;
	private JButton btnCancelTrainingSession;
	private JToggleButton jtbInfo;
	private JToggleButton jtbEnlistedPeople;
	private JToggleButton jtbBooks;
	private JLabel lblResearch;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;

	/**
	 * Create the panel.
	 */
	public TrainingSessionBookPane() {
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
		
		
		btnBack = new JButton("<-  Back");
		btnBack.setActionCommand("BackToTrainingSessoin");
		btnBack.setBounds(30, 100, 110, 50);
		add(btnBack);
		
		lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		add(lblTrainingSessionTitle);
		
		btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		btnCancelTrainingSession.setActionCommand("CancelTrainingSession");
		add(btnCancelTrainingSession);
		
		jtbInfo = new JToggleButton("Info");
		jtbInfo.setBackground(SystemColor.control);
		jtbInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbInfo.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbInfo.setBackground(SystemColor.control);
			}
		});
		jtbInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbInfo.setHorizontalAlignment(SwingConstants.CENTER);
		jtbInfo.setOpaque(true);
		jtbInfo.setBounds(450, 165, 100, 50);
		jtbInfo.setActionCommand("Info");
		add(jtbInfo);
		
		jtbEnlistedPeople = new JToggleButton("Enlisted people");
		jtbEnlistedPeople.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbEnlistedPeople.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbEnlistedPeople.setBackground(SystemColor.control);
			}
			});
		jtbEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		jtbEnlistedPeople.setOpaque(true);
		jtbEnlistedPeople.setBounds(550, 165, 200, 50);
		jtbEnlistedPeople.setActionCommand("EnlistedPeople");
		add(jtbEnlistedPeople);
		
		jtbBooks = new JToggleButton("Books");
		jtbBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jtbBooks.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtbBooks.setBackground(SystemColor.control);
			}
		});
		jtbBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtbBooks.setBounds(750, 165, 100, 50);
		jtbBooks.setHorizontalAlignment(SwingConstants.CENTER);
		jtbBooks.setOpaque(true);
		jtbBooks.setActionCommand("Books");
		add(jtbBooks);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(100, 230, 250, 20);
		txtSearch.setColumns(10);
		add(txtSearch);
		
		lblResearch = new JLabel("Research:");
		lblResearch.setBounds(30, 233, 70, 14);
		add(lblResearch);
		
		Object [] columnHeadersBook = {"isbn","Title","Author","Price","Publisher"};
		DefaultTableModel modelBook = new DefaultTableModel();
		modelBook.setColumnIdentifiers(columnHeadersBook);
		Object[][] data = {
					
		};
		tbBook = new JTable(data, columnHeadersBook);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersBook) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbBook.setModel(tableModel);
		tbBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//tbBook.setEnabled(false);
		tbBook.setRowSelectionAllowed(true);
		//tbBook.setModel(modelBook);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelBook = tbBook.getColumnModel();
	    for (int column = 0; column < tbBook.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbBook.getRowCount(); row++) {
	            TableCellRenderer renderer = tbBook.getCellRenderer(row, column);
	            Component comp = tbBook.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelBook.getColumn(column).setPreferredWidth(width);
	    }
	    
		JScrollPane sclBook = new JScrollPane(tbBook);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 258, 1200, 400);
		add(sclBook);
		ListSelectionModel selectedRowBook = tbBook.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowBook.getMinSelectionIndex();
					//lblTrainingSessionTitle.setText(String.valueOf(selectedRow));
				}
			}
		});
		
		JLabel lblBackBorder = new JLabel("");
		
		lblBackBorder.setBounds(20, 220, 1220, 450);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
	}
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnCancelTrainingSession.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
		jtbInfo.addActionListener(listener);
		jtbEnlistedPeople.addActionListener(listener);
		jtbBooks.addActionListener(listener);
    }
	public String getSearch() {
        return txtSearch.getText();
    }
	public int getSelectedRow() {
		return selectedRow;
	}
}