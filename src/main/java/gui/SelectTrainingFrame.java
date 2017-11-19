package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SelectTrainingFrame extends JFrame {

	private JPanel contentPane;
	private JTable tbTraining;


	/**
	 * Create the frame.
	 */
	public SelectTrainingFrame() {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectTraining = new JLabel("Select Training");
		lblSelectTraining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectTraining.setBounds(10, 11, 250, 25);
		contentPane.add(lblSelectTraining);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 638, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnMakeTrainingSession = new JButton("Make training session");
		btnMakeTrainingSession.setBounds(410, 638, 150, 23);
		contentPane.add(btnMakeTrainingSession);
		
		Object [] columnHeadersTraining = {"Title","Number of Days","Price"};
		DefaultTableModel modelTraining = new DefaultTableModel();
		modelTraining.setColumnIdentifiers(columnHeadersTraining);
		Object[][] data = {

		};
		tbTraining = new JTable(data, columnHeadersTraining);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnHeadersTraining) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbTraining.setModel(tableModel);
		tbTraining.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTraining.setRowSelectionAllowed(true);
	    final TableColumnModel columnmodelTraining = tbTraining.getColumnModel();
	    for (int column = 0; column < tbTraining.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < tbTraining.getRowCount(); row++) {
	            TableCellRenderer renderer = tbTraining.getCellRenderer(row, column);
	            Component comp = tbTraining.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnmodelTraining.getColumn(column).setPreferredWidth(width);
	    }
		JScrollPane sclTraining = new JScrollPane(tbTraining);
		sclTraining.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sclTraining.setBounds(20, 59, 530, 560);
		contentPane.add(sclTraining);
		ListSelectionModel selectedRowBook = tbTraining.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					int selectedRow = selectedRowBook.getMinSelectionIndex();
					//doe iets hier
				}
			}
		});
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(10, 47, 550, 580);
		lblBackBorder.setBorder(border);
		contentPane.add(lblBackBorder);
	}
}
