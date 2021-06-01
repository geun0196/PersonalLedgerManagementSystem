package Gui;

import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Ledger.LedgerInput;
import Manager.LedgerManager;

public class LedgerViewer extends JPanel{

	WindowFrame frame;
	LedgerManager ledgerManager;
	
	public LedgerViewer(WindowFrame frame, LedgerManager ledgerManager) {
		this.frame = frame;
		this.ledgerManager = ledgerManager;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kind");
		model.addColumn("Date");
		model.addColumn("Add");
		model.addColumn("Use");
		model.addColumn("Where");
		
		for(int i = 0; i<ledgerManager.size(); i++) {
			Vector row = new Vector();
			LedgerInput li = ledgerManager.get(i); 
			row.add(li.getKind());
			row.add(li.getDate());
			row.add(li.getHowMuchAdd());
			row.add(li.getHowMuchUse());
			row.add(li.getWhereUse());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}
}
