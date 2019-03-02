package input;

import java.util.Random;

public class MouseRCF extends Mouse{
	private int cost;
	
	public MouseRCF() {
		setWireless(true);
		setCost(detCost());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detCost() {
		return getRandInt(27,78);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String ToString() {
		return "MouseRCF("+isWireless()+")";
	}
}
