package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import dataAccess.AddressAccess;
import dataAccess.EmployeeAccess;
import dataAccess.TrainingInfoAccess;
import dataAccess.TrainingSessionAccess;
import models.Employee;
import models.TrainingInfo;
import models.TrainingSession;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;

public class StatisticsFollowedTrainingPane extends JPanel {

	private int selectedRow;
	private JButton btnTraining;
	private JButton btnEmployees;
	private JButton btnStatistics;
	private JButton btnTrainingsession;
	private JButton btnShowEmployeeFollowedTrainings;
	private JTable tbFollowedTrainingsEmployee;
	private DefaultTableModel tableFollowedTrainingEmployee;
	private DefaultTableModel tableModel;

	private JScrollPane sclFollowedTrainingsEmployee;
	private ListSelectionModel selectedRowFollowedTrainings;
	private JButton btnBackFollowedTrainingStatistics;
	private JTextField txtTrainingEmployeeID;
	private JLabel lblNameFixed;
	private JLabel lblName;
	private JLabel lblFirstName;
	private JLabel lblTotalOfDaysFixed;
	private JLabel lblTotalOfPriceFixed;
	private JLabel lblTotalOfDays;
	private JLabel lblTotalOfPrice;


	/**
	 * Create the panel.
	 */
	private List<String[]> trainingData = null;
	HashMap<Integer, TrainingSession> trainingSessionsMap = null;

