package domain;

import hardware.CPU;
import hardware.CpuRCF;
import hardware.RAM;
import hardware.RamRCF;
import input.Keyboard;
import input.KeyboardRCF;
import input.Mouse;
import input.MouseRCF;
import output.Headphone;
import output.HeadphoneRCF;
import output.Monitor;
import output.MonitorRCF;

public class RegularComputerFactory implements ComputerDevicesFactory {
	public CPU manufactureCPU() {return new CpuRCF(); }
	public RAM manufactureRAM() {return new RamRCF(); }
	public Keyboard manufactureKeyboard() {return new KeyboardRCF(); }
	public Mouse manufactureMouse() {return new MouseRCF(); }
	public Headphone manufactureHeadPhone() {return new HeadphoneRCF(); }
	public Monitor manufactureMonitor() {return new MonitorRCF(); }
	public String ToString() {return "Regular";}
}
