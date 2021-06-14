package Gui;

import javax.swing.*;
import Ledger.*;
import Listeners.LedgerAdderCancelListener;
import Listeners.LedgerAdderListener;
import Manager.LedgerManager;

public class LedgerAdder extends JPanel{

	WindowFrame frame;
	LedgerManager ledgerManager;
	
	public LedgerAdder(WindowFrame frame, LedgerManager ledgerManager) {
		this.frame = frame;
		this.ledgerManager = ledgerManager;
		
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelMymoney = new JLabel("My money : ", JLabel.TRAILING);
		JLabel labelMymoney2 = new JLabel();
		labelMymoney2.setText(Integer.toString(Ledger.money));
		panel.add(labelMymoney);
		panel.add(labelMymoney2);
		
		JLabel labelDate = new JLabel("Date : ", JLabel.TRAILING);
		JTextField fieldDate = new JTextField(10);
		labelDate.setLabelFor(fieldDate);
		panel.add(labelDate);
		panel.add(fieldDate);
		
		JLabel labelHowMuchAdd = new JLabel("How Much Add: ", JLabel.TRAILING);
		JTextField fieldHowMuchAdd = new JTextField(10);
		labelHowMuchAdd.setLabelFor(fieldHowMuchAdd);
		panel.add(labelHowMuchAdd);
		panel.add(fieldHowMuchAdd);
		
		JLabel labelHowMuchUse = new JLabel("How Much Use: ", JLabel.TRAILING);
		JTextField fieldHowMuchUse = new JTextField(10);
		labelHowMuchUse.setLabelFor(fieldHowMuchUse);
		panel.add(labelHowMuchUse);
		panel.add(fieldHowMuchUse);
		
		JLabel labelWhere = new JLabel("Where : ", JLabel.TRAILING);
		JTextField fieldWhere = new JTextField(10);
		labelWhere.setLabelFor(fieldWhere);
		panel.add(labelWhere);
		panel.add(fieldWhere);
		
		JButton save = new JButton("Save");
		save.addActionListener(new LedgerAdderListener(fieldDate,fieldHowMuchAdd, fieldHowMuchUse,fieldWhere, ledgerManager));
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new LedgerAdderCancelListener(frame));
		
		panel.add(save);
		panel.add(cancel);
		
		SpringUtilities.makeCompactGrid(panel, 6, 2, 6, 6, 6, 6);
		
		this.add(panel);
	}
}
