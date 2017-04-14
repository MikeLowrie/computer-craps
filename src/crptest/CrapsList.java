package crptest;

http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
public class CrapsList {
  public CrapsCombination headoflist;

  public class CrapsCombination {
      public int investment;
      public CrapsCombination next;
      public ArrayList<CrapsBet> betcombination;

      public CrapsCombination(int investment, ArrayList<CrapsBet> betcombination) {
        this.investment = investment;
        this.betcombination = betcombination;
        next = null;
      }
  }

  public void sortedInsert(CrapsCombination newcombo) {
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

  public CrapsCombination newCombination(int investment) {
    CrapsCombination obj = new CrapsCombination(investment);
    return obj;
  }
}
