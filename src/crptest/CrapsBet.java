

public class CrapsBet {

  private boolean[] winningroles;
  private boolean[] losingroles;

  private int investment; // How much is needed to make this bet?
  private boolean isflexible;

  public CrapsBet(int investment, boolean isflexible, int[] winners, int[] losers) {
    this.investment = investment;
    this.isflexible = isflexible;

    // Assign win and loss conditions
    // Lazy coding: 2 dice can only get values 2-12, make 0-1 false and use 12 as your array size
    winningroles = new boolean[12];
    losingroles = new boolean[12];

    for(int i = 0; i < 13; i++) {
      winningroles[i] = false;
      losingroles[i] = false;
    }

    for(int win : winners) {
      winningroles[win] = true;
    }

    for(int lose : losers) {
      losingroles[lose] = true;
    }

  }
}
