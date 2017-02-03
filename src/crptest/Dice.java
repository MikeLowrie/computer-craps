package crptest;

public class Dice {
	private int dieone;
	private int dietwo;
	
	public Dice() {
		dieone = 0;
		dietwo = 0;
	}
	
	public int rollDice() {
		dieone = (int)(Math.random() * 6.0);
		dietwo = (int)(Math.random() * 6.0);
		
		if (dieone + dietwo > 12 || dieone + dietwo < 2)
			return rollDice();
		else
			return dieone + dietwo;
	}
}
