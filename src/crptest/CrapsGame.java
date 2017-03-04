/**
 *
 */
package crptest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Eric Lowrie
 * @version 0.1, September 2014
 * @version 0.2, October 2015
 *   Multiple gameplays in one program run added
 * Bob Loblaw's Blob Lobbed Low-Blown SoCal Low-Cal Calzone Zone
 */
public class CrapsGame {
	private final String PASS = "P";
	private final String DONTPASS = "D";
	private final String FIELD = "F";
	private final String ANYSEVEN = "A7";
	private final String COMEFOUR = "c4";
	private final String COMEFIVE = "c5";
	private final String COMESIX = "c6";
	private final String COMEEIGHT = "c8";
	private final String COMENINE = "c9";
	private final String COMETEN = "c10";
	private final String DONTCOMEFOUR = "dc4";
	private final String DONTCOMEFIVE = "dc5";
	private final String DONTCOMESIX = "dc6";
	private final String DONTCOMEEIGHT = "dc8";
	private final String DONTCOMENINE = "dc9";
	private final String DONTCOMETEN = "dc10";
	private final String COMEFOURODDS = "oc4";
	private final String COMEFIVEODDS = "oc5";
	private final String COMESIXODDS = "oc6";
	private final String COMEEIGHTODDS = "oc8";
	private final String COMENINEODDS = "oc9";
	private final String COMETENODDS = "oc10";
	private final String DONTCOMEFOURODDS = "odc4";
	private final String DONTCOMEFIVEODDS = "odc5";
	private final String DONTCOMESIXODDS = "odc6";
	private final String DONTCOMEEIGHTODDS = "odc8";
	private final String DONTCOMENINEODDS = "odc9";
	private final String DONTCOMETENODDS = "odc10";
	private final String NOBET = "N";

	private final int NORMALBET = 10;
	private final int SIXEIGHTODDBET = 12;
	public String filename;

	private int bankroll;
	private int wincondition;
	private int losecondition;
	private boolean allowrepeats;
	private int retainerbankroll;

	private String stratToUse;

	private Table tab;
	private Dice dice;
	private CrapsStrategy crapsstrategy;
	private OutputAnalysis outputanalysis;

	/**
	 * Main method that simply constructs an object of this class.
	 * Done to get out of the static method.
	 * @param args System arguments
	 */
	public static void main(String[] args) {
		new CrapsGame(args);
		//new CrapsStartScreen(this);
	}

	/**
	 * Constructor for the game object.
	 * In-line arguments have been replaced with GUI arguments, which players provide before starting simulation.
	 * @param args System arguments, provided from the main()
	 */
	public CrapsGame(String[] args) {
		new CrapsStartScreen(this);
	}

	/**
	 * Starts the simulation based on the user's input.
	 */
	public void startSimulation(int wincondition_input,
								int losecondition_input,
								int bankroll_input,
								boolean allowrepeats_input,
								String filename_input) {
		wincondition = wincondition_input;
		losecondition = losecondition_input;
		retainerbankroll = bankroll_input;
		allowrepeats = allowrepeats_input;

		tab = new Table();
		dice = new Dice();
		crapsstrategy = new CrapsStrategy(filename_input);
		outputanalysis = new OutputAnalysis( "FirstRunthrough.xls");
		outputanalysis.writeNextLine(1, 0, "Lowest $");
		outputanalysis.writeNextLine(2, 0, "Highest $");

		for(int i = 1; i <= 10000; i++)
		{
			if( i % 100 == 0 )
			{
				int percent = i / 100; // Testing another commit
				System.out.println(percent + "% complete");
			}
			gameplay(i);
		}
		outputanalysis.analytics();
		outputanalysis.writeToBook();
	}

