package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import Exceptions.DateformatException;
import Ledger.*;
import Manager.LedgerManager;

public class LedgerAdderListener implements ActionListener {

	JTextField fieldDate;
	JTextField fieldHowMuchAdd;
	JTextField fieldHowMuchUse;
	JTextField fieldWhere;
	LedgerManager ledgerManager;
	
	public LedgerAdderListener(
			JTextField fieldDate, 
			JTextField fieldHowMuchAdd, 
			JTextField fieldHowMuchUse,
			JTextField fieldWhere,
			LedgerManager ledgerManager) {
		this.fieldDate = fieldDate;
		this.fieldHowMuchAdd = fieldHowMuchAdd;
		this.fieldHowMuchUse = fieldHowMuchUse;
		this.fieldWhere = fieldWhere;
		this.ledgerManager = ledgerManager;
	}

	public int getFieldHowMuchAdd() {
		return Integer.parseInt(fieldHowMuchAdd.getText());
	}

	public void setFieldHowMuchAdd(JTextField fieldHowMuchAdd) {
		this.fieldHowMuchAdd = fieldHowMuchAdd;
	}
	
	public int getFieldHowMuchUse() {
		return Integer.parseInt(fieldHowMuchUse.getText());
	}

	public void setFieldHowMuchUse(JTextField fieldHowMuchUse) {
		this.fieldHowMuchUse = fieldHowMuchUse;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LedgerInput ledger = new PersonalLedger(LedgerKind.Personal);
		try {
			ledger.setDate(fieldDate.getText());
			ledger.setHowMuchAdd(Integer.parseInt(fieldHowMuchAdd.getText()));
			ledger.setHowMuchUse(Integer.parseInt(fieldHowMuchUse.getText()));
			ledger.setWhereUse(fieldWhere.getText());
			Ledger.money = Ledger.money + (getFieldHowMuchAdd());
			Ledger.money = Ledger.money - (getFieldHowMuchUse());
			ledgerManager.putset();
			ledgerManager.addledger(ledger);
			putObject(ledgerManager, "ledgermanager.ser");
			ledger.printinfo();
			
		} catch (DateformatException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void putObject(LedgerManager ledgerManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(ledgerManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
