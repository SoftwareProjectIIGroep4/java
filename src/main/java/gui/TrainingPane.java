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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

import models.Address;
import models.TrainingInfo;
import models.TrainingSession;
import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;

public class TrainingPane extends JPanel {

	private JTextField txtTrainingName;
	private JTextField txtCityTraining;
	private JTextField txtFromTraining;
	private JTextField txtUntilTraining;
	private JTextField txtPriceTraining;
	private String fullEmployee;
	private JTable tbTraining;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JButton btnSelectTraining;
	private JButton btnAddNewTraining;
	private JLabel lblCityTraining;
	private JLabel lblNewLabel_2;
	private int tabelID;
	
	
	/**
	 * Create the panel.
	 */
	public TrainingPane() {
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		try {
			dataAccess.Cache.loadAllAddresses();
			dataAccess.Cache.loadAllTrainingInfos();
			dataAccess.Cache.loadAllTrainingSessions();
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
		ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
		
		ConcurrentMap<Integer, Address> ListAdress=dataAccess.Cache.addressCache.asMap();
		
		
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	        
	        btnSelectTraining = new JButton("Select Training");
	        btnSelectTraining.setActionCommand("goToSelectTraining");
	        btnSelectTraining.setBounds(869, 136, 160, 64);
			add(btnSelectTraining);
			
			btnAddNewTraining = new JButton("Add New Training");
			btnAddNewTraining.setActionCommand("goToAddTraining");
			btnAddNewTraining.setBounds(1080, 136, 160, 64);
			add(btnAddNewTraining);
        
        JLabel lblEmployeeExplanation = new JLabel("Here is a list of the Trainings");
        lblEmployeeExplanation.setBounds(20, 80, 231, 28);
        add(lblEmployeeExplanation);
        
        Object [] columnHeadersSession = {"ID","Training name","City","From","Until","Price"};
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		List<String[]> data1 = new ArrayList<String[]>();
		
		
		for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
			
			
			data1.add(new String[] {
					String.valueOf(listTraingInfo.get(entry.getValue().getTrainingId()).getTrainingId()),
					listTraingInfo.get(entry.getValue().getTrainingId()).getName(),
					String.valueOf(ListAdress.get(entry.getValue().getAddressId()).getCountry()), 
					String.valueOf(entry.getValue().getStartHour()) ,
					String.valueOf(entry.getValue().getEndHour()), 
					String.valueOf(listTraingInfo.get(entry.getValue().getTrainingId()).getPrice())}
					
			);
	

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
		sclBook.setBounds(31, 119, 789, 578);
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
					tabelID = (int) tbTraining.getModel().getValueAt(0, selectedRow);
				}
				
			}
		});
        	 
		txtTrainingName = new JTextField();
		txtTrainingName.setBounds(958, 368, 189, 35);
		txtTrainingName.setColumns(10);
		txtTrainingName.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtTrainingName.selectAll();
        	}
		});
		txtTrainingName.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtTrainingName.selectAll();
        	}
        });
        add(txtTrainingName);
        
        txtCityTraining = new JTextField();
        txtCityTraining.setBounds(958, 442, 189, 35);
        txtCityTraining.setColumns(10);
		txtCityTraining.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtCityTraining.selectAll();
        	}
		});
		txtCityTraining.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtCityTraining.selectAll();
        	}
        });
        add(txtCityTraining);
        
        txtFromTraining = new JTextField();
        txtFromTraining.setBounds(958, 503, 189, 35);
        txtFromTraining.setColumns(10);
        txtFromTraining.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtFromTraining.selectAll();
        	}
		});
        txtFromTraining.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtFromTraining.selectAll();
        	}
        });
        add(txtFromTraining);
       
        txtUntilTraining = new JTextField();
        txtUntilTraining.setBounds(958, 574, 189, 35);
        txtUntilTraining.setColumns(10);
        txtUntilTraining.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtUntilTraining.selectAll();
        	}
		});
        txtUntilTraining.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtUntilTraining.selectAll();
        	}
        });
        add(txtUntilTraining);
        
        
        txtPriceTraining = new JTextField();
        txtPriceTraining.setBounds(958, 638, 189, 35);
        txtPriceTraining.setColumns(10);
        txtPriceTraining.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		txtPriceTraining.selectAll();
        	}
		});
        txtPriceTraining.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtPriceTraining.selectAll();
        	}
        });
        add(txtPriceTraining);
		
        
        JLabel lblTextSearchTraining = new JLabel("SEARCH TRAINING");
        lblTextSearchTraining.setBounds(929, 299, 144, 28);
        add(lblTextSearchTraining);
        
        JLabel lblTrainingName = new JLabel("Training name");
        lblTrainingName.setBounds(958, 347, 100, 21);
        add(lblTrainingName);
        
        JLabel lblFromTraining = new JLabel("From");
        lblFromTraining.setBounds(958, 478, 100, 14);
        add(lblFromTraining);
               
        JLabel lblUntilTraining = new JLabel("Until");
        lblUntilTraining.setBounds(958, 549, 105, 14);
        add(lblUntilTraining);
        
        JLabel trainingSearchBorder = new JLabel("");
        trainingSearchBorder.setBounds(929, 333, 279, 376);
        trainingSearchBorder.setBorder(border);
        add(trainingSearchBorder);
        
        JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 106, 812, 603);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
		
		JLabel lblPriceTraining = new JLabel("Price");
		lblPriceTraining.setBounds(958, 606, 115, 21);
		add(lblPriceTraining);
		
		JLabel lblCityTraining = new JLabel("Until");
		lblCityTraining.setBounds(958, 414, 100, 28);
		add(lblCityTraining);
		
		
				
	}	
	
	public void addActionListener(ActionListener listener) {
		btnSelectTraining.addActionListener(listener);
		btnAddNewTraining.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	public String getTrainingName() {
        return txtTrainingName.getText();
    }
	
	public String getCity() {
        return txtCityTraining.getText();
    }
	
	public String getFromTraining() {
        return txtFromTraining.getText();
    }
	
	public String getUntilTraining() {
        return txtUntilTraining.getText();
    }
	
	public String getPriceTraining() {
        return txtPriceTraining.getText();
    }
	public int getTabelID() {
		return tabelID;
	}
	
}
