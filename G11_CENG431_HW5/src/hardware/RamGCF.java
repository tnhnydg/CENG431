package hardware;

import java.util.Random;

public class RamGCF extends RAM {
	private int cost;
	
	public RamGCF() {
		setCapacity(detCapacity());
		setCost(detCost());
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detCapacity() {
		int n = getRandInt(0, 1);
		if(n == 0) {return 128;}
		else {return 256;}
	}

	public int detCost() {
		return getRandInt(7000, 19000);
	}
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "RamGCF("+getCapacity()+")";
	}
}
