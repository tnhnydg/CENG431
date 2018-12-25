package domain;

import java.util.ArrayList;
import java.util.List;

public class ProcessBatch {

	private Scheduler scheduler;
	private List<Process> pList;
	private List<Process> readyQueue;
	
	
	public ProcessBatch(Scheduler scheduler) {
		this.readyQueue = new ArrayList<Process>();
		this.pList = new ArrayList<Process>();
		setScheduler(scheduler);
	}
	
	public void scheduleProcesses (Scheduling algorithm) {
		scheduler.setSchedulingAlgorithm(algorithm);
		scheduler.schedule(pList);
	}
	
	public void detWaitingTime() {
		List<Process> schedule = scheduler.getSchedule();
		int wt=0;
		for(int i=0;i<schedule.size();i++) {
			if(i==0) {
				schedule.get(0).setWaitingTime(0);
				setReady(schedule.get(0));//note that there is no possibility for first process to become starved
			}
			else {
				wt+=schedule.get(i-1).getBurstTime();
				schedule.get(i).setWaitingTime(wt);
				if(wt>50) {
					if(readyQueue.contains(schedule.get(i))) {
						notify(schedule.get(i),new BlockedStateObserver());
						readyQueue.remove(schedule.get(i));
					}
					else {notify(schedule.get(i),new StarvedStateObserver());}
					
				}
				else {setReady(schedule.get(i));} 
			}
		}
	}
	
	public void setReady(Process process) {
		notify(process,new ReadyStateObserver());
		if(!readyQueue.contains(process)) {readyQueue.add(process);}
		else {
			readyQueue.remove(process);
			readyQueue.add(process);
		}//to keep list scheduled order
	}
	
	public void addProcess(Process process) {
		int id;
		if(this.pList.size() == 0) {id=0;}
		else {id=pList.get(pList.size()-1).getId()+1;}
		process.setId(id);
		this.pList.add(process);
		notify(process,new NewStateObserver());
	}
	
	public void manipulateProcesses(Scheduling algorithm) {
		scheduleProcesses(algorithm);
		detWaitingTime();
	}
	
	public void notify(Process process, StateObserver so) {
		so.Update(process);
	}
	
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	public List<Process> getReadyQueue(){
		return this.readyQueue;
	}
	
	public List<Process> getProcessList(){
		return this.pList;
	}
}
