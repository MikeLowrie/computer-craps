/**
 * 
 */
package crptest;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author MikeLowrie
 *
 */
public class CrapsOdds {

	CrapsGame cg;
	JFrame frame;
	JPanel fieldodds;
	JCheckBox fieldthreesinglepayout;
	JCheckBox fieldthreedoublepayout;
	
	/**
	 * 
	 * @param cg
	 */
	public CrapsOdds(CrapsGame cg) {
		this.cg = cg;
		
		frame = new JFrame("Craps Solver Custom Odds");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setFrameLayout();
		
		fieldodds = new JPanel();
		fieldthreesinglepayout = new JCheckBox("1:1");
		fieldthreedoublepayout = new JCheckBox("2:1");
		this.setFrameLayout();

		frame.add(fieldodds);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void setFrameLayout() {
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
		
		GroupLayout layout = new GroupLayout(fieldodds);
		fieldodds.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldthreesinglepayout)
				.addComponent(fieldthreedoublepayout));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(fieldthreesinglepayout)
					.addComponent(fieldthreedoublepayout)));
		
	}
}
