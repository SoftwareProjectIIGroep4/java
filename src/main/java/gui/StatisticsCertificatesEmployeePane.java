package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

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

public class StatisticsCertificatesEmployeePane extends JPanel {

	private int selectedRow;
	private JButton jtbTraining;
	private JButton jtbEmployees;
	private JButton jtbStatistics;
	private JButton jtbTrainingSession;
	private JButton jtbTrainingRequests;
	private JButton btnShowEmployeeCertStatistics;
	private JTextField txtCertEmployeeID;
	private JTable tbCertEmployeeStatistics;
	private DefaultTableModel tableCertEmployeeStatistics;
	private JScrollPane sclCertEmployeeStatistics;
	private ListSelectionModel selectedRowCertEmployeeStatistics;
	private JButton btnBackCertStatistics;
	
	
	/**
	 * Create the panel.
	 */
	public StatisticsCertificatesEmployeePane() {

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
	        
	        JLabel lblUitlegCert = new JLabel("Write employeeID to get information");
	        lblUitlegCert.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblUitlegCert.setBounds(44, 222, 260, 33);
	        add(lblUitlegCert);
	        
	        txtCertEmployeeID = new JTextField();
	        txtCertEmployeeID.setBounds(44, 266, 241, 33);
	        add(txtCertEmployeeID);
	        txtCertEmployeeID.setColumns(10);
	        
	        Object [] columnheaderEmployeeCertStatistics = {"First name","Last name","Certificate title"};
			//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
			Object[][] data = {
			
					
					
			};
			
			tableCertEmployeeStatistics = new DefaultTableModel(data, columnheaderEmployeeCertStatistics)
			{
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			tbCertEmployeeStatistics = new JTable(tableCertEmployeeStatistics);
			tbCertEmployeeStatistics.setBackground(Color.red);
			tbCertEmployeeStatistics.setForeground(Color.blue);
			tbCertEmployeeStatistics.setModel(tableCertEmployeeStatistics);
			tbCertEmployeeStatistics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbCertEmployeeStatistics.setRowSelectionAllowed(true);
		    final TableColumnModel columnmodelTraining = tbCertEmployeeStatistics.getColumnModel();
		    for (int column = 0; column < tbCertEmployeeStatistics.getColumnCount(); column++) {
		        int width = 15; // Min width
		        for (int row = 0; row < tbCertEmployeeStatistics.getRowCount(); row++) {
		            TableCellRenderer renderer = tbCertEmployeeStatistics.getCellRenderer(row, column);
		            Component comp = tbCertEmployeeStatistics.prepareRenderer(renderer, row, column);
		            width = Math.max(comp.getPreferredSize().width +1 , width);
		        }
		        if(width > 300)
		            width=300;
		        columnmodelTraining.getColumn(column).setPreferredWidth(width);
		    }
			
		    sclCertEmployeeStatistics = new JScrollPane(tbCertEmployeeStatistics);
		    sclCertEmployeeStatistics.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    sclCertEmployeeStatistics.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    sclCertEmployeeStatistics.setBounds(358, 176, 856, 469);
			add(sclCertEmployeeStatistics);
			
			selectedRowCertEmployeeStatistics = tbCertEmployeeStatistics.getSelectionModel();
			selectedRowCertEmployeeStatistics.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					// TODO Auto-generated method stub
					if(!selectedRowCertEmployeeStatistics.isSelectionEmpty()) {
						//GET ROW
						selectedRow = selectedRowCertEmployeeStatistics.getMinSelectionIndex();
						//doe iets hier
					}
				}
			});
			
			btnShowEmployeeCertStatistics = new JButton("Show information");
			btnShowEmployeeCertStatistics.setActionCommand("showcertTrainingsEmployee");
			btnShowEmployeeCertStatistics.setBounds(44, 310, 158, 45);
			add(btnShowEmployeeCertStatistics);
			
			JLabel lblExplanationOfTableCert = new JLabel("Certificates of employee");
			lblExplanationOfTableCert.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblExplanationOfTableCert.setBounds(358, 132, 326, 33);
			add(lblExplanationOfTableCert);
			
			btnBackCertStatistics = new JButton("Back");
			btnBackCertStatistics.setActionCommand("backCertToStatistics");
			btnBackCertStatistics.setBounds(44, 131, 144, 45);
			add(btnBackCertStatistics);
		
	}

	public void addActionListener(ActionListener listener) {
		btnShowEmployeeCertStatistics.addActionListener(listener);
		btnBackCertStatistics.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
    }
	
	public String getEmployeeIDCertTraining() {
		return txtCertEmployeeID.getText();
	}
}
