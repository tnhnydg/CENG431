package hardware;

public abstract class RAM implements HardwareDevice {
	private int capacity;

	public RAM() {}
	
	public abstract int getCost();
	public abstract String ToString();
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