	/**
	 * This method will focus on housing all aspects of gameplay.
	 */
	public void gameplay(int turnnumber) {
		//System.out.println("Evaluating game #" + turnnumber);
		String nextbet;
		int nextwager;
		int wagermultiplier = 1;
		int turns = 0;
		int roll = 0;

		int lowest = Integer.MAX_VALUE;
		int highest = Integer.MIN_VALUE;

		List<String> splitupbets = new ArrayList<String>();
		Iterator<String> itr;

		bankroll = retainerbankroll;

		//System.out.println("Welcome to the simulation! You are starting with $" + bankroll + ". Good luck!");
		// loop based on user-provided conditions
		// check for current bets
		// read strategy
		// place bet
		// shoot
		// payout
		// end loop
		while (bankroll > losecondition && bankroll < wincondition)
		{
			//System.out.println("Turn #" + ++turns + ", Bankroll of $" + bankroll);

			if (lowest > bankroll)
				lowest = bankroll;

			if (highest < bankroll)
				highest = bankroll;

			if (tab.anyActiveBets()) {
				stratToUse = crapsstrategy.getStrategy(tab.standingBets(), allowrepeats);
			} else {
				stratToUse = crapsstrategy.getStrategy("None", allowrepeats);
			}

			splitupbets = Arrays.asList(stratToUse.split("[,]"));
			// Thumb through the stratToUse
			// Expected format: 2P,F,A7,4o5,o10
			// Expected format: D,2F,6o10
			// Break up on comments, error check odds bets, multiply wagers, use $12 bet when needed
			itr = splitupbets.iterator();

			while (itr.hasNext()) {
				nextbet = itr.next();
				nextwager = NORMALBET;
				wagermultiplier = 1;

				if (Character.isDigit(nextbet.charAt(0)))
				{
					wagermultiplier = Integer.parseInt(nextbet.substring(0, 1));
					nextbet = nextbet.substring(1);
				}
				switch (nextbet.charAt(0)) {
					case 'P':
						nextwager *= wagermultiplier;
						tab.addBet(nextbet, nextwager);
						break;
					case 'D':
						nextwager *= wagermultiplier;
						tab.addBet(nextbet, nextwager);
						break;
					case 'A':
						nextwager *= wagermultiplier;
						tab.addBet(nextbet, nextwager);
						break;
					case 'o':
						if (nextbet.charAt(1) == '6' || nextbet.charAt(1) == '8')
							nextwager = SIXEIGHTODDBET;
						nextwager *= wagermultiplier;
						tab.addBet(nextbet, nextwager);
						break;
					case 'N':
						// No functionality needed for "No bet", but it's nice to keep here.
						break;
				}
			}

			//System.out.println("   Currently on the table: " + tab.standingBets());

			roll = dice.rollDice();
			//System.out.println("   The roll shows a " + roll);
			payoutShot(roll);
		}
		if (bankroll <= losecondition) {
			// Loser
			//System.out.println("LOSE LOSE LOSE after " + turns + " turns.");
			//System.out.println("The lowest you have gone is $" + lowest);
			//System.out.println("The highest you have gone is $" + highest);
			outputanalysis.writeNextLine(0, turnnumber, "LOSE");
			outputanalysis.writeNextLine(1, turnnumber, lowest);
			outputanalysis.writeNextLine(2, turnnumber, highest);
		} else {
			// Winner
			//System.out.println("WIN WIN WIN after " + turns + " turns.");
			//System.out.println("The lowest you have gone is $" + lowest);
			//System.out.println("The highest you have gone is $" + highest);
			outputanalysis.writeNextLine(0, turnnumber, "WIN");
			outputanalysis.writeNextLine(3, turnnumber, lowest);
			outputanalysis.writeNextLine(4, turnnumber, highest);
		}
	}


