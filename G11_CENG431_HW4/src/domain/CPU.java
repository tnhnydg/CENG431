package domain;

public class CPU {

	private Process runningProcess;
	
	public CPU() {
		
	}
	
	public void Run(Process process) {
		runningProcess = process;
		System.out.println("The process " +runningProcess.toString() + " is running." );
		notify(process,new TerminatedStateObserver());
	}
	
	public void notify(Process process,StateObserver so) {
		so.Update(process);
	}
}
