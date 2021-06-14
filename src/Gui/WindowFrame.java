package Gui;

import javax.swing.*;

import Manager.LedgerManager;

public class WindowFrame extends JFrame{
	
	LedgerManager ledgerManager;
	MenuSelection menuselection;
	LedgerAdder adder;
	LedgerViewer viewer;

	public WindowFrame(LedgerManager ledgerManager) {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.ledgerManager = ledgerManager;
		menuselection = new MenuSelection(this);
		adder = new LedgerAdder(this, this.ledgerManager);
		viewer = new LedgerViewer(this, this.ledgerManager);
		
		this.setupPanel(menuselection);
		
		this.setVisible(true);
	}

	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuselection() {
		return menuselection;
	}

	public void setMenuselection(MenuSelection menuselection) {
		this.menuselection = menuselection;
	}

	public LedgerAdder getAdder() {
		return adder;
	}

	public void setAdder(LedgerAdder adder) {
		this.adder = adder;
	}

	public LedgerViewer getViewer() {
		return viewer;
	}

	public void setViewer(LedgerViewer viewer) {
		this.viewer = viewer;
	}
	
}
