package input;

import java.util.Random;

public class KeyboardGCF extends Keyboard {
	private int cost;
	
	public KeyboardGCF() {
		setHasBacklight(true);
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
		return getRandInt(500,1500);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "KeyboardGCF("+getNumberOfKeys()+" keys, "+isHasBacklight()+")";
	}
}
