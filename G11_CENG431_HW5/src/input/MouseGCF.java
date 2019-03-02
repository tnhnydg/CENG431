package input;

import java.util.Random;

public class MouseGCF extends Mouse{
	private int cost;
	
	public MouseGCF() {
		setWireless(false);
		setCost(detCost());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detCost() {
		return getRandInt(300,850);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "MouseGCF("+isWireless()+")";
	}
	
	
	
}
