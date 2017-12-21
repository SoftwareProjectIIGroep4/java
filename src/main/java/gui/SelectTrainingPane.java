package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

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
import javax.swing.table.TableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.itextpdf.kernel.pdf.filters.IFilterHandler;

import models.TrainingInfo;
import models.TrainingSession;

public class SelectTrainingPane extends JPanel {
	
	private JTable tbTraining;
	private JButton btnBack;
	private JButton btnMakeTrainingSession;
	private int selectedRow;
	private DefaultTableModel modelTraining,tableModel;
	TrainingPane trainingPane;
	////////////////////////////////
	private ConcurrentMap<Integer, TrainingInfo> listTraingInfo=dataAccess.Cache.trainingInfoCache.asMap();
	
	////////////////////////////////

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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(1071, 175, 172, 60);
		btnBack.setActionCommand("BackToTrainingPane");
		add(btnBack);
		
		btnMakeTrainingSession = new JButton("Make training session");
		btnMakeTrainingSession.setBounds(1071, 90, 172, 60);
		btnMakeTrainingSession.setActionCommand("MakeTrainingSession");
		add(btnMakeTrainingSession);
		
		Object [] columnHeadersTraining = {"Title","Number of Days","Price"};
		modelTraining = new DefaultTableModel();
		modelTraining.setColumnIdentifiers(columnHeadersTraining);
		List<String[]> data1 = new ArrayList<String[]>();
		
		for (Map.Entry<Integer, TrainingInfo>  entry : listTraingInfo.entrySet()) {
			if (entry.getValue().getTrainingId()==MainFrame.getKeeper()) {
			data1.add(new String[] {
					entry.getValue().getName(),
					String.valueOf(entry.getValue().getNumberOfDays()),
					String.valueOf(entry.getValue().getPrice())
					}
			
					
			);
			}
		}
		
		   tableModel = new DefaultTableModel(data1.toArray(new Object[][] {}), columnHeadersTraining) {
		   

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tbTraining = new JTable(tableModel);
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
		sclTraining.setBounds(20, 56, 1010, 563);
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
		lblBackBorder.setBounds(10, 47, 1030, 580);
		lblBackBorder.setBorder(border);
		add(lblBackBorder);
	}
	
	public void addActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
		btnMakeTrainingSession.addActionListener(listener);
    }
	
	public int getSelectedRow() {
		return selectedRow;
	}

	public DefaultTableModel getModelTraining() {
		return modelTraining;
	}

	public ConcurrentMap<Integer, TrainingInfo> getListTraingInfo() {
		return listTraingInfo;
	}

	public void setListTraingInfo(ConcurrentMap<Integer, TrainingInfo> listTraingInfo) {
		this.listTraingInfo = listTraingInfo;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	

	

}
