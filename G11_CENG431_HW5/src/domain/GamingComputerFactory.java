package domain;

import hardware.CPU;
import hardware.CpuGCF;
import hardware.RAM;
import hardware.RamGCF;
import input.Keyboard;
import input.KeyboardGCF;
import input.Mouse;
import input.MouseGCF;
import output.Headphone;
import output.HeadphoneGCF;
import output.Monitor;
import output.MonitorGCF;

public class GamingComputerFactory implements ComputerDevicesFactory {
	public CPU manufactureCPU() {return new CpuGCF(); }
	public RAM manufactureRAM() {return new RamGCF(); }
	public Keyboard manufactureKeyboard() {return new KeyboardGCF(); }
	public Mouse manufactureMouse() {return new MouseGCF(); }
	public Headphone manufactureHeadPhone() {return new HeadphoneGCF(); }
	public Monitor manufactureMonitor() {return new MonitorGCF(); }
	public String ToString() {return "Gaming";}
}
