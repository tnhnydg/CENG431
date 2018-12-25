package domain;

public class NewStateObserver implements StateObserver {

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.New);
	}

}
