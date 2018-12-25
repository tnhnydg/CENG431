package domain;

import java.util.List;

public class Dispatcher {
	private ProcessBatch pb;
	
	public Dispatcher(ProcessBatch pb) {
		this.pb = pb;
	}
	
	public void ExtractProcess(CPU cpu) {
		if(pb.getReadyQueue().size() == 0) {
			System.out.println("Ready queue is empty.");
			return;
		}
		Process process = pb.getReadyQueue().get(0);
		notify(process,new RunningStateObserver());
		cpu.Run(process);
		pb.getReadyQueue().remove(0);
		deleteProcessFromProcessList(process);
		
	}
	
	public void deleteProcessFromProcessList(Process process) {
		List<Process> pList = pb.getProcessList();
		for(int i=0;i<pList.size();i++) {
			if(process.getId() == pList.get(i).getId() ) {
				pList.remove(i);
			}
		}
	}
	
	public void notify(Process process,StateObserver so) {
		so.Update(process);
	}
}
