package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class NewTrainingSessionPane extends JPanel {

	
	private JTextField txtTitle;
	private JTextField txtDate;
	private JTextField txtStartHour;
	private JTextField txtEndHour;
	private JTextField txtAdministrativeArea;
	private JTextField txtLocality;
	private JTextField txtPostalCode;
	private JTextField txtStreetAddress;
	private JTextField txtPremise;
	private JTextField txtCountry;
	private JTextField txtTrainingTitel;
	private JTable tbTraining;
	private JButton btnBack;
	private JButton btnSave;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JButton btnAddTeacher;
	private JButton btnSearch;
	private JButton btnAddBook;
	private JButton btnaddSurvey;
	
	/**
	 * Create the panel.
	 */
	public NewTrainingSessionPane() {
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
		btnBack.setActionCommand("backToTrainingSession");
		btnBack.setBounds(30, 100, 110, 50);
		add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.setActionCommand("SaveTrainingSession");
		btnSave.setBounds(170, 100, 110, 50);
		add(btnSave);
		
		JLabel lblTitle = new JLabel("Session title");
		lblTitle.setBounds(50, 200, 100, 14);
		add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(50, 225, 300, 25);
		txtTitle.setColumns(10);
		txtTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtTitle.selectAll();
			}
		});
		txtTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTitle.selectAll();
			}
		});
		add(txtTitle);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(50, 271, 46, 14);
		add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(50, 296, 152, 25);
		txtDate.setColumns(10);
		txtDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtDate.selectAll();
			}
		});
		txtDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDate.selectAll();
			}
		});
		add(txtDate);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocation.setBounds(50, 413, 100, 14);
		add(lblLocation);
		
		JLabel lblStartHour = new JLabel("Start hour");
		lblStartHour.setBounds(50, 342, 100, 14);
		add(lblStartHour);
		
		txtStartHour = new JTextField();
		txtStartHour.setBounds(50, 367, 86, 25);
		txtStartHour.setColumns(10);
		txtStartHour.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtStartHour.selectAll();
			}
		});
		txtStartHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStartHour.selectAll();
			}
		});
		add(txtStartHour);
		
		JLabel lblEndHour = new JLabel("End hour");
		lblEndHour.setBounds(425, 342, 100, 14);
		add(lblEndHour);
		
		txtEndHour = new JTextField();
		txtEndHour.setBounds(425, 367, 86, 25);
		txtEndHour.setColumns(10);
		txtEndHour.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtEndHour.selectAll();
			}
		});
		txtEndHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEndHour.selectAll();
			}
		});
		add(txtEndHour);
		
		JLabel lblAdministrativeArea = new JLabel("Region");
		lblAdministrativeArea.setBounds(50, 448, 100, 14);
		add(lblAdministrativeArea);
		
		txtAdministrativeArea = new JTextField();
		txtAdministrativeArea.setBounds(50, 473, 300, 25);
		txtAdministrativeArea.setColumns(10);
		txtAdministrativeArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtAdministrativeArea.selectAll();
			}
		});
		txtAdministrativeArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdministrativeArea.selectAll();
			}
		});
		add(txtAdministrativeArea);
		
		JLabel lblLocality = new JLabel("City");
		lblLocality.setBounds(50, 519, 59, 14);
		add(lblLocality);
		
		txtLocality = new JTextField();
		txtLocality.setBounds(50, 544, 300, 25);
		txtLocality.setColumns(10);
		txtLocality.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtLocality.selectAll();
			}
		});
		txtLocality.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLocality.selectAll();
			}
		});
		add(txtLocality);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setBounds(50, 590, 100, 14);
		add(lblPostalCode);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setBounds(50, 615, 300, 25);
		txtPostalCode.setColumns(10);
		txtPostalCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPostalCode.selectAll();
			}
		});
		txtPostalCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPostalCode.selectAll();
			}
		});
		add(txtPostalCode);
		
		JLabel lblStreetAddress = new JLabel("Street address");
		lblStreetAddress.setBounds(425, 448, 100, 14);
		add(lblStreetAddress);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setBounds(413, 473, 300, 25);
		txtStreetAddress.setColumns(10);
		txtStreetAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtStreetAddress.selectAll();
			}
		});
		txtStreetAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStreetAddress.selectAll();
			}
		});
		add(txtStreetAddress);
		
		JLabel lblPremise = new JLabel("PO Box");
		lblPremise.setBounds(425, 519, 46, 14);
		add(lblPremise);
		
		txtPremise = new JTextField();
		txtPremise.setBounds(425, 546, 300, 25);
		txtPremise.setColumns(10);
		txtPremise.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPremise.selectAll();
			}
		});
		txtPremise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPremise.selectAll();
			}
		});
		add(txtPremise);
		
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(425, 590, 100, 14);
		add(lblCountry);
		
		txtCountry = new JTextField();
		txtCountry.setBounds(425, 617, 300, 25);
		txtCountry.setColumns(10);
		txtCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCountry.selectAll();
			}
		});
		txtCountry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCountry.selectAll();
			}
		});
		add(txtCountry);
		
		JLabel lblResaerchFortTraining = new JLabel("Research for Training");
		lblResaerchFortTraining.setBounds(816, 200, 150, 14);
		add(lblResaerchFortTraining);
		
		txtTrainingTitel = new JTextField();
		txtTrainingTitel.setBounds(816, 227, 300, 25);
		txtTrainingTitel.setColumns(10);
		txtTrainingTitel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtTrainingTitel.selectAll();
			}
		});
		txtTrainingTitel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTrainingTitel.selectAll();
			}
		});
		add(txtTrainingTitel);
		
		
		Object [] columnHeadersTraining = {"Title","Number of Days","Price"};
		DefaultTableModel modelTraining = new DefaultTableModel();
		modelTraining.setColumnIdentifiers(columnHeadersTraining);
		Object[][] data = {

		};
		tbTraining = new JTable(data, columnHeadersTraining);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersTraining) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbTraining.setModel(tableModel);
		tbTraining.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTraining.setRowSelectionAllowed(true);
	    final TableColumnModel columnmodelTraining = tbTraining.getColumnModel();
	    for (int column = 0; column < tbTraining.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbTraining.getRowCount(); row++) {
	            TableCellRenderer renderer = tbTraining.getCellRenderer(row, column);
	            Component comp = tbTraining.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnmodelTraining.getColumn(column).setPreferredWidth(width);
	    }
		JScrollPane sclTraining = new JScrollPane(tbTraining);
		sclTraining.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setBounds(810, 262, 430, 400);
		add(sclTraining);
		ListSelectionModel selectedRowBook = tbTraining.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					//int selectedRow = selectedRowBook.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(6, 186, 750, 484);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(800, 186, 450, 484);
		lblBackBorder2.setBorder(border);
		add(lblBackBorder2);

		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setActionCommand("addTeacher");
		btnAddTeacher.setBounds(425, 200, 117, 54);
		add(btnAddTeacher);
		
		btnSearch = new JButton("Search");
		btnSearch.setActionCommand("searchTrainingSession");
		btnSearch.setBounds(1123, 225, 117, 29);
		add(btnSearch);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.setActionCommand("addBook");
		btnAddBook.setBounds(425, 271, 117, 50);
		add(btnAddBook);
		
		btnaddSurvey = new JButton("Add Survey");
		btnaddSurvey.setActionCommand("addSurvey");
		btnaddSurvey.setBounds(589, 200, 117, 54);
		add(btnaddSurvey);

	}
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnAddTeacher.addActionListener(listener);
		btnSearch.addActionListener(listener);
		btnAddBook.addActionListener(listener);
		btnaddSurvey.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	public String getTitle() {
        return txtTitle.getText();
    }
	public String getDate() {
        return txtDate.getText();
    }
	public String getStartHour() {
        return txtStartHour.getText();
    }
	public String getEndHour() {
        return txtEndHour.getText();
    }
	public String getAdministrativeArea() {
        return txtAdministrativeArea.getText();
    }
	public String getLocality() {
        return txtLocality.getText();
    }
	public String getPostalCode() {
        return txtPostalCode.getText();
    }
	public String getStreetAddress() {
        return txtStreetAddress.getText();
    }
	public String getPremise() {
        return txtPremise.getText();
    }
	public String getCountry() {
        return txtCountry.getText();
    }
	public String getTrainingTitel() {
        return txtTrainingTitel.getText();
    }
}
