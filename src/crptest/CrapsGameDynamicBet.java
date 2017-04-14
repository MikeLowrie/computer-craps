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

	private void determineNextBet() {
		ArrayList<CrapsBet> nextbets = activebets;
		for(CrapsBet bet : nextbets) {
			if(!bet.getIsFlexible()) {
				nextbets.remove(bet);
			}
		}
		ArrayList<CrapsBet> availablebets;
		for()
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
