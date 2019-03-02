package hardware;

import java.util.Random;

public class RamRCF extends RAM {
	private int cost;
	
	public RamRCF() {
		setCapacity(detCapacity());
		setCost(detCost());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detCapacity() {
		int n = getRandInt(0, 2);
		if(n == 0) {return 32;}
		else if(n == 1) {return 64;}
		else {return 128;}
	}

	public int detCost() {
		return getRandInt(1500, 3500);
	}
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "RamRCF("+getCapacity()+")";
	}
}
