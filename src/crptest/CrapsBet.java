/**
 * 
 */
package crptest;

public class CrapsBet {

  private double[][] betspectrum;
  private int investment; // How much is needed to make this bet?
  private boolean isflexible;
  private boolean requiresminimum; // Does this bet need to at least meet the table minimum? Hardways, prop bets do NOT have to.
  private String name;

  public CrapsBet(double[][] betspectrum, int investment, boolean isflexible, boolean requiresminimum, String name) {
	this.betspectrum = betspectrum;
	this.investment = investment;
    this.isflexible = isflexible;
    this.requiresminimum = requiresminimum;
    this.name = name;
  }
  
  /**
   * Retrieves the odds that will result from this bet hitting a specific combination of dice.
   * @param firstdie Number on first die
   * @param seconddie Number on second die
   * @return The payout odds of this bet, based on the dice roll
   */
  public double getPayout(int firstdie, int seconddie) {
	 return betspectrum[firstdie][seconddie]; 
  }
  
  /**
   * Simple getter method to return this bet's name.
   * @return Name of this bet
   */
  public String getName() {
	  return this.name;
  }
  
  public boolean requiresMinimum() {
	  return this.requiresminimum;
  }
}
