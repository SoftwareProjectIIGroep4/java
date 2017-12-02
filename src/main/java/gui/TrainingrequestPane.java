package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;

public class TrainingrequestPane extends JPanel {

	
	private JTable tbTrainingrequest;
	private JTextField txtFirstNameSearch;
	private JTextField txtLastNameSearch;
	private JTextField txtTrainingSearch;
	private JTextField txtCountrySearch;
	private JTextField txtCitySearch;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	
	/**
	 * Create the panel.
	 */
	
	public TrainingrequestPane() {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		setLayout(null);
		setBorder(new EmptyBorder(20, 20, 20, 20));

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
        
        JLabel lblListOfRequested = new JLabel("List of requested trainings (click on the requests in the list to get more information)");
        lblListOfRequested.setBounds(30, 102, 644, 38);
        add(lblListOfRequested);
        
        Object [] columnHeadersBook = {"First name","Last name","Training name","Country","City"};
		DefaultTableModel modelBook = new DefaultTableModel();
		modelBook.setColumnIdentifiers(columnHeadersBook);
		Object[][] data = {

		};
		tbTrainingrequest = new JTable(data, columnHeadersBook);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersBook) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbTrainingrequest.setModel(tableModel);
		tbTrainingrequest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//tbBook.setEnabled(false);
		tbTrainingrequest.setRowSelectionAllowed(true);
		//tbBook.setModel(modelBook);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelBook = tbTrainingrequest.getColumnModel();
	    for (int column = 0; column < tbTrainingrequest.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbTrainingrequest.getRowCount(); row++) {
	            TableCellRenderer renderer = tbTrainingrequest.getCellRenderer(row, column);
	            Component comp = tbTrainingrequest.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelBook.getColumn(column).setPreferredWidth(width);
	    }
		
	    
		JScrollPane sclBook = new JScrollPane(tbTrainingrequest);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 145, 840, 564);
		add(sclBook);
		ListSelectionModel selectedRowBook = tbTrainingrequest.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					lblListOfRequested.setText(String.valueOf(selectedRow));
				}
			}
		});
        
        JLabel lblNewLabel_2 = new JLabel("Filters");
        lblNewLabel_2.setBounds(890, 202, 162, 30);
        add(lblNewLabel_2);
        
        JLabel lblLastNameSearch = new JLabel("Last name");
        lblLastNameSearch.setBounds(914, 308, 133, 30);
        add(lblLastNameSearch);
        
        txtFirstNameSearch = new JTextField();
        txtFirstNameSearch.setBounds(914, 264, 189, 35);
        txtFirstNameSearch.setColumns(10);
        txtFirstNameSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtFirstNameSearch.selectAll();
        	}
		});
        txtFirstNameSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtFirstNameSearch.selectAll();
        	}
        });
        add(txtFirstNameSearch);
        
        JLabel lblTrainingSearch = new JLabel("Training name");
        lblTrainingSearch.setBounds(914, 383, 134, 16);
        add(lblTrainingSearch);
        
        txtLastNameSearch = new JTextField();
        txtLastNameSearch.setBounds(914, 331, 189, 35);
        txtLastNameSearch.setColumns(10);
        txtLastNameSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtLastNameSearch.selectAll();
        	}
		});
        txtLastNameSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtLastNameSearch.selectAll();
        	}
        });
        add(txtLastNameSearch);
        
        JLabel lblCounrtySearch = new JLabel("Country");
        lblCounrtySearch.setBounds(914, 448, 134, 30);
        add(lblCounrtySearch);
        
        txtTrainingSearch = new JTextField();
        txtTrainingSearch.setBounds(914, 402, 189, 35);
        txtTrainingSearch.setColumns(10);
        txtTrainingSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtTrainingSearch.selectAll();
        	}
		});
        txtTrainingSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtTrainingSearch.selectAll();
        	}
        });
        add(txtTrainingSearch);
        
        JLabel lblFirstNameSearch = new JLabel("First name");
        lblFirstNameSearch.setBounds(914, 238, 178, 30);
        add(lblFirstNameSearch);
        
        txtCountrySearch = new JTextField();
        txtCountrySearch.setBounds(914, 472, 189, 35);
        txtCountrySearch.setColumns(10);
        txtCountrySearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtCountrySearch.selectAll();
        	}
		});
        txtCountrySearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtCountrySearch.selectAll();
        	}
        });
        add(txtCountrySearch);
        
        JLabel TrainingreqBorder = new JLabel("");
        TrainingreqBorder.setBounds(891, 230, 374, 479);
        TrainingreqBorder.setBorder(border);
        add(TrainingreqBorder);
        
        txtCitySearch = new JTextField();
        txtCitySearch.setBounds(914, 540, 189, 35);
        txtCitySearch.setColumns(10);
        txtCitySearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtCitySearch.selectAll();
        	}
		});
        txtCitySearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtCitySearch.selectAll();
        	}
        });
        add(txtCitySearch);
        
        JLabel lblCitySearch = new JLabel("City");
        lblCitySearch.setBounds(914, 518, 86, 27);
        add(lblCitySearch);
        
	}

	
	public void addActionListener(ActionListener listener) {
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	public String getFirstnameTrainingrequest() {
		return txtFirstNameSearch.getText();
	}
	
	public String getLastnameTrainingrequest() {
		return txtLastNameSearch.getText();
	}
	
	public String getTrainingNameTrainingrequest() {
		return txtFirstNameSearch.getText();
	}
	
	public String getCountryTrainingrequest() {
		return txtCountrySearch.getText();
	}
	
	public String getCityTrainingrequest() {
		return txtCitySearch.getText();
	}
	
	
	
}
