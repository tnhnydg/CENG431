package domain;

import hardware.CPU;
import hardware.RAM;
import input.Keyboard;
import input.Mouse;
import output.Headphone;
import output.Monitor;

public class Computer implements Component {
	private ComputerDevicesFactory type;
	private CPU cpu;
	private RAM ram;
	private Monitor monitor;
	private Headphone headphone;
	private Keyboard keyboard;
	private Mouse mouse;
	private int cost;
	
	public Computer(ComputerDevicesFactory type) {
		setType(type);
		assemble(type);
		setTotalCost();
	}
	
	public void assemble(ComputerDevicesFactory type) {
		setCpu(type.manufactureCPU());
		setRam(type.manufactureRAM());
		setMonitor(type.manufactureMonitor());
		setHeadphone(type.manufactureHeadPhone());
		setKeyboard(type.manufactureKeyboard());
		setMouse(type.manufactureMouse());
	}
	
	public void AddToCost(int value) {
		setCost(getCost()+value);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setTotalCost() {
		AddToCost(getCpu().getCost());
		AddToCost(getRam().getCost());
		AddToCost(getMonitor().getCost());
		AddToCost(getHeadphone().getCost());
		AddToCost(getKeyboard().getCost());
		AddToCost(getMouse().getCost());
	}

	public ComputerDevicesFactory getType() {
		return type;
	}

	public void setType(ComputerDevicesFactory type) {
		this.type = type;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public RAM getRam() {
		return ram;
	}

	public void setRam(RAM ram) {
		this.ram = ram;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Headphone getHeadphone() {
		return headphone;
	}

	public void setHeadphone(Headphone headphone) {
		this.headphone = headphone;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	
	public String toString() {
		return "Computer [ "+getType().ToString()+", "+getCpu().ToString()+":"+getCpu().getCost()+
				                                  ", "+getRam().ToString()+":"+getRam().getCost()+
				                                  ", "+getMonitor().ToString()+":"+getMonitor().getCost()+
				                                  ", "+getHeadphone().ToString()+":"+getHeadphone().getCost()+
				                                  ", "+getKeyboard().ToString()+":"+getKeyboard().getCost()+
				                                  ", "+getMouse().ToString()+":"+getMouse().getCost()+
				                                  ", TotalCost:"+getCost()+" ]"; 
	}
}
