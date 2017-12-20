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
import models.Certificate;
import models.Employee;
import models.TrainingInfo;

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
	private DefaultTableModel tableModel;
	private JScrollPane sclCertEmployeeStatistics;
	private ListSelectionModel selectedRowCertEmployeeStatistics;
	private JButton btnBackCertStatistics;
	private JLabel lblNameFixed;
	private JLabel lblName;
	private JLabel lblFirstName;


	/**
	 * Create the panel.
	 */


	private List<String[]> certData = null;

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
		txtCertEmployeeID.setBounds(44, 266, 61, 33);
		add(txtCertEmployeeID);
		txtCertEmployeeID.setColumns(10);

		Object [] columnheaderEmployeeCertStatistics = {"Certificate title"};
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
		//tbCertEmployeeStatistics.setBackground(Color.red);
		//tbCertEmployeeStatistics.setForeground(Color.blue);
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
		btnShowEmployeeCertStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int employeeNr = Integer.parseInt(txtCertEmployeeID.getText());
				Employee searchEmployee = new Employee();

				try {
					searchEmployee = EmployeeAccess.get(employeeNr);
					//	searchUser = UserAccess.get(employeeID);
					//	searchEmployee = EmployeeAccess.get(searchUser.empID);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//setEmployeeID(employeeID);
				//!!!// nog checken bij none-valid employee ID
				lblName.setText(searchEmployee.getLastName());
				lblFirstName.setText(searchEmployee.getFirstName());

				HashMap<Integer, Certificate> listCertificateInfo = new HashMap<Integer, Certificate>();

				try {
					listCertificateInfo = CertificateAccess.getUserCertificateInfos(employeeNr);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				List<String[]> certData = new ArrayList<String[]>();
				for(Map.Entry<Integer, Certificate> lijst: listCertificateInfo.entrySet()) {

					try {

						certData.add(new String[] {
								CertificateAccess.get(lijst.getValue().getCertificateID()).getTitel()
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
				};
				//tbEmployeeHistoryTraining = new JTable(tableModel);
				tbCertEmployeeStatistics.setModel(tableModel);
				//tbEmployeeHistoryTraining.setModel(defTableModelHistoryTraining);
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
				txtCertEmployeeID.setText("");
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

		JButton btnMakePdfCertificates = new JButton("Get PDF");
		btnMakePdfCertificates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sources: https://www.tutorialspoint.com/itext/index.htm
				// DESTPDF is string met path+naam waar we aangemaakt PDF-bestand bewaren

				int employeeNr = Integer.parseInt(txtCertEmployeeID.getText());
				String employeeNaam = lblName.getText();
				String employeeVoornaam = lblFirstName.getText();

				final String DESTPDF ="results/certificate" + employeeNr + "_" + employeeNaam + "_" + employeeVoornaam + ".pdf";
				File file = new File(DESTPDF);
				file.getParentFile().mkdirs();

				//initialize PDF Writer
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(DESTPDF);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PdfWriter writer = new PdfWriter(fos);
				//initialize PDFDocument
				PdfDocument pdf = new PdfDocument(writer);
				//initialize document
				Document doc = new Document(pdf);
				// add paragraph to document
				doc.add(new Paragraph ("Certificates Overview - EmployeeID: " +  employeeNr + " - " + employeeNaam + ", " + employeeVoornaam +""));

				HashMap<Integer, Certificate> listCertificateInfo = new HashMap<Integer, Certificate>();

				try {
					listCertificateInfo = CertificateAccess.getUserCertificateInfos(employeeNr);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				certData = new ArrayList<String[]>();
				for(Map.Entry<Integer, Certificate> lijst: listCertificateInfo.entrySet()) {

					Paragraph naamTraining;
					try {
						naamTraining = new Paragraph ("Name Training: " + CertificateAccess.get(lijst.getValue().getCertificateID()).getTitel());
						doc.add(naamTraining);
						//creating imageDataObject
						if (CertificateAccess.get(lijst.getValue().getCertificateID()).getPicture() != null) {
							ImageData fotodata = ImageDataFactory.create(CertificateAccess.get(lijst.getValue().getCertificateID()).getPicture());
							Image foto = new Image(fotodata);
							// add image to document, AutoScale true
							doc.add(foto.setAutoScale(true));
						}
						else {
							Paragraph noCert = new Paragraph ("Certification not yet received.");
							doc.add(noCert);
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				

				}
				if (listCertificateInfo.isEmpty()) {
					Paragraph warning = new Paragraph ("No Certificates - No Training Succeeded");
					doc.add(warning);
				}
				//close document
				doc.close();
				// print action executed
				System.out.println("PDF-document " + DESTPDF + " created");
			}
		});
		btnMakePdfCertificates.setBounds(44, 369, 158, 45);
		add(btnMakePdfCertificates);


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
