/**
 *
 */
package crptest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.*;

/**
 * @author MikeLowrie
 * Goal of this class is to allow for the use of a GUI instead of using
 * command line arguments. Dude, it's 2017. Write code like it.
 */
public class CrapsStartScreen {
// TEST
	final String NOFILESELECTED = "No file selected.";

	CrapsGame cg;

	JFrame frame;
	JPanel filechoicepanel;
	JPanel bankrollpanel;
	JPanel winconditionpanel;
	JPanel loseconditionpanel;
	JPanel startsimulationpanel;
	JPanel allowrepeatspanel;
	JPanel usermessagepanel;
	JButton filechoicebtn;
	JButton startsimulationbtn;
	JFileChooser fc;
	JCheckBox allowrepeatscheck;
	JLabel filenamelabel;
	JLabel bankrolllabel;
	JLabel winconditionlabel;
	JLabel loseconditionlabel;
	JLabel usermessagelabel;
	JTextField bankrolltextfield;
	JTextField winconditiontextfield;
	JTextField loseconditiontextfield;

	/**
	 *
	 */
	public CrapsStartScreen(CrapsGame crapsgame) {
		cg = crapsgame;
		buildBankrollPanel();
		buildWinConditionPanel();
		buildLoseConditionPanel();
		buildFileChoicePanel();
		buildAllowRepeatsPanel();
		buildStartSimulationPanel();
		buildUserMessagePanel();

		frame = new JFrame("Craps Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1));

		frame.add(bankrollpanel);
		frame.add(winconditionpanel);
		frame.add(loseconditionpanel);
		frame.add(allowrepeatspanel);
		frame.add(filechoicepanel);
		frame.add(startsimulationpanel);
		frame.add(usermessagepanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	/**
	 * Creates the bank roll GUI components.
	 */
	public void buildBankrollPanel() {
		bankrolllabel = new JLabel("Bankroll:");
		bankrolltextfield = new JTextField("1000", 4);
		bankrolltextfield.setHorizontalAlignment(JTextField.RIGHT);

		bankrollpanel = new JPanel();
		bankrollpanel.add(bankrolllabel);
		bankrollpanel.add(bankrolltextfield);
	}

	/**
	 * Creates the win condition GUI components.
	 */
	public void buildWinConditionPanel() {
		winconditionlabel = new JLabel("Win condition:");
		winconditiontextfield = new JTextField("1200", 4);
		winconditiontextfield.setHorizontalAlignment(JTextField.RIGHT);

		winconditionpanel = new JPanel();
		winconditionpanel.add(winconditionlabel);
		winconditionpanel.add(winconditiontextfield);
	}

	/**
	 * Creates the lose condition GUI components.
	 */
	public void buildLoseConditionPanel() {
		loseconditionlabel = new JLabel("Lose condition:");
		loseconditiontextfield = new JTextField("800", 4);
		loseconditiontextfield.setHorizontalAlignment(JTextField.RIGHT);

		loseconditionpanel = new JPanel();
		loseconditionpanel.add(loseconditionlabel);
		loseconditionpanel.add(loseconditiontextfield);
	}

	/**
	 * Creates the file chooser GUI components.
	 */
	public void buildFileChoicePanel() {
		filechoicebtn = new JButton("Choose strategy...");
		filechoicebtn.addActionListener(new FileButtonListener());

		fc = new JFileChooser();

		filenamelabel = new JLabel(NOFILESELECTED);

		filechoicepanel = new JPanel();
		filechoicepanel.add(filechoicebtn);
		filechoicepanel.add(filenamelabel);
	}

	/**
	 * Creates the allow repeats GUI components.
	 */
	public void buildAllowRepeatsPanel() {
		allowrepeatscheck = new JCheckBox("Allow repeats");

		allowrepeatspanel = new JPanel();
		allowrepeatspanel.add(allowrepeatscheck);
	}

	/**
	 * Creates the start simulation GUI components.
	 */
	public void buildStartSimulationPanel() {
		startsimulationbtn = new JButton("Start simulation");
		startsimulationbtn.addActionListener(new StartSimulationListener());

		startsimulationpanel = new JPanel();
		startsimulationpanel.add(startsimulationbtn);
	}

	/**
	 * Creates the user message GUI components.
	 */
	public void buildUserMessagePanel() {
		usermessagelabel = new JLabel("Select your starting conditions.");

		usermessagepanel = new JPanel();
		usermessagepanel.add(usermessagelabel);
	}

	/**
	 * StartSimulatorListener class allows the user to start the program, and checks that the
	 * correct data has been input before beginning, such as an actual file.
	 * @author MikeLowrie
	 *
	 */
	private class StartSimulationListener implements ActionListener {
		int wincondition;
		int losecondition;
		int bankroll;
		boolean allowrepeats;
		String filename;

		public void actionPerformed(ActionEvent e) {
			if(!this.isUserError()) {
				allowrepeats = allowrepeatscheck.isSelected();

				cg.startSimulation(wincondition, losecondition, bankroll, allowrepeats, filename);
			}
		}

		/**
		 * Checks for user error before moving forward, to make sure the program behaves as expected. Common errors
		 * would be having a lose condition greater than the win condition.
		 * @return True if there is an error in the information the user provided, false otherwise.
		 */
		private boolean isUserError() {
		    try {
		    	wincondition = Integer.parseInt(winconditiontextfield.getText());
		    } catch (NumberFormatException e) {
		    	usermessagelabel.setText("Win condition is not a number.");
		    	return true;
		    }

		    try {
		    	losecondition = Integer.parseInt(loseconditiontextfield.getText());
		    } catch (NumberFormatException e) {
		    	usermessagelabel.setText("Lose condition is not a number.");
		    	return true;
		    }

		    try {
		    	bankroll = Integer.parseInt(bankrolltextfield.getText());
		    } catch (NumberFormatException e) {
		    	usermessagelabel.setText("Bankroll is not a number.");
		    	return true;
		    }


		    filename = filenamelabel.getText();
		    String fileextension = filename.substring(filename.lastIndexOf('.'));
		    if(filename.equals(NOFILESELECTED)) {
		    	usermessagelabel.setText("Please select a strategy file.");
		    	return true;
		    } else if(!(fileextension.equals(".xls")||fileextension.equals(".xlsx"))) {
		    	usermessagelabel.setText("Use an Excel file for strategy.");
		    	return true;
		    }

		    if(wincondition <= losecondition) {
		    	usermessagelabel.setText("Lose condition must be lower than win condition.");
		    	return true;
		    }

		    if(wincondition <= bankroll) {
		    	usermessagelabel.setText("Bankroll must be lower than win condition.");
		    	return true;
		    }

		    if(bankroll <= losecondition) {
		    	usermessagelabel.setText("Lose condition must be lower than bankroll.");
		    	return true;
		    }

		    usermessagelabel.setText("");
			return false;
		}
	}
	
	/**
	 * FileButtonListener class allows the user to select a file for their craps strategy.
	 * @author MikeLowrie
	 *
	 */
	private class FileButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if(event.getSource() == filechoicebtn) {
					int value = fc.showOpenDialog(filechoicepanel);

					if(value == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						filenamelabel.setText(file.getName());
					} else {
						filenamelabel.setText("No file selected.");
					}
				}
				} catch (Exception e) {
					System.err.println("Failure on loading File Button.");
					System.exit(-101);
				}
		}
	}
}
