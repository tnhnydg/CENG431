package input;

import java.util.Random;

public abstract class Keyboard implements InputDevice{
	private int numberOfKeys;
	private boolean hasBacklight;
	
	public Keyboard() {}
	
	public abstract int getCost();
	public abstract String ToString();
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	
	public int getNumberOfKeys() {
		return numberOfKeys;
	}
	public void setNumberOfKeys(int numberOfKeys) {
		this.numberOfKeys = numberOfKeys;
	}
	public boolean isHasBacklight() {
		return hasBacklight;
	}
	public void setHasBacklight(boolean hasBacklight) {
		this.hasBacklight = hasBacklight;
	}
	
	
}
