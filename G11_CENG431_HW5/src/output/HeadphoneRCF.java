package output;

import java.util.Random;

public class HeadphoneRCF extends Headphone{
	private int cost;
	
	public HeadphoneRCF() {
		setWireless(detWireless());
		setHasMicrophone(false);
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
		return getRandInt(40, 400);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String ToString() {
		return "HeadphoneRCF("+isWireless()+", "+isHasMicrophone()+")";
	}
}
