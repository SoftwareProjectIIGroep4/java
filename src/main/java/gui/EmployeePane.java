package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

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

import models.Employee;

public class EmployeePane extends JPanel {
	
	private int selectedRow;
	private JTextField firstnameEmployeeSearch;
	private JTextField lastnameEmployeeSearch;
	private JTextField departmentEmployeeSearch;
	private JTable tbEmployees;
	private JTextField functionEmployeeSearch;
	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private DefaultTableModel modelEmployees;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public EmployeePane() {
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
	        jtbTraining = new JButton("Training");
	        /*jtbTraining.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTraining.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTraining.setBorder(null);
	            }
	        });*/
	       
	        jtbTraining.setBackground(Color.WHITE);
	        jtbTraining.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTraining.setOpaque(true);
	        jtbTraining.setActionCommand("TrainingMenu");
	        jtbTraining.setBounds(133, 0, 211, 75);
	        add(jtbTraining);
	        
	        jtbTrainingSession = new JButton("Training session");
	       /* jtbTrainingSession.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingSession.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingSession.setBorder(null);
	            }
	        });*/
	      
	        jtbTrainingSession.setBackground(Color.WHITE);
	        jtbTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbTrainingSession.setOpaque(true);
	        jtbTrainingSession.setActionCommand("TrainingSessionMenu");
	        jtbTrainingSession.setBounds(344, 0, 211, 75);
	        add(jtbTrainingSession);
	        
	        jtbEmployees = new JButton("Employees");
	      /*  jtbEmployees.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbEmployees.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbEmployees.setBorder(null);
	            }
	        });*/
	       
	        jtbEmployees.setBackground(Color.WHITE);
	        jtbEmployees.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbEmployees.setOpaque(true);
	        jtbEmployees.setActionCommand("EmployeesMenu");
	        jtbEmployees.setBounds(555, 0, 212, 75);
	        add(jtbEmployees);
	        
	        jtbStatistics = new JButton("Statistics");
	        /*jtbStatistics.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbStatistics.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbStatistics.setBorder(null);
	            }
	        });*/
	        
	        jtbStatistics.setBackground(Color.WHITE);
	        jtbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbStatistics.setOpaque(true);
	        jtbStatistics.setActionCommand("StatisticsMenu");
	        jtbStatistics.setBounds(767, 0, 212, 75);
	        add(jtbStatistics);
	        
	        jtbTrainingRequests = new JButton("Training requests");
	       /* jtbTrainingRequests.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                jtbTrainingRequests.setBorder(border);
	            }
	            @Override
	            public void mouseExited(MouseEvent e) {
	                jtbTrainingRequests.setBorder(null);
	            }
	        });*/
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
        
        JLabel lblEmployeeExplanation = new JLabel("Here is a list of the employees");
        lblEmployeeExplanation.setBounds(20, 67, 231, 41);
        add(lblEmployeeExplanation);
	
        Object [] columnHeadersEmployees = {"First name","Last name","Department","Function"};
		//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
		Object[][] data = {
		
				
				
		};
		
		tableModel = new DefaultTableModel(data, columnHeadersEmployees)
		{
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbEmployees = new JTable(tableModel);
		tbEmployees.setBackground(Color.red);
		tbEmployees.setForeground(Color.blue);
		tbEmployees.setModel(tableModel);
		tbEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbEmployees.setRowSelectionAllowed(true);
	    final TableColumnModel columnmodelTraining = tbEmployees.getColumnModel();
	    for (int column = 0; column < tbEmployees.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbEmployees.getRowCount(); row++) {
	            TableCellRenderer renderer = tbEmployees.getCellRenderer(row, column);
	            Component comp = tbEmployees.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnmodelTraining.getColumn(column).setPreferredWidth(width);
	    }
		
	    JScrollPane sclEmployee = new JScrollPane(tbEmployees);
	    sclEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sclEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    sclEmployee.setBounds(30, 119, 789, 581);
		add(sclEmployee);
		ListSelectionModel selectedRowEmployees = tbEmployees.getSelectionModel();
		selectedRowEmployees.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowEmployees.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowEmployees.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});
        
        firstnameEmployeeSearch = new JTextField();
        firstnameEmployeeSearch.setBounds(958, 367, 189, 35);
        firstnameEmployeeSearch.setColumns(10);
        firstnameEmployeeSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		firstnameEmployeeSearch.selectAll();
        	}
		});
        firstnameEmployeeSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		firstnameEmployeeSearch.selectAll();
        	}
        });
        add(firstnameEmployeeSearch);
        
        
        lastnameEmployeeSearch = new JTextField();
        lastnameEmployeeSearch.setBounds(958, 428, 189, 35);
        lastnameEmployeeSearch.setColumns(10);
        lastnameEmployeeSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		lastnameEmployeeSearch.selectAll();
        	}
		});
        lastnameEmployeeSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lastnameEmployeeSearch.selectAll();
        	}
        });
        add(lastnameEmployeeSearch);
        
        departmentEmployeeSearch = new JTextField();
        departmentEmployeeSearch.setBounds(958, 488, 189, 35);
        departmentEmployeeSearch.setColumns(10);
        departmentEmployeeSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		departmentEmployeeSearch.selectAll();
        	}
		});
        departmentEmployeeSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		departmentEmployeeSearch.selectAll();
        	}
        });
        add(departmentEmployeeSearch);
       
        functionEmployeeSearch = new JTextField();
        functionEmployeeSearch.setBounds(958, 549, 189, 35);
        functionEmployeeSearch.setColumns(10);
        functionEmployeeSearch.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent arg0) {
        		functionEmployeeSearch.selectAll();
        	}
		});
        functionEmployeeSearch.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		functionEmployeeSearch.selectAll();
        	}
        });
        add(functionEmployeeSearch);
       
        	 
        JLabel lblNewLabel_2 = new JLabel("SEARCH EMPLOYEE");
        lblNewLabel_2.setBounds(929, 308, 144, 28);
        add(lblNewLabel_2);
        
        JLabel lblNewLabel_5 = new JLabel("Firstname");
        lblNewLabel_5.setBounds(958, 347, 65, 21);
        add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Lastname");
        lblNewLabel_6.setBounds(958, 413, 100, 14);
        add(lblNewLabel_6);
        
        JLabel lblFunction = new JLabel("Department");
        lblFunction.setBounds(958, 474, 100, 14);
        add(lblFunction);
               
        JLabel lblFunction_1 = new JLabel("Function");
        lblFunction_1.setBounds(958, 534, 105, 14);
        add(lblFunction_1);
        
        JLabel employeeSearchBorder = new JLabel("");
        employeeSearchBorder.setBounds(929, 333, 279, 376);
        employeeSearchBorder.setBorder(border);
        add(employeeSearchBorder);
        
        JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 106, 812, 603);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);

	}	

	public void addActionListener(ActionListener listener) {
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	public String getFirstnameSearch() {
        return firstnameEmployeeSearch.getText();
    }
	
	public String getLastnameSearch() {
        return lastnameEmployeeSearch.getText();
    }
	
	public String getDepartmentSearch() {
        return departmentEmployeeSearch.getText();
    }
	
	public String getFunctionSearch() {
        return functionEmployeeSearch.getText();
    }
	
	public void addRowToEmployeeTable(Object[] row) {
			
		tableModel.addRow(row);
	
	}
	
	
}