	public StatisticsFollowedTrainingPane() {

		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);


		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		btnTraining = new JButton("Training");
		btnTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// velden op blanco zetten
				lblTotalOfPrice.setText("");
				lblTotalOfDays.setText("");
				txtTrainingEmployeeID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				// bestaande tabel blanco op zetten!
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

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
				// velden op blanco zetten
				lblTotalOfPrice.setText("");
				lblTotalOfDays.setText("");
				txtTrainingEmployeeID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				// bestaande tabel blanco op zetten!
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

			}
		});
		btnTrainingsession.setBackground(Color.WHITE);
		btnTrainingsession.setHorizontalAlignment(SwingConstants.CENTER);
		btnTrainingsession.setOpaque(true);
		btnTrainingsession.setActionCommand("TrainingSessionMenu");
		btnTrainingsession.setBounds(387, 0, 264, 75);
		add(btnTrainingsession);

		btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// velden op blanco zetten
				lblTotalOfPrice.setText("");
				lblTotalOfDays.setText("");
				txtTrainingEmployeeID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				// bestaande tabel blanco op zetten!
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

			}
		});
		btnEmployees.setBackground(Color.WHITE);
		btnEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		btnEmployees.setOpaque(true);
		btnEmployees.setActionCommand("EmployeesMenu");
		btnEmployees.setBounds(650, 0, 264, 75);
		add(btnEmployees);

		btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// velden op blanco zetten
				lblTotalOfPrice.setText("");
				lblTotalOfDays.setText("");
				txtTrainingEmployeeID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				// bestaande tabel blanco op zetten!
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

			}
		});
		btnStatistics.setBackground(Color.WHITE);
		btnStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		btnStatistics.setOpaque(true);
		btnStatistics.setActionCommand("StatisticsMenu");
		btnStatistics.setBounds(912, 0, 264, 75);
		add(btnStatistics);

		/**		jtbTrainingRequests = new JButton("Training requests");
		/* jtbTrainingRequests.addMouseListener(new MouseAdapter() {
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
		add(jtbTrainingRequests); */

		JLabel lblNewLabel = new JLabel("logo");
		lblNewLabel.setBounds(0, 0, 133, 75);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Profiel");
		lblNewLabel_1.setBounds(1190, 0, 75, 75);
		lblNewLabel_1.setOpaque(true);
		add(lblNewLabel_1);

		JLabel lblUitleg = new JLabel("Write employeeID to get information");
		lblUitleg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUitleg.setBounds(44, 222, 260, 33);
		add(lblUitleg);

		lblName = new JLabel("");
		lblName.setBounds(767, 141, 144, 16);
		add(lblName);

		lblFirstName = new JLabel("");
		lblFirstName.setBounds(915, 141, 144, 16);
		add(lblFirstName);

		lblTotalOfPriceFixed = new JLabel("Total of Price:");
		lblTotalOfPriceFixed.setBounds(44, 423, 158, 16);
		add(lblTotalOfPriceFixed);

		lblTotalOfDays = new JLabel("");
		lblTotalOfDays.setBounds(204, 379, 100, 16);
		add(lblTotalOfDays);

		Object [] columnheaderEmployeeStatistics = {"Training name", "Date", "City", "Number of Days","Price"};
		//modelEmployees.setColumnIdentifiers(columnHeadersEmployees);
		Object[][] data = {
		};

		tableFollowedTrainingEmployee = new DefaultTableModel(data, columnheaderEmployeeStatistics)
		{
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tbFollowedTrainingsEmployee = new JTable(tableFollowedTrainingEmployee);
		tbFollowedTrainingsEmployee.setModel(tableFollowedTrainingEmployee);
		tbFollowedTrainingsEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbFollowedTrainingsEmployee.setRowSelectionAllowed(true);
		final TableColumnModel columnmodelTraining = tbFollowedTrainingsEmployee.getColumnModel();
		for (int column = 0; column < tbFollowedTrainingsEmployee.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < tbFollowedTrainingsEmployee.getRowCount(); row++) {
				TableCellRenderer renderer = tbFollowedTrainingsEmployee.getCellRenderer(row, column);
				Component comp = tbFollowedTrainingsEmployee.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width +1 , width);
			}
			if(width > 300)
				width=300;
			columnmodelTraining.getColumn(column).setPreferredWidth(width);
		}

		sclFollowedTrainingsEmployee = new JScrollPane(tbFollowedTrainingsEmployee);
		sclFollowedTrainingsEmployee.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclFollowedTrainingsEmployee.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclFollowedTrainingsEmployee.setBounds(358, 176, 856, 469);
		add(sclFollowedTrainingsEmployee);

		selectedRowFollowedTrainings = tbFollowedTrainingsEmployee.getSelectionModel();
		selectedRowFollowedTrainings.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowFollowedTrainings.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowFollowedTrainings.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});



		btnShowEmployeeFollowedTrainings = new JButton("Show information");
		btnShowEmployeeFollowedTrainings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lblTrainingID.setText("");
				//lblTrainingName.setText("");
				//lblShowImageIcon.setIcon(null);
				int totaalDagen;
				float totaalPrijs;
				totaalDagen = 0;
				totaalPrijs = 0;
				int employeeID = Integer.parseInt(txtTrainingEmployeeID.getText());

				System.out.println("ljlkj" + employeeID + txtTrainingEmployeeID.getText());
				// ! ! ! !// check employeeid en userid verschil?		
				Employee searchEmployee = new Employee();

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
				//!!!// nog checken bij none-valid employee ID
				lblName.setText(searchEmployee.getLastName());
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

				trainingData = new ArrayList<String[]>();
				trainingSessionsMap = new HashMap<Integer, TrainingSession>();

				for(Map.Entry<Integer, TrainingInfo> lijst: listTrainingInfo.entrySet()) {

					try {
						totaalDagen = totaalDagen + TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getNumberOfDays();
						totaalPrijs = totaalPrijs + TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getPrice();
						trainingSessionsMap = TrainingSessionAccess.getByTrainingInfo(TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getTrainingId());
						trainingData.add(new String[] {
								TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getName(),
								String.valueOf(trainingSessionsMap.entrySet().iterator().next().getValue().getDate()),
								AddressAccess.get(trainingSessionsMap.entrySet().iterator().next().getValue().getAddressId()).getLocality(),
								String.valueOf(TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getNumberOfDays()),
								String.valueOf(TrainingInfoAccess.get(lijst.getValue().getTrainingId()).getPrice())
						});

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				lblTotalOfPrice.setText(String.valueOf(totaalPrijs));
				lblTotalOfDays.setText(String.valueOf(totaalDagen));

				if (listTrainingInfo.isEmpty()) {
					trainingData.add(new String[] {
							"No Training Followed Yet"	
					});
				}

				tableModel = new DefaultTableModel(trainingData.toArray(new Object[][] {}), columnheaderEmployeeStatistics) {
					@Override
					public boolean isCellEditable(int row, int column) {
						//all cells false
						return false;
					}
				};
				//tbEmployeeHistoryTraining = new JTable(tableModel);
				tbFollowedTrainingsEmployee.setModel(tableModel);
				//tbEmployeeHistoryTraining.setModel(defTableModelHistoryTraining);
				tbFollowedTrainingsEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbFollowedTrainingsEmployee.setRowSelectionAllowed(true);

				final TableColumnModel columnmodelTraining = tbFollowedTrainingsEmployee.getColumnModel();
				for (int column = 0; column < tbFollowedTrainingsEmployee.getColumnCount(); column++) {
					int width = 15; // Min width
					for (int row = 0; row < tbFollowedTrainingsEmployee.getRowCount(); row++) {
						TableCellRenderer renderer = tbFollowedTrainingsEmployee.getCellRenderer(row, column);
						Component comp = tbFollowedTrainingsEmployee.prepareRenderer(renderer, row, column);
						width = Math.max(comp.getPreferredSize().width +1 , width);
					}
					if(width > 300)
						width=300;
					columnmodelTraining.getColumn(column).setPreferredWidth(width);
				}

			}
		});

		btnShowEmployeeFollowedTrainings.setBounds(44, 310, 158, 45);
		add(btnShowEmployeeFollowedTrainings);

		lblNameFixed = new JLabel("Name:");
		lblNameFixed.setBounds(696, 141, 61, 16);
		add(lblNameFixed);

		JLabel lblExplanationOfTable = new JLabel("Employee took part in the following trainings");
		lblExplanationOfTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExplanationOfTable.setBounds(358, 132, 326, 33);
		add(lblExplanationOfTable);

		btnBackFollowedTrainingStatistics = new JButton("Back");
		btnBackFollowedTrainingStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// velden op blanco zetten
				lblTotalOfPrice.setText("");
				lblTotalOfDays.setText("");
				txtTrainingEmployeeID.setText("");
				lblName.setText("");
				lblFirstName.setText("");
				// bestaande tabel blanco op zetten!
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

			}
		});
		btnBackFollowedTrainingStatistics.setActionCommand("backFollowedToStatistics");
		btnBackFollowedTrainingStatistics.setBounds(44, 131, 144, 45);
		add(btnBackFollowedTrainingStatistics);

		txtTrainingEmployeeID = new JTextField();
		txtTrainingEmployeeID.setColumns(10);
		txtTrainingEmployeeID.setBounds(44, 267, 61, 33);
		add(txtTrainingEmployeeID);

		lblTotalOfDaysFixed = new JLabel("Total of Days:");
		lblTotalOfDaysFixed.setBounds(44, 379, 158, 16);
		add(lblTotalOfDaysFixed);

		lblTotalOfPrice = new JLabel("");
		lblTotalOfPrice.setBounds(204, 423, 115, 16);
		add(lblTotalOfPrice);

	}

	public void addActionListener(ActionListener listener) {
		btnShowEmployeeFollowedTrainings.addActionListener(listener);
		btnBackFollowedTrainingStatistics.addActionListener(listener);
		btnTraining.addActionListener(listener);
		btnStatistics.addActionListener(listener);
		btnEmployees.addActionListener(listener);
		btnTrainingsession.addActionListener(listener);
	}

}
