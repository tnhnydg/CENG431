package domain;

public class RunningStateObserver implements StateObserver{

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.Running);
	}

}
