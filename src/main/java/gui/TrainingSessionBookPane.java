package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import dataAccess.BookAccess;
import dataAccess.Cache;
import models.Book;
import models.Settings;
import models.TrainingSession;

public class TrainingSessionBookPane extends JPanel {
	private int selectedRow;
	private JTextField txtSearch;
	private JTable tbBook;	
	private JButton btnBack;
	private JLabel lblTrainingSessionTitle;
	private JButton btnCancelTrainingSession;
	private DefaultTableModel tableModel;
	private DefaultTableModel modelBook;
	private JLabel lblResearch;
	private JButton btnInfo;
	private JButton btnEnlistedPeople;
	private JButton btnBooks;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnMaps;
	private MainFrame mainFrame;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;

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
					txtSearch.setText("");
					tableModel.getDataVector().removeAllElements();
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
					txtSearch.setText("");
					tableModel.getDataVector().removeAllElements();
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
					txtSearch.setText("");
					tableModel.getDataVector().removeAllElements();
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
					txtSearch.setText("");
					tableModel.getDataVector().removeAllElements();
				}
			});
	        btnStatistics.setBackground(Color.WHITE);
	        btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        btnStatistics.setOpaque(true);
	        btnStatistics.setActionCommand("StatisticsMenu");
	        btnStatistics.setBounds(912, 0, 264, 75);
	        add(btnStatistics);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtSearch.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTrainingSessoin");
		add(btnBack);
		
		lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		add(lblTrainingSessionTitle);
		
		btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtSearch.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
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
		
		Object [] columnHeadersBook = {"isbn","Title","Author","Price","Publisher"};
		DefaultTableModel modelBook = new DefaultTableModel();
		modelBook.setColumnIdentifiers(columnHeadersBook);
		Object[][] data = {
					
		};
		tbBook = new JTable(data, columnHeadersBook);
		tableModel = new DefaultTableModel(data, columnHeadersBook) {
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
		jtbSettings.addActionListener(listener);
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
							String.valueOf(ListBook.get(entry).getIsbn()),
							//String.valueOf(ListBook.get(entry).getBookID()),
							ListBook.get(entry).getUrl(),
							//ListBook.get(entry).getAuthor(),
							//String.valueOf(ListBook.get(entry).getPrice()),
							//ListBook.get(entry).getPublisher()
							
							}
					);
					System.out.println("test book voor de print out");
					
					System.out.println("test" + ListBook.get(entry).getUrl());
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
			System.out.println("book�nope");
			exp.printStackTrace();
      
		}
				System.out.println("book4");
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
