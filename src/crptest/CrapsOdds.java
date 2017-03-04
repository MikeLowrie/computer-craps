/**
 * 
 */
package crptest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

/**
 * @author MikeLowrie
 * Goal of this class is to create a dialog that allows the user to select different
 * payouts on certain bets. Depending on the table a player plays at, the payouts can
 * be higher or lower, and this will allow the player to replicate that variance.
 */
public class CrapsOdds {

	CrapsGame cg;
	JFrame frame;
	
	JPanel mainpanel;
	JPanel fieldtwoodds;
	JPanel fieldthreeodds;
	JPanel fieldtwelveodds;
	JPanel okcancelpanel;
	
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
	JLabel fieldtwelvelabel;
	ButtonGroup fieldtwelvebuttongroup;
	JRadioButton fieldtwelvesinglepayout;
	JRadioButton fieldtwelvedoublepayout;
	JRadioButton fieldtwelvetriplepayout;
	
	JButton okbtn;
	JButton cancelbtn;
	
	/**
	 * Dialog for selecting the payout of various bets, which can vary when playing different tables in real casinos.
	 * @param cg
	 */
	public CrapsOdds(CrapsGame cg) {
		this.cg = cg;
		
		frame = new JFrame("Craps Solver Custom Odds");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fieldlabel = new JLabel("Field Payout:");
		
		buildFieldTwoPanel();
		buildFieldThreePanel();
		buildFieldTwelvePanel();
		
		buildOKAndCancelButtons();
		
		setMainLayout();
		setFrameLayout();
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	/**
	 * Creates the GUI components for the Field: Two odds selector.
	 */
	private void buildFieldTwoPanel() {
		// Build components
		fieldtwoodds = new JPanel();
		fieldtwolabel = new JLabel("Two");
		fieldtwobuttongroup = new ButtonGroup();
		fieldtwosinglepayout = new JRadioButton("1:1");
		fieldtwodoublepayout = new JRadioButton("2:1");
		fieldtwotriplepayout = new JRadioButton("3:1");
		fieldtwobuttongroup.add(fieldtwosinglepayout);
		fieldtwobuttongroup.add(fieldtwodoublepayout);
		
		// Set layout
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
	 * Creates the GUI components for the Field: Three odds selector.
	 */
	private void buildFieldThreePanel() {
		// Build components
		fieldthreeodds = new JPanel();
		fieldthreelabel = new JLabel("Three");
		fieldthreebuttongroup = new ButtonGroup();
		fieldthreesinglepayout = new JRadioButton("1:1");
		fieldthreedoublepayout = new JRadioButton("2:1");
		fieldthreebuttongroup.add(fieldthreesinglepayout);
		fieldthreebuttongroup.add(fieldthreedoublepayout);
		
		// Set layout
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
	 * Creates the GUI components for the Field: Twelve odds selector.
	 */
	private void buildFieldTwelvePanel() {
		// Build components
		fieldtwelveodds = new JPanel();
		fieldtwelvelabel = new JLabel("Twelve");
		fieldtwelvebuttongroup = new ButtonGroup();
		fieldtwelvesinglepayout = new JRadioButton("1:1");
		fieldtwelvedoublepayout = new JRadioButton("2:1");
		fieldtwelvetriplepayout = new JRadioButton("3:1");
		fieldtwelvebuttongroup.add(fieldtwelvesinglepayout);
		fieldtwelvebuttongroup.add(fieldtwelvedoublepayout);
		
		// Set layout
		GroupLayout layout = new GroupLayout(fieldtwelveodds);
		fieldtwelveodds.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(fieldtwelvelabel)
						.addComponent(fieldtwelvesinglepayout)
						.addComponent(fieldtwelvedoublepayout)
						.addComponent(fieldtwelvetriplepayout)));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldtwelvelabel)
				.addComponent(fieldtwelvesinglepayout)
				.addComponent(fieldtwelvedoublepayout)
				.addComponent(fieldtwelvetriplepayout));
	}
	
	/**
	 * Creates the GUI components for the OK and Cancel buttons.
	 */
	private void buildOKAndCancelButtons() {
		// Build components
		okcancelpanel = new JPanel();
		okbtn = new JButton("OK");
		okbtn.addActionListener(new OddsActionListener());
		cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(new OddsActionListener());
		
		okcancelpanel.add(okbtn);
		okcancelpanel.add(cancelbtn);
		okcancelpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	/**
	 * 
	 */
	private void setMainLayout() {
		mainpanel = new JPanel();
		GroupLayout layout = new GroupLayout(mainpanel);
		mainpanel.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldtwoodds)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(fieldlabel)
					.addComponent(fieldthreeodds))
				.addComponent(fieldtwelveodds));
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(fieldlabel)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(fieldtwoodds)
						.addComponent(fieldthreeodds)
						.addComponent(fieldtwelveodds)));
	}
	
	/**
	 * Sets the layout of the entire frame, using GroupLayout.
	 */
	private void setFrameLayout() {
		frame.add(mainpanel, BorderLayout.CENTER);
		frame.add(okcancelpanel, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @author MikeLowrie
	 *
	 */
	private class OddsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if(event.getSource() == okbtn) {
					// TODO: Add functionality to assign odds values to program
					frame.dispose();
				} else if(event.getSource() == cancelbtn) {
					frame.dispose();
				}
			} catch (Exception e) {
				System.err.println("Error on Odds dialog!");
			}
		}
		
	}
}
