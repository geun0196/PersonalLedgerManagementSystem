package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

import Gui.LedgerViewer;
import Gui.WindowFrame;
import Manager.LedgerManager;

public class ButtonViewListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonViewListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LedgerViewer ledgerviewer = frame.getViewer();
		LedgerManager ledgerManager = getObject("ledgermanager.ser");
		ledgerviewer.setLedgerManager(ledgerManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(ledgerviewer);
		frame.revalidate();
		frame.repaint();
	}
	
	public static LedgerManager getObject(String filename) {
		LedgerManager ledgerManager = null; 
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			ledgerManager = (LedgerManager) in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return ledgerManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ledgerManager;
	}
}
