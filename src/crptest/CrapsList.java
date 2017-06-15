package crptest;

http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
public class CrapsList {
  private CrapsCombination headoflist;

  public CrapsList() {
    headoflist = new CrapsCombination();
  }

  public class CrapsCombination {
      public int investment;
      public double differential;
      public CrapsCombination next;
      public ArrayList<CrapsBet> betcombination;

      public CrapsCombination(int investment, ArrayList<CrapsBet> betcombination) {
        this.investment = investment;
        this.betcombination = betcombination;
        next = null;
        this.differential = this.assignDifferential();
      }

      public CrapsCombination() {
        this.investment = 0;
        this.betcombination = new ArrayList<CrapsBet>();
        next = null;
        this.differential = 0.0;
      }

      private double assignDifferential() {
        diff = 0.0;
        for(CrapsBet cb : this.betcombination) {
          diff += cb.getDifferential();
        }
        return diff;
      }
  }

  /**
   * Bets are sorted by investment, not differential.
   */
  public void insertSorted(CrapsCombination newcombo) {
    CrapsCombination current;

    if(headoflist == null || headoflist.investment >= newcombo.investment) {
      newcombo.next = headoflist;
      headoflist = newcombo;
    } else {
      current = headoflist;

      while(current.next != null && current.next.investment < newcombo.investment) {
        current = current.next;
      }

      newcombo.next = current.next;
      current.next = newcombo;
    }
  }

  /**
   * Insert the combination at the end of the list
   */
  public void insertLast(CrapsCombination newcombo) {

  }

  public CrapsCombination newCombination(int investment) {
    CrapsCombination obj = new CrapsCombination(investment);
    return obj;
  }

  public CrapsCombination getListHead() {
    return this.head;
  }
}
