package output;

import java.util.Random;

public class HeadphoneGCF extends Headphone{
	private int cost;
	
	public HeadphoneGCF() {
		setWireless(detWireless());
		setHasMicrophone(true);
		setCost(detCost());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public boolean detWireless() {
		int n = getRandInt(0,1);
		if(n == 0) {return false;}
		else {return true;}
	}
	
	public int detCost() {
		return getRandInt(600, 1900);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "HeadphoneGCF("+isWireless()+", "+isHasMicrophone()+")";
	}
}
