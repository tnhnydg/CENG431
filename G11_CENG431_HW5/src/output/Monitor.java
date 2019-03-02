package output;

public abstract class Monitor implements OutputDevice{
	private int inch;
	
	public Monitor() {}

	public abstract int getCost();
	public abstract String ToString();
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	
}
