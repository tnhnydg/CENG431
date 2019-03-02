package hardware;

import java.util.Random;

public class CpuGCF extends CPU{
	private int cost;
	
	public CpuGCF() {
		setVersion(detVersion());
		setFrequency(detFrequency());
		setCost(detCost());
		
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public CpuVersion detVersion() {
		int n = getRandInt(0, 1);
		if(n == 0) {return CpuVersion.i5;}
		else {return CpuVersion.i7;}
	}
	
	public double detFrequency() {
		int n = getRandInt(0, 2);
		if(n == 0) {return 3.4;}
		else if(n == 1) {return 4.4;}
		else {return 5.4;}
	}
	
	public int detCost() {
		return getRandInt(14000, 24000);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String ToString() {
		return "CpuGCF("+getVersion()+", "+getFrequency()+")";
	}

}
