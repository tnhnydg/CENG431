package domain;

public class TerminatedStateObserver implements StateObserver{

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.Terminated);
	}

}
