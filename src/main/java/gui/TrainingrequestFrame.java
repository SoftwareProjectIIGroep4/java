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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;


public class TrainingrequestFrame extends JFrame {

	private JPanel contentPane;
	private JTable tbTrainingrequest;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Create the frame.
	 */
	public TrainingrequestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
		// create a line border with the specified color and width
		
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
        
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
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
				EmployeeFrame employeeFr = new EmployeeFrame();
				employeeFr.setVisible(true);
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
        
        JLabel lblListOfRequested = new JLabel("List of requested trainings (click on the requests in the list to get more information)");
        lblListOfRequested.setBounds(30, 102, 644, 38);
        contentPane.add(lblListOfRequested);
        
        
        Object [] columnHeadersBook = {"Employee name","Training name","Country","City"};
		DefaultTableModel modelBook = new DefaultTableModel();
		modelBook.setColumnIdentifiers(columnHeadersBook);
		Object[][] data = {

		};
		tbTrainingrequest = new JTable(data, columnHeadersBook);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersBook) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbTrainingrequest.setModel(tableModel);
		tbTrainingrequest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//tbBook.setEnabled(false);
		tbTrainingrequest.setRowSelectionAllowed(true);
		//tbBook.setModel(modelBook);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelBook = tbTrainingrequest.getColumnModel();
	    for (int column = 0; column < tbTrainingrequest.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbTrainingrequest.getRowCount(); row++) {
	            TableCellRenderer renderer = tbTrainingrequest.getCellRenderer(row, column);
	            Component comp = tbTrainingrequest.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelBook.getColumn(column).setPreferredWidth(width);
	    }
		
	    
		JScrollPane sclBook = new JScrollPane(tbTrainingrequest);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 145, 840, 525);
		contentPane.add(sclBook);
		ListSelectionModel selectedRowBook = tbTrainingrequest.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					lblListOfRequested.setText(String.valueOf(selectedRow));
				}
			}
		});
        
        JLabel lblNewLabel_2 = new JLabel("Filters");
        lblNewLabel_2.setBounds(890, 202, 162, 30);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Training name");
        lblNewLabel_3.setBounds(914, 308, 133, 30);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(914, 267, 178, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Country");
        lblNewLabel_4.setBounds(914, 383, 134, 16);
        contentPane.add(lblNewLabel_4);
        
        textField_1 = new JTextField();
        textField_1.setBounds(914, 345, 178, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("City");
        lblNewLabel_5.setBounds(914, 448, 134, 30);
        contentPane.add(lblNewLabel_5);
        
        textField_2 = new JTextField();
        textField_2.setBounds(914, 410, 178, 30);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Employee name");
        lblNewLabel_6.setBounds(914, 239, 178, 30);
        contentPane.add(lblNewLabel_6);
        
        textField_3 = new JTextField();
        textField_3.setBounds(914, 477, 178, 30);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel TrainingreqBorder = new JLabel("");
        TrainingreqBorder.setBounds(880, 230, 374, 440);
        TrainingreqBorder.setBorder(border1);
        contentPane.add(TrainingreqBorder);

  
	}
}