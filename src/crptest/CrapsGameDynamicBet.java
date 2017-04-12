package crptest;

import java.util.ArrayList;
import java.util.Map;

public class CrapsGameDynamicBet {
	private ArrayList<CrapsBet> activebets;
	private Map<ArrayList<CrapsBet>, Integer> everycombinationbet;
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
		// @TODO: Handle flexible bets
		
	}
	
	private void createCombinations(ArrayList<CrapsBet> input, ArrayList<CrapsBet> output, int index) {
		// @TODO: Create separate scenarios for bets that do not require minimum.
		//        What if you WANT to put the table minimum on Hardway instead of just a dollar?
		for(int i = index; i < input.size(); i++) {
			output.add(input.get(i));
			//everycombinationbet.add(output.get(output.size() - 1));
			Integer investment = getRequiredInvestment(output);
			everycombinationbet.put(output, investment);
			createCombinations(input, output, ++index);
			output.remove(output.size() - 1);
		}
	}
	//http://stackoverflow.com/questions/8965926/algorithm-to-generate-all-combinations-of-a-string
	
	private int getRequiredInvestment(ArrayList<CrapsBet> bets) {
		int investment = 0;
		for(CrapsBet bet : bets) {
			if(bet.requiresMinimum()) {
				investment += tableminimum;
			} else {
				investment++;
			}
		}
		return investment;
	}
}
