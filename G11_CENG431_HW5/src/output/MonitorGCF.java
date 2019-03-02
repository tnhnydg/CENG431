package output;

import java.util.Random;

public class MonitorGCF extends Monitor {
	private int cost;
	
	public MonitorGCF() {
		setInch(detInch());;
		setCost(detCost());
	}
	
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public int detInch() {
		int n = getRandInt(0,3);
		if(n == 0) {return 18;}
		else if(n == 1) {return 21;}
		else if(n == 2) {return 25;}
		else {return 27;}
	}
	
	public int detCost() {
		return getRandInt(2500, 3500);
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}

	public String ToString() {
		return "MonitorGCF("+getInch()+")";
	}
}
