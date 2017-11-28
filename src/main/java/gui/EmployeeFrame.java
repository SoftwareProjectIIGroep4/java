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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import java.awt.Font;


public class EmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField firstnameEmployeeSearch;
	private JTextField lastnameEmployeeSearch;
	private JTextField departmentEmployeeSearch;
	private String fullEmployee;
	private JTable tbEmployees;
	private JTextField functionEmployeeSearch;
	
	
	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		// create a line border with the specified color and width
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK,1);
        
        JLabel lblTraining1 = new JLabel("Training");
        lblTraining1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTraining1.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTraining1.setBorder(null);
            }
        	
			@Override
        	public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingFrame trainingFr = new TrainingFrame();
        		trainingFr.setVisible(true);
        	}
        });
        lblTraining1.setBackground(Color.WHITE);
        lblTraining1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTraining1.setOpaque(true);
        lblTraining1.setBounds(133, 0, 213, 75);
        contentPane.add(lblTraining1);
        
        JLabel lblTrainingSession = new JLabel("Training session");
        lblTrainingSession.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTrainingSession.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTrainingSession.setBorder(null);
            }
            @Override
        	public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionFrame frame = new TrainingSessionFrame();
        		frame.setVisible(true);
        	}
        });
        lblTrainingSession.setBackground(Color.WHITE);
        lblTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainingSession.setOpaque(true);
        lblTrainingSession.setBounds(344, 0, 213, 75);
        contentPane.add(lblTrainingSession);
        
        JLabel lblEmployees = new JLabel("Employees");
        lblEmployees.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblEmployees.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblEmployees.setBorder(null);
            }
        });
        lblEmployees.setBackground(Color.WHITE);
        lblEmployees.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployees.setOpaque(true);
        lblEmployees.setBounds(555, 0, 213, 75);
        contentPane.add(lblEmployees);
        
        JLabel lblStatistics = new JLabel("Statistics");
        lblStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblStatistics.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblStatistics.setBorder(null);
            }
            public void mouseClicked(MouseEvent e) {
        		dispose();
				StatistiekenFrame statistiekenFr = new StatistiekenFrame();
				statistiekenFr.setVisible(true);
        	}
        });
        lblStatistics.setBackground(Color.WHITE);
        lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatistics.setOpaque(true);
        lblStatistics.setBounds(766, 0, 213, 75);
        contentPane.add(lblStatistics);
        
        JLabel lblTrainingRequests = new JLabel("Training requests");
        lblTrainingRequests.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTrainingRequests.setBorder(border1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblTrainingRequests.setBorder(null);
            }
            public void mouseClicked(MouseEvent e) {
                dispose();
    			TrainingrequestFrame trainingrequestFr = new TrainingrequestFrame();
    			trainingrequestFr.setVisible(true);   
        	}
        });
        lblTrainingRequests.setBackground(Color.WHITE);
        lblTrainingRequests.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainingRequests.setOpaque(true);
        lblTrainingRequests.setBounds(977, 0, 213, 75);
        contentPane.add(lblTrainingRequests);
        
        JLabel lblNewLabel = new JLabel("logo");
        lblNewLabel.setBounds(0, 0, 133, 75);
        lblNewLabel.setOpaque(true);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Profiel");
        lblNewLabel_1.setBounds(1190, 0, 75, 75);
        lblNewLabel_1.setOpaque(true);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblEmployeeExplanation = new JLabel("Here is a list of the employees");
        lblEmployeeExplanation.setBounds(20, 67, 231, 41);
        contentPane.add(lblEmployeeExplanation);
        
        
        Object [] columnHeadersSession = {"First name","Last name","Department","Function"};
		DefaultTableModel modelSession = new DefaultTableModel();
		modelSession.setColumnIdentifiers(columnHeadersSession);
		Object[][] data = {
				//table data schrijven
		};
		tbEmployees = new JTable(data, columnHeadersSession);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersSession) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbEmployees.setModel(tableModel);
		tbEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbEmployees.setRowSelectionAllowed(true);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelSession = tbEmployees.getColumnModel();
	    for (int column = 0; column < tbEmployees.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbEmployees.getRowCount(); row++) {
	            TableCellRenderer renderer = tbEmployees.getCellRenderer(row, column);
	            Component comp = tbEmployees.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelSession.getColumn(column).setPreferredWidth(width);
	    }  
		JScrollPane sclBook = new JScrollPane(tbEmployees);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(31, 119, 789, 537);
		contentPane.add(sclBook);
		ListSelectionModel selectedRowBook = tbEmployees.getSelectionModel();
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
		lblBackBorder.setBounds(20, 106, 812, 564);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
		 
        firstnameEmployeeSearch = new JTextField();
        firstnameEmployeeSearch.setBounds(958, 367, 189, 35);
        contentPane.add(firstnameEmployeeSearch);
        firstnameEmployeeSearch.setColumns(10);
        
        lastnameEmployeeSearch = new JTextField();
        lastnameEmployeeSearch.setBounds(958, 428, 189, 35);
        contentPane.add(lastnameEmployeeSearch);
        lastnameEmployeeSearch.setColumns(10);
        
        departmentEmployeeSearch = new JTextField();
        departmentEmployeeSearch.setBounds(958, 488, 189, 35);
        contentPane.add(departmentEmployeeSearch);
        departmentEmployeeSearch.setColumns(10);
       
        functionEmployeeSearch = new JTextField();
        functionEmployeeSearch.setBounds(958, 548, 187, 41);
        contentPane.add(functionEmployeeSearch);
        functionEmployeeSearch.setColumns(10);
        
	
      //SOURCE: https://www.youtube.com/watch?v=22MBsRYuM4Q
		
      /*  JButton addEmployeeButton = new JButton("Add employee");
        Object[] row = new Object[4];
        addEmployeeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        		row[0] = firstnameEmployeeSearch.getText();
        		row[1] = lastnameEmployeeSearch.getText();
        		row[2] = departmentEmployeeSearch.getText();
        		row[3] = functionEmployeeSearch.getText();
        		
        		modelEmployees.addRow(row);
            	
        	}
        });
        addEmployeeButton.setBounds(977, 114, 187, 41);
        contentPane.add(addEmployeeButton);
        
        
        
        JButton deleteEmployeeButton = new JButton("Delete employee");
        deleteEmployeeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		int i = tbEmployees.getSelectedRow();
				if(i>=0) {
					modelEmployees.removeRow(i);
				} else {
					System.out.println("Delete error");
				}
        	}
        });
        deleteEmployeeButton.setBounds(977, 218, 187, 41);
        contentPane.add(deleteEmployeeButton);
             
        JButton updateEmployeeButton = new JButton("Update employee");
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
        
        updateEmployeeButton.addActionListener(new ActionListener() {
			
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
		});*/
        
        
     //   updateEmployeeButton.setBounds(977, 172, 187, 35);
      //  contentPane.add(updateEmployeeButton);
        
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                lblNewLabel.setBackground(Color.GREEN);
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("SEARCH EMPLOYEE");
        lblNewLabel_2.setBounds(929, 308, 144, 28);
        contentPane.add(lblNewLabel_2);
       
        
        JLabel employeeSearchBorder = new JLabel("");
        employeeSearchBorder.setBounds(929, 333, 279, 337);
        employeeSearchBorder.setBorder(border);
        contentPane.add(employeeSearchBorder);
        
        JLabel lblNewLabel_5 = new JLabel("Firstname");
        lblNewLabel_5.setBounds(958, 347, 65, 21);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Lastname");
        lblNewLabel_6.setBounds(958, 413, 100, 14);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblFunction = new JLabel("Department");
        lblFunction.setBounds(958, 474, 100, 14);
        contentPane.add(lblFunction);
       
        
        JLabel lblFunction_1 = new JLabel("Function");
        lblFunction_1.setBounds(958, 534, 105, 14);
        contentPane.add(lblFunction_1);
        
	}
}