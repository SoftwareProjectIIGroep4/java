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
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
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
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
    }
	
	public String getEmployeeIDCertTraining() {
		return txtCertEmployeeID.getText();
	}
}
