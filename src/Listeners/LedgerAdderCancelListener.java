package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Gui.LedgerAdder;
import Gui.LedgerViewer;
import Gui.WindowFrame;

public class LedgerAdderCancelListener implements ActionListener {

	WindowFrame frame;
	
	public LedgerAdderCancelListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselection());
		frame.revalidate();
		frame.repaint();
	}

}
