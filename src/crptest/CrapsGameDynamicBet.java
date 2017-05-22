package crptest;

import java.util.ArrayList;
import java.util.Map;

public class CrapsGameDynamicBet {
	private ArrayList<CrapsBet> activebets;
	private Map<ArrayList<CrapsBet>, Integer> everycombinationbet;
	private CrapsList crapslist;
	private ArrayList<CrapsBet> everysinglebet;
	private CrapsExcelReader cer;

	private String filename;

	private int bankroll;
	private int tableminimum;

	public CrapsGameDynamicBet() {
		// @TODO: Actually assign a filename
		cer = new CrapsExcelReader(filename);
		// cer.AssignEverySingleBet(everysinglebet);
		createCombinations(everysinglebet, new ArrayList<CrapsBet>(), 0);
	}

	private CrapsCombination determineNextBet() {

		// Strip away 'flexible' bets to increase available bankroll
		ArrayList<CrapsBet> nextbets = activebets;
		for(CrapsBet bet : nextbets) {
			if(!bet.getIsFlexible()) {
				nextbets.remove(bet);
				// @TODO: Increase bankroll by removing these bets
			}
		}

		// Find all bets that you can afford
		CrapsCombination marker = crapslist.getListHead();
		CrapsList availablelist = new CrapsList();
		while(marker.investment < this.bankroll) {
			availablelist.insertLast(marker);
			marker = marker.next;
		}

		// Locate bet with highest differential
		CrapsCombination bestbet = availablelist.getListHead();
		ArrayList<CrapsCombination> bestbets = new ArrayList<CrapsCombination>();
		while(bestbet != null) {
			if(bestbets.isEmpty()) {
				bestbets.add(bestbet);
			} else if(bestbet.differential > bestbets.get(0).differential) {
				bestbets.clear();
				bestbets.add(bestbet);
			} else if(bestbet.differential = bestbets.get(0).differential) {
				bestbets.add(bestbet);
			}
		}

		// Pick bet with lowest bankroll contribution
		// @TODO: Implement ways to allow user to choose desired contribution
		CrapsCombination bettouse = bestbet.get(0);
		for(CrapsCombination betcheck : bestbets) {
			if(betcheck.investment < bettouse.investment) {
				bettouse = betcheck;
			}
		}

		return bettouse;
	}

	private void createCombinations(ArrayList<CrapsBet> input, ArrayList<CrapsBet> output, int index, int jndex) {
		// jndex used to allow multiples of bets, such as 2x table minimum on Field
		for(int i = index; i < input.size(); i++) {
			output.add(input.get(i));
			//Integer investment = getRequiredInvestment(output);
			crapslist.sortedInsert(new CrapsCombination(getRequiredInvestment(output), output));
			//everycombinationbet.put(output, investment);
			if(jndex < 10) {
				createCombinations(input, output, i, ++jndex);
			}
			createCombinations(input, output, ++index);
			output.remove(output.size() - 1);
		}
	}
	//http://stackoverflow.com/questions/8965926/algorithm-to-generate-all-combinations-of-a-string

	private int getRequiredInvestment(ArrayList<CrapsBet> bets) {
		int investment = 0;
		for(CrapsBet bet : bets) {
			invesment += bet.getInvestment();
		}
		return investment;
	}
}
