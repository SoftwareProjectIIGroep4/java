package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

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
 
import dataAccess.BookAccess;
import dataAccess.EmployeeAccess;
import models.Address;
import models.Book;
import models.Employee;
import models.TrainingInfo;
import models.TrainingSession;

public class TrainingSessionBookPane extends JPanel {
	private int selectedRow;
	private JTextField txtSearch;
	private JTable tbBook;	
	private JButton btnBack;
	private JLabel lblTrainingSessionTitle;
	private JButton btnCancelTrainingSession;
	private JLabel lblResearch;
	private JButton btnInfo;
	private JButton btnEnlistedPeople;
	private JButton btnBooks;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnMaps;

	/**
	 * Create the panel.
	 */
	public TrainingSessionBookPane() {
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
		//ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
		//ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
		ConcurrentMap<Long, Book> ListBook=dataAccess.Cache.bookCache.asMap();
		
		
		
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
		
		btnBack = new JButton("<-  Back");
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
		
		txtSearch = new JTextField();
		txtSearch.setBounds(100, 230, 250, 20);
		txtSearch.setColumns(10);
		add(txtSearch);
		
		lblResearch = new JLabel("Research:");
		lblResearch.setBounds(30, 233, 70, 14);
		add(lblResearch);
		
		Object [] columnHeadersBook = {"isbn","Title",/*"Author",*/"Price","Publisher"};
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersBook);
		List<String[]> data = new ArrayList<String[]>();
		/*for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
			data.add(new String[] {
					String.valueOf(entry.getValue().getTrainingSessionId()),
					listTraingInfo.get(entry.getValue().getTrainingId()).getName(), 
					//String.valueOf(ListAdress.get(entry.getValue().getAddressId()).getLocality()), 
					String.valueOf(entry.getValue().getDate()) ,
					String.valueOf(entry.getValue().getStartHour())}
			);
		}*/
		DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersBook) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbBook = new JTable(tableModel);
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
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		btnInfo.addActionListener(listener);
		btnEnlistedPeople.addActionListener(listener);
		btnBooks.addActionListener(listener);
		btnMaps.addActionListener(listener);
    }
	
	public String getSearch() {
        return txtSearch.getText();
    }
	public int getSelectedRow() {
		return selectedRow;
	}
	public void setListBook(int id) {
		try {
			Object [] columnHeadersBook = {"id","Title",/*"Author",*/"Price","Publisher"};
			System.out.println("toon trainingID" + String.valueOf(id));
			HashMap<Long, Book> ListBook = BookAccess.getBooksByTrainingId(id);
			System.out.println("toon toString book" + ListBook.toString());
			 List<String[]> data = new ArrayList<String[]>();
				for (Long  entry : ListBook.keySet()) {
					System.out.println("book1");
					data.add(new String[] {
							String.valueOf(ListBook.get(entry).getBookID()),
							ListBook.get(entry).getTitle(),
							//ListBook.get(entry).getAuthor(),
							String.valueOf(ListBook.get(entry).getPrice()),
							ListBook.get(entry).getPublisher()
							
							}
					);
					System.out.println("test book voor de print out");
					
					System.out.println("test" + ListBook.get(entry).getTitle());
				}
				DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersBook) {


					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				tbBook.setModel(tableModel);
		} catch (Exception exp) {
			System.out.println("book§nope");
			exp.printStackTrace();
      
		}
				System.out.println("book4");
	}

	
	
}
