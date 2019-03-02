package hardware;

public abstract class CPU implements HardwareDevice {
	private CpuVersion version;
	private double frequency;
	
	public CPU() {}
	
	public abstract int getCost();
	public abstract String ToString();
	
	public CpuVersion getVersion() {
		return version;
	}
	public void setVersion(CpuVersion version) {
		this.version = version;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
}
