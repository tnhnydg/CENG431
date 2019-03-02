package output;

public abstract class Headphone implements OutputDevice {
	private boolean isWireless;
	private boolean hasMicrophone;
	
	public Headphone() {}
	
	public abstract int getCost();
	public abstract String ToString();
	
	public boolean isWireless() {
		return isWireless;
	}
	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}
	public boolean isHasMicrophone() {
		return hasMicrophone;
	}
	public void setHasMicrophone(boolean hasMicrophone) {
		this.hasMicrophone = hasMicrophone;
	}
}
