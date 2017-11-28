package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

public class TrainingSessionBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable tbBook;
	
	/**
	 * Create the frame.
	 */
	public TrainingSessionBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblTraining = new JLabel("Training");
		lblTraining.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTraining.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTraining.setBorder(null);
			}
		});
		lblTraining.setBackground(Color.WHITE);
		lblTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraining.setOpaque(true);
		lblTraining.setBounds(133, 0, 211, 75);
		contentPane.add(lblTraining);
		
		JLabel lblTrainingSession = new JLabel("Training session");
		lblTrainingSession.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrainingSession.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTrainingSession.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionFrame newFrame = new TrainingSessionFrame();
				newFrame.setVisible(true);
			}
		});
		lblTrainingSession.setBackground(Color.WHITE);
		lblTrainingSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainingSession.setOpaque(true);
		lblTrainingSession.setBounds(344, 0, 211, 75);
		contentPane.add(lblTrainingSession);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEmployees.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEmployees.setBorder(null);
			}
		});
		lblEmployees.setBackground(Color.WHITE);
		lblEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployees.setOpaque(true);
		lblEmployees.setBounds(555, 0, 212, 75);
		contentPane.add(lblEmployees);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStatistics.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblStatistics.setBorder(null);
			}
		});
		lblStatistics.setBackground(Color.WHITE);
		lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistics.setOpaque(true);
		lblStatistics.setBounds(767, 0, 212, 75);
		contentPane.add(lblStatistics);
		
		JLabel lblTrainingRequests = new JLabel("Training requests");
		lblTrainingRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrainingRequests.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTrainingRequests.setBorder(null);
			}
		});
		lblTrainingRequests.setBackground(Color.WHITE);
		lblTrainingRequests.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainingRequests.setOpaque(true);
		lblTrainingRequests.setBounds(979, 0, 211, 75);
		contentPane.add(lblTrainingRequests);
		
		JLabel lblNewLabel = new JLabel("logo");
		lblNewLabel.setBounds(0, 0, 133, 75);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Profiel");
		lblNewLabel_1.setBounds(1190, 0, 75, 75);
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnBack = new JButton("<-  Back");
		
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TrainingSessionFrame newFrame = new TrainingSessionFrame();
				newFrame.setVisible(true);
			}
		});
		
		btnBack.setBounds(30, 100, 110, 50);
		contentPane.add(btnBack);
		
		JLabel lblTrainingSessionTitle = new JLabel("Training session title");
		lblTrainingSessionTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingSessionTitle.setBounds(175, 115, 300, 25);
		contentPane.add(lblTrainingSessionTitle);
		
		JButton btnCancelTrainingSession = new JButton("Cancel training session");
		btnCancelTrainingSession.setBounds(1039, 100, 200, 50);
		contentPane.add(btnCancelTrainingSession);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBackground(SystemColor.control);
		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblInfo.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionInfoFrame newFrame = new TrainingSessionInfoFrame();
				newFrame.setVisible(true);
			}
		});
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setOpaque(true);
		lblInfo.setBounds(450, 165, 100, 50);
		contentPane.add(lblInfo);
		
		JLabel lblEnlistedPeople = new JLabel("Enlisted people");
		lblEnlistedPeople.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblEnlistedPeople.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEnlistedPeople.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionPeopleFrame newFrame = new TrainingSessionPeopleFrame();
				newFrame.setVisible(true);
		}});
		lblEnlistedPeople.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnlistedPeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnlistedPeople.setOpaque(true);
		lblEnlistedPeople.setBounds(550, 165, 200, 50);
		contentPane.add(lblEnlistedPeople);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBooks.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBooks.setBackground(SystemColor.control);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TrainingSessionBookFrame newFrame = new TrainingSessionBookFrame();
				newFrame.setVisible(true);
			}
		});
		lblBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBooks.setBounds(750, 165, 100, 50);
		lblBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooks.setOpaque(true);
		contentPane.add(lblBooks);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(100, 230, 250, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblResearch = new JLabel("Research:");
		lblResearch.setBounds(30, 233, 70, 14);
		contentPane.add(lblResearch);
		
		Object [] columnHeadersBook = {"isbn","Title","Author","Price","Publisher"};
		DefaultTableModel modelBook = new DefaultTableModel();
		modelBook.setColumnIdentifiers(columnHeadersBook);
		Object[][] data = {

		};
		tbBook = new JTable(data, columnHeadersBook);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersBook) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbBook.setModel(tableModel);
		tbBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//tbBook.setEnabled(false);
		tbBook.setRowSelectionAllowed(true);
		//tbBook.setModel(modelBook);
		//https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	    final TableColumnModel columnModelBook = tbBook.getColumnModel();
	    for (int column = 0; column < tbBook.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbBook.getRowCount(); row++) {
	            TableCellRenderer renderer = tbBook.getCellRenderer(row, column);
	            Component comp = tbBook.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModelBook.getColumn(column).setPreferredWidth(width);
	    }
		
		/*tbBook.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbBook.getColumnModel().getColumn(0).setPreferredWidth(100);
		tbBook.getColumnModel().getColumn(1).setPreferredWidth(284);
		tbBook.getColumnModel().getColumn(2).setPreferredWidth(283);
		tbBook.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbBook.getColumnModel().getColumn(4).setPreferredWidth(283);*/
		//tbBook.setBounds(30, 258, 1000, 400);
	    
		JScrollPane sclBook = new JScrollPane(tbBook);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 258, 1200, 400);
		contentPane.add(sclBook);
		ListSelectionModel selectedRowBook = tbBook.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					lblTrainingSessionTitle.setText(String.valueOf(selectedRow));
				}
			}
		});
		
		JLabel lblBackBorder = new JLabel("");
		
		lblBackBorder.setBounds(20, 220, 1220, 450);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
	}
	
}

