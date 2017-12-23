package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dataAccess.Cache;
import models.Address;
import models.Settings;
import models.TrainingInfo;
import models.TrainingSession;


public class TrainingSessionMapPane extends JPanel {
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
	ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
	ConcurrentMap<Integer, Address> ListAdress=dataAccess.Cache.addressCache.asMap();
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	private JButton btnBack;
	private JButton btnCancelTrainingSession;
	private JLabel lblTrainingSessionTitle;
	private JButton btnInfo;
	private JButton btnEnlistedPeople;
	private JButton btnBooks;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnMaps;
	private JLabel lblMaps;
	private BufferedImage image;
	private JTextField textField;
	private String streetAddress;
	private String postalCode;
	private String locality;
	private String administrativeArea;
	private String premise;
	private String country;
	private JLabel lbl1;
	private JLabel lblStreetAddress;
	private JLabel lbl2;
	private JLabel lblPostalCode;
	private JLabel lbl3;
	private JLabel lblLocality;
	private JLabel lbl4;
	private JLabel lblAdministrativeArea;
	private JLabel lbl5;
	private JLabel lblPremise;
	private JLabel lbl6;
	private JLabel lblCountry;
	private JButton jtbSettings;
	private Settings settings;
	public JLabel companyName;
	

	/**
	 * Create the panel.
	 */
	public TrainingSessionMapPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		  Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		  
		  	try {
				settings = Cache.settingsCache.get(1);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        companyName = new JLabel(settings.getCompanyName()); //uit cache halen f
	        companyName.setBounds(10, 0, 110, 75);
	        companyName.setOpaque(true);
	        add(companyName);
		  
		  	jtbSettings = new JButton("Settings");
		  	jtbSettings.setBackground(Color.WHITE);
		  	jtbSettings.setHorizontalAlignment(SwingConstants.CENTER);
	        jtbSettings.setOpaque(true);
	        jtbSettings.setActionCommand("SettingsMenu");
	        jtbSettings.setBounds(1175, 0, 105, 75);
	        add(jtbSettings);
	        
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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(30, 100, 110, 50);
		btnBack.setActionCommand("BackToTrainingSessoin");
		add(btnBack);
		
		lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		add(lblTrainingSessionTitle);
		
		btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		btnCancelTrainingSession.setActionCommand("CancelTrainingSession");
		add(btnCancelTrainingSession);
		
		btnInfo = new JButton("Info");
		btnInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInfo.setHorizontalAlignment(SwingConstants.CENTER);
		btnInfo.setOpaque(true);
		btnInfo.setBounds(440, 165, 100, 50);
		btnInfo.setActionCommand("Info");
		add(btnInfo);
		
		btnEnlistedPeople = new JButton("Enlisted people");
		btnEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		btnEnlistedPeople.setOpaque(true);
		btnEnlistedPeople.setBounds(540, 165, 200, 50);
		btnEnlistedPeople.setActionCommand("EnlistedPeople");
		add(btnEnlistedPeople);
		
		btnBooks = new JButton("Books");
		btnBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBooks.setBounds(740, 165, 100, 50);
		btnBooks.setHorizontalAlignment(SwingConstants.CENTER);
		btnBooks.setOpaque(true);
		btnBooks.setActionCommand("Books");
		add(btnBooks);
		
		btnMaps = new JButton("Map");
		btnMaps.setOpaque(true);
		btnMaps.setHorizontalAlignment(SwingConstants.CENTER);
		btnMaps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMaps.setActionCommand("Map");
		btnMaps.setBounds(840, 165, 100, 50);
		add(btnMaps);
		
		lblMaps = new JLabel();
		lblMaps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaps.setBounds(52, 230, 650, 430);
		add(lblMaps);
		
		lbl1 = new JLabel("Street address:");
		lbl1.setBounds(740, 250, 133, 14);
		add(lbl1);
		
		lblStreetAddress = new JLabel("");
		lblStreetAddress.setBounds(740, 275, 476, 14);
		add(lblStreetAddress);
		
		lbl2 = new JLabel("Postal Code:");
		lbl2.setBounds(740, 300, 184, 14);
		add(lbl2);
		
		lblPostalCode = new JLabel("");
		lblPostalCode.setBounds(740, 325, 476, 14);
		add(lblPostalCode);
		
		lbl3 = new JLabel("Locality:");
		lbl3.setBounds(740, 350, 229, 14);
		add(lbl3);
		
		lblLocality = new JLabel("");
		lblLocality.setBounds(740, 375, 476, 14);
		add(lblLocality);
		
		lbl4 = new JLabel("Administrative Area: ");
		lbl4.setBounds(740, 400, 200, 14);
		add(lbl4);
		
		lblAdministrativeArea = new JLabel("");
		lblAdministrativeArea.setBounds(740, 425, 476, 14);
		add(lblAdministrativeArea);
		
		lbl5 = new JLabel("Premise: ");
		lbl5.setBounds(740, 450, 229, 14);
		add(lbl5);
		
		lblPremise = new JLabel("");
		lblPremise.setBounds(740, 475, 476, 14);
		add(lblPremise);
		
		lbl6 = new JLabel("Country: ");
		lbl6.setBounds(740, 500, 229, 14);
		add(lbl6);
		
		lblCountry = new JLabel("");
		lblCountry.setBounds(740, 525, 46, 14);
		add(lblCountry);

		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(20, 220, 1220, 450);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);

	}
	
	public void addActionListener(ActionListener listener) {
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
		btnInfo.addActionListener(listener);
		btnEnlistedPeople.addActionListener(listener);
		btnBooks.addActionListener(listener);
		btnBack.addActionListener(listener);
		btnCancelTrainingSession.addActionListener(listener);
		btnMaps.addActionListener(listener);
		jtbSettings.addActionListener(listener);
    }
	public void setImage(int id) {
		String address = null;
		System.out.println("test1");
		for (Map.Entry<Integer, Address>  entry : ListAdress.entrySet()) {
			if (entry.getValue().getAddressId()==id) {
				if (entry.getValue().getPremise() == null) {
					address = entry.getValue().getStreetAddress().replaceAll("\\s+","+") + "," + String.valueOf(entry.getValue().getPostalCode()) 
					+  "," + entry.getValue().getLocality() + "," + entry.getValue().getCountry();
				} else {
					address = entry.getValue().getStreetAddress().replaceAll("\\s+","+") + "," + String.valueOf(entry.getValue().getPostalCode()) 
					+  "," + entry.getValue().getLocality() + "," + entry.getValue().getCountry();
				}
				
				lblStreetAddress.setText(entry.getValue().getStreetAddress());
				lblPostalCode.setText(String.valueOf(entry.getValue().getPostalCode()));
				lblLocality.setText(entry.getValue().getLocality());
				lblAdministrativeArea.setText(entry.getValue().getAdministrativeArea());
				lblPremise.setText(entry.getValue().getPremise());
				lblCountry.setText(entry.getValue().getCountry());
			}
		}
		System.out.println("test2");
		System.out.println(address);
		if(address != null) {
			//https://stackoverflow.com/questions/13448368/trying-to-display-url-image-in-jframe
			 try {
				 String pathUrl = "https://maps.googleapis.com/maps/api/staticmap?zoom=14&center=" + address
						 		+ "&size=1100x430&markers=color:red%7Clabel:A%7C" + address
						 		+ "&key=AIzaSyBNGYCltDm0bAbk0OWAkD1Mi7VXbat_vIc";
				 URL url = new URL(pathUrl);
				 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				 connection.connect();
			     InputStream in = connection.getInputStream();
			     image = ImageIO.read(in);
  
			     } catch (Exception exp) {
			     	 System.out.println("nope");
			          exp.printStackTrace();     
			     }
			 //lblMaps = new JLabel(new ImageIcon(image));
			 lblMaps.setIcon(new ImageIcon(image));
		}
	}
	
	public void setBtnCancelTrainingSession(int id) {	
		TrainingSession session = null;
        try {
			session = Cache.trainingSessionCache.get(id);
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		if(session.isCancelled() == true) {
			System.out.println("true");
			btnCancelTrainingSession.setText("Uncancel training session");
		} else {
			System.out.println("false");
			btnCancelTrainingSession.setText("Cancel training session");
		}
	}
	
	public void updateCancelTrainingSession(int id) {	
		TrainingSession session = null;
        try {
			session = Cache.trainingSessionCache.get(id);
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		if(session.isCancelled() == true) {
			System.out.println("true");
			btnCancelTrainingSession.setText("Uncancel training session");
			session.setCanceled(false);
			try {
				session.save();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			System.out.println("false");
			btnCancelTrainingSession.setText("Cancel training session");
			session.setCanceled(true);
			try {
				session.save();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
