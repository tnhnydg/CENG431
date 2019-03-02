package input;

public abstract class Mouse implements InputDevice {
	private boolean isWireless;

	public Mouse() {}
	
	public abstract int getCost();
	public abstract String ToString();
	
	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}
}
