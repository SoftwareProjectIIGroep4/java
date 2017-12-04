package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class SelectTrainingPane extends JPanel {
	
	private JTable tbTraining;
	private JButton btnCancel;
	private JButton btnMakeTrainingSession;
	private int selectedRow;

	/**
	 * Create the panel.
	 */
	public SelectTrainingPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblSelectTraining = new JLabel("Select Training");
		lblSelectTraining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectTraining.setBounds(10, 11, 250, 25);
		add(lblSelectTraining);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 638, 89, 23);
		btnCancel.setActionCommand("Cancel");
		add(btnCancel);
		
		btnMakeTrainingSession = new JButton("Make training session");
		btnMakeTrainingSession.setBounds(410, 638, 150, 23);
		btnMakeTrainingSession.setActionCommand("MakeTrainingSession");
		add(btnMakeTrainingSession);
		
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
		add(sclTraining);
		ListSelectionModel selectedRowBook = tbTraining.getSelectionModel();
		selectedRowBook.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedRowBook.isSelectionEmpty()) {
					//GET ROW
					selectedRow = selectedRowBook.getMinSelectionIndex();
				}
			}
		});
		
		JLabel lblBackBorder = new JLabel("");
		lblBackBorder.setBounds(10, 47, 550, 580);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
	}
	
	public void addActionListener(ActionListener listener) {
		btnCancel.addActionListener(listener);
		btnMakeTrainingSession.addActionListener(listener);
    }
	
	public int getSelectedRow() {
		return selectedRow;
	}

}