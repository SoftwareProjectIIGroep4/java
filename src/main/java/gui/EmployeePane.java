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

public class EmployeePane extends JPanel {

	private JTextField firstnameEmployeeSearch;
	private JTextField lastnameEmployeeSearch;
	private JTextField departmentEmployeeSearch;
	private JTable tbEmployees;
	private JTextField functionEmployeeSearch;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JButton btnAddEmployee;
	private JButton btnUpdateEmployee;
	private JButton btnDeleteEmployee;
	
	/**
	 * Create the panel.
	 */
	public EmployeePane() {
		
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
        
        JLabel lblEmployeeExplanation = new JLabel("Here is a list of the employees");
        lblEmployeeExplanation.setBounds(20, 67, 231, 41);
        add(lblEmployeeExplanation);
	
        Object [] columnHeadersEmployees = {"First name","Last name","Department","Function"};
		DefaultTableModel modelEmployees = new DefaultTableModel();
		modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
		Object[][] data = {

		};
		tbEmployees = new JTable(data, columnHeadersEmployees);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersEmployees)
		{
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
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
		JScrollPane sclTraining = new JScrollPane(tbEmployees);
		sclTraining.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setBounds(30, 119, 789, 581);
		add(sclTraining);
		ListSelectionModel selectedRowBook = tbEmployees.getSelectionModel();
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
		
		//SOURCE: https://www.youtube.com/watch?v=22MBsRYuM4Q
		
	    btnAddEmployee = new JButton("Add employee");
		btnAddEmployee.setBounds(979, 126, 144, 41);
        Object[] row = new Object[4];
        btnAddEmployee.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		
        		row[0] = firstnameEmployeeSearch.getText();
        		row[1] = lastnameEmployeeSearch.getText();
        		row[2] = departmentEmployeeSearch.getText();
        		row[3] = functionEmployeeSearch.getText();
        		
        		modelEmployees.addRow(row);
            	
        	}
        });     
		add(btnAddEmployee);
		btnAddEmployee.setActionCommand("addEmployeeToTable");
      
        btnDeleteEmployee = new JButton("Delete employee");
        btnDeleteEmployee.setActionCommand("deleteEmployeeToTable");
        btnDeleteEmployee.setBounds(979, 182, 144, 41);
        btnDeleteEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		int i = tbEmployees.getSelectedRow();
				if(i>=0) {
					modelEmployees.removeRow(i);
				} else {
					System.out.println("Delete error");
				}
        	}
        });
		add(btnDeleteEmployee);
             
        btnUpdateEmployee= new JButton("Update employee");
        btnUpdateEmployee.setActionCommand("updateEmployeeToTable");
        btnUpdateEmployee.setBounds(979, 236, 144, 41);
        tbEmployees.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	
        	int i = tbEmployees.getSelectedRow();
        	firstnameEmployeeSearch.setText(modelEmployees.getValueAt(i, 0).toString());
        	lastnameEmployeeSearch.setText(modelEmployees.getValueAt(i, 1).toString());
        	departmentEmployeeSearch.setText(modelEmployees.getValueAt(i, 2).toString());
        	functionEmployeeSearch.setText(modelEmployees.getValueAt(i, 3).toString());
        	
        }
     });
        
        btnUpdateEmployee.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
			int i = tbEmployees.getSelectedRow();
			
			if(i>=0) {
				
				modelEmployees.setValueAt(firstnameEmployeeSearch.getText(), i, 0);
				modelEmployees.setValueAt(lastnameEmployeeSearch.getText(), i, 1);
				modelEmployees.setValueAt(departmentEmployeeSearch.getText(), i, 2);
				modelEmployees.setValueAt(functionEmployeeSearch.getText(), i, 3);
				
			} else {
				System.out.println("Update Error");
			}
				
			}
		});
		add(btnUpdateEmployee);
	
	
	}	

	public void addActionListener(ActionListener listener) {
		btnAddEmployee.addActionListener(listener);
		btnDeleteEmployee.addActionListener(listener);
		btnUpdateEmployee.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	public String getFirstname() {
        return firstnameEmployeeSearch.getText();
    }
	
	public String getLastname() {
        return lastnameEmployeeSearch.getText();
    }
	
	public String getDepartment() {
        return departmentEmployeeSearch.getText();
    }
	
	public String getFunction() {
        return functionEmployeeSearch.getText();
    }
}
