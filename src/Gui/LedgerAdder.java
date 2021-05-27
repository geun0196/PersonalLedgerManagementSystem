package Gui;

import javax.swing.*;

public class LedgerAdder extends JFrame{

	public LedgerAdder() {
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelMymoney = new JLabel("My money : ", JLabel.TRAILING);
		JLabel labelMymoney2 = new JLabel();
		//labelMymoney.setLabelFor(labelMymoney2);
		panel.add(labelMymoney);
		panel.add(labelMymoney2);
		
		JLabel labelID = new JLabel("Date : ", JLabel.TRAILING);
		JTextField fieldID = new JTextField(10);
		labelID.setLabelFor(fieldID);
		panel.add(labelID);
		panel.add(fieldID);
		
		JLabel labelHowMuch = new JLabel("How Much : ", JLabel.TRAILING);
		JTextField fieldHowMuch = new JTextField(10);
		labelHowMuch.setLabelFor(fieldHowMuch);
		panel.add(labelHowMuch);
		panel.add(fieldHowMuch);
		
		JLabel labelWhere = new JLabel("Where : ", JLabel.TRAILING);
		JTextField fieldWhere = new JTextField(10);
		labelWhere.setLabelFor(fieldWhere);
		panel.add(labelWhere);
		panel.add(fieldWhere);
		
		JButton save = new JButton("Save");
		JButton close = new JButton("Close");
		
		panel.add(save);
		panel.add(close);
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6);
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
