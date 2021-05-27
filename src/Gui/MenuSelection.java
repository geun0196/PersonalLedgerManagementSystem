package Gui;

import javax.swing.*;
import java.awt.*;

public class MenuSelection extends JFrame{
	
	public MenuSelection() {
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(290,300);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Menu Selection");
		
		JButton add = new JButton("Add Ledger");
		JButton delete = new JButton("Delete Ledger");
		JButton edit = new JButton("Edit Ledger");
		JButton view = new JButton("View Ledgers");
		JButton exit = new JButton("Exit");
		
		panel1.add(label);
		panel2.add(add);
		panel2.add(delete);
		panel2.add(edit);
		panel2.add(view);
		panel2.add(exit);

		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
