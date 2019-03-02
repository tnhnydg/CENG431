package output;

import java.util.Random;

public class MonitorRCF extends Monitor{
	private int cost;
	
	public MonitorRCF() {
		setInch(detInch());;
		setCost(detCost());
	}
	
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detInch() {
		int n = getRandInt(0,1);
		if(n == 0) {return 18;}
		else {return 21;}
	}
	
	public int detCost() {
		return getRandInt(900, 1500);
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "MonitorRCF("+getInch()+")";
	}
}
