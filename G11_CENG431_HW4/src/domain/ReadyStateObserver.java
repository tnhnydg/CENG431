package domain;

public class ReadyStateObserver implements StateObserver{

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.Ready);
	}

}
