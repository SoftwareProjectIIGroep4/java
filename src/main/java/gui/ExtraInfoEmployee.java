package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
//import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.EmployeeAccess;
import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;
import models.Certificate;
import models.Employee;
import models.TrainingInfo;
import models.TrainingSession;
import models.UserCertificate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
//import com.itextpdf.layout.element.List;


public class ExtraInfoEmployee extends JPanel {
	private int selectedRow;
	private JToggleButton jtbTraining;
	private JToggleButton jtbEmployees;
	private JToggleButton jtbStatistics;
	private JToggleButton jtbTrainingSession;
	private JToggleButton jtbTrainingRequests;
	private JTable tbEmployeeHistoryTraining;
	private JTable tbEmployeeHistoryBook;
	private JButton uploadCertificate;
	private DefaultTableModel modelEmployeeHistoryTraining;
	private DefaultTableModel modelEmployeeHistoryBooks;
	private JButton btnListOfTrainings;
	private JTextField textFieldEmployeeID;
	private int employeeID;

	/**
	 * Create the panel.
	 */


	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int nieuwewaarde) {
		employeeID = nieuwewaarde;
	}
	
	private	List<String[]> data1 = null;

	public ExtraInfoEmployee() {
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

		JLabel employeeLabel = new JLabel("User search by ID: ");
		employeeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		employeeLabel.setBounds(40, 100, 184, 39);
		add(employeeLabel);

		JLabel firstnameLabel = new JLabel("User ID:");
		firstnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstnameLabel.setBounds(40, 150, 85, 25);
		add(firstnameLabel);

		JLabel lblFirstNameFixed = new JLabel("First name:");
		lblFirstNameFixed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstNameFixed.setBounds(332, 150, 93, 25);
		add(lblFirstNameFixed);

		JLabel lblLastName = new JLabel("");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(425, 200, 155, 25);
		add(lblLastName);

		JLabel lblFirstName = new JLabel("");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(425, 146, 155, 25);
		add(lblFirstName);

		JLabel lblLastNameFixed = new JLabel("Last name:");
		lblLastNameFixed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastNameFixed.setBounds(332, 205, 81, 16);
		add(lblLastNameFixed);

		JLabel lblTrainingName = new JLabel("");
		lblTrainingName.setBounds(776, 200, 255, 22);
		add(lblTrainingName);

		JLabel lblTrainingID = new JLabel("");
		lblTrainingID.setBounds(776, 150, 117, 21);
		add(lblTrainingID);

		JLabel lblShowImageIcon = new JLabel("");
		lblShowImageIcon.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblShowImageIcon.setBounds(669, 282, 521, 427);
		add(lblShowImageIcon);
		
		textFieldEmployeeID = new JTextField();
		textFieldEmployeeID.setBounds(133, 149, 147, 28);
		add(textFieldEmployeeID);
		textFieldEmployeeID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("view certificate");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(669, 253, 264, 25);
		add(lblNewLabel_2);

		JLabel lblTrainingFixed = new JLabel("TrainingID:");
		lblTrainingFixed.setBounds(669, 155, 98, 16);
		add(lblTrainingFixed);

		JLabel lblTrainingNameFixed = new JLabel("Training Name:");
		lblTrainingNameFixed.setBounds(669, 206, 104, 16);
		add(lblTrainingNameFixed);
		
		uploadCertificate = new JButton("Upload Certificate");
		uploadCertificate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int trainingID = 0;
				try{
					trainingID = Integer.parseInt(lblTrainingID.getText());
				} catch(NumberFormatException ex) {
					System.out.println("dit is de labeltraining" + lblTrainingID);
				}
				int employeeNr = Integer.parseInt(textFieldEmployeeID.getText());
				String trainingName = lblTrainingName.getText();
				CertificateAccess cA = new CertificateAccess();
				File bestand = null;
				Certificate certificate = new Certificate();
				certificate.setTrainingID(trainingID);
				certificate.setTitel(trainingName);
				bestand = cA.chooseFile();
				certificate.setPicture(CertificateAccess.ConvertFile(bestand.getAbsolutePath()));
				UserCertificate certificateUser = new UserCertificate(certificate, employeeNr);
				try {
					//certificate.save();
					CertificateAccess.addCertificateUser(certificateUser);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		uploadCertificate.setBounds(1043, 150, 147, 75);
		add(uploadCertificate);

		Object [] columnHeadersHistoryTraining = {"TrainingID", "Training name"};
		modelEmployeeHistoryTraining = new DefaultTableModel();
		modelEmployeeHistoryTraining.setColumnIdentifiers(columnHeadersHistoryTraining);

		List<String[]> data = new ArrayList<String[]>();

		DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnHeadersHistoryTraining) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tbEmployeeHistoryTraining = new JTable(tableModel);
		tbEmployeeHistoryTraining.setModel(tableModel);
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


		btnListOfTrainings = new JButton("List of trainings employee followed");
		btnListOfTrainings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTrainingID.setText("");
				lblTrainingName.setText("");
				lblShowImageIcon.setIcon(null);
				employeeID = Integer.parseInt(textFieldEmployeeID.getText());
		
				System.out.println("ljlkj" + employeeID + textFieldEmployeeID.getText());
// ! ! ! !				// check employeeid en userid verschil?		
				Employee searchEmployee = new Employee();
				//	Employee searchUser = new User(); // id van de GUI


				try {
					searchEmployee = EmployeeAccess.get(employeeID);
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
//!!!				// nog checken bij none-valid employee ID
				lblLastName.setText(searchEmployee.getLastName());
				lblFirstName.setText(searchEmployee.getFirstName());

				HashMap<Integer, TrainingInfo> listTrainingInfo = new HashMap<Integer, TrainingInfo>();

				try {
					listTrainingInfo = TrainingInfoAccess.getUserTrainingInfos(employeeID);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				data1 = new ArrayList<String[]>();
				for(Map.Entry<Integer, TrainingInfo> lijst: listTrainingInfo.entrySet()) {

					try {

						data1.add(new String[] {
								String.valueOf(TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getTrainingId()),
								TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getName()	
						});

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				DefaultTableModel tableModel = new DefaultTableModel(data1.toArray(new Object[][] {}), columnHeadersHistoryTraining) {
					@Override
					public boolean isCellEditable(int row, int column) {
						//all cells false
						return false;
					}
				};
				//tbEmployeeHistoryTraining = new JTable(tableModel);
				tbEmployeeHistoryTraining.setModel(tableModel);
				//tbEmployeeHistoryTraining.setModel(defTableModelHistoryTraining);
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

				ListSelectionModel selectedRowBook = tbEmployeeHistoryTraining.getSelectionModel();

				selectedRowBook.addListSelectionListener(new ListSelectionListener() {
					int certID = 65;
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						lblShowImageIcon.setIcon(null);
						if(!selectedRowBook.isSelectionEmpty()) {
							//GET ROW
							
							int userid = Integer.parseInt(textFieldEmployeeID.getText());
							int selectedRow = selectedRowBook.getMinSelectionIndex();
							String[] test = data1.get(selectedRow);
							String trainingID = test[0];
							int intTrainingID = Integer.parseInt(trainingID);
							String trainingNaam = test[1];
							//lblLastName.setText(String.valueOf(testID));
							lblTrainingID.setText(String.valueOf(trainingID));
							lblTrainingName.setText(trainingNaam);
							//lblShowImageIcon.
							Certificate certZoek = new Certificate();
							String naam = "";
							byte[] foto = null;
							// hier op basis van userid en trainingid het certificaatid weergeven
							certID = 65;
							try { // userid en trainingid meegeven, je krijgt dat certificateid
								certID = CertificateAccess.getUserCertificateID(userid, intTrainingID);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
							if (certID != 0) {
								try {
									certZoek = Cache.certificateCache.get(certID);
								} catch (ExecutionException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								naam = certZoek.getTitel();
								System.out.println(naam);
								if (certZoek.getPicture() != null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(certZoek.getPicture()).getImage().getScaledInstance(521, 427, ABORT));
									lblShowImageIcon.setIcon(imageIcon);
								}
								
							}
							else {
								System.out.println("Kan het gevraagde certificaat niet vinden");

							}
						}
					}
				});
			}

		});

		btnListOfTrainings.setBounds(40, 233, 256, 29);
		add(btnListOfTrainings);

		
		
		// wegdoen, wordt niet gebruikt
//!!		//hier nog fucntie koppelen aan je selectie van de rij!
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Certificate certZoek = new Certificate();
				String naam = "";
				byte[] foto = null;
				int nummer = Integer.parseInt(lblTrainingID.getText());

				try {
					certZoek = Cache.certificateCache.get(nummer);
					if (certZoek == null) {
						System.out.println("Kan het gevraagde certificaat niet vinden");
					}
					else
						naam = certZoek.getTitel();
					System.out.println(naam);

				}
				catch (ExecutionException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(certZoek.getPicture()).getImage().getScaledInstance(521, 427, ABORT));
				//ImageIcon imageIcon = new ImageIcon(new ImageIcon(certZoek.getPicture()).getImage().getScaledInstance(521, 427, Image.SCALE_DEFAULT));
				lblShowImageIcon.setIcon(imageIcon);
				//lblShowImageIcon.setBounds(669, 282, 521, 427);
				//lblShowImageIcon.setIcon(new ImageIcon(certZoek.getPicture()));

			}
		});

		btnShow.setBounds(901, 234, 117, 29);
		add(btnShow);

		JButton btnMakePdfCertificates = new JButton("Make PDF Certificates Employee");
		btnMakePdfCertificates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sources: https://www.tutorialspoint.com/itext/index.htm
				// DESTPDF is string met path+naam waar we aangemaakt PDF-bestand bewaren
				
				int employeeNr = Integer.parseInt(textFieldEmployeeID.getText());
				String employeeNaam = lblLastName.getText();
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
						
				List<String[]> certData = new ArrayList<String[]>();
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
							Paragraph noCert = new Paragraph ("Certification not yet earned.");
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
		btnMakePdfCertificates.setBounds(308, 233, 256, 29);
		add(btnMakePdfCertificates);
		
		
		

	}





	public void addActionListener(ActionListener listener) {

		uploadCertificate.addActionListener(listener);
		btnListOfTrainings.addActionListener(listener);
		jtbTraining.addActionListener(listener);
		jtbTrainingRequests.addActionListener(listener);
		jtbStatistics.addActionListener(listener);
		jtbEmployees.addActionListener(listener);
		jtbTrainingSession.addActionListener(listener);
	}
}
