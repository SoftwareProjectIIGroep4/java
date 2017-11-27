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
import javax.swing.JTable;
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

public class TrainingSessionPeopleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDepartment;
	private JTextField txtFunction;
	private JTable tbBook;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingSessionPeopleFrame frame = new TrainingSessionPeopleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TrainingSessionPeopleFrame() {
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
		
		Object [] columnHeadersBook = {"Employee name","Department","Function","Status"};
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
		
	    
		JScrollPane sclBook = new JScrollPane(tbBook);
		sclBook.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclBook.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclBook.setBounds(30, 230, 840, 430);
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
		lblBackBorder.setBounds(20, 220, 860, 450);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
		
		txtName = new JTextField();
		txtName.setBounds(910, 260, 300, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(910, 235, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDepartment.setBounds(910, 306, 100, 14);
		contentPane.add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setBounds(910, 331, 300, 25);
		contentPane.add(txtDepartment);
		txtDepartment.setColumns(10);
		
		JLabel lblFunction = new JLabel("Function:");
		lblFunction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFunction.setBounds(910, 377, 100, 14);
		contentPane.add(lblFunction);
		
		txtFunction = new JTextField();
		txtFunction.setBounds(910, 402, 300, 25);
		contentPane.add(txtFunction);
		txtFunction.setColumns(10);
		
		JLabel lblBackBorder2 = new JLabel("");
		lblBackBorder2.setBounds(900, 220, 350, 450);
		lblBackBorder2.setBorder(border);
		contentPane.add(lblBackBorder2);
		
	}

}
