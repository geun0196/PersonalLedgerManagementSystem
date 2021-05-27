package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LedgerViewer extends JFrame{

	public LedgerViewer() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kind");
		model.addColumn("Date");
		model.addColumn("Add");
		model.addColumn("Use");
		model.addColumn("Where");
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
