package domain;

import java.util.Random;

public class Process {

	private int id;
	private int arrivalTime;
	private int burstTime;
	private int completionTime;
	private int waitingTime;
	private int priority;
	private ProcessState state;
	
	public Process() {
		pickArrivalTime();
		pickBurstTime();
		pickPriority();
		setCompletionTime();
	}
	
	private void pickArrivalTime() {
		this.arrivalTime = getRandInt(1,20);
	}
	
	private void pickBurstTime() {
		this.burstTime = getRandInt(1,20);
	}
	
	private void pickPriority() {
		this.priority = getRandInt(1,10);
	}
	
	private void setCompletionTime() {
		this.completionTime = this.arrivalTime + this.burstTime;
	}
	
	public int getRandInt(int min,int max) {
		Random rn = new Random();
		int n = rn.nextInt((max-min)+1) + min;
		return n;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	public int getBurstTime() {
		return this.burstTime;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setState(ProcessState state) {
		this.state = state;
	}
	
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	public int getWaitingTime() {
		return this.waitingTime;
	}
	
	public ProcessState getProcessState() {
		return this.state;
	}
	
	public String toString() {
		return "[" + this.id +" "+ this.arrivalTime +" "+ this.burstTime +" "+ this.completionTime +" "+ this.waitingTime +" "+ this.priority + "]";
	}
	
}
