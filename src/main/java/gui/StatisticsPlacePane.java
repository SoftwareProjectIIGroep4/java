package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import dataAccess.CertificateAccess;
import dataAccess.EmployeeAccess;
import dataAccess.TrainingInfoAccess;
import dataAccess.AddressAccess;
import models.Address;
import models.Certificate;
import models.Employee;
import models.TrainingInfo;

public class StatisticsPlacePane extends JPanel {

	private int selectedRow;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnShowEmployeeCertStatistics;
	private JTextField txtEmpID;
	private JTable tbPlaceEmployeeStatistics;
	private DefaultTableModel tablePlaceEmployeeStatistics;
	private DefaultTableModel tableModel;
	private JScrollPane sclpartEmployeeStatistics;
	private ListSelectionModel selectedRowPlaceEmployeeStatistics;
	private JButton btnBackCertStatistics;
	private JLabel lblNameFixed;
	private JLabel lblName;
	private JLabel lblFirstName;




	/**
	 * Create the panel.
	 */


	private List<String[]> AddressData = null;

	public StatisticsPlacePane() {

		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);


		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		btnTraining = new JButton("Training");
		btnTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alle velden + table blanco zetten!
				txtEmpID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
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
			public void actionPerformed(ActionEvent e) {
				// alle velden + table blanco zetten!
				txtEmpID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
		btnTrainingsession.setBackground(Color.WHITE);
		btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
		btnTrainingsession.setOpaque(true);
		btnTrainingsession.setActionCommand("TrainingSessionMenu");
		btnTrainingsession.setBounds(388, 0, 264, 75);
		add(btnTrainingsession);

		btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alle velden + table blanco zetten!
				txtEmpID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
		btnEmployees.setBackground(Color.WHITE);
		btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		btnEmployees.setOpaque(true);
		btnEmployees.setActionCommand("EmployeesMenu");
		btnEmployees.setBounds(652, 0, 264, 75);
		add(btnEmployees);

		btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alle velden + table blanco zetten!
				txtEmpID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
		btnStatistics.setBackground(Color.WHITE);
		btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		btnStatistics.setOpaque(true);
		btnStatistics.setActionCommand("StatisticsMenu");
		btnStatistics.setBounds(916, 0, 264, 75);
		add(btnStatistics);
		
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

		txtEmpID = new JTextField();
		txtEmpID.setBounds(44, 266, 61, 33);
		add(txtEmpID);
		txtEmpID.setColumns(10);

		Object [] columnheaderEmployeeCertStatistics = {"Certificate title"};
		//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
		Object[][] data = {
		};

		tablePlaceEmployeeStatistics = new DefaultTableModel(data, columnheaderEmployeeCertStatistics)
		{
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tbPlaceEmployeeStatistics = new JTable(tablePlaceEmployeeStatistics);
		tbPlaceEmployeeStatistics.setModel(tablePlaceEmployeeStatistics);
		tbPlaceEmployeeStatistics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbPlaceEmployeeStatistics.setRowSelectionAllowed(true);
		final TableColumnModel columnmodelTraining = tbPlaceEmployeeStatistics.getColumnModel();
		for (int column = 0; column < tbPlaceEmployeeStatistics.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < tbPlaceEmployeeStatistics.getRowCount(); row++) {
				TableCellRenderer renderer = tbPlaceEmployeeStatistics.getCellRenderer(row, column);
				Component comp = tbPlaceEmployeeStatistics.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width +1 , width);
			}
			if(width > 300)
				width=300;
			columnmodelTraining.getColumn(column).setPreferredWidth(width);
		}

		sclpartEmployeeStatistics = new JScrollPane(tbPlaceEmployeeStatistics);
		sclpartEmployeeStatistics.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclpartEmployeeStatistics.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclpartEmployeeStatistics.setBounds(358, 176, 856, 469);
		add(sclpartEmployeeStatistics);

		selectedRowPlaceEmployeeStatistics = tbPlaceEmployeeStatistics.getSelectionModel();
		selectedRowPlaceEmployeeStatistics.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowPlaceEmployeeStatistics.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowPlaceEmployeeStatistics.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});

		btnShowEmployeeCertStatistics = new JButton("Show information");
		btnShowEmployeeCertStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int employeeNr = Integer.parseInt(txtEmpID.getText());
				Employee searchEmployee = new Employee();

				try {
					searchEmployee = EmployeeAccess.get(employeeNr);


				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				lblName.setText(searchEmployee.getLastName());
				lblFirstName.setText(searchEmployee.getFirstName());

				HashMap<Integer, Address> listAddressInfo = new HashMap<Integer, Address>();

			/*	try {
					listAddressInfo = AddressAccess.getAll();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				List<String[]> AddressData = new ArrayList<String[]>();
				
				for(Map.Entry<Integer, Address> lijst: listAddressInfo.entrySet()) {

					try {

						AddressData.add(new String[] {
								//CertificateAccess.get(lijst.getValue().getCertificateID()).getTitel()
								AddressAccess.get(lijst.getValue().get)
						});

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (listCertificateInfo.isEmpty()) {
					certData.add(new String[] {
							"No Certification Earned"	
					});
				}

				tableModel = new DefaultTableModel(certData.toArray(new Object[][] {}), columnheaderEmployeeCertStatistics) {
					@Override
					public boolean isCellEditable(int row, int column) {
						//all cells false
						return false;
					}
				};*/
				tbPlaceEmployeeStatistics.setModel(tableModel);
				tbPlaceEmployeeStatistics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbPlaceEmployeeStatistics.setRowSelectionAllowed(true);

				final TableColumnModel columnmodelTraining = tbPlaceEmployeeStatistics.getColumnModel();
				for (int column = 0; column < tbPlaceEmployeeStatistics.getColumnCount(); column++) {
					int width = 15; // Min width
					for (int row = 0; row < tbPlaceEmployeeStatistics.getRowCount(); row++) {
						TableCellRenderer renderer = tbPlaceEmployeeStatistics.getCellRenderer(row, column);
						Component comp = tbPlaceEmployeeStatistics.prepareRenderer(renderer, row, column);
						width = Math.max(comp.getPreferredSize().width +1 , width);
					}
					if(width > 300)
						width=300;
					columnmodelTraining.getColumn(column).setPreferredWidth(width);
				}

			}

		});
		btnShowEmployeeCertStatistics.setBounds(44, 310, 158, 45);
		add(btnShowEmployeeCertStatistics);

		JLabel lblExplanationOfTableCert = new JLabel("Certificates of employee");
		lblExplanationOfTableCert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExplanationOfTableCert.setBounds(358, 132, 183, 33);
		add(lblExplanationOfTableCert);

		btnBackCertStatistics = new JButton("Back");
		btnBackCertStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alle velden + table blanco zetten!
				txtEmpID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				tableModel.getDataVector().removeAllElements();
			}
		});
		btnBackCertStatistics.setActionCommand("backCertToStatistics");
		btnBackCertStatistics.setBounds(44, 131, 144, 45);
		add(btnBackCertStatistics);

		lblNameFixed = new JLabel("Name:");
		lblNameFixed.setBounds(555, 141, 61, 16);
		add(lblNameFixed);

		lblName = new JLabel("");
		lblName.setBounds(602, 141, 144, 16);
		add(lblName);

		lblFirstName = new JLabel("");
		lblFirstName.setBounds(758, 141, 144, 16);
		add(lblFirstName);


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
		return txtEmpID.getText();
	}
}
