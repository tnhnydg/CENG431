package domain;

public class App {

	public static void main(String[] args) {
		
		CPU cpu = new CPU();
		Scheduler sc = new Scheduler();
		ProcessBatch pb = new ProcessBatch(sc);
		Dispatcher dp = new Dispatcher(pb);
		
		Process p1 = new Process();
		Process p2 = new Process();
		Process p3 = new Process();
		Process p4 = new Process();
		Process p5 = new Process();
		
		pb.addProcess(p1);
		pb.addProcess(p2);
		pb.addProcess(p3);
		pb.addProcess(p4);
		pb.addProcess(p5);
		
		pb.manipulateProcesses(new FirstComeFirstServeBS());
		
		dp.ExtractProcess(cpu);
		dp.ExtractProcess(cpu);
		dp.ExtractProcess(cpu);
		
		pb.manipulateProcesses(new PriorityBS());
		
		dp.ExtractProcess(cpu);
		dp.ExtractProcess(cpu);
		dp.ExtractProcess(cpu);
		
		
		
		

	}

}
