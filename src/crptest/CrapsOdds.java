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
	
	JPanel fieldtwoodds;
	JPanel fieldthreeodds;
	
	JLabel fieldlabel;
	JLabel fieldtwolabel;
	ButtonGroup fieldtwobuttongroup;
	JRadioButton fieldtwosinglepayout;
	JRadioButton fieldtwodoublepayout;
	JRadioButton fieldtwotriplepayout;
	JLabel fieldthreelabel;
	ButtonGroup fieldthreebuttongroup;
	JRadioButton fieldthreesinglepayout;
	JRadioButton fieldthreedoublepayout;
	
	/**
	 * 
	 * @param cg
	 */
	public CrapsOdds(CrapsGame cg) {
		this.cg = cg;
		
		frame = new JFrame("Craps Solver Custom Odds");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setFrameLayout();
		
		fieldtwoodds = new JPanel();
		fieldthreeodds = new JPanel();
		
		fieldlabel = new JLabel("Field Payout:");
		
		buildFieldTwoPanel();
		buildFieldThreePanel();

		//frame.add(fieldtwoodds);
		//frame.add(fieldthreeodds);
		
		this.setFrameLayout();
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void buildFieldTwoPanel() {
		fieldtwolabel = new JLabel("Two");
		fieldtwobuttongroup = new ButtonGroup();
		fieldtwosinglepayout = new JRadioButton("1:1");
		fieldtwodoublepayout = new JRadioButton("2:1");
		fieldtwotriplepayout = new JRadioButton("3:1");
		fieldtwobuttongroup.add(fieldtwosinglepayout);
		fieldtwobuttongroup.add(fieldtwodoublepayout);
		
		setFieldTwoPanelLayout();
	}
	
	/**
	 * 
	 */
	private void setFieldTwoPanelLayout() {
		GroupLayout layout = new GroupLayout(fieldtwoodds);
		fieldtwoodds.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(fieldtwolabel)
						.addComponent(fieldtwosinglepayout)
						.addComponent(fieldtwodoublepayout)
						.addComponent(fieldtwotriplepayout)));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldtwolabel)
				.addComponent(fieldtwosinglepayout)
				.addComponent(fieldtwodoublepayout)
				.addComponent(fieldtwotriplepayout));
	}
	
	/**
	 * 
	 */
	private void buildFieldThreePanel() {
		fieldthreelabel = new JLabel("Three");
		fieldthreebuttongroup = new ButtonGroup();
		fieldthreesinglepayout = new JRadioButton("1:1");
		fieldthreedoublepayout = new JRadioButton("2:1");
		fieldthreebuttongroup.add(fieldthreesinglepayout);
		fieldthreebuttongroup.add(fieldthreedoublepayout);
		
		setFieldThreePanelLayout();
	}

	/**
	 * 
	 */
	private void setFieldThreePanelLayout() {
		GroupLayout layout = new GroupLayout(fieldthreeodds);
		fieldthreeodds.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(fieldthreelabel)
						.addComponent(fieldthreesinglepayout)
						.addComponent(fieldthreedoublepayout)));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldthreelabel)
				.addComponent(fieldthreesinglepayout)
				.addComponent(fieldthreedoublepayout));
	}
	
	/**
	 * 
	 */
	private void setFrameLayout() {
		//https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldtwoodds)
				.addComponent(fieldthreeodds));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(fieldtwoodds)
						.addComponent(fieldthreeodds)));
	}
}
