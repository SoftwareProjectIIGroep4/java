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
import javax.swing.JTextArea;


public class ExtraInfoEmployee extends JPanel {
		
		private int selectedRow;
		private JButton jtbTraining;
		private JButton jtbEmployees;
		private JButton jtbStatistics;
		private JButton jtbTrainingSession;
		private JButton jtbTrainingRequests;
		private JTable tbEmployeeHistoryTraining;
		private JTable tbEmployeeHistoryBook;
		private JButton uploadCertificate;
		private DefaultTableModel modelEmployeeHistoryTraining;
		private DefaultTableModel modelEmployeeHistoryBooks;
		
		
	/**
	 * Create the panel.
	 */
	

public ExtraInfoEmployee() {
		
		
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        
	        jtbTraining = new JButton("Training");
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
	        
	        jtbTrainingSession = new JButton("Training session");
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
	        
	        jtbEmployees = new JButton("Employees");
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
	        
	        jtbStatistics = new JButton("Statistics");
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
	        
	        jtbTrainingRequests = new JButton("Training requests");
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
	        
	        JLabel employeeLabel = new JLabel("Employee: ");
	        employeeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	        employeeLabel.setBounds(40, 100, 93, 39);
	        add(employeeLabel);
	        
	        JLabel firstnameLabel = new JLabel("First name:");
	        firstnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        firstnameLabel.setBounds(50, 150, 75, 25);
	        add(firstnameLabel);
	        
	        JLabel lastnameLabel = new JLabel("Last name:");
	        lastnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lastnameLabel.setBounds(50, 199, 75, 25);
	        add(lastnameLabel);
	        
	        JTextArea textAreaFirstName = new JTextArea();
	        textAreaFirstName.setBounds(133, 155, 147, 25);
	        add(textAreaFirstName);
	        
	        JTextArea textAreaLastName = new JTextArea();
	        textAreaLastName.setBounds(133, 201, 147, 25);
	        add(textAreaLastName);
	        
	        JLabel lblNewLabel_5 = new JLabel("Department:");
	        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_5.setBounds(356, 150, 93, 25);
	        add(lblNewLabel_5);
	        
	        JTextArea textAreaDepartment = new JTextArea();
	        textAreaDepartment.setBounds(455, 155, 147, 25);
	        add(textAreaDepartment);
	        
	        JLabel lblNewLabel_6 = new JLabel("Function:");
	        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_6.setBounds(359, 206, 93, 25);
	        add(lblNewLabel_6);
	        
	        JTextArea textAreaFunction = new JTextArea();
	        textAreaFunction.setBounds(455, 202, 147, 25);
	        add(textAreaFunction);
	        
	        uploadCertificate = new JButton("Upload Certificate");
			uploadCertificate.setBounds(902, 150, 147, 75);
			add(uploadCertificate);
			
	        JLabel lblNewLabel_7 = new JLabel("List of trainings the employee has followed");
	        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_7.setBounds(40, 253, 264, 25);
	        add(lblNewLabel_7);
	        
	        Object [] columnHeadersHistoryTraining = {"TrainingID","Training name","Amount of days","Price"};
			modelEmployeeHistoryTraining = new DefaultTableModel();
			modelEmployeeHistoryTraining.setColumnIdentifiers(columnHeadersHistoryTraining);
			Object[][] data = {
					
					
			};
			tbEmployeeHistoryTraining = new JTable(data, columnHeadersHistoryTraining);
			DefaultTableModel defTableModelHistoryTraining = new DefaultTableModel(data, columnHeadersHistoryTraining)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbEmployeeHistoryTraining.setBackground(Color.red);
			tbEmployeeHistoryTraining.setForeground(Color.blue);
			tbEmployeeHistoryTraining.setModel(defTableModelHistoryTraining);
			tbEmployeeHistoryTraining.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbEmployeeHistoryTraining.setRowSelectionAllowed(true);
		    final TableColumnModel columnmodelTraining = tbEmployeeHistoryTraining.getColumnModel();
		    for (int column = 0; column < tbEmployeeHistoryTraining.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tbEmployeeHistoryTraining.getRowCount(); row++) {
		            TableCellRenderer renderer = tbEmployeeHistoryTraining.getCellRenderer(row, column);
		            Component comp = tbEmployeeHistoryTraining.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnmodelTraining.getColumn(column).setPreferredWidth(width);
		    }
			JScrollPane sclTraining = new JScrollPane(tbEmployeeHistoryTraining);
			sclTraining.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			sclTraining.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			sclTraining.setBounds(40, 282, 548, 427);
			add(sclTraining);
			ListSelectionModel selectedHistoryTraining = tbEmployeeHistoryTraining.getSelectionModel();
			selectedHistoryTraining.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedHistoryTraining.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedHistoryTraining.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});
			
			 Object [] columnHeadersHistoryBooks = {"isbn","Book name","author","Price"};
			    modelEmployeeHistoryBooks = new DefaultTableModel();
				modelEmployeeHistoryBooks.setColumnIdentifiers(columnHeadersHistoryBooks);
				Object[][] dataHistoryBook = {
						
						
						
				};
				tbEmployeeHistoryBook = new JTable(dataHistoryBook, columnHeadersHistoryBooks);
				DefaultTableModel defTableModelHistoryBooks = new DefaultTableModel(dataHistoryBook, columnHeadersHistoryBooks)
				{
				    @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				tbEmployeeHistoryBook.setBackground(Color.red);
				tbEmployeeHistoryBook.setForeground(Color.blue);
				tbEmployeeHistoryBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbEmployeeHistoryBook.setRowSelectionAllowed(true);
			    final TableColumnModel columnmodelHistoryBook = tbEmployeeHistoryBook.getColumnModel();
			    for (int column = 0; column < tbEmployeeHistoryBook.getColumnCount(); column++) {
			        int width = 15; // Min width
			        for (int row = 0; row < tbEmployeeHistoryBook.getRowCount(); row++) {
			            TableCellRenderer renderer = tbEmployeeHistoryBook.getCellRenderer(row, column);
			            Component comp = tbEmployeeHistoryBook.prepareRenderer(renderer, row, column);
			            width = Math.max(comp.getPreferredSize().width +1 , width);
			        }
			        if(width > 300)
			            width=300;
			        columnmodelTraining.getColumn(column).setPreferredWidth(width);
			    }
				JScrollPane sclHistoryBook = new JScrollPane(tbEmployeeHistoryBook);
				sclHistoryBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				sclHistoryBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				sclHistoryBook.setBounds(669, 282, 569, 427);
				add(sclHistoryBook);
				
				JLabel lblNewLabel_2 = new JLabel("History of books the employee has purchased");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(669, 253, 264, 25);
				add(lblNewLabel_2);
				ListSelectionModel selectedRowHistoryBooks = tbEmployeeHistoryBook.getSelectionModel();
				selectedRowHistoryBooks.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						if(!selectedRowHistoryBooks.isSelectionEmpty()) {
							//GET ROW
							selectedRow = selectedRowHistoryBooks.getMinSelectionIndex();
							//doe iets hier
						}
					}
				});
			
			
			
			
			
		
		
	}
}
