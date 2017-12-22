package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class NewTrainingSessionPane extends JPanel {

	
	private JTextField txtTitle;
	private JTextField txtDate;
	private JTextField txtStartHour;
	private JTextField txtEndHour;
	private JTextField txtAdministrativeArea;
	private JTextField txtLocality;
	private JTextField txtPostalCode;
	private JTextField txtStreetAddress;
	private JTextField txtPremise;
	private JTextField txtCountry;
	private JButton btnBack;
	private JButton btnSave;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnAddTeacher;
	private JButton btnAddBook;
	private JButton btnaddSurvey;
	
	/**
	 * Create the panel.
	 */
	public NewTrainingSessionPane() {
		
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
	       
		
		btnBack = new JButton("<-  Back");
		btnBack.setActionCommand("backToTrainingSession");
		btnBack.setBounds(30, 100, 110, 50);
		add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.setActionCommand("SaveTrainingSession");
		btnSave.setBounds(170, 100, 110, 50);
		add(btnSave);
		
		JLabel lblTitle = new JLabel("Session title");
		lblTitle.setBounds(309, 221, 100, 14);
		add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(309, 246, 300, 25);
		txtTitle.setColumns(10);
		txtTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtTitle.selectAll();
			}
		});
		txtTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTitle.selectAll();
			}
		});
		add(txtTitle);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(309, 282, 46, 14);
		add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(309, 307, 152, 25);
		txtDate.setColumns(10);
		txtDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtDate.selectAll();
			}
		});
		txtDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDate.selectAll();
			}
		});
		add(txtDate);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation.setBounds(309, 423, 133, 14);
		add(lblLocation);
		
		JLabel lblStartHour = new JLabel("Start hour");
		lblStartHour.setBounds(309, 359, 100, 14);
		add(lblStartHour);
		
		txtStartHour = new JTextField();
		txtStartHour.setBounds(309, 384, 86, 25);
		txtStartHour.setColumns(10);
		txtStartHour.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtStartHour.selectAll();
			}
		});
		txtStartHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStartHour.selectAll();
			}
		});
		add(txtStartHour);
		
		JLabel lblEndHour = new JLabel("End hour");
		lblEndHour.setBounds(682, 359, 100, 14);
		add(lblEndHour);
		
		txtEndHour = new JTextField();
		txtEndHour.setBounds(682, 384, 86, 25);
		txtEndHour.setColumns(10);
		txtEndHour.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtEndHour.selectAll();
			}
		});
		txtEndHour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEndHour.selectAll();
			}
		});
		add(txtEndHour);
		
		JLabel lblAdministrativeArea = new JLabel("Region");
		lblAdministrativeArea.setBounds(309, 448, 100, 14);
		add(lblAdministrativeArea);
		
		txtAdministrativeArea = new JTextField();
		txtAdministrativeArea.setBounds(309, 473, 300, 25);
		txtAdministrativeArea.setColumns(10);
		txtAdministrativeArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtAdministrativeArea.selectAll();
			}
		});
		txtAdministrativeArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdministrativeArea.selectAll();
			}
		});
		add(txtAdministrativeArea);
		
		JLabel lblLocality = new JLabel("City");
		lblLocality.setBounds(309, 519, 59, 14);
		add(lblLocality);
		
		txtLocality = new JTextField();
		txtLocality.setBounds(309, 544, 300, 25);
		txtLocality.setColumns(10);
		txtLocality.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtLocality.selectAll();
			}
		});
		txtLocality.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLocality.selectAll();
			}
		});
		add(txtLocality);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setBounds(309, 590, 100, 14);
		add(lblPostalCode);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setBounds(309, 615, 300, 25);
		txtPostalCode.setColumns(10);
		txtPostalCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPostalCode.selectAll();
			}
		});
		txtPostalCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPostalCode.selectAll();
			}
		});
		add(txtPostalCode);
		
		JLabel lblStreetAddress = new JLabel("Street address");
		lblStreetAddress.setBounds(682, 448, 100, 14);
		add(lblStreetAddress);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setBounds(682, 473, 300, 25);
		txtStreetAddress.setColumns(10);
		txtStreetAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtStreetAddress.selectAll();
			}
		});
		txtStreetAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStreetAddress.selectAll();
			}
		});
		add(txtStreetAddress);
		
		JLabel lblPremise = new JLabel("PO Box");
		lblPremise.setBounds(682, 519, 46, 14);
		add(lblPremise);
		
		txtPremise = new JTextField();
		txtPremise.setBounds(682, 544, 300, 25);
		txtPremise.setColumns(10);
		txtPremise.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPremise.selectAll();
			}
		});
		txtPremise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPremise.selectAll();
			}
		});
		add(txtPremise);
		
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(682, 590, 100, 14);
		add(lblCountry);
		
		txtCountry = new JTextField();
		txtCountry.setBounds(682, 615, 300, 25);
		txtCountry.setColumns(10);
		txtCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCountry.selectAll();
			}
		});
		txtCountry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCountry.selectAll();
			}
		});
		add(txtCountry);
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(253, 195, 825, 486);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);

		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setActionCommand("addTeacher");
		btnAddTeacher.setBounds(1102, 231, 117, 54);
		add(btnAddTeacher);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.setActionCommand("addBook");
		btnAddBook.setBounds(1102, 371, 117, 50);
		add(btnAddBook);
		
		btnaddSurvey = new JButton("Add Survey");
		btnaddSurvey.setActionCommand("addSurvey");
		btnaddSurvey.setBounds(1102, 499, 117, 54);
		add(btnaddSurvey);
		
		JLabel lblNewLabel_2 = new JLabel("(YYYY-MM-DD)");
		lblNewLabel_2.setBounds(370, 282, 72, 14);
		add(lblNewLabel_2);

	}
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnAddTeacher.addActionListener(listener);
		btnAddBook.addActionListener(listener);
		btnaddSurvey.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
    }
	public String getTitle() {
        return txtTitle.getText();
    }
	public String getDate() {
		return txtDate.getText();
    }
	public Time getStartHour() {
		return java.sql.Time.valueOf(txtStartHour.getText()+":00");

    }
	public Time getEndHour() {
		return java.sql.Time.valueOf(txtEndHour.getText()+":00");
    }
	public String getAdministrativeArea() {
        return txtAdministrativeArea.getText();
    }
	public String getLocality() {
        return txtLocality.getText();
    }
	public String getPostalCode() {
        return txtPostalCode.getText();
    }
	public String getStreetAddress() {
        return txtStreetAddress.getText();
    }
	public String getPremise() {
        return txtPremise.getText();
    }
	public String getCountry() {
        return txtCountry.getText();
    }
}
