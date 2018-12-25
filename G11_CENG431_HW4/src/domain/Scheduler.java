package domain;

import java.util.List;

public class Scheduler {

	private Scheduling algorithm;
	private List<Process> schedule;
	
	public Scheduler() {
	}
	
	public void schedule(List<Process> pList) {
		schedule = algorithm.Schedule(pList);
	}
	
	public void setSchedulingAlgorithm(Scheduling algorithm) {
		this.algorithm = algorithm;
	}
	
	public List<Process> getSchedule(){
		return this.schedule;
	}
}
