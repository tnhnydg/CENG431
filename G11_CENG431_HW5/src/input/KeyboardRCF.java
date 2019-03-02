package input;

import java.util.Random;

public class KeyboardRCF extends Keyboard {
	private int cost;

	public KeyboardRCF() {
		setHasBacklight(false);
		setCost(detCost());
		setNumberOfKeys(detNumberOfKeys());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detNumberOfKeys() {
		return getRandInt(84,108);
	}
	
	public int detCost() {
		return getRandInt(80,450);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String ToString() {
		return "KeyboardRCF("+getNumberOfKeys()+" keys, "+isHasBacklight()+")";
	}
}
