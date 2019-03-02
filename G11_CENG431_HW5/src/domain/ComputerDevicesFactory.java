package domain;

import hardware.CPU;
import hardware.RAM;
import input.Keyboard;
import input.Mouse;
import output.Headphone;
import output.Monitor;


public interface ComputerDevicesFactory {

	public CPU manufactureCPU();
	public RAM manufactureRAM();
	public Keyboard manufactureKeyboard();
	public Mouse manufactureMouse();
	public Headphone manufactureHeadPhone();
	public Monitor manufactureMonitor();
	public String ToString();
}