	/**
	 * Determines how each shot pays out by the following:
	 *  - Winning shots increase the bank roll, then are removed from the table
	 *  - Losing bets are simply removed from the table
	 *  - Established bets are added to the table
	 *
	 *  Payouts are the following:
	 *   - Field pays 2:1 on 2, 12 and 1:1 on 3, 4, 9, 10, 11
	 *   - Come Odds on 4, 10 pay 2:1
	 *   - Come Odds on 5, 9 pay 3:2
	 *   - Come Odds on 6, 8 pay 6:5
	 *   - Any Seven pays 4:1
	 *   - Don't Come Odds pay the opposite for each
	 * @param shot Number rolled by the dice. Between 2 and 12.
	 */
	public void payoutShot(int shot) {
		switch (shot)
		{
			case 2:
				// Pass Line loses
				bankroll -= tab.getWager(PASS);
				tab.removeBet(PASS);
				// Don't Pass Line wins 1:1
				bankroll += tab.getWager(DONTPASS);
				tab.removeBet(DONTPASS);
				// Field wins 2:1
				bankroll += (2 * tab.getWager(FIELD));
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				break;

			case 3:
				// Pass Line loses
				bankroll -= tab.getWager(PASS);
				tab.removeBet(PASS);
				// Don't Pass Line wins 1:1
				bankroll += tab.getWager(DONTPASS);
				tab.removeBet(DONTPASS);
				// Field wins 1:1
				bankroll += tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				break;

			case 4:
				// Come 4 wins 1:1
				bankroll += tab.getWager(COMEFOUR);
				tab.removeBet(COMEFOUR);
				// Come 4 odds wins 2:1
				bankroll += (2 * tab.getWager(COMEFOURODDS));
				tab.removeBet(COMEFOURODDS);
				// Don't Come 4 loses
				bankroll -= tab.getWager(DONTCOMEFOUR);
				tab.removeBet(DONTCOMEFOUR);
				// Don't Come 4 odds lose
				bankroll -= tab.getWager(DONTCOMEFOURODDS);
				tab.removeBet(DONTCOMEFOURODDS);
				// Field wins 1:1
				bankroll += tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to four
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMEFOUR, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to four
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMEFOUR, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 5:
				// Come 5 wins 1:1
				bankroll += tab.getWager(COMEFIVE);
				tab.removeBet(COMEFIVE);
				// Come 5 odds wins 3:2
				bankroll += ((3 * tab.getWager(COMEFIVEODDS)) / 2);
				tab.removeBet(COMEFIVEODDS);
				// Don't Come 5 loses
				bankroll -= tab.getWager(DONTCOMEFIVE);
				tab.removeBet(DONTCOMEFIVE);
				// Don't Come 5 odds lose
				bankroll -= tab.getWager(DONTCOMEFIVEODDS);
				tab.removeBet(DONTCOMEFIVEODDS);
				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to five
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMEFIVE, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to five
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMEFIVE, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 6:
				// Come 6 wins 1:1
				bankroll += tab.getWager(COMESIX);
				tab.removeBet(COMESIX);
				// Come 6 odds wins 6:5
				bankroll += ((6 * tab.getWager(COMESIXODDS)) / 5);
				tab.removeBet(COMESIXODDS);
				// Don't Come 6 loses
				bankroll -= tab.getWager(DONTCOMESIX);
				tab.removeBet(DONTCOMESIX);
				// Don't Come 6 odds lose
				bankroll -= tab.getWager(DONTCOMESIXODDS);
				tab.removeBet(DONTCOMESIXODDS);
				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to six
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMESIX, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to six
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMESIX, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 7:
				// Pass Line wins 1:1
				bankroll += tab.getWager(PASS);
				tab.removeBet(PASS);
				// Don't Pass Line loses
				bankroll -= tab.getWager(DONTPASS);
				tab.removeBet(DONTPASS);
				// All Come bets and Come odds lose
				bankroll -= tab.getWager(COMEFOUR);
				tab.removeBet(COMEFOUR);
				bankroll -= tab.getWager(COMEFIVE);
				tab.removeBet(COMEFIVE);
				bankroll -= tab.getWager(COMESIX);
				tab.removeBet(COMESIX);
				bankroll -= tab.getWager(COMEEIGHT);
				tab.removeBet(COMEEIGHT);
				bankroll -= tab.getWager(COMENINE);
				tab.removeBet(COMENINE);
				bankroll -= tab.getWager(COMETEN);
				tab.removeBet(COMETEN);
				bankroll -= tab.getWager(COMEFOURODDS);
				tab.removeBet(COMEFOURODDS);
				bankroll -= tab.getWager(COMEFIVEODDS);
				tab.removeBet(COMEFIVEODDS);
				bankroll -= tab.getWager(COMESIXODDS);
				tab.removeBet(COMESIXODDS);
				bankroll -= tab.getWager(COMEEIGHTODDS);
				tab.removeBet(COMEEIGHTODDS);
				bankroll -= tab.getWager(COMENINEODDS);
				tab.removeBet(COMENINEODDS);
				bankroll -= tab.getWager(COMETENODDS);
				tab.removeBet(COMETENODDS);
				// All Don't Come bets win 1:1
				bankroll += tab.getWager(DONTCOMEFOUR);
				tab.removeBet(DONTCOMEFOUR);
				bankroll += tab.getWager(DONTCOMEFIVE);
				tab.removeBet(DONTCOMEFIVE);
				bankroll += tab.getWager(DONTCOMESIX);
				tab.removeBet(DONTCOMESIX);
				bankroll += tab.getWager(DONTCOMEEIGHT);
				tab.removeBet(DONTCOMEEIGHT);
				bankroll += tab.getWager(DONTCOMENINE);
				tab.removeBet(DONTCOMENINE);
				bankroll += tab.getWager(DONTCOMETEN);
				tab.removeBet(DONTCOMETEN);
				// Don't Come 4 wins 1:2
				bankroll += (tab.getWager(DONTCOMEFOURODDS) / 2);
				tab.removeBet(DONTCOMEFOURODDS);
				// Don't Come 5 wins 2:3
				bankroll += ((2 * tab.getWager(DONTCOMEFIVEODDS)) / 3);
				tab.removeBet(DONTCOMEFIVEODDS);
				// Don't Come 6 wins 5:6
				bankroll += ((5 * tab.getWager(DONTCOMESIXODDS)) / 6);
				tab.removeBet(DONTCOMESIXODDS);
				// Don't Come 8 wins 5:6
				bankroll += ((5 * tab.getWager(DONTCOMEEIGHTODDS)) / 6);
				tab.removeBet(DONTCOMEEIGHTODDS);
				// Don't Come 9 wins 2:3
				bankroll += ((2 * tab.getWager(DONTCOMENINEODDS)) / 3);
				tab.removeBet(DONTCOMENINEODDS);
				// Don't Come 10 wins 1:2
				bankroll += (tab.getWager(DONTCOMETENODDS) / 2);
				tab.removeBet(DONTCOMETENODDS);

				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven wins 4:1
				bankroll += (4 * tab.getWager(ANYSEVEN));
				tab.removeBet(ANYSEVEN);
				break;

			case 8:
				// Come 8 wins 1:1
				bankroll += tab.getWager(COMEEIGHT);
				tab.removeBet(COMEEIGHT);
				// Come 8 odds wins 6:5
				bankroll += ((6 * tab.getWager(COMEEIGHTODDS)) / 5);
				tab.removeBet(COMEEIGHTODDS);
				// Don't Come 8 loses
				bankroll -= tab.getWager(DONTCOMEEIGHT);
				tab.removeBet(DONTCOMEEIGHT);
				// Don't Come 8 odds lose
				bankroll -= tab.getWager(DONTCOMEEIGHTODDS);
				tab.removeBet(DONTCOMEEIGHTODDS);
				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to eight
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMEEIGHT, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to eight
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMEEIGHT, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 9:
				// Come 9 wins 1:1
				bankroll += tab.getWager(COMENINE);
				tab.removeBet(COMENINE);
				// Come 5 odds wins 3:2
				bankroll += ((3 * tab.getWager(COMENINEODDS)) / 2);
				tab.removeBet(COMENINEODDS);
				// Don't Come 5 loses
				bankroll -= tab.getWager(DONTCOMENINE);
				tab.removeBet(DONTCOMENINE);
				// Don't Come 5 odds lose
				bankroll -= tab.getWager(DONTCOMENINEODDS);
				tab.removeBet(DONTCOMENINEODDS);
				// Field loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				// Field wins 1:1
				bankroll += tab.getWager(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(FIELD);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to nine
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMENINE, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to nine
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMENINE, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 10:
				// Come 4 wins 1:1
				bankroll += tab.getWager(COMETEN);
				tab.removeBet(COMETEN);
				// Come 4 odds wins 2:1
				bankroll += (2 * tab.getWager(COMETENODDS));
				tab.removeBet(COMETENODDS);
				// Don't Come 4 loses
				bankroll -= tab.getWager(DONTCOMETEN);
				tab.removeBet(DONTCOMETEN);
				// Don't Come 4 odds lose
				bankroll -= tab.getWager(DONTCOMETENODDS);
				tab.removeBet(DONTCOMETENODDS);
				// Field wins 1:1
				bankroll += tab.getWager(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);

				// Pass Line moves point to ten
				if (tab.getWager(PASS) > 0)
					tab.addBet(COMETEN, tab.getWager(PASS));
				tab.removeBet(PASS);
				// Don't Pass Line moves point to ten
				if (tab.getWager(DONTPASS) > 0)
					tab.addBet(DONTCOMETEN, tab.getWager(DONTPASS));
				tab.removeBet(DONTPASS);
				break;

			case 11:
				// Pass Line wins 1:1
				bankroll += tab.getWager(PASS);
				tab.removeBet(PASS);
				// Don't Pass Line loses
				bankroll -= tab.getWager(DONTPASS);
				tab.removeBet(DONTPASS);
				// Field wins 1:1
				bankroll += tab.getWager(FIELD);
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				break;

			case 12:
				// Pass Line loses
				bankroll -= tab.getWager(PASS);
				tab.removeBet(PASS);
				// Field wins 2:1
				bankroll += (2 * tab.getWager(FIELD));
				tab.removeBet(FIELD);
				// Any Seven loses
				bankroll -= tab.getWager(ANYSEVEN);
				tab.removeBet(ANYSEVEN);
				break;

			default:
				System.err.println("payoutShot() provided with an invalid number. Number provided: " + shot);
				System.exit(-101);
				break;
		}
	}

	/**
	 * Inner class that represents the craps table.
	 * Logically, this object "holds" all the bets.
	 * @author MikeLowrie
	 *
	 */
	class Table {
		private Map<String, Integer> tab;

		public Table() {
			tab = new HashMap<String, Integer>();
		}

		/**
		 * Method for determining if there are currently any bets on the table.
		 * @return True if there are bets (the map has at least one key), false otherwise
		 */
		public boolean anyActiveBets() {
			return !tab.isEmpty();
		}

		/**
		 * Method that places a bet on the table.
		 * @param bet Bet that is being placed
		 * @param dollars Amount riding on bet being placed
		 * @return True if the bet is placed, false otherwise
		 */
		public boolean addBet(String bet, Integer dollars) {
			try {
				if (bet.charAt(0) == 'o')
					addOddsBet(bet, dollars);
				else if (!tab.containsKey(bet))
					tab.put(bet, dollars);
				else
					throw new Exception("Bet already in place: " + bet);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
			return true;
		}

		/**
		 * Internal method that has special functionality in the case that an odds bet is placed.
		 * Checks if there is a come bet or don't come bet, then places odds on the correct one(s).
		 * @param bet Odds bet that is being placed
		 * @param dollars Amount riding on bet(s) placed
		 * @return True if the bet is placed, false otherwise
		 */
		private boolean addOddsBet(String bet, Integer dollars) {
			try {
				int oddspoint = Integer.parseInt(bet.substring(1));
				if (tab.containsKey("c" + oddspoint))
					tab.put("oc" + oddspoint, dollars);
				if (tab.containsKey("dc" + oddspoint))
					tab.put("odc" + oddspoint, dollars);
			} catch (NumberFormatException e) {
				System.err.println("Having trouble gathering the number value from " + bet + ". Unexpected behavior in addOddsBet().");
				return false;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return true;
		}

		/**
		 * Method that gets the riding wager on a bet.
		 * @param bet Bet to identify wager for
		 * @return The dollar amount riding on a bet, 0 if there if the bet isn't placed.
		 */
		public Integer getWager(String bet) {
			if (tab.containsKey(bet))
				return tab.get(bet);
			return 0;
		}

		/**
		 * Method that removes a standing bet.
		 * @param bet Bet to be removed
		 * @return True if the bet was removed, false otherwise
		 */
		public boolean removeBet(String bet) {
			try {
				if (tab.containsKey(bet))
				{
					tab.remove(bet);
				}
				else
					throw new Exception("Bet is not currently on the table: " + bet);
			} catch (Exception e) {
				// Write up an exception statement
				//System.err.println(e.getMessage());
				return false;
			}
			return true;
		}

		/**
		 * Method that gathers the current bets that are on the table.
		 *
		 * This method as version 1 could probably be written better than a bunch of if-else statements.
		 * Look into rewriting this upon a version update.
		 *
		 * @return String containing bets on table
		 */
		public String standingBets() {
			// Return string expected in following format:
			// D4D10C4C10
			// Low-to-high Don't Come bets BEFORE low-to-high Come bets
			String currentbets = "";

			// Comma intentionally added in every case; first character is removed before return
			if (tab.containsKey(DONTCOMEFOUR))
				currentbets = currentbets + ",D4";
			if (tab.containsKey(DONTCOMEFIVE)) 
				currentbets = currentbets + ",D5";
			if (tab.containsKey(DONTCOMESIX))
				currentbets = currentbets + ",D6";
			if (tab.containsKey(DONTCOMEEIGHT))
				currentbets = currentbets + ",D8";
			if (tab.containsKey(DONTCOMENINE))
				currentbets = currentbets + ",D9";
			if (tab.containsKey(DONTCOMETEN))
				currentbets = currentbets + ",D10";
			if (tab.containsKey(COMEFOUR))
				currentbets = currentbets + ",C4";
			if (tab.containsKey(COMEFIVE))
				currentbets = currentbets + ",C5";
			if (tab.containsKey(COMESIX))
				currentbets = currentbets + ",C6";
			if (tab.containsKey(COMEEIGHT))
				currentbets = currentbets + ",C8";
			if (tab.containsKey(COMENINE))
				currentbets = currentbets + ",C9";
			if (tab.containsKey(COMETEN))
				currentbets = currentbets + ",C10";

			if (currentbets.length() > 0)
				return currentbets.substring(1);
			return "None";
		}
	}
}
